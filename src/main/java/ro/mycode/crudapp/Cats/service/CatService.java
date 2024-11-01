package ro.mycode.crudapp.Cats.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Service;
import ro.mycode.crudapp.Cats.dtos.CreateCatResponse;
import ro.mycode.crudapp.Cats.dtos.CreateCatRequest;
import ro.mycode.crudapp.Cats.dtos.UpdateCatRequest;
import ro.mycode.crudapp.Cats.dtos.UpdateCatResponse;
import ro.mycode.crudapp.Cats.exceptions.CatDoesntExist;
import ro.mycode.crudapp.Cats.exceptions.CatExist;
import ro.mycode.crudapp.Cats.exceptions.CatListEmpty;
import ro.mycode.crudapp.Cats.exceptions.NoUpdate;
import ro.mycode.crudapp.Cats.models.Cat;
import ro.mycode.crudapp.Cats.repository.CatRepo;
import ro.mycode.crudapp.Cats.system.logs.StructuredLogger;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class CatService {

    private final CatRepo catRepo;
    @Autowired
    private final StructuredLogger logger ;


    @ReadOnlyProperty
    public List<Cat> getAllCats(){
        List<Cat> all = catRepo.findAll();
        if (all.size() == 0) {


            logger.logBuilder()
                    .withMessage("FAIL GET ALL CATS")
                    .withField("sizeList", 0)
                    .withLevel("ERROR")
                    .log();
            return all;
        }else{
            logger.logBuilder()
                    .withMessage("GET ALL CATS")
                    .withField("firstCat", all.get(0))
                    .withField("firstCatRasa", all.get(0).getRasa())
                    .withField("firstCatAge", all.get(0).getVarsta())
                    .withField("sizeList", all.size())
                    .log();

        }


        return all;
    }



    @Transactional
    public CreateCatResponse addCat(CreateCatRequest createCatRequest) {

        Optional<Cat> makeupByMarca = catRepo.findCatByRasa(createCatRequest.getNumeStapan());
        if (makeupByMarca.isPresent()) {


            throw new CatExist();
        }
         Cat cat = Cat.builder()
                 .rasa(createCatRequest.getRasa())
                 .numeStapan(createCatRequest.getNumeStapan())
                 .varsta(createCatRequest.getVarsta())
                .build();
        Cat cat1 =  catRepo.saveAndFlush(cat);

        return CreateCatResponse.builder().cat(cat1).build();

    }

    @Transactional
    public void deleteCat(long id) {
        Optional<Cat> cat = catRepo.findById(id);
        if (cat.isPresent()) {
            catRepo.delete(cat.get());
        } else {
            throw new CatDoesntExist();
        }
    }


    @Transactional
    public UpdateCatResponse updateCatResponse(UpdateCatRequest updateCatRequest) {
        Optional<Cat>catOptional= catRepo.findCatById(updateCatRequest.getId());
        if(catOptional.isPresent()){

            Cat cat = catOptional.get();


            if(updateCatRequest.getVarsta()!=0){
                cat.setVarsta(updateCatRequest.getVarsta());
                catRepo.saveAndFlush(cat);
            }
            return UpdateCatResponse.builder().cat(cat).build();


        }else{
            throw new NoUpdate();
        }


    }

    public Optional<Cat> getCatById(long id) {
        return catRepo.findById(id);
    }

}

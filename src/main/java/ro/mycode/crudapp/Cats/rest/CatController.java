package ro.mycode.crudapp.Cats.rest;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.mycode.crudapp.Cats.dtos.*;
import ro.mycode.crudapp.Cats.models.Cat;
import ro.mycode.crudapp.Cats.service.CatService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/cat")
@AllArgsConstructor
@Slf4j
@CrossOrigin
public class CatController {


    private CatService catService;

    @GetMapping("/allCats")
    public ResponseEntity<List<Cat>> getAllCats() {
        List<Cat> cat = catService.getAllCats();
        return   new ResponseEntity<>(cat, HttpStatus.OK);
    }


    @PostMapping("/cretaeCat")
    public ResponseEntity<CreateCatResponse>addCat(@RequestBody CreateCatRequest createCatRequest) {
        CreateCatResponse createCatResponse = catService.addCat(createCatRequest);
        return   new ResponseEntity<>(createCatResponse,HttpStatus.CREATED);
    }
    @PutMapping("/updateCatAge")
    public ResponseEntity<UpdateCatResponse>updated(@RequestBody UpdateCatRequest updateCatRequest) {
        UpdateCatResponse updateCatResponse = catService.updateCatResponse(updateCatRequest);
        return new ResponseEntity<>(updateCatResponse,HttpStatus.ACCEPTED);
    }



    @DeleteMapping("delete")
    public ResponseEntity<Void>getFindById(@RequestParam long id){
        catService.deleteCat(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


    @GetMapping("/catById")
    public ResponseEntity<Cat> getCatById(@RequestParam long id){
        Optional<Cat> cat = catService.getCatById(id);
        return cat.map(value->new ResponseEntity<>(value,HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

}

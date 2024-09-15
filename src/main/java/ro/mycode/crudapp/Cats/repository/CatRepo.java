package ro.mycode.crudapp.Cats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.mycode.crudapp.Cats.models.Cat;

import java.util.List;
import java.util.Optional;


@Repository
    public interface CatRepo extends JpaRepository<Cat,Long> {
    @Query("select distinct m.rasa from Cat m")
    List<String>getAllCats();


    @Query("select m from Cat m where m.rasa = ?1 and m.numeStapan= ?2 ")
    Optional<Cat> findCatByRasaAndNumeStapan(String rasa, String numeStapan);

    @Query("select m from Cat m where m.rasa = ?1 ")
    Optional<Cat> findCatByRasa(String rasa);

    @Query("select m from Cat m where m.id = ?1 ")
    Optional<Cat> findCatById(int id);






}

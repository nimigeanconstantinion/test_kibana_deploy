package ro.mycode.crudapp.Cats.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ro.mycode.crudapp.Cats.models.Cat;
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CreateCatResponse {

    private Cat cat;
    @Builder.Default
    private String message="Pisica a a fost creata cu succes";
}

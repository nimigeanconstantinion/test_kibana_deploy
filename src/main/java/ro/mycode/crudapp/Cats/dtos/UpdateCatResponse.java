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
public class UpdateCatResponse {

    private Cat cat;
    @Builder.Default
    private String message="Detaliile despre pisica au fost actualizate cu succes";
}

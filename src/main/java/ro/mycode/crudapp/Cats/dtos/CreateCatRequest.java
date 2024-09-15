package ro.mycode.crudapp.Cats.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateCatRequest {
    private String rasa;
    private String numeStapan;
    private int varsta;
}

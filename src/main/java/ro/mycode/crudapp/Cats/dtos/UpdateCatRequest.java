package ro.mycode.crudapp.Cats.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UpdateCatRequest {
    private int id;
    private String rasa="";
    private String numeStapan="";
    private int varsta=0;
}

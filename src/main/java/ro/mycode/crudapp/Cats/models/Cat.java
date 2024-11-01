package ro.mycode.crudapp.Cats.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@Entity
@Table(name="cat")
@Data
@AllArgsConstructor
@SuperBuilder
@ToString
@NoArgsConstructor
public class Cat implements Comparable<Cat> {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    private String rasa;
    private String numeStapan;
    private int varsta;



    public String toString(){
        return this.rasa+";"+this.numeStapan;
    }
    @Override
    public int compareTo(Cat o) {
        return 0;
    }
}

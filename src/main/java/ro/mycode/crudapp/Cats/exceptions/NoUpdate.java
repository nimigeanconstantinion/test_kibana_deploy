package ro.mycode.crudapp.Cats.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static ro.mycode.crudapp.Cats.system.Constants.NO_UPDATE;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NoUpdate extends RuntimeException{


    public NoUpdate() {
        super(NO_UPDATE);
    }
}

package ro.mycode.crudapp.Cats.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static ro.mycode.crudapp.Cats.system.Constants.MAKEUP_LIST_EMPTY;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CatListEmpty extends RuntimeException{

    public CatListEmpty() {
        super(MAKEUP_LIST_EMPTY);
    }
}

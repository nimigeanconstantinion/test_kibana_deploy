package ro.mycode.crudapp.Cats.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static ro.mycode.crudapp.Cats.system.Constants.MAKEUP_DOESNT_EXIST;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CatDoesntExist extends RuntimeException{

    public CatDoesntExist() {
        super(MAKEUP_DOESNT_EXIST);
    }
}

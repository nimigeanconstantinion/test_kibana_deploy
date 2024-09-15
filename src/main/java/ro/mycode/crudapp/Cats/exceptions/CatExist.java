package ro.mycode.crudapp.Cats.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static ro.mycode.crudapp.Cats.system.Constants.MAKEUP_EXIST;
@ResponseStatus(HttpStatus.OK)
public class CatExist extends RuntimeException {

    public CatExist() {
        super(MAKEUP_EXIST);
    }
}

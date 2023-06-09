package pro.sky.course02.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class OversizeException extends RuntimeException {
    public OversizeException() {
        super();
    }

    public OversizeException(String message) {
        super(message);
    }
}

package collections.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeNotValidDataException extends RuntimeException {
    public EmployeeNotValidDataException(String message) {
        super(message);
    }
}

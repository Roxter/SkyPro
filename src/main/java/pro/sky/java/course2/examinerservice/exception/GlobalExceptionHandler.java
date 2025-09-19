package pro.sky.java.course2.examinerservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidQuestionAmountException.class)
    public ResponseEntity<ResponseError> handleNoSuchProductException(InvalidQuestionAmountException e) {
        ResponseError responseError = new ResponseError("INCORRECT_QUESTION_AMOUNT", "Available: " + e.requestTotalQuestions());
        return new ResponseEntity<>(responseError, HttpStatus.BAD_REQUEST);
    }
}
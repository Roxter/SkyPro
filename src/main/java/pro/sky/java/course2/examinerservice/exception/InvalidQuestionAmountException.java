package pro.sky.java.course2.examinerservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidQuestionAmountException extends RuntimeException {
    private int totalQuestions;

    public InvalidQuestionAmountException(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public int requestTotalQuestions() {
        return totalQuestions;
    }
}
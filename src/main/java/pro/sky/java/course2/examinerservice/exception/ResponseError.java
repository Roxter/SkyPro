package pro.sky.java.course2.examinerservice.exception;

public class ResponseError {
    private String code;
    private String message;

    public ResponseError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

package micronaut.post.examples.domain;


import java.util.List;

public class ApiError {

    private int code;
    private String message;

    public void setCode(int code) {
         this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

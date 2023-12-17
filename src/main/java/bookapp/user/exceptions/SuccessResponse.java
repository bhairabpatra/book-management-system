package bookapp.user.exceptions;

import bookapp.user.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class SuccessResponse {
    private String message;
    private int status;

    @JsonIgnore
    private User user;

    public SuccessResponse(String message, int status, User user) {
        this.message = message;
        this.status = status;
        this.user = user;
    }

    public SuccessResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

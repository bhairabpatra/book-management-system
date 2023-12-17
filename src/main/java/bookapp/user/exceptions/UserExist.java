package bookapp.user.exceptions;

public class UserExist extends RuntimeException {
    public UserExist() {
    }

    public UserExist(String message) {
        super(message);
    }
}

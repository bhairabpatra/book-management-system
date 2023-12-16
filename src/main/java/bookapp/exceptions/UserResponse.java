package bookapp.exceptions;

import bookapp.models.Books;
import lombok.Data;


public class UserResponse<T> {

    private String message;
    private int status;
    private T  books;

    public UserResponse() {
    }

    public UserResponse(String message, int status, T books) {
        this.message = message;
        this.status = status;
        this.books = books;
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

    public T getBooks() {
        return books;
    }

    public void setBooks(T books) {
        this.books = books;
    }
}

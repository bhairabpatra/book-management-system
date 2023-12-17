package bookapp.user.services;

import bookapp.user.models.User;

public interface UserService {

    public User createUser(User user);
    public Boolean signInUser(User user);

    public Boolean resetPassword(User user);
}

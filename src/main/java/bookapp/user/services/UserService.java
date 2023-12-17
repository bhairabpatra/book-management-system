package bookapp.user.services;

import bookapp.user.models.User;

public interface UserService {

    public User createUser(User user);

    public Boolean signInUser(User user);

    public Boolean resetPassword(User user);

    public Boolean updateUser(Long id, User user);

    public Boolean deleteUSer(Long id);
}

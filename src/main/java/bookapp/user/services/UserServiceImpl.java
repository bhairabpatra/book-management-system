package bookapp.user.services;

import bookapp.user.models.User;
import bookapp.user.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User createUser(User user) {

        return userRepo.save(user);
    }
}

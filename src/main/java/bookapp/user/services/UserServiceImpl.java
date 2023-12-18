package bookapp.user.services;

import bookapp.exceptions.NotFoundException;
import bookapp.user.exceptions.UserExist;
import bookapp.user.models.User;
import bookapp.user.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User createUser(User user) {
        Optional<User> isExist = userRepo.findByEmail(user.getEmail());
        if (isExist.isPresent()) {
            throw new UserExist("This  " + user.getEmail() + "  email id already exists");
        } else {
            return userRepo.save(user);
        }
    }

    @Override
    public Boolean signInUser(User user) {

        Optional<User> checkUser = userRepo.findByEmail(user.getEmail());
        if (checkUser.isPresent()) {
            if (checkUser.get().getPassword().equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean resetPassword(User user) {
        Optional<User> checkUser = userRepo.findByEmail(user.getEmail());
        if (checkUser.isPresent()) {
            checkUser.get().setPassword(user.getPassword());
            userRepo.save(checkUser.get());
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateUser(Long id, User user) {
        Optional<User> existUser = userRepo.findById(id);
        if (existUser.isPresent()) {
            existUser.get().setUsername(user.getUsername());
            existUser.get().setAddress(user.getAddress());
            existUser.get().setPhone(user.getPhone());
            userRepo.save(existUser.get());
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteUSer(Long id) {
        Optional<User> existUser = userRepo.findById(id);
        if(existUser.isPresent()){
            userRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public User getUserByID(String email) {
        Optional<User> existUser = userRepo.findByEmail(email);
        if(existUser.isPresent()){
            System.out.println(existUser.get());
            return existUser.get();
        }
        return null;
    }
}

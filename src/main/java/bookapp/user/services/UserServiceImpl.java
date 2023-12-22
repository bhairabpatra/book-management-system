package bookapp.user.services;

import bookapp.exceptions.NotFoundException;
import bookapp.user.exceptions.UserExist;
import bookapp.user.models.User;
import bookapp.user.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User createUser(User user) {
        Optional<User> isEmailExist = userRepo.findByEmail(user.getEmail());
        Optional<User> isNameExist = userRepo.findByName(user.getName());
        if (isEmailExist.isPresent() && isNameExist.isPresent()) {
            throw new UserExist("This  " + user.getEmail() + " & "+ user.getName() + " already exists");
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepo.save(user);
        }
    }

    @Override
    public Boolean signInUser(User user) {
        Optional<User> checkUser = userRepo.findByName(user.getName());
        if (checkUser.isPresent()) {
            boolean isPasswordMatch = passwordEncoder.matches(user.getPassword(), checkUser.get().getPassword());
            if (isPasswordMatch) {
                System.out.println("Password");
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
            existUser.get().setName(user.getName());
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
        if (existUser.isPresent()) {
            userRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public User getUserByEmail(String email) {
        Optional<User> existUser = userRepo.findByEmail(email);
        return existUser.orElse(null);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> existUser = userRepo.findById(id);
        return existUser.orElse(null);
    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }
}

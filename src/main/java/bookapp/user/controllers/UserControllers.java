package bookapp.user.controllers;


import bookapp.user.exceptions.UserExist;
import bookapp.user.models.User;
import bookapp.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api/user")
public class UserControllers {

    @Autowired
    private UserService userService;

    @PostMapping("signup")
    public ResponseEntity<User> signUp(@RequestBody User user) {
        User newUser = userService.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PostMapping("sign-in")
    public ResponseEntity<String> signIn(@RequestBody User user) {
        if (userService.signInUser(user)) {
            return new ResponseEntity<>("Welcome back! You've successfully logged in", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Login failed", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody User user) {
        if (userService.resetPassword(user)) {
            return new ResponseEntity<>("Your password has been changed successfully", HttpStatus.OK);
        } else {
            throw new UserExist("The requested user was not found");
        }
    }
}

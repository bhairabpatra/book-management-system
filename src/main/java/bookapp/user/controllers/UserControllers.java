package bookapp.user.controllers;
import bookapp.user.exceptions.ErrorResponse;
import bookapp.user.exceptions.SuccessResponse;
import bookapp.user.models.User;
import bookapp.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/api/user")
public class UserControllers {

    @Autowired
    private UserService userService;

    @PostMapping("signup")
    public ResponseEntity<?> signUp(@RequestBody User user) {
        User newUser = userService.createUser(user);
        SuccessResponse successResponse = new SuccessResponse();
        successResponse.setStatus(HttpStatus.CREATED.value());
        successResponse.setMessage("User Created successfully");
        successResponse.setUser(user);
        return new ResponseEntity<>(successResponse, HttpStatus.CREATED);
    }

    @PostMapping("sign-in")
    public ResponseEntity<?> signIn(@RequestBody User user) {
        if (userService.signInUser(user)) {
            SuccessResponse successResponse = new SuccessResponse();
            successResponse.setStatus(HttpStatus.OK.value());
            successResponse.setMessage("Welcome back! You've successfully logged i");
            return new ResponseEntity<>(successResponse, HttpStatus.OK);
        } else {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),"Login failed");
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody User user) {
        if (userService.resetPassword(user)) {
            SuccessResponse successResponse = new SuccessResponse();
            successResponse.setStatus(HttpStatus.OK.value());
            successResponse.setMessage("User updated successfully");
            successResponse.setUser(user);
            return new ResponseEntity<>(successResponse, HttpStatus.OK);
        } else {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(),"User updated failed");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

        }
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<?> editUser(@PathVariable Long id, @RequestBody User user) {
        if (userService.updateUser(id, user)) {
            SuccessResponse successResponse = new SuccessResponse();
            successResponse.setStatus(HttpStatus.OK.value());
            successResponse.setMessage("User updated successfully");
            successResponse.setUser(user);
            return new ResponseEntity<>(successResponse, HttpStatus.OK);
        } else {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),"User updated failed");
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        if (userService.deleteUSer(id)) {
            SuccessResponse successResponse = new SuccessResponse();
            successResponse.setStatus(HttpStatus.OK.value());
            successResponse.setMessage("User deleted Successfully");
            return new ResponseEntity<>(successResponse, HttpStatus.OK);
        } else {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),"User deleted failed");
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

}

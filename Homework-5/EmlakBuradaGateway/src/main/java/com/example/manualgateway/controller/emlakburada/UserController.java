package main.java.com.example.manualgateway.controller.emlakburada;

import com.example.manualgateway.client.emlakburada.UserClient;
import com.example.manualgateway.dto.request.MessageRequest;
import com.example.manualgateway.dto.request.UserRequest;
import com.example.manualgateway.dto.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
public class UserController {

    @Autowired
    private UserClient userClient;


    @GetMapping(value = "/users")
    public UserResponse findAllUser() {
        return userClient.findAll();
    }

    @PostMapping(value = "/users")
    public UserResponse saveUser(@RequestBody UserRequest request) {
        return userClient.saveUser(request);
    }

    @PutMapping(value = "/users/{id}")
    public UserResponse updateUserById(@RequestBody UserRequest request, @PathVariable int id) {
        return userClient.updateUserById(request, id);
    }

    @DeleteMapping(value = "/users/{id}")
    public UserResponse deleteUserById(@PathVariable int id) {
        return userClient.deleteUserById(id);
    }

    @GetMapping(value = "/users/{id}")
    public UserResponse findByUserId(@PathVariable int id) {
        return userClient.findByUserId(id);
    }


}

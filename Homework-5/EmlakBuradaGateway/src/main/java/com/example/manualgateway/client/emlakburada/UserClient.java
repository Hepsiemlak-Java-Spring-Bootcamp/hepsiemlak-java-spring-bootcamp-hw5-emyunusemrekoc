package main.java.com.example.manualgateway.client.emlakburada;

import com.example.manualgateway.dto.request.UserRequest;
import com.example.manualgateway.dto.response.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "feign-emlakburada-user",url="http://localhost:8080")
public interface UserClient {

    @PostMapping(value = "/users")
    UserResponse saveUser(UserRequest request);

    @GetMapping(value = "/users")
    UserResponse findAll();

    @PutMapping(value = "/users/{id}")
    UserResponse updateUserById(@RequestBody UserRequest request, @PathVariable int id);

    @DeleteMapping(value = "/users/{id}")
    UserResponse  deleteUserById(@PathVariable int id);

    @GetMapping(value = "/users/{id}")
    UserResponse findByUserId(@PathVariable int id);
}

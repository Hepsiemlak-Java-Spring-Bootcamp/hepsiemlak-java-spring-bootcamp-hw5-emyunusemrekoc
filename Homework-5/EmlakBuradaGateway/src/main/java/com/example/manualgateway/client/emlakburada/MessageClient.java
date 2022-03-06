package main.java.com.example.manualgateway.client.emlakburada;

import com.example.manualgateway.dto.request.AdvertRequest;
import com.example.manualgateway.dto.request.MessageRequest;
import com.example.manualgateway.dto.response.MessageResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
@FeignClient(value = "feign-emlakburada-message",url="http://localhost:8080")
public interface MessageClient {

    @PostMapping(value = "/messages")
    MessageResponse  saveMessage(MessageRequest request);

    @GetMapping(value = "/messages")
    MessageResponse  findAll();

    @PutMapping(value = "/messages/{id}")
    MessageResponse  updateMessageById(@RequestBody MessageRequest request, @PathVariable int id);

    @DeleteMapping(value = "/messages/{id}")
    MessageResponse   deleteMessageById(@PathVariable int id);

    @GetMapping(value = "/messages/{id}")
    MessageResponse findByMessageId(@PathVariable int id);
}

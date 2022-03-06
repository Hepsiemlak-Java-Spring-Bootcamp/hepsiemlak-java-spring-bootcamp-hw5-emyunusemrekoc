package main.java.com.example.manualgateway.controller.emlakburada;

import com.example.manualgateway.client.emlakburada.MessageClient;
import com.example.manualgateway.dto.request.AdvertRequest;
import com.example.manualgateway.dto.request.MessageRequest;
import com.example.manualgateway.dto.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
public class MessageController {

    @Autowired
    private MessageClient messageClient;


    @GetMapping(value = "/messages")
    public MessageResponse  findAllMessage() {
        return messageClient.findAll();
    }

    @PostMapping(value = "/messages")
    public MessageResponse  saveMessage(@RequestBody MessageRequest request) {
        return messageClient.saveMessage(request);
    }

    @PutMapping(value = "/messages/{id}")
    public MessageResponse  updateMessageById(@RequestBody MessageRequest request, @PathVariable int id) {
        return messageClient.updateMessageById(request, id);
    }

    @DeleteMapping(value = "/messages/{id}")
    public MessageResponse deleteMessageById(@PathVariable int id) {
        return messageClient.deleteMessageById(id);
    }
}

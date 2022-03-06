package main.java.com.example.manualgateway.controller.emlakburada;

import com.example.manualgateway.client.emlakburada.AdvertClient;
import com.example.manualgateway.dto.request.AdvertRequest;
import com.example.manualgateway.dto.response.AdvertResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdvertController {

    @Autowired
    private AdvertClient advertClient;


    @GetMapping(value = "/adverts")
    public AdvertResponse getAllAdvert() {
        return advertClient.getAllAdvert();
    }

    @PostMapping(value = "/adverts")
    public AdvertResponse saveAdvert(@RequestBody AdvertRequest request) {
        return advertClient.createAdvert(request);
    }

    @PutMapping(value = "/adverts/{id}")
    public AdvertResponse updateAdvertById(@RequestBody AdvertRequest request, @PathVariable int id) {
        return advertClient.updateAdvertById(request, id);
    }

    @DeleteMapping(value = "/adverts/{id}")
    public AdvertResponse deleteAdvertById(@PathVariable int id) {
        return advertClient.deleteAdvertById(id);
    }
}

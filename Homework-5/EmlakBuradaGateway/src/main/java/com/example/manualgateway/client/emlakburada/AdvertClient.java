package main.java.com.example.manualgateway.client.emlakburada;

import com.example.manualgateway.dto.request.AdvertRequest;
import com.example.manualgateway.dto.response.AdvertResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "feign-emlakburada-advert",url="http://localhost:8080")
public interface AdvertClient {

    @PostMapping(value = "/adverts")
    AdvertResponse createAdvert(AdvertRequest request);

    @GetMapping(value = "/adverts")
    AdvertResponse getAllAdvert();

    @PutMapping(value = "/adverts/{id}")
    AdvertResponse updateAdvertById(@RequestBody AdvertRequest request, @PathVariable int id);

    @DeleteMapping(value = "/adverts/{id}")
    AdvertResponse deleteAdvertById(@PathVariable int id);

    @GetMapping(value = "/adverts/{id}")
    AdvertResponse findAdvertByAdvertId(@PathVariable int id);

}

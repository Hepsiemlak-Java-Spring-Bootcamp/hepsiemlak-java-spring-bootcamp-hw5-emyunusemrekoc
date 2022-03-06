package main.java.com.example.manualgateway.controller.emlakBuradaBanner;

import com.example.manualgateway.client.emlakBuradaBanner.BannerClient;
import com.example.manualgateway.dto.request.BannerRequest;
import com.example.manualgateway.dto.response.BannerResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
public class BannerController {

    @Autowired
    private BannerClient bannerClient;


    @GetMapping(value = "/banners")
    public BannerResponse getAllBanners() {
        return bannerClient.getAllBanners();
    }

    @PostMapping(value = "/banners")
    public BannerResponse saveBanner(@RequestBody BannerRequest request) {
        return bannerClient.saveBanner(request);
    }

    @PutMapping(value = "/banners/{id}")
    public BannerResponse updateBannerById(@RequestBody BannerRequest request, @PathVariable int id) {
        return bannerClient.updateBannerById(request, id);
    }

    @DeleteMapping(value = "/banners/{id}")
    public BannerResponse deleteBannerById(@PathVariable int id) {
        return bannerClient.deleteBannerById(id);
    }
}

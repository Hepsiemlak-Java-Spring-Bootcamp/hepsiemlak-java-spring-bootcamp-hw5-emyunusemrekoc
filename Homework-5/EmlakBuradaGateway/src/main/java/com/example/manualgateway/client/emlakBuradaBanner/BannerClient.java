package main.java.com.example.manualgateway.client.emlakBuradaBanner;


import com.example.manualgateway.dto.request.BannerRequest;
import com.example.manualgateway.dto.response.BannerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(value = "feign-banner",url ="http://localhost:8081" )
public interface BannerClient {

	@PostMapping(value = "/banners")
	BannerResponse saveBanner(BannerRequest bannerRequest);

	@GetMapping(value = "/banners")
	BannerResponse getAllBanners();

	@PutMapping(value = "/banners/{id}")
	BannerResponse updateBannerById(@RequestBody BannerRequest request, @PathVariable int id);

	@DeleteMapping(value = "/banners{id}")
	BannerResponse deleteBannerById(@PathVariable int id);

}

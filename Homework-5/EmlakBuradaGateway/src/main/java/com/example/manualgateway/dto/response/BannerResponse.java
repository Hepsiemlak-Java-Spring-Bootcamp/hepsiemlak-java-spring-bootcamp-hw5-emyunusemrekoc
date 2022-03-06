package main.java.com.example.manualgateway.dto.response;

import com.example.manualgateway.dto.request.AddressRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BannerResponse {

	private int advertNo;
	private String phone;
	private int total;
	private AddressRequest address;

}

package main.java.com.example.manualgateway.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

	private String name;
	private String email;
	private String photo;
	private String biography;

}

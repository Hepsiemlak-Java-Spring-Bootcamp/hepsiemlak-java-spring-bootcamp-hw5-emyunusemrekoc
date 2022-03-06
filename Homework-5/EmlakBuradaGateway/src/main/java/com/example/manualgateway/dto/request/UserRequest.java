package main.java.com.example.manualgateway.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {


    private String name;
    private String email;
    private String photo;
    private String biography;
}

package main.java.com.example.manualgateway.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class AdvertResponse {

	private int advertNo;
	//private RealEstate realEstate;
	private String title;
	//@JsonIgnore
	//private User user; // hem bireysel & kurumsal
	//private List<AdvertPhoto> advertPhotos;
	private Long price;
	private Date createdDate;
	private Date endDate;
	private boolean turbo;
	private boolean isActive;

}

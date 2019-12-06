package mx.gnc.as.gutsncode.dao;

import java.util.Base64;

import lombok.Data;

@Data
public class FounderReduced {

	private Long founderId;
	private String name;
	private String lastName;
	private String secondLastName;
	private String photo;
	private String summary;
	private String email;
	private String password;

	public FounderReduced(Founder founder) {
		this.founderId = founder.getFounderId();
		this.name = founder.getName();
		this.lastName = founder.getLastName();
		this.secondLastName = founder.getSecondLastName();
		this.summary = founder.getSummary();
		this.email = founder.getEmail();
		this.photo = Base64.getEncoder().encodeToString(founder.getPhoto());
	}

	public FounderReduced() {
	}

	public boolean isNull() {
		if(this.name != null || this.lastName != null || this.secondLastName != null)
			return false;
		else
			return true;
	};

}

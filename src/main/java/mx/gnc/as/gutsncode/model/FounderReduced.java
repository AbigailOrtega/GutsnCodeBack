package mx.gnc.as.gutsncode.model;

import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import mx.gnc.as.gutsncode.dao.Founder;

@Data
public class FounderReduced {

	private Long founderId;
	private String name;
	private String lastName;
	private String photo;
	private String summary;
	private String email;
	private String alias;
	
	public FounderReduced(Founder founder) {
		this.founderId = founder.getFounderId();
		this.name = founder.getName();
		this.lastName = founder.getLastName();
		this.summary = founder.getSummary();
		this.email = founder.getEmail();
		this.alias = founder.getAlias();
		if(founder.getPhoto() != null)
		this.photo = Base64.getEncoder().encodeToString(founder.getPhoto());
	}

	public boolean isNull() {
		if(this.name != null || this.lastName != null || this.alias != null)
			return false;
		else
			return true;
	};

}

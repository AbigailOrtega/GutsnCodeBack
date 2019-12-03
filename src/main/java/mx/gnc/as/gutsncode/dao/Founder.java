package mx.gnc.as.gutsncode.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "FOUNDER")
public class Founder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FOUNDER_ID")
	private Long founderId;
	@Column(name = "NAME")
	private String name;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "SECOND_LAST_NAME")
	private String secondLastName;
	@Column(name = "PHOTO")
	private byte[] photo;
	@Column(name = "SUMMARY")
	private String summary;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PASSWORD")
	private String password;

	public Founder(String name, String lastName, String secondLastName, String summary, String email, String password) {
		this.name = name;
		this.lastName = lastName;
		this.secondLastName = secondLastName;
		this.summary = summary;
		this.email = email;
		this.password = password;
	}

	public Founder() {
	}

	public boolean isNull() {
		if(this.name != null || this.lastName != null || this.secondLastName != null)
			return true;
		else
			return false;
	};

}

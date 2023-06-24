package mx.gnc.as.gutsncode.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
	@Column(name = "PHOTO", columnDefinition="blob")
	private byte[] photo;
	@Column(name = "SUMMARY")
	private String summary;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "ALIAS")
	private String alias;
	
	public Founder(String name, String lastName, String summary, String email, String alias) {
		this.name = name;
		this.lastName = lastName;
		this.summary = summary;
		this.email = email;
		this.alias = alias;
	}

	public boolean isNull() {
		if(this.name != null || this.lastName != null || this.alias != null)
			return false;
		else
			return true;
	};

}

package mx.gnc.as.gutsncode.dao;

import java.sql.Blob;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "STADISTICS")
public class Stadistics {
	
	@Id
	@Column(name = "STAT_ID")
	private Long statId;
	@Column(name = "STAT_NAME")
	private String statName;
	@Column(name = "STAT_VALUE")
	private String statValue;
	@Column(name = "STAT_DATE")
	private Date statDate;
	
	public Stadistics(Long statId, String statName, String statValue, Date statDate) {
		super();
		this.statId = statId;
		this.statName = statName;
		this.statValue = statValue;
		this.statDate = statDate;
	}

	public Stadistics() {
		super();
	}
	
}

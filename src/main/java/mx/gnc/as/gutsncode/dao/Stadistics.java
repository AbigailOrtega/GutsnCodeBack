package mx.gnc.as.gutsncode.dao;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
	
}

package mx.gnc.as.gutsncode.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "IMAGE")
public class Image {
	
	@Id
	@Column(name="IMAGE_ID")
	private Long imageId;
	@Column(name="IMAGE_NAME")
	private String imageName;
	@Column(name="DESCRIPTION")
	private String description;
	@Column(name="IMAGE")
	private byte[] image;
	
	@ManyToOne
	@JoinColumn(name="TEXT_ID")
	private Text textId;
	
	@Column(name="FOOTER")
	private String footer;
	@Column(name="CARDINALITY")
	private String cardinality;
	
}

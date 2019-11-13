package mx.gnc.as.gutsncode.dao;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
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
	private Blob image;
	
	@ManyToOne
	@JoinColumn(name="TEXT_ID")
	private Text textId;
	
	@Column(name="FOOTER")
	private String footer;
	@Column(name="CARDINALITY")
	private String cardinality;
	
	public Image(Long imageId, String imageName, String description, Blob image, Text textId, String footer,
			String cardinality) {
		super();
		this.imageId = imageId;
		this.imageName = imageName;
		this.description = description;
		this.image = image;
		this.textId = textId;
		this.footer = footer;
		this.cardinality = cardinality;
	}

	public Image() {
		super();
	}
	
	
}

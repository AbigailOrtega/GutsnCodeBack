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
public class ImageReduced {
	
	private String imageName;
	private String description;
	private Byte[] image;
	private String footer;
	private String cardinality;
	
	public ImageReduced(String imageName, String description, Byte[] image, String footer,
			String cardinality) {
		super();
		this.imageName = imageName;
		this.description = description;
		this.image = image;
		this.footer = footer;
		this.cardinality = cardinality;
	}

	public ImageReduced() {
		super();
	}
	
	
}

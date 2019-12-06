package mx.gnc.as.gutsncode.dao;

import lombok.Data;

@Data
public class ImageReduced {
	
	private String imageName;
	private String description;
	private String image;
//	private Byte[] image;
	private String footer;
	private String cardinality;
	
	public ImageReduced(String imageName, String description, String image, String footer,
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

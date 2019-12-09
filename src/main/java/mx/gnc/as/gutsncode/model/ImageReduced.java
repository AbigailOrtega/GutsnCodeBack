package mx.gnc.as.gutsncode.model;

import java.util.Base64;

import lombok.Data;
import lombok.NoArgsConstructor;
import mx.gnc.as.gutsncode.dao.Image;

@Data
@NoArgsConstructor
public class ImageReduced {
	
	private String imageName;
	private String description;
	private String image;
	private String footer;
	private String cardinality;
	
	public ImageReduced(Image image) {
		super();
		this.imageName = image.getImageName();
		this.description = image.getDescription();
		if(image.getImage() != null)
		this.image = Base64.getEncoder().encodeToString(image.getImage());
		this.footer = image.getFooter();
		this.cardinality = image.getCardinality();
	}

}

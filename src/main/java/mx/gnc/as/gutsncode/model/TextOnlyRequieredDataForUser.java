package mx.gnc.as.gutsncode.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.gnc.as.gutsncode.dao.Text;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TextOnlyRequieredDataForUser {
	
	private Long textId;
	private Long typeTextId;
	private String textRealize;
//	private String textBeta;
//	private String imageBlob;
	
	public TextOnlyRequieredDataForUser(Text text, byte[] image) {
		super();
		this.textId 		= text.getTextId();
		this.typeTextId 	= text.getTypeTextId().getTypeTextId();
		this.textRealize 	= text.getTextRealize();
//		this.textBeta		= text.getTextBeta();
//		this.imageBlob		= Base64.getEncoder().encodeToString(image);
	}
	
}

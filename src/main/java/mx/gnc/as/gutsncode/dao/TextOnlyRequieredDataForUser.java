package mx.gnc.as.gutsncode.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TextOnlyRequieredDataForUser {
	
	private Long textId;
	private Long typeTextId;
	private String textRealize;
//	private String imageBlob;
	
	public TextOnlyRequieredDataForUser(Text text, byte[] image) {
		super();
		this.textId 		= text.getTextId();
		this.typeTextId 	= text.getTypeTextId().getTypeTextId();
		this.textRealize 	= text.getTextRealize();
//		this.imageBlob		= Base64.getEncoder().encodeToString(image);
	}
	
}

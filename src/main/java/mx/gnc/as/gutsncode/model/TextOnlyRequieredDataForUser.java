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
	private String text;
	
	public TextOnlyRequieredDataForUser(Text text, byte[] image) {
		super();
		this.textId 		= text.getTextId();
		this.typeTextId 	= text.getTypeTextId().getTypeTextId();
		this.text 	= text.getTextRealize();
	}
	
	
	public TextOnlyRequieredDataForUser(Text text) {
		super();
		this.textId 		= text.getTextId();
		this.typeTextId 	= text.getTypeTextId().getTypeTextId();
		this.text 	= text.getTextBeta();
	}
	
}

package mx.gnc.as.gutsncode.model.management;

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
	private String textBeta;

	
	public TextOnlyRequieredDataForUser(Text text) {
		super();
		this.textId 		= text.getTextId();
		this.typeTextId 	= text.getTypeTextId().getTypeTextId();
		this.textBeta 	= text.getTextBeta();
	}
	
}
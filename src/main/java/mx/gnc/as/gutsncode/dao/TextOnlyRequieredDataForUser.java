package mx.gnc.as.gutsncode.dao;

import lombok.Data;

@Data
public class TextOnlyRequieredDataForUser {
	
	private Long textId;
	private Long typeTextId;
	private String textRealize;
	private byte[] imageBlob;
	
	public TextOnlyRequieredDataForUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TextOnlyRequieredDataForUser(Text text, byte[] image) {
		super();
		this.textId 		= text.getTextId();
		this.typeTextId 	= text.getTypeTextId().getTypePostId();
		this.textRealize 	= text.getTextRealize();
		this.imageBlob		= image;
	}
	
}

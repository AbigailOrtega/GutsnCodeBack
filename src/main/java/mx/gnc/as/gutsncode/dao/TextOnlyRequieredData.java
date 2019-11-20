package mx.gnc.as.gutsncode.dao;

import lombok.Data;

@Data
public class TextOnlyRequieredData {
	
	private Long textId;
	private String typeTextId;
	private String textBeta;
	private String textRealize;
	private Byte[] imageBlob;
	
	public TextOnlyRequieredData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TextOnlyRequieredData(Long textId, String typeTextId, String textBeta, String textRealize,
			Byte[] imageBlob) {
		super();
		this.textId = textId;
		this.typeTextId = typeTextId;
		this.textBeta = textBeta;
		this.textRealize = textRealize;
		this.imageBlob = imageBlob;
	}
	
}

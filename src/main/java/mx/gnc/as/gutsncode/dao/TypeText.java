package mx.gnc.as.gutsncode.dao;

public enum TypeText {
	
	HEADER(0L,"HEADER","HEADER"),
	BODY(1L, "BODY","BODY"),
	FOOTER(2L,"FOOTER", "FOOTER"),
	ANOTATION(3L,"ANOTATION","ANOTATION");
	
	private TypeText(Long typePostId, String name, String descripcion) {
		this.typeTextId=typePostId;
		this.name=name;
		this.descripcion=descripcion;
	}
	private Long typeTextId;
	private String name;
	private String descripcion;
	//private byte[] image;

	public Long getTypePostId() {
		return typeTextId;
	}

	public void setTypePostId(Long typePostId) {
		this.typeTextId = typePostId;
	}
	
}

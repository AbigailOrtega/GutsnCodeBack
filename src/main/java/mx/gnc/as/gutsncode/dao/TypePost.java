package mx.gnc.as.gutsncode.dao;

import lombok.Getter;

@Getter
public enum TypePost {
	NEW (0L,"NEW","TECNOLOGY NEW"),
	POST(1L, "POST","TECNOLOGY POST"),
	EXPERIENCE(2L,"EXPERIENCE", "FOUNDER EXPERIENCE"),
	FOUNDER(3L,"FOUNDER","FOUNDER BIOGRAPHY"),
	PHILOSOPHY(4L,"PHILOSOPHY","GUTS & CODE PHILOSOPHY"),
	FUTURE(5L,"FUTURE","GUTS & CODE FUTURE");
	
	private TypePost(Long typePostId, String name, String descripcion) {
		this.typePostId=typePostId;
		this.name=name;
		this.descripcion=descripcion;
	}
	private Long typePostId;
	private String name;
	private String descripcion;
	//private byte[] image;

	public Long getTypePostId() {
		return typePostId;
	}

	public void setTypePostId(Long typePostId) {
		this.typePostId = typePostId;
	}

}

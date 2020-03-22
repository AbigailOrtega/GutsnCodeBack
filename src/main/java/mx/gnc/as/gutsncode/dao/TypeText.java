package mx.gnc.as.gutsncode.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum TypeText {
	
	HEADER		(0L,"HEADER","HEADER"),
	BODY		(1L, "BODY","BODY"),
	FOOTER		(2L,"FOOTER", "FOOTER"),
	ANOTATION	(3L,"ANOTATION","ANOTATION");
	
	private Long typeTextId;
	private String name;
	private String descripcion;

}

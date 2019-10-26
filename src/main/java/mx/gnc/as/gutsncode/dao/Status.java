package mx.gnc.as.gutsncode.dao;

import lombok.Getter;

@Getter
public enum Status {
	PUBLISHED(0L,"PUBLISHED","PUBLISHED POST"),
	APPROVED(1L,"APPROVED", "APPROVED POST TO BE PUBLISHED "),
	REVISION(2L,"REVISION","REVISION POST"),
	EDITION(3L,"EDITION","EDITION COURSE");
	
	private Status(Long statusId, String name, String descripcion) {
		this.statusId=statusId;
		this.name=name;
		this.descripcion=descripcion;
	}
	
	private Long statusId;
	private String name;
	private String descripcion;
	
}

package mx.gnc.as.gutsncode.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
	
	PUBLISHED(0L,"PUBLISHED","PUBLISHED POST"),
	APPROVED(1L,"APPROVED", "APPROVED POST TO BE PUBLISHED "),
	REVISION(2L,"REVISION","REVISION POST"),
	EDITION(3L,"EDITION","EDITION COURSE");
	
	private Long statusId;
	private String name;
	private String descripcion;
	
	public static Status getEnum(String enumOption) {

		switch (enumOption.toLowerCase()) {
		case "published": 		return Status.PUBLISHED;
		case "approved": 		return Status.APPROVED;
		case "revision": 	return Status.REVISION;
		case "edition":	return Status.EDITION;
		default: 			return null;
		}
	}
}

package mx.gnc.as.gutsncode.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
	
	PUBLISHED (0L,"PUBLISHED","PUBLISHED POST"),
	APPROVED  (1L,"APPROVED", "APPROVED POST TO BE PUBLISHED "),
	REVISION  (2L,"REVISION","REVISION POST"),
	EDITION   (3L,"EDITION","EDITION COURSE"),
	PUBLIAPPR (4L,"PUBLIAPPR","PUBLISHED AND APPROVED"),
	PUBLIREV  (5L,"PUBLIREV","PUBLISHED AND REVISION"),
	PUBLIEDIT (6L,"PUBLIEDIT","PUBLISHED AND EDIT VERSION");
	
	
	private Long statusId;
	private String name;
	private String descripcion;
	
	public static Status getEnum(String enumOption) {

		switch (enumOption.toLowerCase()) {
		case "published": 	return Status.PUBLISHED;
		case "approved": 	return Status.APPROVED;
		case "revision": 	return Status.REVISION;
		case "edition":		return Status.EDITION;
		case "publiappr":	return Status.PUBLIAPPR;
		case "publirev":	return Status.PUBLIREV;
		case "publiedit":	return Status.PUBLIEDIT;
		default: 			return null;
		}
	}
}

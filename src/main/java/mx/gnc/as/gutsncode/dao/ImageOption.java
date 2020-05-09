package mx.gnc.as.gutsncode.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ImageOption {

	PINK	(0L, "PINK"),
	BLACK	(1L, "BLACK"),
	ORANGE	(2L, "ORANGE"),
	ORANGES	(3L, "ORANGES"),
	MINT	(4L, "MINT"),
	BLUE	(5L, "BLUE"), 
	BLUEK	(6L, "BLUEK"),
	BLUES	(7L, "BLUES"), 
	BROWN	(8L, "BROWN"),
	GREEN	(9L, "GREEN"); 
	

	private Long imageId;
	private String name;

	public static ImageOption getEnum(String enumOption) {

		switch (enumOption.toUpperCase()) {
		case "BLACK": 	return ImageOption.BLACK;
		case "ORANGE": 	return ImageOption.ORANGE;
		case "ORANGES": return ImageOption.ORANGES;
		case "BLUE":	return ImageOption.BLUE;
		case "BLUEK": 	return ImageOption.BLUEK;
		case "BLUES": 	return ImageOption.BLUES;
		case "BROWN": 	return ImageOption.BROWN;
		case "GREEN":	return ImageOption.GREEN;
		case "MINT":	return ImageOption.MINT;
		case "PINK":	return ImageOption.PINK;
		default: 		return ImageOption.BLACK;
		}
	}

}

package mx.gnc.as.gutsncode.model;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonRootName("snapshot")
public class DesktopSnapshot {

	private Integer pageNumber;
	private Integer sizePage;
	private String topic;
	private String type;
	
}

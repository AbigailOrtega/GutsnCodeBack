package mx.gnc.as.gutsncode.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReceiveObject {
	
	private Integer page;
	private Integer sizePage;
	private String topic;
	private String type;
	
}

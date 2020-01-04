package mx.gnc.as.gutsncode.model.management;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReceiveObjectRecent {	
	private Integer page;
	private Integer sizePage;
	private String founderName;
	private String[] topics;
	private String[] types;
	private String[] status;
}

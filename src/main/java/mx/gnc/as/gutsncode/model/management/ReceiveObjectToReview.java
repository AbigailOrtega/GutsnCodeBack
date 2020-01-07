package mx.gnc.as.gutsncode.model.management;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReceiveObjectToReview {
	private String reviewerName;
	private Integer pageNumber;
	private Integer sizePage;

}

package mx.gnc.as.gutsncode.model.management;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReceivePostData {
	private String postId ;
	private String status;
	private String name;
	private String typePost;
	private String topic;
	private String lastUpDate;
	private String title;
	private String parentId;
	private String childId;
}

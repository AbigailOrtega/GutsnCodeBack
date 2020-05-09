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
	private String imageOption;
	private String topic;
	private String lastUpDate;
	private String parentId;
	private String childId;
	private String user;
	private String location;
	private String header;
	private String body;
	private String footer;
}

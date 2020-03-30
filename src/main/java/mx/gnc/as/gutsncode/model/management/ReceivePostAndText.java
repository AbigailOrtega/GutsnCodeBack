package mx.gnc.as.gutsncode.model.management;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.gnc.as.gutsncode.dao.Post;
import mx.gnc.as.gutsncode.dao.Text;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReceivePostAndText {
	private Post post;
	private Text textHeader;
	private Text textBody;
	private Text textFooter;
}

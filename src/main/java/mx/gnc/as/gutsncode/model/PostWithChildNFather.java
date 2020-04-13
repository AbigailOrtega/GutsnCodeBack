package mx.gnc.as.gutsncode.model;

import java.math.BigInteger;
import java.util.Base64;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import mx.gnc.as.gutsncode.dao.Founder;
import mx.gnc.as.gutsncode.dao.ImageOption;
import mx.gnc.as.gutsncode.dao.Post;
import mx.gnc.as.gutsncode.dao.Status;
import mx.gnc.as.gutsncode.dao.TypePost;

@Data
@NoArgsConstructor
public class PostWithChildNFather {
	
	private Long postId ;
	private String name;
	private String topic;
	private BigInteger numberView;
	private TypePost typePostId;
	private Status statusId;
	private ImageOption imageId;
	private Date lastUpDate;
	private Founder writerId;
	private Founder reviewerId;
	private Date dateReview;
	private String title;
	private String location;
	private Post parentId;
	private Post childId;
	private Post postEditId;

	public PostWithChildNFather(Post post) {
		this.postId			=post.getPostId();
		this.name			=post.getName();
		this.numberView		=post.getNumberView();
		this.statusId		=post.getStatusId();
		this.topic			=post.getTopic();
		this.lastUpDate		=post.getLastUpDate();
		this.writerId		=post.getWriterId();
		this.reviewerId		=post.getReviewerId();
		this.dateReview		=post.getDateReview();
		this.typePostId		=post.getTypePostId();
		this.location		=post.getLocation();
		this.imageId		=post.getImageOptionId();
	}

	public boolean isNull() {
		if(this.name != null || this.postId != null || this.title != null)
			return false;
		else
			return true;
	}

}
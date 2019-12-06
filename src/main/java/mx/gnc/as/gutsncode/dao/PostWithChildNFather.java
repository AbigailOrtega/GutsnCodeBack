package mx.gnc.as.gutsncode.dao;

import java.math.BigInteger;
import java.util.Base64;
import java.util.Date;

import lombok.Data;

@Data
public class PostWithChildNFather {
	
	private Long postId ;
	private String name;
	private BigInteger numberView;
	private TypePost typePostId;
	private Status statusId;
	private String topic;
	private Date lastUpDate;
	private Founder writerId;
	private Founder reviewerId;
	private Date dateReview;
	private String title;
	private String location;
	private Post parentId;
	private String image;
	private Post childId;
	
	public PostWithChildNFather() {};
	
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
		this.title			=post.getTitle();
		this.location		=post.getLocation();
		if(post.getImage() != null)
		this.image			=Base64.getEncoder().encodeToString(post.getImage());
	}

	public boolean isNull() {
		if(this.name != null || this.postId != null || this.title != null)
			return false;
		else
			return true;
	}

	

}
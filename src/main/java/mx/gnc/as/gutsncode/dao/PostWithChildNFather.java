package mx.gnc.as.gutsncode.dao;

import java.math.BigInteger;
import java.util.Base64;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
//@ApiModel("POST MODEL")
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
	
	public PostWithChildNFather(Long postId, String name, BigInteger numberView, 
			Status statusId, String topic, 
			Date lastUpDate, Founder writerId, 
			Founder reviewerId, Date dateReview, 
			TypePost type, String title , 
			String location, Post parentId, 
			Post childId ) {
		this.postId = postId;
		this.name=name;
		this.numberView=numberView;
		this.statusId=statusId;
		this.topic=topic;
		this.lastUpDate=lastUpDate;
		this.writerId=writerId;
		this.reviewerId=reviewerId;
		this.dateReview=dateReview;
		this.typePostId=type;
		this.title=title;
		this.location=location;
		this.parentId=parentId;
		this.childId=childId;
	}

	
	public PostWithChildNFather(Long postId, String name, BigInteger numberView, 
			Status statusId, String topic, 
			Date lastUpDate, Founder writerId, 
			Founder reviewerId, Date dateReview, 
			TypePost typePostId, String title , 
			String location) {
		this.postId = postId;
		this.name=name;
		this.numberView=numberView;
		this.statusId=statusId;
		this.topic=topic;
		this.lastUpDate=lastUpDate;
		this.writerId=writerId;
		this.reviewerId=reviewerId;
		this.dateReview=dateReview;
		this.typePostId=typePostId;
		this.title=title;
		this.location=location;
	}
	
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
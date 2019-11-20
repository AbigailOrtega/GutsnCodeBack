package mx.gnc.as.gutsncode.dao;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Entity
@Table(name = "POST")
//@ApiModel("POST MODEL")
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "POST_ID")
//	@ApiModelProperty(value = "the post's id", required = true)
	private Long postId ;
	
//	@ApiModelProperty(value = "the post's name", required = true)
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "NUMBER_VIEW")
	private BigInteger numberView;
	
	@Enumerated(EnumType.ORDINAL)
	private TypePost typePostId;
	
	
	@Enumerated(EnumType.ORDINAL)
	private Status statusId;
	
	@Column(name = "TOPIC")
	private String topic;
	@Column(name = "LAST_UPDATE")
	private Date lastUpDate;
	
	@ManyToOne
	@JoinColumn(name = "WRITTER_ID")
	private Founder writerId;
	
	@ManyToOne
	@JoinColumn(name = "REVIEWER_ID")
	private Founder reviewerId;
	
	
	@Column(name = "DATE_REVIEWER")
	private Date dateReview;
	
	
	@Column(name = "TITLE")
	private String title;
	@Column(name = "LOCATION")
	private String location;
	
	@OneToOne
	@JoinColumn(name = "PARENT_ID")
	private Post parentId;
	
	@Column(name = "IMAGE")
	private Byte[] image;
	
	@OneToOne
	@JoinColumn(name = "CHILD_ID")
	private Post childId;
	
	public Post() {};
	
	public Post(String name, BigInteger numberView, 
			Status statusId, String topic, 
			Date lastUpDate, Founder writerId, 
			Founder reviewerId, Date dateReview, 
			TypePost type, String title , 
			String location, Post parentId, 
			Post childId ) {
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

	
	public Post(String name, BigInteger numberView, 
			Status statusId, String topic, 
			Date lastUpDate, Founder writerId, 
			Founder reviewerId, Date dateReview, 
			TypePost typePostId, String title , 
			String location) {
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

	public Long getPostId() {
		return postId;
	}
}
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
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
	
//	@OneToOne
//	@JoinColumn(name = "CHILD_ID")
	@Column(name = "PARENT_ID")
	private Long parentId;
	
	@Column(name = "IMAGE")	
	private byte[] image;
	
//	@OneToOne
//	@JoinColumn(name = "PARENT_ID")
	@Column(name = "CHILD_ID")
	private Long childId;
	
	
	public boolean isNull() {
		if(this.name != null || this.postId != null || this.title != null)
			return false;
		else
			return true;
	}

	public Post(String name, BigInteger numberView, TypePost typePostId, Status statusId,
			String topic, Date lastUpDate, Founder writerId, Founder reviewerId, 
			Date dateReview, String title, String location) {
		this.name = name;
		this.numberView = numberView;
		this.typePostId = typePostId;
		this.statusId = statusId;
		this.topic = topic;
		this.lastUpDate = lastUpDate;
		this.writerId = writerId;
		this.reviewerId = reviewerId;
		this.dateReview = dateReview;
		this.title = title;
		this.location = location;
	}

}
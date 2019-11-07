package mx.gnc.as.gutsncode.dao;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "TEXT")
public class Text {
	
	@Id
	@Column(name = "TEXT_ID")
	private String textId;
	
	@Enumerated(EnumType.ORDINAL)
	private TypeText typeTextId;
	
	@ManyToOne
	@JoinColumn(name = "POST_ID")
	private Post postId;
	
	@Column(name = "TEXT_BETA")
	private String textBeta;
	@Column(name = "TEXT_REALIZE")
	private String textRealize;
	
	public Text(String textId, TypeText typeTextId, Post postId, String textBeta, String textRealize) {
		super();
		this.textId = textId;
		this.typeTextId = typeTextId;
		this.postId = postId;
		this.textBeta = textBeta;
		this.textRealize = textRealize;
	}
	public Text() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

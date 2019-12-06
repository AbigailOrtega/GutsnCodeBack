package mx.gnc.as.gutsncode.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "TEXT")
public class Text {
	
	@Id
	@Column(name = "TEXT_ID")
	private Long textId;
	
	@Enumerated(EnumType.ORDINAL)
	private TypeText typeTextId;
	
	@ManyToOne
	@JoinColumn(name = "POST_ID")
	private Post postId;
	
	@Column(name = "TEXT_BETA")
	private String textBeta;
	@Column(name = "TEXT_REALIZE")
	private String textRealize;
	
}

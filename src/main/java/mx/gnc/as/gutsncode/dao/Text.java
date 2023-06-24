package mx.gnc.as.gutsncode.dao;

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
@Table(name = "TEXT")
public class Text {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TEXT_ID")
	private Long textId;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "TYPE_TEXT_ID"
	, columnDefinition="bigint"
	)
	private TypeText typeTextId;
	
	@ManyToOne
	@JoinColumn(name = "POST_ID"
	, columnDefinition="bigint"
	)
	private Post postId;
	
	@Column(name = "TEXT_BETA")
	private String textBeta;
	@Column(name = "TEXT_REALIZE")
	private String textRealize;
	
}

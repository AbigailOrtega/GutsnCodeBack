package mx.gnc.as.gutsncode.dao;

import lombok.Data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name="MESSAGE")
public class Message{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MESSAGE_ID")
    private Long messageId;
    @Column(name="MESSAGE_TEXT")
    private String message_text;
    
    @ManyToOne
    @JoinColumn(name="SENDER_ID")
    private Founder sender_id;
    
    @ManyToOne
    @JoinColumn(name="RECEIVER_ID")
    private Founder receiver_id;
    
    @Column(name="CLASSIFICATION")
    private String classification;
    @Column(name="DATE_RECEIVE")
    private Date date_receive;
    @Column(name="STATUS")
    private Boolean status;
	
	public Message() {
		super();
	}

	public Message(Long messageId, String message_text, Founder sender_id, Founder receiver_id, String classification,
			Date date_receive, Boolean status) {
		super();
		this.messageId = messageId;
		this.message_text = message_text;
		this.sender_id = sender_id;
		this.receiver_id = receiver_id;
		this.classification = classification;
		this.date_receive = date_receive;
		this.status = status;
	}

}

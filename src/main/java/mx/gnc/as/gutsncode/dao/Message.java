package mx.gnc.as.gutsncode.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="MESSAGE")
public class Message{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MESSAGE_ID")
    private Long messageId;
    @Column(name="MESSAGE_TEXT")
    private String message_text;
    
    @ManyToOne
    @JoinColumn(name="SENDER_ID", columnDefinition="bigint")
    private Founder sender_id;
    
    @ManyToOne
    @JoinColumn(name="RECEIVER_ID", columnDefinition="bigint")
    private Founder receiver_id;
    
    @Column(name="CLASSIFICATION")
    private String classification;
    @Column(name="DATE_RECEIVE")
    private Date date_receive;
    @Column(name="STATUS")
    private Boolean status;
	
}

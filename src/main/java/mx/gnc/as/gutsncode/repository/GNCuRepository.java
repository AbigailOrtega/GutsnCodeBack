package mx.gnc.as.gutsncode.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.gnc.as.gutsncode.dao.Founder;
import mx.gnc.as.gutsncode.dao.Image;
import mx.gnc.as.gutsncode.dao.Post;
import mx.gnc.as.gutsncode.dao.Status;
import mx.gnc.as.gutsncode.dao.Text;
import mx.gnc.as.gutsncode.dao.TypePost;

@Repository
public interface GNCuRepository extends CrudRepository<Post, Long>{

	@Query(value = "SELECT p FROM Post p where p.statusId in :status and p.typePostId=:type and p.topic like %:topic% order by lastUpDate desc")
	List<Post> getPostOrdered( List <Status> status, TypePost type, String topic, Pageable  pageRequest);
	
	@Query(value = "SELECT COUNT(p) FROM Post p where p.statusId=:status and p.typePostId=:type and p.topic like %:topic%")
	Integer numberTotalPost( Status status, TypePost type, String topic);
	
	@Query(value = "SELECT p FROM Post p where postId=:postId")
	Post getPostContent(Long postId);
	
	@Query(value = "SELECT t FROM Text t where t.postId.postId=:postId")
	List<Text> getTextContent(Long postId);
	
	@Query(value= "SELECT i FROM Image i where i.textId.textId=:textId")
	List<Image> getImage(Long textId);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE Post p SET p.numberView = p.numberView + :newVisits where postId=:postId")
	Integer incrementViewCounter(Long postId, BigInteger newVisits);
	
	@Query(value = "SELECT numberView FROM Post where postId=:postId")
	Integer getViewCounter(Long postId);
	
	@Query(value = "SELECT f FROM Founder f where f.name like %:name% or f.lastName like %:name%")
	Founder getFounderInfo(String name);
	
}

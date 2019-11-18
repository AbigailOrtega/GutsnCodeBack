package mx.gnc.as.gutsncode.services.gncu;

import java.math.BigInteger;
import java.sql.Blob;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import mx.gnc.as.gutsncode.dao.Image;
import mx.gnc.as.gutsncode.dao.Post;
import mx.gnc.as.gutsncode.dao.Status;
import mx.gnc.as.gutsncode.dao.Text;
import mx.gnc.as.gutsncode.dao.TypePost;

public interface GnCuRepository extends   CrudRepository<Post, Long>{
	
	List<Post> findAll();
	
	@Query(value = "SELECT p FROM Post p where p.statusId=:status and p.typePostId=:type and p.topic like %:topic% order by lastUpDate desc")
	List<Post> findTop2LastTwenty( Status status, TypePost type, String topic, Pageable  pageRequest);
	
	@Query(value = "SELECT COUNT(p) FROM Post p where p.statusId=:status and p.typePostId=:type and p.topic like %:topic%")
	Integer numberTotalPost( Status status, TypePost type, String topic);
	
	@Query(value = "SELECT t FROM Text t where t.postId.postId=:postId")
	List<Text> getTextContent(Long postId);
	
	@Query(value = "SELECT p FROM Post p where postId=:postId")
	Post getPostContent(Long postId);
	
	@Query(value= "SELECT i FROM Image i where i.imageId=:postId")
	Image getImage(Long postId);
	
}

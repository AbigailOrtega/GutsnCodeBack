package mx.gnc.as.gutsncode.services;

import java.math.BigInteger;
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



public interface GeneralRepository extends   CrudRepository<Post, Long>{
	
	List<Post> findAll();
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE Post p SET p.numberView = p.numberView + :newVisits where postId=:postId")
	Integer incrementViewCounter(Long postId, BigInteger  newVisits);
	
	@Query(value = "SELECT numberView FROM Post where postId=:postId")
	Integer getViewCounter(Long postId);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE from Text where post_id =:postId")
	Integer deleteRelatedText(Long postId);
	
	@Modifying
	@Transactional
	@Query(value = "Delete from Post where post_id =:postId")
	Integer deletePost(Long postId);
	
}

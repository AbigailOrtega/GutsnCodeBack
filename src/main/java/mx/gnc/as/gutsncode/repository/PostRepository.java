package mx.gnc.as.gutsncode.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import mx.gnc.as.gutsncode.dao.Image;
import mx.gnc.as.gutsncode.dao.Post;
import mx.gnc.as.gutsncode.dao.Status;
import mx.gnc.as.gutsncode.dao.Text;
import mx.gnc.as.gutsncode.dao.TypePost;



public interface PostRepository extends   CrudRepository<Post, Long>{
	
	List<Post> findAll();
	
	@Query(value = "SELECT p FROM Post p where p.statusId=:status and p.typePostId=:type and p.topic like %:topic% order by lastUpDate desc")
//	List<Post> findTop2LastTwenty( Status status, TypePost type, Pageable  pageRequest);
	List<Post> findTop2LastTwenty( Status status, TypePost type, String topic, Pageable  pageRequest);
	
	@Query(value = "SELECT p FROM Text p where p.postId.postId=?1")
	List<Text> getTextContent(Long postId);
	
	@Query(value= "SELECT i FROM Image i where i.imageId=?1")
	Image getImage(Long postId);
//	@Query(value = "SELECT p FROM Post  order by lastUpDate desc")
//	List<Post> findTop2LastTwenty( Status status, TypePost type, Pageable  pageRequest);
	
}

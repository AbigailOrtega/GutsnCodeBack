package mx.gnc.as.gutsncode.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import mx.gnc.as.gutsncode.dao.Post;
import mx.gnc.as.gutsncode.dao.Status;
import mx.gnc.as.gutsncode.dao.TypePost;



public interface PostRepository extends   CrudRepository<Post, Long>{
	
	List<Post> findAll();
	
	@Query(value = "SELECT p FROM Post p where p.statusId=:status and p.typePostId=:type order by lastUpDate desc")
	List<Post> findTop2LastTwenty( Status status, TypePost type, Pageable  pageRequest);
	
	
	
}

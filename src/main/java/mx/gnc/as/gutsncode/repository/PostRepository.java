package mx.gnc.as.gutsncode.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import mx.gnc.as.gutsncode.dao.Post;



public interface PostRepository extends   CrudRepository<Post, Long>{
	List<Post> findAll();
}

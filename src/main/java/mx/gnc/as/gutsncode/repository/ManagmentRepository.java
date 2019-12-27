package mx.gnc.as.gutsncode.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.gnc.as.gutsncode.dao.Post;
import mx.gnc.as.gutsncode.dao.Status;
import mx.gnc.as.gutsncode.dao.TypePost;

@Repository
public interface ManagmentRepository extends CrudRepository<Post, Long>{
	
	@Query(value = "SELECT p FROM Post p where p.statusId=:status and p.typePostId=:type and p.writerId.name=:name order by lastUpDate desc")
	List<Post> getPostRelated( Status status, TypePost type,  Pageable  pageRequest, String name);

}

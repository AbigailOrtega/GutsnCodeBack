package mx.gnc.as.gutsncode.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.gnc.as.gutsncode.dao.Post;
import mx.gnc.as.gutsncode.dao.Status;
import mx.gnc.as.gutsncode.dao.Text;
import mx.gnc.as.gutsncode.dao.TypePost;


@Repository
public interface ManagmentRepository extends CrudRepository<Post, Long>{
	
	@Query(value = "SELECT p FROM Post p where p.writerId.name=:name order by lastUpDate desc")
	List<Post> getPostRelated( Pageable  pageRequest, String name);

	@Query(value = "SELECT t FROM Text t where t.postId.postId=:postId")
	List<Text> getTextContent(Long postId);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE Text p SET p.textBeta =:textBeta where textId=:textId")
	Integer updateTextBeta(String textBeta, Long textId);
	
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE Text p SET p.textRealize =p.textBeta where textId=:textId")
	Integer switchBetaRealize(Long textId);
}

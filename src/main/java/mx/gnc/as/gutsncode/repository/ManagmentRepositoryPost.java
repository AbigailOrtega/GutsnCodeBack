package mx.gnc.as.gutsncode.repository;

import java.util.List;
import java.util.Set;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
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
public interface ManagmentRepositoryPost extends CrudRepository<Post, Long>{
	@Query(value = "SELECT p FROM Post p where p.statusId IN :status and p.typePostId IN :type and p.writerId.name=:nameFounder and p.topic IN :topic order by lastUpDate desc")
	List<Post> getPostRelatedCompleteParams(String nameFounder, Set<Status> status, Set<TypePost> type, List<String> topic, Pageable  pageRequest);
	
	@Query(value = "SELECT p FROM Post p where p.statusId IN :status and p.typePostId IN :type and p.writerId.name=:nameFounder order by lastUpDate desc")
	List<Post> getPostRelatedStatusAndType(String nameFounder, Set<Status> status, Set<TypePost>  type,  Pageable  pageRequest);
	
	@Query(value = "SELECT p FROM Post p where p.statusId IN :status and p.writerId.name=:nameFounder and p.topic IN :topic order by lastUpDate desc")
	List<Post> getPostRelatedStatusAndTopic(String nameFounder, Set<Status> status,  List<String> topic, Pageable  pageRequest);
	
	@Query(value = "SELECT p FROM Post p where p.typePostId IN :type and p.writerId.name=:nameFounder and p.topic IN :topic order by lastUpDate desc")
	List<Post> getPostRelatedTypeAndTopic(String nameFounder, Set<TypePost>  type, List<String> topic, Pageable  pageRequest);
	
	@Query(value = "SELECT p FROM Post p where p.statusId IN :status  and p.writerId.name=:nameFounder  order by lastUpDate desc")
	List<Post> getPostRelatedStatus(String nameFounder, Set<Status> status, Pageable  pageRequest);
	
	@Query(value = "SELECT p FROM Post p where  p.writerId.name=:nameFounder and p.topic IN :topic order by lastUpDate desc")
	List<Post> getPostRelatedTopic(String nameFounder, List<String> topic, Pageable  pageRequest);
	
	@Query(value = "SELECT p FROM Post p where  p.typePostId IN :type and p.writerId.name=:nameFounder  order by lastUpDate desc")
	List<Post> getPostRelatedType(String nameFounder,  Set<TypePost> type,  Pageable  pageRequest);

	@Query(value = "SELECT p FROM Post p where p.writerId.name=:nameFounder order by lastUpDate desc")
	List<Post> getPostRelated(  String nameFounder, Pageable  pageRequest);
	
	
	@Query(value = "SELECT COUNT(p) FROM Post p where p.statusId IN :status and p.typePostId IN :type and p.writerId.name=:nameFounder and p.topic IN :topic")
	Integer getCountPostRelatedCompleteParams(String nameFounder, Set<Status> status, Set<TypePost> type, List<String> topic);
	
	@Query(value = "SELECT COUNT(p) FROM Post p where p.statusId IN :status and p.typePostId IN :type and p.writerId.name=:nameFounder")
	Integer getCountPostRelatedStatusAndType(String nameFounder, Set<Status> status, Set<TypePost>  type);
	
	@Query(value = "SELECT COUNT(p) FROM Post p where p.statusId IN :status and p.writerId.name=:nameFounder and p.topic IN :topic")
	Integer getCountPostRelatedStatusAndTopic(String nameFounder, Set<Status> status,  List<String> topic);
	
	@Query(value = "SELECT COUNT(p) FROM Post p where p.typePostId IN :type and p.writerId.name=:nameFounder and p.topic IN :topic")
	Integer getCountPostRelatedTypeAndTopic(String nameFounder, Set<TypePost>  type, List<String> topic);
	
	@Query(value = "SELECT COUNT(p) FROM Post p where p.statusId IN :status  and p.writerId.name=:nameFounder ")
	Integer getCountPostRelatedStatus(String nameFounder, Set<Status> status);
	
	@Query(value = "SELECT COUNT(p) FROM Post p where  p.writerId.name=:nameFounder and p.topic IN :topic")
	Integer getCountPostRelatedTopic(String nameFounder, List<String> topic);
	
	@Query(value = "SELECT COUNT(p) FROM Post p where  p.typePostId IN :type and p.writerId.name=:nameFounder ")
	Integer getCountPostRelatedType(String nameFounder,  Set<TypePost> type);
//	
	@Query(value = "SELECT COUNT(p) FROM Post p where p.writerId.name=:nameFounder")
	Integer getCountPostRelated(String nameFounder);
	

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
	
	
	@Query(value = "SELECT distinct p.topic FROM Post p where p.writerId.name=:nameFounder")
	Set<String> getTopics(String nameFounder);
	
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE Post p SET p.statusId=:status where postId=:postId")
	Integer updateStatusPost(Status status, Long postId);
	
	@Query(value = "SELECT p FROM Post p where p.reviewerId.name=:nameReviewer and p.statusId=:status order by lastUpDate asc")
	List<Post> getPostToReview(Status status, String nameReviewer, Pageable  pageRequest);
}

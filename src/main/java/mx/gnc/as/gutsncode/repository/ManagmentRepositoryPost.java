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

import mx.gnc.as.gutsncode.dao.Founder;
import mx.gnc.as.gutsncode.dao.ImageOption;
import mx.gnc.as.gutsncode.dao.Post;
import mx.gnc.as.gutsncode.dao.Status;
import mx.gnc.as.gutsncode.dao.Text;
import mx.gnc.as.gutsncode.dao.TypePost;


@Repository
public interface ManagmentRepositoryPost extends CrudRepository<Post, Long>{
	
	//GET POST WROTE BY
	@Query(value = "SELECT p FROM Post p where p.statusId IN :status and p.typePostId IN :type and p.writerId.alias=:nameFounder and p.topic IN :topic order by lastUpDate desc")
	List<Post> getPostRelatedCompleteParams(String nameFounder, Set<Status> status, Set<TypePost> type, List<String> topic, Pageable  pageRequest);
	
	@Query(value = "SELECT p FROM Post p where p.statusId IN :status and p.typePostId IN :type and p.writerId.alias=:nameFounder order by lastUpDate desc")
	List<Post> getPostRelatedStatusAndType(String nameFounder, Set<Status> status, Set<TypePost>  type,  Pageable  pageRequest);
	
	@Query(value = "SELECT p FROM Post p where p.statusId IN :status and p.writerId.alias=:nameFounder and p.topic IN :topic order by lastUpDate desc")
	List<Post> getPostRelatedStatusAndTopic(String nameFounder, Set<Status> status,  List<String> topic, Pageable  pageRequest);
	
	@Query(value = "SELECT p FROM Post p where p.typePostId IN :type and p.writerId.alias=:nameFounder and p.topic IN :topic order by lastUpDate desc")
	List<Post> getPostRelatedTypeAndTopic(String nameFounder, Set<TypePost>  type, List<String> topic, Pageable  pageRequest);
	
	@Query(value = "SELECT p FROM Post p where p.statusId IN :status  and p.writerId.alias=:nameFounder  order by lastUpDate desc")
	List<Post> getPostRelatedStatus(String nameFounder, Set<Status> status, Pageable  pageRequest);
	
	@Query(value = "SELECT p FROM Post p where  p.writerId.alias=:nameFounder and p.topic IN :topic order by lastUpDate desc")
	List<Post> getPostRelatedTopic(String nameFounder, List<String> topic, Pageable  pageRequest);
	
	@Query(value = "SELECT p FROM Post p where  p.typePostId IN :type and p.writerId.alias=:nameFounder  order by lastUpDate desc")
	List<Post> getPostRelatedType(String nameFounder,  Set<TypePost> type,  Pageable  pageRequest);

	@Query(value = "SELECT p FROM Post p where p.writerId.alias=:nameFounder order by lastUpDate desc")
	List<Post> getPostRelated(  String nameFounder, Pageable  pageRequest);
	
	//COUNT POST WROTE BY
	@Query(value = "SELECT COUNT(p) FROM Post p where p.statusId IN :status and p.typePostId IN :type and p.writerId.alias=:nameFounder and p.topic IN :topic")
	Integer getCountPostRelatedCompleteParams(String nameFounder, Set<Status> status, Set<TypePost> type, List<String> topic);
	
	@Query(value = "SELECT COUNT(p) FROM Post p where p.statusId IN :status and p.typePostId IN :type and p.writerId.alias=:nameFounder")
	Integer getCountPostRelatedStatusAndType(String nameFounder, Set<Status> status, Set<TypePost>  type);
	
	@Query(value = "SELECT COUNT(p) FROM Post p where p.statusId IN :status and p.writerId.alias=:nameFounder and p.topic IN :topic")
	Integer getCountPostRelatedStatusAndTopic(String nameFounder, Set<Status> status,  List<String> topic);
	
	@Query(value = "SELECT COUNT(p) FROM Post p where p.typePostId IN :type and p.writerId.alias=:nameFounder and p.topic IN :topic")
	Integer getCountPostRelatedTypeAndTopic(String nameFounder, Set<TypePost>  type, List<String> topic);
	
	@Query(value = "SELECT COUNT(p) FROM Post p where p.statusId IN :status  and p.writerId.alias=:nameFounder ")
	Integer getCountPostRelatedStatus(String nameFounder, Set<Status> status);
	
	@Query(value = "SELECT COUNT(p) FROM Post p where  p.writerId.alias=:nameFounder and p.topic IN :topic")
	Integer getCountPostRelatedTopic(String nameFounder, List<String> topic);
	
	@Query(value = "SELECT COUNT(p) FROM Post p where  p.typePostId IN :type and p.writerId.alias=:nameFounder ")
	Integer getCountPostRelatedType(String nameFounder,  Set<TypePost> type);
	
	@Query(value = "SELECT COUNT(p) FROM Post p where p.writerId.alias=:nameFounder")
	Integer getCountPostRelated(String nameFounder);
	
	
	//GET POST TO CHECK BY
	@Query(value = "SELECT p FROM Post p where p.statusId IN :status and p.typePostId IN :type and p.reviewerId.alias=:nameFounder and p.topic IN :topic order by lastUpDate desc")
	List<Post> getPostToCheckCompleteParams(String nameFounder, Set<Status> status, Set<TypePost> type, List<String> topic, Pageable  pageRequest);
	
	@Query(value = "SELECT p FROM Post p where p.statusId IN :status and p.typePostId IN :type and p.reviewerId.alias=:nameFounder order by lastUpDate desc")
	List<Post> getPostToCheckStatusAndType(String nameFounder, Set<Status> status, Set<TypePost>  type,  Pageable  pageRequest);
	
	@Query(value = "SELECT p FROM Post p where p.statusId IN :status and p.reviewerId.alias=:nameFounder and p.topic IN :topic order by lastUpDate desc")
	List<Post> getPostToCheckStatusAndTopic(String nameFounder, Set<Status> status,  List<String> topic, Pageable  pageRequest);
	
	@Query(value = "SELECT p FROM Post p where p.typePostId IN :type and p.reviewerId.alias=:nameFounder and p.topic IN :topic order by lastUpDate desc")
	List<Post> getPostToCheckTypeAndTopic(String nameFounder, Set<TypePost>  type, List<String> topic, Pageable  pageRequest);
	
	@Query(value = "SELECT p FROM Post p where p.statusId IN :status  and p.reviewerId.alias=:nameFounder  order by lastUpDate desc")
	List<Post> getPostToCheckStatus(String nameFounder, Set<Status> status, Pageable  pageRequest);
	
	@Query(value = "SELECT p FROM Post p where  p.reviewerId.alias=:nameFounder and p.topic IN :topic order by lastUpDate desc")
	List<Post> getPostToCheckTopic(String nameFounder, List<String> topic, Pageable  pageRequest);
	
	@Query(value = "SELECT p FROM Post p where  p.typePostId IN :type and p.reviewerId.alias=:nameFounder  order by lastUpDate desc")
	List<Post> getPostToCheckType(String nameFounder,  Set<TypePost> type,  Pageable  pageRequest);

	@Query(value = "SELECT p FROM Post p where p.reviewerId.alias=:nameFounder order by lastUpDate desc")
	List<Post> getPostToCheck(  String nameFounder, Pageable  pageRequest);
	
	//COUNT POST TO CHECK BY
	@Query(value = "SELECT COUNT(p) FROM Post p where p.statusId IN :status and p.typePostId IN :type and p.reviewerId.alias=:nameFounder and p.topic IN :topic")
	Integer getCountPostToCheckCompleteParams(String nameFounder, Set<Status> status, Set<TypePost> type, List<String> topic);
	
	@Query(value = "SELECT COUNT(p) FROM Post p where p.statusId IN :status and p.typePostId IN :type and p.reviewerId.alias=:nameFounder")
	Integer getCountPostToCheckStatusAndType(String nameFounder, Set<Status> status, Set<TypePost>  type);
	
	@Query(value = "SELECT COUNT(p) FROM Post p where p.statusId IN :status and p.reviewerId.alias=:nameFounder and p.topic IN :topic")
	Integer getCountPostToCheckStatusAndTopic(String nameFounder, Set<Status> status,  List<String> topic);
	
	@Query(value = "SELECT COUNT(p) FROM Post p where p.typePostId IN :type and p.reviewerId.alias=:nameFounder and p.topic IN :topic")
	Integer getCountPostToCheckTypeAndTopic(String nameFounder, Set<TypePost>  type, List<String> topic);
	
	@Query(value = "SELECT COUNT(p) FROM Post p where p.statusId IN :status  and p.reviewerId.alias=:nameFounder ")
	Integer getCountPostToCheckStatus(String nameFounder, Set<Status> status);
	
	@Query(value = "SELECT COUNT(p) FROM Post p where  p.reviewerId.alias=:nameFounder and p.topic IN :topic")
	Integer getCountPostToCheckTopic(String nameFounder, List<String> topic);
	
	@Query(value = "SELECT COUNT(p) FROM Post p where  p.typePostId IN :type and p.reviewerId.alias=:nameFounder ")
	Integer getCountPostToCheckType(String nameFounder,  Set<TypePost> type);
	
	@Query(value = "SELECT COUNT(p) FROM Post p where p.reviewerId.alias=:nameFounder")
	Integer getCountPostToCheck(String nameFounder);
	
	

	@Query(value = "SELECT t FROM Text t where t.postId.postId=:postId")
	List<Text> getTextContent(Long postId);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE Text p SET p.textBeta =:textBeta where textId=:textId")
	Integer updateTextBeta(String textBeta, Long textId);
	
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE Text p SET p.textRealize = p.textBeta, p.textBeta = '' where textId=:textId")
	Integer publishText(Long textId);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE Text p SET p.textBeta =p.textRealize where textId=:textId")
	Integer startToEdit(Long textId);
	

	@Query(value = "SELECT distinct p.topic FROM Post p")
	Set<String> getAllTopics(String nameFounder);
	
	@Query(value = "SELECT distinct p.topic FROM Post p where p.writerId.alias=:nameFounder")
	Set<String> getTopics(String nameFounder);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE Post p SET p.name =:name, p.topic=:topic, p.typePostId=:typePost, p.imageId=:imageOption, p.parentId=:parent, p.childId =:child where p.postId=:postId")
	Integer updatePost(String name, String topic, TypePost typePost, ImageOption imageOption, Long parent, Long child, Long postId);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE Post p SET p.statusId=:status where postId=:postId")
	Integer updateStatusPost(Status status, Long postId);
	
	@Query(value = "SELECT p FROM Post p where p.reviewerId.name=:nameReviewer and p.statusId=:status order by lastUpDate asc")
	List<Post> getPostToReview(Status status, String nameReviewer, Pageable  pageRequest);

	@Query(value = "SELECT f FROM Founder f where f.alias =:user")
	Founder getFounder(String user);
	
	@Query(value = "SELECT f FROM Founder f where f.alias !=:user")
	List<Founder> getEditors(String user);
	
	@Query(value = "SELECT max(POST_ID) + 1 FROM Post p")
	Integer getNewPostId();
	
//	@Query(value = "SELECT f FROM founder f where f.founderId = (SELECT editorId FROM founder f where f. :user)")
//	Founder getEditor(String user);
}

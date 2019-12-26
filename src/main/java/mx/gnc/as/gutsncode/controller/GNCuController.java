package mx.gnc.as.gutsncode.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import mx.gnc.as.gutsncode.dao.Founder;
import mx.gnc.as.gutsncode.dao.Image;
import mx.gnc.as.gutsncode.dao.Post;
import mx.gnc.as.gutsncode.dao.Status;
import mx.gnc.as.gutsncode.dao.Text;
import mx.gnc.as.gutsncode.dao.TypePost;
import mx.gnc.as.gutsncode.exceptions.ResourceNotFoundException;
import mx.gnc.as.gutsncode.model.FounderReduced;
import mx.gnc.as.gutsncode.model.ImageReduced;
import mx.gnc.as.gutsncode.model.Name;
import mx.gnc.as.gutsncode.model.PostId;
import mx.gnc.as.gutsncode.model.PostWithChildNFather;
import mx.gnc.as.gutsncode.model.ReceiveObject;
import mx.gnc.as.gutsncode.model.TextId;
import mx.gnc.as.gutsncode.model.TextOnlyRequieredDataForUser;
import mx.gnc.as.gutsncode.repository.GNCuRepository;

@RestController
@RequestMapping("/gncu")
@CrossOrigin(origins = "http://localhost:4200")
@Api(value = "User GNC Services")
public class GNCuController {
	
	private final Integer defaultSizePage = 20;
	
	private static final Logger LOG = LogManager.getLogger(GNCuController.class);
	
	@Autowired
	private GNCuRepository gncRepository;
	
	@PostMapping(value = "/recentPost")
	@ApiOperation(value = "Return the recent post", notes = "need type and topic, pageNumber are 0 by default and pageSize are 20 by default")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "The payload was correct"),
			@ApiResponse(code = 204, message = "The payload do not contain correct/enough info"),
			@ApiResponse(code = 400, message = "The payload do not contain required info") 
			})
	public ResponseEntity<List<Post>> postBy20(@RequestBody ReceiveObject receiver) throws ResourceNotFoundException {
		
		LOG.info("recentPost service");
		
		Integer pageNumber = (receiver.getPage()!=null)? receiver.getPage():0;
		Integer sizePage = (receiver.getSizePage()!=null)? receiver.getSizePage():this.defaultSizePage;
		String topic = (receiver.getTopic()!=null)? receiver.getTopic().toLowerCase():"";
		String type;

		List<Post> listPost;
		
		if(receiver.getType() != null) {
			LOG.info("REQUIRED DATA VALID");
			type = receiver.getType();
		}else {
			LOG.error("BAD REQUEST for: " + receiver.toString());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		listPost = gncRepository.getPostOrdered(Status.PUBLISHED, TypePost.getEnum(type), topic, PageRequest.of(pageNumber, sizePage));
		if(listPost == null || listPost.size() == 0) {
			LOG.warn("NO CONTENT for: " + receiver.toString());
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		LOG.info("SUCCESS REQUEST, SENDING INFO");
		return new ResponseEntity<>(listPost, HttpStatus.OK);
	}
	
	@PostMapping("/totalPages")
	@ApiOperation(value = "Return the numbers of pages", notes = "That pages are related according to Type Post and Topic, pageNumber are 0 by default and pageSize are 20 by default" )
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "The payload was correct"),
			@ApiResponse(code = 204, message = "The payload do not contain correct/enough info"),
			@ApiResponse(code = 400, message = "The payload do not contain required info") 
			})
	public ResponseEntity<Integer> totalPages(@RequestBody ReceiveObject receiver) throws ResourceNotFoundException {
		
		LOG.info("totalPages Service");
		Integer sizePage = (receiver.getSizePage()!=null)? receiver.getSizePage():this.defaultSizePage;
		String topic = (receiver.getTopic()!=null)? receiver.getTopic().toLowerCase():"";
		String type;

		if(receiver.getType() != null) {
			type = receiver.getType();
		}
		else {
			LOG.error("BAD REQUEST for: " + receiver.toString());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Integer totalPost = gncRepository.numberTotalPost(Status.PUBLISHED, TypePost.getEnum(type), topic);
		if(totalPost.compareTo(0) == 0)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		LOG.info("SUCCESS REQUEST, SENDING INFO");
		return new ResponseEntity<Integer>((totalPost / (sizePage + 1)) + 1, HttpStatus.OK);
	}

	@PostMapping("/getInfo")
	@ApiOperation(value = "Return the main informartion of a Post or New", notes = "" )
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "The payload was correct"),
			@ApiResponse(code = 204, message = "The payload do not contain correct/enough info"),
			@ApiResponse(code = 400, message = "The payload do not contain required info") 
			})
	public ResponseEntity<PostWithChildNFather> getInfoPost(@RequestBody PostId receiver) throws ResourceNotFoundException {

		Long postId;
		
		if(receiver.getPostId() != null) {
			postId = receiver.getPostId();
		}
		else {
			LOG.error("BAD REQUEST for: " + receiver.toString());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Post post = gncRepository.getPostContent(postId);
		if(post.isNull())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		PostWithChildNFather withChildNFather = new PostWithChildNFather(post);
		
		if(post.getParentId() != null) {
			withChildNFather.setParentId(gncRepository.getPostContent(post.getParentId()));
		}
		
		if(post.getChildId() != null) {
			withChildNFather.setChildId(gncRepository.getPostContent(post.getChildId()));
		}

		LOG.info("SUCCESS REQUEST, SENDING INFO");
		return new ResponseEntity<>(withChildNFather, HttpStatus.OK);
	}

	// could change to admin services
	@PostMapping("/addNewView")
	@ApiOperation(value = "Add a new visit to a Post", notes = "" )
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "The payload was correct"),
			@ApiResponse(code = 204, message = "The payload do not contain correct/enough info"),
			@ApiResponse(code = 400, message = "The payload do not contain required info") 
			})
	public ResponseEntity<Integer> newVisit(@RequestBody PostId receiver) throws ResourceNotFoundException {	
		
		Long postId;

		if(receiver.getPostId() != null) {
			postId = receiver.getPostId();
		}
		else {
			LOG.error("BAD REQUEST for: " + receiver.toString());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Integer response = gncRepository.incrementViewCounter(postId, BigInteger.ONE);
		if(response.compareTo(0) == 0)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		LOG.info("SUCCESS REQUEST, SENDING INFO");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping("/getViews")
	@ApiOperation(value = "get number of visits in a post")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 204, message = "The payload do not contain correct/enough info"),
			@ApiResponse(code = 400, message = "The payload do not contain required info") 
			})
	public ResponseEntity<Integer> getVisits(@RequestBody PostId receiver) throws ResourceNotFoundException {
		
		Long postId;
		if(receiver.getPostId() != null) {
			postId = receiver.getPostId();
		}
		else {
			LOG.error("BAD REQUEST for: " + receiver.toString());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Integer views = gncRepository.getViewCounter(postId);
		
		if(views == 0) return new ResponseEntity<>(0, HttpStatus.NO_CONTENT);
		
		LOG.info("SUCCESS REQUEST, SENDING INFO");
		return new ResponseEntity<>(views, HttpStatus.OK);
	}
	
	@PostMapping("/getText")
	@ApiOperation(value = "Bring all texts and images related with a post", notes = "Return texts with images" )
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "The payload was correct"),
			@ApiResponse(code = 204, message = "The payload do not contain correct/enough info"),
			@ApiResponse(code = 400, message = "The payload do not contain required info") 
			})
	public ResponseEntity<List<TextOnlyRequieredDataForUser>> getText(@RequestBody PostId receiver) throws ResourceNotFoundException {	

		Long postId;
		if(receiver.getPostId() != null) {
			postId = receiver.getPostId();
		}
		else {
			LOG.error("BAD REQUEST for: " + receiver.toString());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		List<Text> text = gncRepository.getTextContent(postId);
		if(text == null || text.size() == 0)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		List<TextOnlyRequieredDataForUser> textReduced = new ArrayList<TextOnlyRequieredDataForUser>();
		for (Text text2 : text) {
			textReduced.add(new TextOnlyRequieredDataForUser(text2, new byte[0]));
		}
		
		LOG.info("SUCCESS REQUEST, SENDING INFO");
		return new ResponseEntity<>(textReduced, HttpStatus.OK);
	}

	@PostMapping("/getImage")
	@ApiOperation(value = "bring all texts and images related with a post", notes = "Return a list of @ImageReduced" )
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "The payload was correct"),
			@ApiResponse(code = 204, message = "The payload do not contain correct/enough info"),
			@ApiResponse(code = 400, message = "The payload do not contain required info") 
			})
	public ResponseEntity<List<ImageReduced>> dmeImage(@RequestBody TextId receiver) throws ResourceNotFoundException {
	
		Long textId;
		if(receiver.getTextId() != null) {
			textId = receiver.getTextId();
		}
		else {
			LOG.error("BAD REQUEST for: " + receiver.toString());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		List<Image> images = gncRepository.getImage(textId);
		if(images == null || images.size() == 0)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		List<ImageReduced> imagesReduced = new ArrayList<>();
		for (Image reduced : images) {
			imagesReduced.add(new ImageReduced(reduced));
		}
		LOG.info("SUCCESS REQUEST, SENDING INFO");
		return new ResponseEntity<>(imagesReduced, HttpStatus.OK);
	}
	
	@PostMapping("/getFoundersInfo")
	@ApiOperation(value = "Especial service that brings the info of a founder", notes = "Return a @Founder object" )
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "The payload was correct"),
			@ApiResponse(code = 204, message = "The payload do not contain correct/enough info"),
			@ApiResponse(code = 400, message = "The payload do not contain required info") 
			})
	public ResponseEntity<FounderReduced> foundersInfo(@RequestBody Name receiver) throws ResourceNotFoundException {
		
		String name;
		if(receiver.getName() != null) {
			name = receiver.getName().toUpperCase();
		}
		else {
			LOG.error("BAD REQUEST for: " + receiver.toString());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	    
		Founder founder = gncRepository.getFounderInfo(name.toUpperCase());
		if(founder == null || founder.isNull())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		LOG.info("SUCCESS REQUEST, SENDING INFO");
		return new ResponseEntity<>(new FounderReduced(founder), HttpStatus.OK);
	}
	
}
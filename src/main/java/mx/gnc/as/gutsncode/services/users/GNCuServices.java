package mx.gnc.as.gutsncode.services.users;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import mx.gnc.as.gutsncode.dao.Founder;
import mx.gnc.as.gutsncode.dao.FounderReduced;
import mx.gnc.as.gutsncode.dao.Image;
import mx.gnc.as.gutsncode.dao.ImageReduced;
import mx.gnc.as.gutsncode.dao.Post;
import mx.gnc.as.gutsncode.dao.PostWithChildNFather;
import mx.gnc.as.gutsncode.dao.Status;
import mx.gnc.as.gutsncode.dao.Text;
import mx.gnc.as.gutsncode.dao.TextOnlyRequieredDataForUser;
import mx.gnc.as.gutsncode.dao.TypePost;
import mx.gnc.as.gutsncode.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping("/gncu")
@CrossOrigin(origins = "http://localhost:4200")
@Api(value = "User GNC Services")
public class GNCuServices {
	
	private final Integer defaultSizePage = 20;
	
	@Autowired
	private GNCuRepository gncRepository;

	@PostMapping(value = "/recentPost")
	@ApiOperation(value = "Return the recent post", notes = "need type and topic, pageNumber are 0 by default and pageSize are 20 by default")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "The payload was correct"),
			@ApiResponse(code = 204, message = "The payload do not contain correct/enough info"),
			@ApiResponse(code = 400, message = "The payload do not contain required info") 
			})
	public ResponseEntity<List<Post>> postBy20(@RequestBody String jsonRequest) throws ResourceNotFoundException {

		JSONObject jsonObj = new JSONObject(jsonRequest);
		Integer pageNumber = jsonObj.has("page")?Integer.valueOf(jsonObj.getInt("page")):0;
		Integer sizePage = jsonObj.has("sizePage")?Integer.valueOf(jsonObj.getInt("sizePage")):this.defaultSizePage;
		String topic = jsonObj.has("topic") ? jsonObj.getString("topic").toLowerCase() : "";
		String type;
		try {
			type = jsonObj.getString("type");
		}catch(JSONException e){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		List<Post> listPost = gncRepository.getPostOrdered(Status.PUBLISHED, TypePost.getEnum(type), topic, PageRequest.of(pageNumber, sizePage));
		if(listPost == null || listPost.size() == 0)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<>(listPost, HttpStatus.OK);
	}
	
	@PostMapping("/totalPages")
	@ApiOperation(value = "Return the numbers of pages", notes = "That pages are related according to Type Post and Topic, pageNumber are 0 by default and pageSize are 20 by default" )
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "The payload was correct"),
			@ApiResponse(code = 204, message = "The payload do not contain correct/enough info"),
			@ApiResponse(code = 400, message = "The payload do not contain required info") 
			})
	public ResponseEntity<Integer> totalPages(@RequestBody String jsonRequest) throws ResourceNotFoundException {
		
		JSONObject jsonObj = new JSONObject(jsonRequest);
		String topic = jsonObj.has("topic")? jsonObj.getString("topic").toLowerCase() : "";
		Integer sizePage = jsonObj.has("sizePage")?Integer.valueOf(jsonObj.getInt("sizePage")):this.defaultSizePage;
		String type;
		try {
			type = jsonObj.getString("type");
		}catch(JSONException e){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
//		if(jsonObj.has("type"))		type = jsonObj.getString("type");
//		else						throw new ResourceNotFoundException("It is mandatory send what kind of post is it");
//		else						return null;
		
		Integer totalPost = gncRepository.numberTotalPost(Status.PUBLISHED, TypePost.getEnum(type), topic);
		if(totalPost.compareTo(0) == 0)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<Integer>((totalPost / (sizePage + 1)) + 1, HttpStatus.OK);
	}

	@PostMapping("/getInfo")
	@ApiOperation(value = "Return the main informartion of a Post or New", notes = "" )
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "The payload was correct"),
			@ApiResponse(code = 204, message = "The payload do not contain correct/enough info"),
			@ApiResponse(code = 400, message = "The payload do not contain required info") 
			})
	public ResponseEntity<PostWithChildNFather> getInfoPost(@RequestBody String jsonRequest) throws ResourceNotFoundException {
		JSONObject jsonObj = new JSONObject(jsonRequest);
		Long postId;
		try {
			postId = Long.valueOf(jsonObj.getInt("postId"));
		} catch (JSONException e) {
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
	public ResponseEntity<Integer> newVisit(@RequestBody String jsonRequest) throws ResourceNotFoundException{
		JSONObject jsonObj = new JSONObject(jsonRequest);
		Long postId;
		try {
			postId = Long.valueOf(jsonObj.getInt("postId"));
		} catch (JSONException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if(postId == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		Integer response = gncRepository.incrementViewCounter(postId, BigInteger.ONE);
		if(response.compareTo(0) == 0)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/getViews")
	@ApiOperation(value = "get number of visits in a post")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 204, message = "The payload do not contain correct/enough info"),
			@ApiResponse(code = 400, message = "The payload do not contain required info") 
			})
	public ResponseEntity<Integer> getVisits(@RequestBody String jsonRequest) throws ResourceNotFoundException{
		JSONObject jsonObj = new JSONObject(jsonRequest);
		Long postId;
		try {
			postId = Long.valueOf(jsonObj.getInt("postId"));
		} catch (JSONException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Integer views = gncRepository.getViewCounter(postId);
		
		if(views == 0) return new ResponseEntity<>(0, HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<>(views, HttpStatus.OK);
	}
	
	@PostMapping("/getText")
	@ApiOperation(value = "Bring all texts and images related with a post", notes = "Return texts with images" )
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "The payload was correct"),
			@ApiResponse(code = 204, message = "The payload do not contain correct/enough info"),
			@ApiResponse(code = 400, message = "The payload do not contain required info") 
			})
	public ResponseEntity<List<TextOnlyRequieredDataForUser>> getText(@RequestBody String jsonRequest) throws ResourceNotFoundException {
		JSONObject jsonObj = new JSONObject(jsonRequest);
		Long postId;
		try {
			postId = Long.valueOf(jsonObj.getInt("postId"));
		} catch (JSONException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		List<Text> text = gncRepository.getTextContent(postId);
		if(text == null || text.size() == 0)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		List<TextOnlyRequieredDataForUser> textReduced = new ArrayList<TextOnlyRequieredDataForUser>();
		for (Text text2 : text) {
			textReduced.add(new TextOnlyRequieredDataForUser(text2, new byte[0]));
		}
		
		return new ResponseEntity<>(textReduced, HttpStatus.OK);
	}

	@PostMapping("/getImage")
	@ApiOperation(value = "bring all texts and images related with a post", notes = "Return a list of @ImageReduced" )
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "The payload was correct"),
			@ApiResponse(code = 204, message = "The payload do not contain correct/enough info"),
			@ApiResponse(code = 400, message = "The payload do not contain required info") 
			})
	public ResponseEntity<List<ImageReduced>> dmeImage(@RequestBody String jsonRequest) throws ResourceNotFoundException {
	
		JSONObject jsonObj = new JSONObject(jsonRequest);
		Long textId;
		try {
			textId = Long.valueOf(jsonObj.getInt("textId"));
		} catch (JSONException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		List<Image> images = gncRepository.getImage(textId);
		if(images == null || images.size() == 0)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		List<ImageReduced> imagesReduced = new ArrayList<>();
		for (Image reduced : images) {
			imagesReduced.add(new ImageReduced(reduced));
		}
		return new ResponseEntity<>(imagesReduced, HttpStatus.OK);
	}
	
	@PostMapping("/getFoundersInfo")
	@ApiOperation(value = "Especial service that brings the info of a founder", notes = "Return a @Founder object" )
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "The payload was correct"),
			@ApiResponse(code = 204, message = "The payload do not contain correct/enough info"),
			@ApiResponse(code = 400, message = "The payload do not contain required info") 
			})
	public ResponseEntity<FounderReduced> foundersInfo(@RequestBody String jsonRequest) throws ResourceNotFoundException {
		
		JSONObject jsonObj = new JSONObject(jsonRequest);
		String name;
		try {
			name =jsonObj.getString("name").toUpperCase(); //names in database will always been on UpperCase
		}catch(JSONException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	    
		Founder founder = gncRepository.getFounderInfo(name.toUpperCase());
		if(founder == null || founder.isNull())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<>(new FounderReduced(founder), HttpStatus.OK);
	}
	
}
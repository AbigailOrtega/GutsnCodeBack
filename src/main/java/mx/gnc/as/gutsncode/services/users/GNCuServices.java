package mx.gnc.as.gutsncode.services.users;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
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
@Api(value = "User GNC Services", description = "All web services for users")
public class GNCuServices {
	
	private final Integer defaultSizePage = 20;
	
	@Autowired
	private GNCuRepository gncRepository;

	@PostMapping("/recentPost")
	@ApiOperation(value = "Return the recent post", notes = "need type and topic, pageNumber are 0 by default and pageSize are 20 by default")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public List<Post> postBy20(@RequestBody String jsonRequest) throws ResourceNotFoundException{
	
		JSONObject jsonObj = new JSONObject(jsonRequest);
		
		Integer pageNumber = jsonObj.has("page")?Integer.valueOf(jsonObj.getInt("page")):0;
		Integer sizePage = jsonObj.has("sizePage")?Integer.valueOf(jsonObj.getInt("sizePage")):this.defaultSizePage;
		String topic = jsonObj.has("topic") ? jsonObj.getString("topic").toLowerCase() : "";
		
		String type;
		if(jsonObj.has("type"))		type = jsonObj.getString("type");
		else						throw new ResourceNotFoundException("It is mandatory send what kind of post is it");
//		else						return null;
			
		List<Post> listPost = gncRepository.findTop2LastTwenty(Status.PUBLISHED, TypePost.getEnum(type), topic, PageRequest.of(pageNumber, sizePage));
		
		return listPost;
	}
	
	@PostMapping("/totalPages")
	@ApiOperation(value = "Return the numbers of pages", notes = "That pages are related according to Type Post and Topic, pageNumber are 0 by default and pageSize are 20 by default" )
	public Integer totalPages(@RequestBody String jsonRequest) throws ResourceNotFoundException{
		
		JSONObject jsonObj = new JSONObject(jsonRequest);
		
		String topic = jsonObj.has("topic")? jsonObj.getString("topic").toLowerCase() : "";
		Integer sizePage = jsonObj.has("sizePage")?Integer.valueOf(jsonObj.getInt("sizePage")):this.defaultSizePage;
		
		String type;
		if(jsonObj.has("type"))		type = jsonObj.getString("type");
		else						throw new ResourceNotFoundException("It is mandatory send what kind of post is it");
//		else						return null;
		
		Integer listPost = gncRepository.numberTotalPost(Status.PUBLISHED, TypePost.getEnum(type), topic);
		return (listPost / (sizePage + 1)) + 1;
	}

	@PostMapping("/getInfo")
	@ApiOperation(value = "Return the main informartion of a Post or New", notes = "" )
	public PostWithChildNFather getInfoPost(@RequestBody String jsonRequest) {
	
		JSONObject jsonObj = new JSONObject(jsonRequest);
		Long postId = Long.valueOf(jsonObj.getInt("postid"));
		Post post = gncRepository.getPostContent(postId);
		
		PostWithChildNFather withChildNFather = new PostWithChildNFather(post);

		if(post.getParentId() != null) {
			withChildNFather.setParentId(gncRepository.getPostContent(post.getParentId()));
			withChildNFather.getParentId().setImage(new byte[0]);
		}
		
		if(post.getChildId() != null) {
			withChildNFather.setChildId(gncRepository.getPostContent(post.getChildId()));
			withChildNFather.getChildId().setImage(new byte[0]);
		}

		return withChildNFather;
	}

	@PostMapping("/addNewView")
	@ApiOperation(value = "Add a new visit to a Post", notes = "" )
	public Integer newVisit(@RequestBody String jsonRequest) {
		JSONObject jsonObj = new JSONObject(jsonRequest);
		Long postId = Long.valueOf(jsonObj.getInt("postid"));
		return gncRepository.incrementViewCounter(postId, BigInteger.ONE);
	}

	@PostMapping("/getText")
	@ApiOperation(value = "bring all texts and images related with a post", notes = "Return texts with images" )
	public List<TextOnlyRequieredDataForUser> getText(@RequestBody String jsonRequest) {
		JSONObject jsonObj = new JSONObject(jsonRequest);
		Long postId = Long.valueOf(jsonObj.getInt("postid"));
		List<Text> text = gncRepository.getTextContent(postId);
		List<TextOnlyRequieredDataForUser> textReduced = new ArrayList<TextOnlyRequieredDataForUser>();
		for (Text text2 : text) {
//			byte[] image = dmeImage(text2.getTextId());
			textReduced.add(new TextOnlyRequieredDataForUser(text2, new byte[0]));
		}
		
		return textReduced;
	}

	@PostMapping("/getImage")
	@ApiOperation(value = "bring all texts and images related with a post", notes = "Return a list of @ImageReduced" )
	public List<ImageReduced> dmeImage(@RequestBody String jsonRequest) {
	
		JSONObject jsonObj = new JSONObject(jsonRequest);
		Long image = Long.valueOf(jsonObj.getInt("textId"));
		List<Image> images = gncRepository.getImage(image);
		List<ImageReduced> imagesReduced = new ArrayList<>();
		for (Image reduced : images) {
			imagesReduced.add(new ImageReduced(reduced.getImageName(), reduced.getDescription(), Base64.getEncoder().encodeToString(reduced.getImage()), reduced.getFooter(), reduced.getCardinality()));
		}
		return imagesReduced;
	}
	
	@PostMapping("/getFoundersInfo")
	@ApiOperation(value = "Especial service that brings the info of a founder", notes = "Return a @Founder object" )
	public ResponseEntity<Founder> foundersInfo(@RequestBody String jsonRequest) {
	
		JSONObject jsonObj = new JSONObject(jsonRequest);
		String name =jsonObj.getString("name");
		HttpHeaders headers = new HttpHeaders();
	    
		Founder founder = gncRepository.getFounderInfo(name);
		
		if(founder.isNull()) {
			headers.add("Response", "404 - no founder founded");	
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(founder, HttpStatus.OK);
	}
	
}
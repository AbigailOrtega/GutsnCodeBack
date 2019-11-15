package mx.gnc.as.gutsncode.service.rest;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import mx.gnc.as.gutsncode.dao.Image;
import mx.gnc.as.gutsncode.dao.Post;
import mx.gnc.as.gutsncode.dao.Status;
import mx.gnc.as.gutsncode.dao.Text;
import mx.gnc.as.gutsncode.dao.TypePost;
import mx.gnc.as.gutsncode.repository.PostRepository;

@RestController
@RequestMapping("/serviciosUsers")
@Api(value = "Post microservice", description = "This API has a CRUD for posts")
@CrossOrigin()
public class BringPost {
	
	private final Integer defaultSizePage = 5;
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/recentPost")
	@ApiOperation(value = "Find in 20 by 20 most recent post or news", notes = "Return a post o new by id" )
	public List<Post> postBy20(@RequestBody String jsonRequest) {
	
		JSONObject jsonObj = new JSONObject(jsonRequest);
		
		Integer pageNumber = jsonObj.has("pagina")?Integer.valueOf(jsonObj.getInt("pagina")):1;
		Integer maxPost = jsonObj.has("maxPost")?Integer.valueOf(jsonObj.getInt("maxPost")):this.defaultSizePage;
		String topic = jsonObj.has("topic")? jsonObj.getString("topic"):"";
		String tipo = jsonObj.has("tipo")?jsonObj.getString("tipo"):"";
		List<Post> listPost = postRepository.findTop2LastTwenty(Status.PUBLISHED, TypePost.getEnum(tipo), topic, PageRequest.of(pageNumber, maxPost));
		return listPost;
	}
	
	@GetMapping("/totalPages")
	@ApiOperation(value = "Find the total numbers of the pages", notes = "An integer" )
	public Integer totalPages(@RequestBody String jsonRequest) {
	
		JSONObject jsonObj = new JSONObject(jsonRequest);
		String topic = jsonObj.has("topic")? jsonObj.getString("topic"):"";
		String tipo = jsonObj.has("tipo")?jsonObj.getString("tipo"):"";
		Integer listPost = postRepository.numberTotalPost(Status.PUBLISHED, TypePost.getEnum(tipo), topic);
		return (listPost/this.defaultSizePage) + 1;
	}
	
	@GetMapping("/getInfoPost")
	@ApiOperation(value = "bring al text related of a post", notes = "Return texts" )
	public Post getInfoPost(@RequestBody String jsonRequest) {
	
		JSONObject jsonObj = new JSONObject(jsonRequest);
		Long postId = Long.valueOf(jsonObj.getInt("postid"));
		Post post = postRepository.getPostContent(postId);
		return post;
	}
	
	@PostMapping("/addNewView")
	public Integer newVisit(@RequestBody String jsonRequest) {
		JSONObject jsonObj = new JSONObject(jsonRequest);
		Long postId = Long.valueOf(jsonObj.getInt("postid"));
		BigInteger newView = new BigInteger("1");
		Integer view = postRepository.incrementViewCounter(postId, newView);
		return view;
	}
	
	@DeleteMapping("/deletePost")
	public Integer deletePost(@RequestBody String jsonRequest) {
		JSONObject jsonObj = new JSONObject(jsonRequest);
		Long postId = Long.valueOf(jsonObj.getInt("postid"));
		Integer view  = postRepository.deletePost(postId);
		return view;
	}
		
	@GetMapping("/getText")
	@ApiOperation(value = "bring al text related of a post", notes = "Return texts" )
	public List<Text> dmePostNew(@RequestBody String jsonRequest) {
		JSONObject jsonObj = new JSONObject(jsonRequest);
		Long pageNumber = Long.valueOf(jsonObj.getInt("postid"));
		List<Text> text = postRepository.getTextContent(pageNumber);
		return text;
	}
	
	@GetMapping("/getImage")
	public Image dmeImage(@RequestBody String jsonRequest) {
	
		JSONObject jsonObj = new JSONObject(jsonRequest);
		Long image = Long.valueOf(jsonObj.getInt("imageId"));
//		List<Text> text = postRepository.getTextContent(post);
		Image text = postRepository.getImage(image);
		return text;
	}
	
	
	
}

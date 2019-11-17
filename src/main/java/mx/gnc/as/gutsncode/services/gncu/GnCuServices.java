package mx.gnc.as.gutsncode.services.gncu;

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

@RestController
@RequestMapping("/gncU")
@Api(value = "Post microservice", description = "This API has a CRUD for guts and code content")
@CrossOrigin()
public class GnCuServices {
	
	private final Integer defaultSizePage = 5;
	
	@Autowired
	private GnCuRepository GnCRepository;
	
	@GetMapping("/getGNCData")
	@ApiOperation(value = "Find in 20 by 20 most recent post or news", notes = "Return a post o new by id" )
	public List<Post> postBy20(@RequestBody String jsonRequest) {
	
		JSONObject jsonObj = new JSONObject(jsonRequest);
		
		Integer pageNumber = jsonObj.has("pagina")?Integer.valueOf(jsonObj.getInt("pagina")):1;
		Integer maxPost = jsonObj.has("maxPost")?Integer.valueOf(jsonObj.getInt("maxPost")):this.defaultSizePage;
		String topic = jsonObj.has("topic")? jsonObj.getString("topic"):"";
		String tipo = jsonObj.has("tipo")?jsonObj.getString("tipo"):"";
		List<Post> listPost = GnCRepository.findTop2LastTwenty(Status.PUBLISHED, TypePost.getEnum(tipo), topic, PageRequest.of(pageNumber, maxPost));
		return listPost;
	}
	
	@GetMapping("/getInfoGNC")
	@ApiOperation(value = "bring al text related of a post", notes = "Return texts" )
	public Post getInfoPost(@RequestBody String jsonRequest) {
	
		JSONObject jsonObj = new JSONObject(jsonRequest);
		Long postId = Long.valueOf(jsonObj.getInt("postid"));
		Post post = GnCRepository.getPostContent(postId);
		return post;
	}
	
	@PostMapping("/addNewViewGNC")
	public Integer newVisit(@RequestBody String jsonRequest) {
		JSONObject jsonObj = new JSONObject(jsonRequest);
		Long postId = Long.valueOf(jsonObj.getInt("postid"));
		BigInteger newView = new BigInteger("1");
		Integer view = GnCRepository.incrementViewCounter(postId, newView);
		return view;
	}
	
	@DeleteMapping("/deletePostGNC")
	public Integer deletePost(@RequestBody String jsonRequest) {
		JSONObject jsonObj = new JSONObject(jsonRequest);
		Long postId = Long.valueOf(jsonObj.getInt("postid"));
		Integer view  = GnCRepository.deletePost(postId);
		return view;
	}
		
	@GetMapping("/getTextGNC")
	@ApiOperation(value = "bring al text related of a post", notes = "Return texts" )
	public List<Text> dmePostNew(@RequestBody String jsonRequest) {
		JSONObject jsonObj = new JSONObject(jsonRequest);
		Long pageNumber = Long.valueOf(jsonObj.getInt("postid"));
		List<Text> text = GnCRepository.getTextContent(pageNumber);
		return text;
	}
	
}

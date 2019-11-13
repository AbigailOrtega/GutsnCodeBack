package mx.gnc.as.gutsncode.service.rest;

import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/algo")
@Api(value = "Post microservice", description = "This API has a CRUD for posts")
@CrossOrigin()
public class BringPost {
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/recentPost")
	@ApiOperation(value = "Find in 20 by 20 most recent post or news", notes = "Return a post o new by id" )
	public List<Post> dme20(@RequestBody String jsonRequest) {
	
		JSONObject jsonObj = new JSONObject(jsonRequest);
		
		Integer pageNumber = jsonObj.has("pagina")?Integer.valueOf(jsonObj.getInt("pagina")):1;
		String topic = jsonObj.has("topic")? jsonObj.getString("topic"):"";
		String tipo = jsonObj.has("tipo")?jsonObj.getString("tipo"):"";
		List<Post> listPost = postRepository.findTop2LastTwenty(Status.PUBLISHED, TypePost.getEnum(tipo), topic, PageRequest.of(pageNumber, 5));
		return listPost;
	}
	
	@GetMapping("/getText")
	@ApiOperation(value = "bring al text related of a post", notes = "Return texts" )
	public List<Text> dmePostNew(@RequestBody String jsonRequest) {
	
		JSONObject jsonObj = new JSONObject(jsonRequest);
		Long pageNumber = Long.valueOf(jsonObj.getInt("postid"));
		System.out.println(pageNumber);
		List<Text> text = postRepository.getTextContent(pageNumber);
		return text;
	}
	
	@GetMapping("/getImage")
	public Image dmeImage(@RequestBody String jsonRequest) {
	
		JSONObject jsonObj = new JSONObject(jsonRequest);
		Long image = Long.valueOf(jsonObj.getInt("imageId"));
//		List<Text> text = postRepository.getTextContent(post);
		System.out.println(image);
		Image text = postRepository.getImage(image);
		return text;
	}
	
	
	
}

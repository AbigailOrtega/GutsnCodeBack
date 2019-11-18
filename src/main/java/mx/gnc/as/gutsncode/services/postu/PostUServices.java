package mx.gnc.as.gutsncode.services.postu;

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
import mx.gnc.as.gutsncode.services.GeneralServices;

@RestController
@RequestMapping("/postU")
@CrossOrigin(origins = "http://localhost:4200")
public class PostUServices {
	
	private final Integer defaultSizePage = 5;
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private GeneralServices generalServices;
	
	@PostMapping("/recentPost")
	public List<Post> postBy20(@RequestBody String jsonRequest) {
	
		JSONObject jsonObj = new JSONObject(jsonRequest);
		
		Integer pageNumber = jsonObj.has("pagina")?Integer.valueOf(jsonObj.getInt("pagina")):0;
		Integer maxPost = jsonObj.has("maxPost")?Integer.valueOf(jsonObj.getInt("maxPost")):this.defaultSizePage;
		String topic = jsonObj.has("topic")? jsonObj.getString("topic"):"";
		List<Post> listPost = postRepository.findTop2LastTwenty(Status.PUBLISHED, TypePost.POST, topic, PageRequest.of(pageNumber, maxPost));
		return listPost;
	}
	
	@PostMapping("/totalPages")
	public Integer totalPages(@RequestBody String jsonRequest) {
		JSONObject jsonObj = new JSONObject(jsonRequest);
		String topic = jsonObj.has("topic")? jsonObj.getString("topic"):"";
		Integer listPost = postRepository.numberTotalPost(Status.PUBLISHED, TypePost.POST, topic);
		return (listPost/this.defaultSizePage) + 1;
	}
	
	@PostMapping("/getInfoPost")
	public Post getInfoPost(@RequestBody String jsonRequest) {
	
		JSONObject jsonObj = new JSONObject(jsonRequest);
		Long postId = Long.valueOf(jsonObj.getInt("postid"));
		Post post = postRepository.getPostContent(postId);
		return post;
	}
	
	@PostMapping("/addView")
	public Integer newVisit(@RequestBody String jsonRequest) {
		JSONObject jsonObj = new JSONObject(jsonRequest);
		Long postId = Long.valueOf(jsonObj.getInt("postid"));
		return generalServices.addView(postId);
	}
	
	@DeleteMapping("/deletePost")
	public Integer deletePost(@RequestBody String jsonRequest) {
		JSONObject jsonObj = new JSONObject(jsonRequest);
		Long postId = Long.valueOf(jsonObj.getInt("postid"));
		return generalServices.deletePost(postId);
	}
		
	@PostMapping("/getText")
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
		Image text = postRepository.getImage(image);
		return text;
	}
	
	
	
}

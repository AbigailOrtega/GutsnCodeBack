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
import mx.gnc.as.gutsncode.services.GeneralServices;

@RestController
@RequestMapping("/gncU")
@CrossOrigin()
public class GnCuServices {
	
	private final Integer defaultSizePage = 5;
	
	@Autowired
	private GnCuRepository gncRepository;
	
	@Autowired
	private GeneralServices generalServices;
	
	@PostMapping("/getGNCData")
	public List<Post> postBy20(@RequestBody String jsonRequest) {
	
		JSONObject jsonObj = new JSONObject(jsonRequest);
		
		Integer pageNumber = jsonObj.has("pagina")?Integer.valueOf(jsonObj.getInt("pagina")):1;
		Integer maxPost = jsonObj.has("maxPost")?Integer.valueOf(jsonObj.getInt("maxPost")):this.defaultSizePage;
//		String topic = jsonObj.has("topic")? jsonObj.getString("topic"):"";
		String tipo = jsonObj.has("tipo")?jsonObj.getString("tipo"):"";
		List<Post> listPost = gncRepository.findTop2LastTwenty(Status.PUBLISHED, TypePost.getEnum(tipo), "", PageRequest.of(pageNumber, maxPost));
		return listPost;
	}
	
	@PostMapping("/getInfoGNC")
	public Post getInfoPost(@RequestBody String jsonRequest) {
		JSONObject jsonObj = new JSONObject(jsonRequest);
		Long postId = Long.valueOf(jsonObj.getInt("postid"));
		Post post = gncRepository.getPostContent(postId);
		return post;
	}
	
	@PostMapping("/addNewViewGNC")
	public Integer newVisit(@RequestBody String jsonRequest) {
		JSONObject jsonObj = new JSONObject(jsonRequest);
		Long postId = Long.valueOf(jsonObj.getInt("postid"));
		return generalServices.addView(postId);
	}
	
	@DeleteMapping("/deletePostGNC")
	public Integer deletePost(@RequestBody String jsonRequest) {
		JSONObject jsonObj = new JSONObject(jsonRequest);
		Long postId = Long.valueOf(jsonObj.getInt("postid"));
		return generalServices.deletePost(postId);
	}
		
	@PostMapping("/getTextGNC")
	@ApiOperation(value = "bring al text related of a post", notes = "Return texts" )
	public List<Text> dmePostNew(@RequestBody String jsonRequest) {
		JSONObject jsonObj = new JSONObject(jsonRequest);
		Long pageNumber = Long.valueOf(jsonObj.getInt("postid"));
		List<Text> text = gncRepository.getTextContent(pageNumber);
		return text;
	}
	
	@GetMapping("/getImage")
	public Image dmeImage(@RequestBody String jsonRequest) {
	
		JSONObject jsonObj = new JSONObject(jsonRequest);
		Long image = Long.valueOf(jsonObj.getInt("imageId"));
		Image text = gncRepository.getImage(image);
		return text;
	}
	
}

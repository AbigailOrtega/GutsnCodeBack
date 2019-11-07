package mx.gnc.as.gutsncode.service.rest;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.gnc.as.gutsncode.dao.Post;
import mx.gnc.as.gutsncode.dao.Status;
import mx.gnc.as.gutsncode.dao.Text;
import mx.gnc.as.gutsncode.dao.TypePost;
import mx.gnc.as.gutsncode.repository.PostRepository;

@RestController
@RequestMapping("/algo")
public class BringPost {
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/recentPost")
	public List<Post> dme20(@RequestBody String jsonRequest) {
	
		JSONObject jsonObj = new JSONObject(jsonRequest);
		Integer pageNumber = Integer.valueOf(jsonObj.getInt("pagina"));
		List<Post> listPost = postRepository.findTop2LastTwenty(Status.PUBLISHED, TypePost.getEnum(jsonObj.getString("tipo")), PageRequest.of(pageNumber, 2));
		return listPost;
	}
	
	@GetMapping("/getText")
	public List<Text> dmePostNew(@RequestBody String jsonRequest) {
	
		JSONObject jsonObj = new JSONObject(jsonRequest);
		Long pageNumber = Long.valueOf(jsonObj.getInt("postid"));
//		List<Text> text = postRepository.getTextContent(post);
		System.out.println(pageNumber);
		List<Text> text = postRepository.getTextContent(pageNumber);
		return text;
	}
	
}

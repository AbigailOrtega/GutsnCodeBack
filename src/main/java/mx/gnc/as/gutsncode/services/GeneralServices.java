package mx.gnc.as.gutsncode.services;

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
@RequestMapping("/generalServices")
@Api(value = "Post microservice", description = "This API has a CRUD for news")
@CrossOrigin()
public class GeneralServices {
	
	@Autowired
	private GeneralRepository newsURepository;
		
	@GetMapping("/getText")
	@ApiOperation(value = "bring al text related of a post", notes = "Return texts" )
	public List<Text> dmePostNew(@RequestBody String jsonRequest) {
		JSONObject jsonObj = new JSONObject(jsonRequest);
		Long pageNumber = Long.valueOf(jsonObj.getInt("postid"));
		List<Text> text = newsURepository.getTextContent(pageNumber);
		return text;
	}
	
	@GetMapping("/getImage")
	public Image dmeImage(@RequestBody String jsonRequest) {
	
		JSONObject jsonObj = new JSONObject(jsonRequest);
		Long image = Long.valueOf(jsonObj.getInt("imageId"));
//		List<Text> text = postRepository.getTextContent(post);
		Image text = newsURepository.getImage(image);
		return text;
	}
	
	
	
}

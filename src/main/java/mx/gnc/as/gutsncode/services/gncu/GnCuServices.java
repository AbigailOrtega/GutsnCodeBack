package mx.gnc.as.gutsncode.services.gncu;

import java.math.BigInteger;
import java.util.ArrayList;
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
import mx.gnc.as.gutsncode.dao.ImageReduced;
import mx.gnc.as.gutsncode.dao.Post;
import mx.gnc.as.gutsncode.dao.PostWithChildNFather;
import mx.gnc.as.gutsncode.dao.Status;
import mx.gnc.as.gutsncode.dao.Text;
import mx.gnc.as.gutsncode.dao.TextOnlyRequieredDataForUser;
import mx.gnc.as.gutsncode.dao.TypePost;
import mx.gnc.as.gutsncode.services.GeneralServices;

@RestController
@RequestMapping("/gncU")
@CrossOrigin(origins = "http://localhost:4200")
public class GnCuServices {
	
	private final Integer defaultSizePage = 5;
	
	@Autowired
	private GnCuRepository gncRepository;
	
	@Autowired
	private GeneralServices generalServices;
	
	@PostMapping("/getGNCData")
	public List<Post> postBy20(@RequestBody String jsonRequest) {
	
		JSONObject jsonObj = new JSONObject(jsonRequest);
		
		Integer pageNumber = jsonObj.has("page")?Integer.valueOf(jsonObj.getInt("page")):0;
		Integer maxPost = jsonObj.has("maxPost")?Integer.valueOf(jsonObj.getInt("maxPost")):this.defaultSizePage;
//		String topic = jsonObj.has("topic")? jsonObj.getString("topic").toLowerCase():"";
		String tipo = jsonObj.has("tipo")?jsonObj.getString("tipo"):"";
		List<Post> listPost = gncRepository.findTop2LastTwenty(Status.PUBLISHED, TypePost.getEnum(tipo), "", PageRequest.of(pageNumber, maxPost));
		return listPost;
	}
	
	@PostMapping("/getInfoGNC")
//	public Post getInfoPost(@RequestBody String jsonRequest) {
	public PostWithChildNFather getInfoPost(@RequestBody String jsonRequest) {
	
		JSONObject jsonObj = new JSONObject(jsonRequest);
		Long postId = Long.valueOf(jsonObj.getInt("postid"));
		Post post = gncRepository.getPostContent(postId);
		
		PostWithChildNFather withChildNFather = new PostWithChildNFather(post);
		withChildNFather.setParentId(gncRepository.getPostContent(post.getParentId()));
		withChildNFather.setChildId(gncRepository.getPostContent(post.getChildId()));
		
//		return post;
		return withChildNFather;
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
	public List<TextOnlyRequieredDataForUser> dmePostNew(@RequestBody String jsonRequest) {
		JSONObject jsonObj = new JSONObject(jsonRequest);
		Long postId = Long.valueOf(jsonObj.getInt("postid"));
		List<Text> text = gncRepository.getTextContent(postId);
		List<TextOnlyRequieredDataForUser> textReduced = new ArrayList<TextOnlyRequieredDataForUser>();
		for (Text text2 : text) {
			textReduced.add(new TextOnlyRequieredDataForUser(text2, new Byte[0]));
		}
		
		return textReduced;
	}
	
	@PostMapping("/getImage")
	public List<ImageReduced> dmeImage(@RequestBody String jsonRequest) {
	
		JSONObject jsonObj = new JSONObject(jsonRequest);
		Long image = Long.valueOf(jsonObj.getInt("imageId"));
		List<Image> images = gncRepository.getImage(image);
		List<ImageReduced> imagesReduced = new ArrayList<>();
		for (Image reduced : images) {
			imagesReduced.add(new ImageReduced(reduced.getImageName(), reduced.getDescription(), reduced.getImage(), reduced.getFooter(), reduced.getCardinality()));
		}
		return imagesReduced;
	}
	
}

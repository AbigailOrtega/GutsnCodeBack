package mx.gnc.as.gutsncode.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import mx.gnc.as.gutsncode.dao.Post;
import mx.gnc.as.gutsncode.dao.Status;
import mx.gnc.as.gutsncode.dao.TypePost;
import mx.gnc.as.gutsncode.repository.PostRepository;

@RestController
public class PostRestService {
	
	@Autowired
	private PostRepository postRepository;

//	@GetMapping("/getLastTwentyPost/{page}")
//	public List<Post> getLastTwentyPosts(@PathVariable("page") int page){
//		List<Post> last2TwentyPosts=postRepository.findTop2LastTwenty(Status.PUBLISHED,TypePost.POST, PageRequest.of(page, 2));
//		return last2TwentyPosts;
//	}
}

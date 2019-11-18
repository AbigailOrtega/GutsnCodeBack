package mx.gnc.as.gutsncode.services;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
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

@Component		
public class GeneralServices {
	
	@Autowired
	private GeneralRepository generalRepository;
		
	public Integer deletePost(Long postId) {
		generalRepository.deleteRelatedText(postId);
		generalRepository.deletePost(postId);
		return 1;
	}
	
	public Integer addView(Long postId) {
		generalRepository.incrementViewCounter(postId, new BigInteger("1"));
		return generalRepository.getViewCounter(postId);
	}
	
}

package mx.gnc.as.gutsncode.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import mx.gnc.as.gutsncode.dao.Post;
import mx.gnc.as.gutsncode.dao.Status;
import mx.gnc.as.gutsncode.dao.Text;
import mx.gnc.as.gutsncode.dao.TypePost;
import mx.gnc.as.gutsncode.exceptions.ResourceNotFoundException;
import mx.gnc.as.gutsncode.model.PostId;
import mx.gnc.as.gutsncode.model.TextOnlyRequieredDataForUser;
import mx.gnc.as.gutsncode.model.management.ReceiveObject;
import mx.gnc.as.gutsncode.repository.ManagmentRepository;


@RestController
@RequestMapping("/managment")
public class ManagementController {
	
	private final Integer defaultSizePage = 20;
	private static final Logger LOG = LogManager.getLogger(ManagementController.class);
	
	@Autowired
	private ManagmentRepository  managmentRepository;
	
	@PostMapping(value = "/recentPost")
	@ApiOperation(value = "Return the recent post", notes = "need type and topic, pageNumber are 0 by default and pageSize are 20 by default")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "The payload was correct"),
			@ApiResponse(code = 204, message = "The payload do not contain correct/enough info"),
			@ApiResponse(code = 400, message = "The payload do not contain required info") 
			})
	public ResponseEntity<List<Post>> postBy20(@RequestBody ReceiveObject receiver) throws ResourceNotFoundException {		
		LOG.info("recentPost service");
		
		Integer pageNumber = (receiver.getPage()!=null)? receiver.getPage():0;
		Integer sizePage = (receiver.getSizePage()!=null)? receiver.getSizePage():this.defaultSizePage;
		String nameFounder;
		String type;
		String status;

		List<Post> listPost;

		if(receiver.getType() != null || receiver.getStatus()!=null || receiver.getFounderName()!=null) {
			status=receiver.getStatus();
			nameFounder= receiver.getFounderName();
			type = receiver.getType();
		}else {
			LOG.error("BAD REQUEST for: " + receiver.toString());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		listPost = managmentRepository.getPostRelated(Status.getEnum(status), TypePost.getEnum(type), PageRequest.of(pageNumber, sizePage), nameFounder);
		if(listPost == null || listPost.size() == 0) {
			LOG.warn("NO CONTENT for: " + receiver.toString());
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(listPost, HttpStatus.OK);
	}

	
	@PostMapping("/getText")
	@ApiOperation(value = "Bring all texts and images related with a post", notes = "Return texts with images" )
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "The payload was correct"),
			@ApiResponse(code = 204, message = "The payload do not contain correct/enough info"),
			@ApiResponse(code = 400, message = "The payload do not contain required info") 
			})
	public ResponseEntity<List<TextOnlyRequieredDataForUser>> getTextEdition(@RequestBody PostId receiver) throws ResourceNotFoundException {	

		Long postId;
		try {
			postId = receiver.getPostId();
		} catch (NullPointerException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		List<Text> text = managmentRepository.getTextContent(postId);
		if(text == null || text.size() == 0)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		List<TextOnlyRequieredDataForUser> textReduced = new ArrayList<TextOnlyRequieredDataForUser>();
		for (Text text2 : text) {
			textReduced.add(new TextOnlyRequieredDataForUser(text2, new byte[0]));
		}
		
		return new ResponseEntity<>(textReduced, HttpStatus.OK);
	}
}

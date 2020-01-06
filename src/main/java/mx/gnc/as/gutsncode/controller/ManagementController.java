package mx.gnc.as.gutsncode.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import mx.gnc.as.gutsncode.dao.Post;
import mx.gnc.as.gutsncode.dao.Status;
import mx.gnc.as.gutsncode.dao.Text;
import mx.gnc.as.gutsncode.dao.TypePost;
import mx.gnc.as.gutsncode.exceptions.ResourceNotFoundException;
import mx.gnc.as.gutsncode.model.PostId;

import mx.gnc.as.gutsncode.model.management.ReceiveIdTextToEdit;
import mx.gnc.as.gutsncode.model.management.ReceiveObjectRecent;
import mx.gnc.as.gutsncode.model.management.ReceiveTextToEdit;
import mx.gnc.as.gutsncode.model.management.TextOnlyRequieredDataForUser;
import mx.gnc.as.gutsncode.repository.ManagmentRepository;

@RestController
@RequestMapping("/managment")
@CrossOrigin(origins = "http://localhost:4200")
public class ManagementController {

	private final Integer defaultSizePage = 20;
	private static final Logger LOG = LogManager.getLogger(ManagementController.class);

	@Autowired
	private ManagmentRepository managmentRepository;
	
	@PostMapping(value = "/recentPost")
	@ApiOperation(value = "Return the recent post", notes = "need type and topic, pageNumber are 0 by default and pageSize are 20 by default")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "The payload was correct"),
			@ApiResponse(code = 204, message = "The payload do not contain correct/enough info"),
			@ApiResponse(code = 400, message = "The payload do not contain required info") 
			})
	public ResponseEntity<List<Post>> postBy20(@RequestBody ReceiveObjectRecent receiver)
			throws ResourceNotFoundException {
		LOG.info("recentPost service");
		List<Post> listPost=null;
		Integer pageNumber = (receiver.getPage() != null) ? receiver.getPage() : 0;
		Integer sizePage = (receiver.getSizePage() != null) ? receiver.getSizePage() : this.defaultSizePage;
		String nameFounder;
		Set<TypePost> typePostList=new HashSet<TypePost>();
		String[] types=(receiver.getTypes()!= null) ? receiver.getTypes() : null;
		if(types!=null) {
			for(String item :types) {
				typePostList.add(TypePost.getEnum(item));
			}
		}
		Set<Status> statusList=new HashSet<Status>();
		String[] status=(receiver.getStatus()!= null) ? receiver.getStatus() : null;
		if(status!=null) {
			for(String item :status) {
				statusList.add(Status.getEnum(item));
			}
		}
		
		String[] topics=(receiver.getTopics()!= null) ? receiver.getTopics() : null;
	

		if (receiver.getFounderName() != null) {
			nameFounder = receiver.getFounderName().toUpperCase();
			try {
				if (types!=null && topics!=null && status!=null) {
					listPost = managmentRepository.getPostRelatedCompleteParams(nameFounder, statusList, typePostList, Arrays.asList(topics), PageRequest.of(pageNumber, sizePage));
				}
				else if(types!=null && topics==null && status!=null) {
					listPost = managmentRepository.getPostRelatedStatusAndType(nameFounder, statusList, typePostList,  PageRequest.of(pageNumber, sizePage));
				}
				else if(types==null && topics!=null && status!=null) {
					listPost = managmentRepository.getPostRelatedStatusAndTopic(nameFounder, statusList,  Arrays.asList(topics), PageRequest.of(pageNumber, sizePage));
				}
				else if(types!=null && topics!=null && status==null) {
					listPost = managmentRepository.getPostRelatedTypeAndTopic(nameFounder, typePostList, Arrays.asList(topics), PageRequest.of(pageNumber, sizePage));
				}
				else if(types==null && topics==null && status!=null) {
					listPost = managmentRepository.getPostRelatedStatus(nameFounder, statusList, PageRequest.of(pageNumber, sizePage));
				}
				else if(types==null && topics!=null && status==null) {
					listPost = managmentRepository.getPostRelatedTopic(nameFounder, Arrays.asList(topics), PageRequest.of(pageNumber, sizePage));
				}
				else if(types!=null && topics==null && status==null) {
					listPost = managmentRepository.getPostRelatedType(nameFounder, typePostList,  PageRequest.of(pageNumber, sizePage));
				}
				else if(types==null && topics==null && status==null) {
				 listPost = managmentRepository.getPostRelated(nameFounder,
							PageRequest.of(pageNumber, sizePage));
				}
				if (listPost == null || listPost.size() == 0) {
					LOG.warn("NO CONTENT for: " + receiver.toString());
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}

				return new ResponseEntity<>(listPost, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>(null, HttpStatus.OK);
			}
		} else {
			LOG.error("BAD REQUEST for: " + receiver.toString());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
	
	@PostMapping(value = "/totalPages")
	@ApiOperation(value = "Return the recent post", notes = "need type and topic, pageNumber are 0 by default and pageSize are 20 by default")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "The payload was correct"),
			@ApiResponse(code = 204, message = "The payload do not contain correct/enough info"),
			@ApiResponse(code = 400, message = "The payload do not contain required info") 
			})
	public ResponseEntity<Integer> totalPages(@RequestBody ReceiveObjectRecent receiver)
			throws ResourceNotFoundException {
		LOG.info("recentPost service");
		Integer listPost = 0;
		Integer pageNumber = (receiver.getPage() != null) ? receiver.getPage() : 0;
		Integer sizePage = (receiver.getSizePage() != null) ? receiver.getSizePage() : this.defaultSizePage;
		String nameFounder;
		Set<TypePost> typePostList=new HashSet<TypePost>();
		String[] types=(receiver.getTypes()!= null) ? receiver.getTypes() : null;
		if(types!=null) {
			for(String item :types) {
				typePostList.add(TypePost.getEnum(item));
			}
		}
		Set<Status> statusList=new HashSet<Status>();
		String[] status=(receiver.getStatus()!= null) ? receiver.getStatus() : null;
		if(status!=null) {
			for(String item :status) {
				statusList.add(Status.getEnum(item));
			}
		}
		
		String[] topics=(receiver.getTopics()!= null) ? receiver.getTopics() : null;
	

		if (receiver.getFounderName() != null) {
			nameFounder = receiver.getFounderName().toUpperCase();
			try {
				if (types!=null && topics!=null && status!=null) {
					listPost = managmentRepository.getCountPostRelatedCompleteParams(nameFounder, statusList, typePostList, Arrays.asList(topics));
				}
				else if(types!=null && topics==null && status!=null) {
					listPost = managmentRepository.getCountPostRelatedStatusAndType(nameFounder, statusList, typePostList);
				}
				else if(types==null && topics!=null && status!=null) {
					listPost = managmentRepository.getCountPostRelatedStatusAndTopic(nameFounder, statusList,  Arrays.asList(topics));
				}
				else if(types!=null && topics!=null && status==null) {
					listPost = managmentRepository.getCountPostRelatedTypeAndTopic(nameFounder, typePostList, Arrays.asList(topics));
				}
				else if(types==null && topics==null && status!=null) {
					listPost = managmentRepository.getCountPostRelatedStatus(nameFounder, statusList);
				}
				else if(types==null && topics!=null && status==null) {
					listPost = managmentRepository.getCountPostRelatedTopic(nameFounder, Arrays.asList(topics));
				}
				else if(types!=null && topics==null && status==null) {
					listPost = managmentRepository.getCountPostRelatedType(nameFounder, typePostList);
				}
				else if(types==null && topics==null && status==null) {
				 listPost = managmentRepository.getCountPostRelated(nameFounder);
				}
				if (listPost == 0) {
					LOG.warn("NO CONTENT for: " + receiver.toString());
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}

				return new ResponseEntity<>((listPost / sizePage) + 1, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>(null, HttpStatus.OK);
			}
		} else {
			LOG.error("BAD REQUEST for: " + receiver.toString());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("/getText")
	@ApiOperation(value = "Bring all texts and images related with a post", notes = "Return texts with images")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "The payload was correct"),
			@ApiResponse(code = 204, message = "The payload do not contain correct/enough info"),
			@ApiResponse(code = 400, message = "The payload do not contain required info") })
	public ResponseEntity<List<TextOnlyRequieredDataForUser>> getTextEdition(@RequestBody PostId receiver)
			throws ResourceNotFoundException {

		Long postId;
		try {
			postId = receiver.getPostId();
		} catch (NullPointerException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		List<Text> text = managmentRepository.getTextContent(postId);
		if (text == null || text.size() == 0)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		List<TextOnlyRequieredDataForUser> textReduced = new ArrayList<TextOnlyRequieredDataForUser>();
		for (Text text2 : text) {
			textReduced.add(new TextOnlyRequieredDataForUser(text2));
		}

		return new ResponseEntity<>(textReduced, HttpStatus.OK);
	}

	@PostMapping("/updateTextBeta")
	@ApiOperation(value = "Update textBeta", notes = "change textBeta")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "The payload was correct"),
			@ApiResponse(code = 204, message = "The payload do not contain correct/enough info"),
			@ApiResponse(code = 400, message = "The payload do not contain required info") })
	public ResponseEntity<Boolean> updateText(@RequestBody List<ReceiveTextToEdit> receiver)
			throws ResourceNotFoundException {

		try {
			for (ReceiveTextToEdit item : receiver) {
				if (item.getTextBeta() != null && item.getTextId() != null) {
					managmentRepository.updateTextBeta(item.getTextBeta(), Long.parseLong(item.getTextId()));
				} else {
					throw new NullPointerException("Request Item null");
				}
			}
		} catch (NullPointerException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}

	@PostMapping("/switchTextRealizeAndTextBeta")
	@ApiOperation(value = "Update textRealize to textBeta", notes = "change textRealize by textBeta")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "The payload was correct"),
			@ApiResponse(code = 204, message = "The payload do not contain correct/enough info"),
			@ApiResponse(code = 400, message = "The payload do not contain required info") })
	public ResponseEntity<Boolean> switchTextRealizeAndTextBeta(@RequestBody List<ReceiveIdTextToEdit> receiver)
			throws ResourceNotFoundException {

		try {
			for (ReceiveIdTextToEdit item : receiver) {
				if (item.getTextId() != null) {
					managmentRepository.switchBetaRealize(Long.parseLong(item.getTextId()));
				} else {
					throw new NullPointerException("Request Item null");
				}
			}
		} catch (NullPointerException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
	
	@GetMapping("/getTopic/{founderName}")
	@ApiOperation(value = "Get topics ", notes = "get topics")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "The payload was correct"),
			@ApiResponse(code = 204, message = "The payload do not contain correct/enough info"),
			@ApiResponse(code = 400, message = "The payload do not contain required info") })
	public ResponseEntity<Set<String>> getTopics(@PathVariable String founderName)
			throws ResourceNotFoundException {
		try {
			Set<String> listTopic=managmentRepository.getTopics(founderName.toUpperCase());
			return new ResponseEntity<Set<String>>(listTopic, HttpStatus.OK);
				
		} catch (NullPointerException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}

}

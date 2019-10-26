package mx.gnc.as.gutsncode;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.gnc.as.gutsncode.dao.Founder;
import mx.gnc.as.gutsncode.dao.Post;
import mx.gnc.as.gutsncode.dao.Status;
import mx.gnc.as.gutsncode.dao.TypePost;
import mx.gnc.as.gutsncode.repository.FounderRepository;
import mx.gnc.as.gutsncode.repository.PostRepository;

@RestController
public class Rest {
	
	@Autowired
	private FounderRepository repositoryF;
	
	@Autowired
	private PostRepository postRepository;

	@GetMapping("/hola")
	public String rest() {
		Founder founder= null;
		repositoryF.save(
				new Founder("Abi", "Ortega", "Valdivia", "asdlfjasdlf", "abigailortega31@gmail.com", "jflasdjflsd"));
		List<Founder> list = repositoryF.findAll();
		
		for (Founder founderr : list) {
			System.out.println(founderr.getName());
			founder=founderr;
		
		}
		
		System.out.println(TypePost.EXPERIENCE.getTypePostId());
		postRepository.save(new Post("java 8",new BigInteger("0"),Status.EDITION,"java",new Date(), founder,founder ,new Date(),TypePost.NEW,"java 8 fabuloso", "fdfasdf"));
		
		
		
		for (Founder founderr : list) {
			System.out.println(founderr.getName());
		}
		List<Post> postList= postRepository.findAll();
		for (Post post : postList){
			System.out.println(post.getName());
			System.out.println(post.getTypePostId().getTypePostId());
		}		
		repositoryF.findByName("Abi").forEach(x -> System.out.println("by name" + x));
		
		
		/*
		 * repository.save(new Book("Java")); repository.save(new Book("Node"));
		 * repository.save(new Book("Python"));
		 * 
		 * System.out.println("\nfindAll()"); repository.findAll().forEach( x ->
		 * System.out.println(x));
		 * 
		 * System.out.println("\nfindById(1L)"); repository.findById(1l).ifPresent(x ->
		 * System.out.println(x));
		 * 
		 * System.out.println("\nfindByName('Node')");
		 * repository.findByName("Node").forEach(x -> System.out.println(x));
		 */
		
		return "holi";
	}

}

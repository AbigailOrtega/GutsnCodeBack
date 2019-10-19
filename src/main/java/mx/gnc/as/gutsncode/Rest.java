package mx.gnc.as.gutsncode;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.gnc.as.gutsncode.dao.Founder;

import mx.gnc.as.gutsncode.repository.FounderRepository;

@RestController
public class Rest {
	@Autowired
	private FounderRepository repositoryF;

	@GetMapping("/hola")
	public String rest() {

		repositoryF.save(
				new Founder("Abi", "Ortega", "Valdivia", "asdlfjasdlf", "abigailortega31@gmail.com", "jflasdjflsd"));
		
		List<Founder> list = repositoryF.findAll();
		
		for (Founder founder : list) {
			System.out.println(founder.getName());
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

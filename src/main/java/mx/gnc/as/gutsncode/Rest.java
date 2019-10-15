package mx.gnc.as.gutsncode;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Rest {
	
	@GetMapping("/hola")
	public String rest() {
		return "holi";
	}

}

package mx.gnc.as.gutsncode.model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/h")
public class HelloWorldController{

	@RequestMapping("hello")
	public String helloWorld(@RequestParam(value = "name", defaultValue = "World") String name) {
		return "Hello " + name + "!!";
	}
}
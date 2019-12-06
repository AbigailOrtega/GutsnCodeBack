package mx.gnc.as.gutsncode.tests;

import java.math.BigInteger;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import mx.gnc.as.gutsncode.dao.Founder;
import mx.gnc.as.gutsncode.dao.Post;
import mx.gnc.as.gutsncode.dao.Status;
import mx.gnc.as.gutsncode.dao.Text;
import mx.gnc.as.gutsncode.dao.TypePost;
import mx.gnc.as.gutsncode.services.users.GNCuRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class GutsncodeApplicationTests {

	@BeforeAll
	static void setup() {
		System.out.println("@BeforeAll executed");
	}

	@BeforeEach
	void setupThis() {
		System.out.println("@BeforeEach executed");
	}

	/**
	 * REPOSITORY TEST
	 **/
	@Autowired
	private GNCuRepository gncuRepository;
	
	@Test
	// Prueba de Integración
	void testGetTextContent() {
		System.out.println("======TEST getTextContent EXECUTED=======");
		Assertions.assertEquals(Text.class, gncuRepository.getTextContent(Long.valueOf(1)).get(0).getClass());
	}

	@Test
	// Prueba de Integración
	void testGetViewCounter() {
		System.out.println("======TEST getViewCounter EXECUTED=======");
		Assertions.assertEquals(Integer.class, gncuRepository.getViewCounter(Long.valueOf(1)).getClass());
	}

	@Test
	// Prueba de Integración
	void testIncrementViewCounter() {
		System.out.println("======TEST incrementViewCounter EXECUTED=======");
		Assertions.assertEquals(Integer.class, gncuRepository.incrementViewCounter(Long.valueOf(1), BigInteger.valueOf(1)).getClass());
	}

	@Test
	// Prueba de Integración
	void testGetPostOrdered() {
		System.out.println("======TEST getPostOrdered EXECUTED=======");
		List<Post> listPost = gncuRepository.getPostOrdered(Status.PUBLISHED, TypePost.POST, "", PageRequest.of(0,3));
		Assertions.assertEquals(3, listPost.size());
		for (Post post : listPost) {
			Assertions.assertEquals(Long.class, post.getPostId().getClass());
		}
		Assertions.assertEquals(Post.class, listPost.get(0).getClass());
		
	}

	@Test
	// Prueba de Integración
	void testGetFounderInfo() {
		System.out.println("======TEST getFounderInfo EXECUTED=======");
		Founder founder = gncuRepository.getFounderInfo("SEBAS");
		Assertions.assertEquals(Founder.class, founder.getClass());
		Assertions.assertEquals("SEBAS", founder.getName().toUpperCase());
		Assertions.assertEquals("CUATEPOTZO", founder.getLastName().toUpperCase());
		Assertions.assertEquals("MARTINEZ", founder.getSecondLastName().toUpperCase());
	}

	/**
	 * REPOSITORY TEST
	 **/
	
	
	@AfterEach
	void tearThis() {
		System.out.println("@AfterEach executed");
	}

	@AfterAll
	static void tear() {
		System.out.println("@AfterAll executed");
	}

}

package mx.gnc.as.gutsncode.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import mx.gnc.as.gutsncode.dao.Text;
import mx.gnc.as.gutsncode.services.postu.PostURepository;
import mx.gnc.as.gutsncode.services.postu.PostUServices;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class GutsncodeApplicationTests {

	@Autowired
	private PostURepository postURepository;
	
	@BeforeAll
    static void setup(){
        System.out.println("@BeforeAll executed");
    }
     
    @BeforeEach
    void setupThis(){
        System.out.println("@BeforeEach executed");
    }
     
    @Test
    //Prueba de Integración
    void testCalcOne() 
    {
        System.out.println("======TEST ONE EXECUTED=======");
        Assertions.assertEquals(Text.class, postURepository.getTextContent(Long.valueOf(1)).get(0).getClass());
    }
     
//    @Test
//    void testCalcTwo() 
//    {
//        System.out.println("======TEST TWO EXECUTED=======");
//        Assertions.assertEquals( 6 , 6);
//    }
     
    @AfterEach
    void tearThis(){
        System.out.println("@AfterEach executed");
    }
     
    @AfterAll
    static void tear(){
        System.out.println("@AfterAll executed");
    }
	
}

package mx.gnc.as.gutsncode.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class GutsncodeApplicationTests {

	@BeforeAll
    static void setup(){
        System.out.println("@BeforeAll executed");
    }
     
    @BeforeEach
    void setupThis(){
        System.out.println("@BeforeEach executed");
    }
     
    @Test
    void testCalcOne() 
    {
        System.out.println("======TEST ONE EXECUTED=======");
//        Assertions.assertEquals( 4 , 4);
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

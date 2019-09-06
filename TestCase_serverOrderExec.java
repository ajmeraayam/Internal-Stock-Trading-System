import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.After;  
import org.junit.AfterClass;  
import org.junit.Before;  
import org.junit.BeforeClass;  
import org.junit.Test; 
////////////////////////////////////////////////////
//import package and class file being tested here
////////////////////////////////////////////////////
  
public class TestCase_serverOrderExec {  
  
	static File file = new File("abc.txt");													//Address - Preferably /your directory/files/abc.txt
	String name;
	int price, quantity;
	
    @BeforeClass  
    public static void setUpBeforeClass() throws Exception {  
        System.out.println("before class");  
    }
	
    @Before  
    public void setUp() throws Exception {  
        System.out.println("before");
		
    }  
  
    @Test  
    public void testBuyOrder(){  
        System.out.println("Testing order execution");  
        assertTrue(orderExec());																//checking if order is has been executed, returns true if order (buy/sell) executed
	}
	
    @After  
    public void tearDown() throws Exception {  
        System.out.println("after");  
    }  
  
    @AfterClass  
    public static void tearDownAfterClass() throws Exception {  
        System.out.println("after class");  
    }  
}  
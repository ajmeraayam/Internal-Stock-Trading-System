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
  
public class TestCase_shutdown {  
  
	static File file = new File("abc.txt");													//Address - Preferably /your directory/files/abc.txt
	
    @BeforeClass  
    public static void setUpBeforeClass() throws Exception {  
        System.out.println("before class");  
    }
	
    @Before  
    public void setUp() throws Exception {  
        System.out.println("before");
		
		//if(file.exists() && !file.isDirectory())
		//	file.open();
    }  
  
    @Test  
    public void testShutdown(){  
        System.out.println("Testing server shutdown functionality");  
        assertEquals("Server shutdown", shutdown());										//class name before method name
		assertEquals(0, checkQueue());														//class name before method name	
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
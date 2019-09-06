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
  
public class TestCase_login {  
  
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
    public void testLoginPass(){  
        System.out.println("Testing login pass functionality");  
        assertEquals("Successful", login());												//class name before login() method  
    } 

	@Test  
    public void testLoginFail(){  
        System.out.println("Testing login fail functionality");  
        assertEquals("Unsuccessful. You don't have an account on the system", login());		//class name before login() method  
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
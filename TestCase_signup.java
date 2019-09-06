import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.After;  
import org.junit.AfterClass;  
import org.junit.Before;  
import org.junit.BeforeClass;  
import org.junit.Test; 
////////////////////////////////////////////////////
//import package and class file being tested here
////////////////////////////////////////////////////
  
public class TestCase_signup {  
  
	static File file = new File("abc.txt");													//Address - Preferably /your directory/files/abc.txt
	
    @BeforeClass  
    public static void setUpBeforeClass() throws Exception {  
        System.out.println("before class");  
    }
	
    @Before  
    public void setUp() throws Exception {  
        System.out.println("before");
		
		//if(file.exists() && !file.isDirectory())
		//	file.delete();	
    }  
  
    @Test  
    public void testSignupPass(){  
        System.out.println("Testing sign up pass functionality");  
        assertEquals("Successful", signup());												//class name before signup() method  
    }  
	
	@Test  
    public void testSignupFail(){  
        System.out.println("Testing sign up fail functionality");  
        assertEquals("User already exists.", signup());												//class name before signup() method  
    }
	
	@Test
	public void testUniqueUsername() {
		String s = "username";
		System.out.println("Test if userrname is unique.");
		assertTrue(checkUsername(s));
	}
	
	@Test
	public void testCredLength() {
		String uname = "username";
		String pwd = "password";
		assertTrue(checkCredLength(uname, pwd));
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
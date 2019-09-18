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
	signup temp;
	
    @BeforeClass  
    public static void setUpBeforeClass() throws Exception {  
    	temp  = new signup("John", "Applebee", "japple", "japple@bee.com","johnny");
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
        assertEquals(true, new signup("John", "Applebee", "japple", "japple@bee.com","johnny").createAcc());												//class name before signup() method  
    }  
	
	@Test  
    public void testSignupFail(){  
        System.out.println("Testing sign up fail functionality");  
        assertEquals(false, new signup("John", "Applebee", "japple", "japple@bee.com","johnny").createAcc());												//class name before signup() method  
    }
	
	@Test
	public void testUniqueUsername() {
		String s = "username";
		System.out.println("Test if userrname is unique.");
		assertTrue(temp.isUsernameUnique(s));
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
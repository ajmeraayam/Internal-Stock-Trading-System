import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Time;

import org.junit.After;  
import org.junit.AfterClass;  
import org.junit.Before;  
import org.junit.BeforeClass;  
import org.junit.Test; 
 
public class TestCase_signup {  
 
	static signup temp;
	
    @BeforeClass  
    public static void setUpBeforeClass() throws Exception {  
    	temp  = new signup("John", "Applebee", "japple", "japple@bee.com","johnny");
        System.out.println("before class");  
    }
	
    @Before  
    public void setUp() throws Exception {  
        System.out.println("before");
    }  
  
    @Test  
    public void testSignupPass(){  
        System.out.println("Testing sign up pass functionality");  
        assertEquals(true, new signup("John", "Applebee", temp.getUsername()+System.currentTimeMillis(), "japple@bee.com","johnny").createAcc());												//class name before signup() method  
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
	public void testUniqueUsernameFail() {
		String s = "ayamaj";
		System.out.println("Test if userrname is unique.");
		assertFalse(temp.isUsernameUnique(s));
	}
	
	@Test
	public void testCredLengthPass() {
	// Check if password length is >= 8
		String pwd = "password";
		assertTrue(temp.checkCredLength(pwd));
	}
	
	@Test
	public void testCredLengthFail() {
		String pwd = "short";
		assertFalse(temp.checkCredLength(pwd));
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
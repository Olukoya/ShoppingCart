import static org.junit.Assert.*;

import org.junit.Test;


public class Test1 {

	@Test
	   public void validity(){
		   System.out.println("Test username and password validity");
		   grabProduct valid = new grabProduct();
		   assertTrue(grabProduct.validity("mena", "password"));
	}
	
	
	
}

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.UserProfile;
import customTools.DBUtil;

public class grabProduct {
	public static void main(String[] args) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
			model.ShoppingCart cart = em.find(model.ShoppingCart.class, (long)455711);
			System.out.println(cart.getProductName());
		} catch (Exception e){
			System.out.println(e);
		} finally {
			em.close();
			System.out.println("cerrado!");
		}
	}
	
	public static boolean validity (String username, String password) {
		String userMessage = "SELECT u FROM UserProfile u WHERE u.username = :username and u.userPassword = :password";
		EntityManager emf = DBUtil.getEmFactory().createEntityManager();
		TypedQuery<UserProfile> user = emf.createQuery(userMessage,UserProfile.class);
		
		user.setParameter("username", username);
		user.setParameter("password", password);

		boolean valid = false;
		try {
			
			if (user.getSingleResult().getUsername().equalsIgnoreCase(username) &&	user.getSingleResult().getUserPassword().equals(password))
			{
				valid = true;
			}	
			System.out.println(valid);
			
		} catch (Exception e){
			System.out.println(e);
		} finally {
			emf.close();
		}
		return valid;
		
		
	}
	
	
}

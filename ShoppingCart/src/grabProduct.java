import javax.persistence.EntityManager;
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
}

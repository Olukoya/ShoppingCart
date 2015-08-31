import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import model.ShoppingCart;
import customTools.DBUtil;

 

public class Insert {

public static void insert(ShoppingCart item) {
EntityManager emf = DBUtil.getEmFactory().createEntityManager();
EntityTransaction trans = emf.getTransaction();
trans.begin(); 
try {
emf.persist(item);
trans.commit();
} catch (Exception e) {
System.out.println(e);
trans.rollback();
} finally {
emf.close();
}
}

public static void update(ShoppingCart item) {
EntityManager emf = DBUtil.getEmFactory().createEntityManager();
EntityTransaction trans = emf.getTransaction();
trans.begin(); 
try {
emf.merge(item);
trans.commit();
} catch (Exception e) {
System.out.println(e);
trans.rollback();
} finally {
emf.close();
}
}

public static void delete(ShoppingCart item) {
EntityManager emf = DBUtil.getEmFactory().createEntityManager();
EntityTransaction trans = emf.getTransaction();
trans.begin(); 
try {
emf.remove(emf.merge(item));
trans.commit();
} catch (Exception e) {
System.out.println(e);
trans.rollback();
} finally {
emf.close();
} 
}

/*public static Double average(Grades user){
	EntityManager emf = DBUtil.getEmFactory().createEntityManager();
	TypedQuery<Double> q = emf.createQuery("select avg(g.grade) from Grades g",Double.class);
	Double avg = q.getSingleResult();
	
	return avg;
}*/

public static List<ShoppingCart>selectProduct() {
	EntityManager emf = DBUtil.getEmFactory().createEntityManager();
	String qString = "SELECT s FROM ShoppingCart s";
	TypedQuery<ShoppingCart> q = emf.createQuery(qString, ShoppingCart.class);
	//q.setParameter("",username);
	//q.setParameter("",post);
	List <ShoppingCart> products;
	try{
		products = q.getResultList();
		if (products==null || products.isEmpty())
			products = null;
	} finally {
		emf.close();
	}
	return products;
}



}
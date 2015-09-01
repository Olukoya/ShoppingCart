import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpSession;

import model.ShoppingCart;
import customTools.DBUtil;
import model.CartdbTemp;
 

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



public static void insertCart(CartdbTemp cart) {
EntityManager emf = DBUtil.getEmFactory().createEntityManager();
EntityTransaction trans = emf.getTransaction();
trans.begin(); 
try {
emf.persist(cart);
trans.commit();
} catch (Exception e) {
System.out.println(e);
trans.rollback();
} finally {
emf.close();
}
}

public static void updateCart(CartdbTemp cart) {
EntityManager emf = DBUtil.getEmFactory().createEntityManager();
EntityTransaction trans = emf.getTransaction();
trans.begin(); 
try {
emf.merge(cart);
trans.commit();
} catch (Exception e) {
System.out.println(e);
trans.rollback();
} finally {
emf.close();
}
}

public static void deleteCart(CartdbTemp cart) {
EntityManager emf = DBUtil.getEmFactory().createEntityManager();
EntityTransaction trans = emf.getTransaction();
trans.begin(); 
try {
emf.remove(emf.merge(cart));
trans.commit();
} catch (Exception e) {
System.out.println(e);
trans.rollback();
} finally {
emf.close();
} 
}



public static List<ShoppingCart>selectProduct() {
	EntityManager emf = DBUtil.getEmFactory().createEntityManager();
	String qString = "SELECT s FROM ShoppingCart s";
	TypedQuery<ShoppingCart> q = emf.createQuery(qString, ShoppingCart.class);
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

public static List<CartdbTemp>selectCart() {
	EntityManager emf = DBUtil.getEmFactory().createEntityManager();
	String qString = "SELECT c FROM CartdbTemp c";
	TypedQuery<CartdbTemp> q = emf.createQuery(qString, CartdbTemp.class);
	List <CartdbTemp> cart;
	try{
		cart = q.getResultList();
		if (cart==null || cart.isEmpty())
			cart = null;
	} finally {
		emf.close();
	}
	return cart;
}



/*public static  details (ShoppingCart item) {
	String userMessage = "SELECT s FROM ShoppingCart s WHERE s.product_name = :pName";
	EntityManager emf = DBUtil.getEmFactory().createEntityManager();
	TypedQuery<ShoppingCart> product = emf.createQuery(userMessage,ShoppingCart.class);
	
	product.getP
	user.setParameter("username", username);
	user.setParameter("password", password);

	return details(); 
	
	
}

*/
}
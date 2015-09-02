import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpSession;

import model.OrderDb;
import model.ShoppingCart;
import model.UserProfile;
import customTools.DBUtil;
import model.CartdbTemp;
 

public class Insert {
	
// DATABASE MANIPULATIONS FOR SHOPPINGCART JPA
	
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

//DATABASE MANIPULATIONS FOR CARTDBTEMP JPA

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


//DATABASE MANIPULATIONS FOR ORDERDB JPA

public static void insertOrder(OrderDb order) {
EntityManager emf = DBUtil.getEmFactory().createEntityManager();
EntityTransaction trans = emf.getTransaction();
trans.begin(); 
try {
emf.persist(order);
trans.commit();
} catch (Exception e) {
System.out.println(e);
trans.rollback();
} finally {
emf.close();
}
}

public static void updateOrder(OrderDb order) {
EntityManager emf = DBUtil.getEmFactory().createEntityManager();
EntityTransaction trans = emf.getTransaction();
trans.begin(); 
try {
emf.merge(order);
trans.commit();
} catch (Exception e) {
System.out.println(e);
trans.rollback();
} finally {
emf.close();
}
}

public static void deleteOrder(OrderDb order) {
EntityManager emf = DBUtil.getEmFactory().createEntityManager();
EntityTransaction trans = emf.getTransaction();
trans.begin(); 
try {
emf.remove(emf.merge(order));
trans.commit();
} catch (Exception e) {
System.out.println(e);
trans.rollback();
} finally {
emf.close();
} 
}


//DATABASE MANIPULATIONS FOR USERPROFILE JPA

public static void insertUser(UserProfile user) {
EntityManager emf = DBUtil.getEmFactory().createEntityManager();
EntityTransaction trans = emf.getTransaction();
trans.begin(); 
try {
emf.persist(user);
trans.commit();
} catch (Exception e) {
System.out.println(e);
trans.rollback();
} finally {
emf.close();
}
}

public static void updateUser(UserProfile user) {
EntityManager emf = DBUtil.getEmFactory().createEntityManager();
EntityTransaction trans = emf.getTransaction();
trans.begin(); 
try {
emf.merge(user);
trans.commit();
} catch (Exception e) {
System.out.println(e);
trans.rollback();
} finally {
emf.close();
}
}

public static void deleteUser(UserProfile user) {
EntityManager emf = DBUtil.getEmFactory().createEntityManager();
EntityTransaction trans = emf.getTransaction();
trans.begin(); 
try {
emf.remove(emf.merge(user));
trans.commit();
} catch (Exception e) {
System.out.println(e);
trans.rollback();
} finally {
emf.close();
} 
}


// LISTS CONTAINING ALL ITEMS IN EACH JPA


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


public static List<OrderDb>selectOrder() {
	EntityManager emf = DBUtil.getEmFactory().createEntityManager();
	String qString = "SELECT o FROM OrderDb o";
	TypedQuery<OrderDb> q = emf.createQuery(qString, OrderDb.class);
	List <OrderDb> order;
	try{
		order = q.getResultList();
		if (order==null || order.isEmpty())
			order = null;
	} finally {
		emf.close();
	}
	return order;
}

public static List<UserProfile>selectUser() {
	EntityManager emf = DBUtil.getEmFactory().createEntityManager();
	String qString = "SELECT u FROM UserProfile u";
	TypedQuery<UserProfile> q = emf.createQuery(qString, UserProfile.class);
	List <UserProfile> user;
	try{
		user = q.getResultList();
		if (user==null || user.isEmpty())
			user = null;
	} finally {
		emf.close();
	}
	return user;
}

/*
 * public static List<CartdbTemp>getCart() {
	
	HttpSession session = req.getSession();
	user = (String) session.getAttribute("username");
	EntityManager emf = DBUtil.getEmFactory().createEntityManager();
	String qString = "SELECT c FROM CartdbTemp c where c.userId = :userId";
	TypedQuery<UserProfile> q = emf.createQuery(qString, UserProfile.class);
	List <UserProfile> user;
	try{
		user = q.getResultList();
		if (user==null || user.isEmpty())
			user = null;
	} finally {
		emf.close();
	}
	return user;
}
*/

	
}


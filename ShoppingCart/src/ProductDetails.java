

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ShoppingCart;
import customTools.DBUtil;

/**
 * Servlet implementation class ProductDetails
 */
@WebServlet("/ProductDetails")
public class ProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.getAttribute("username");
		

		String oneProduct = req.getParameter("pID");
		long product1 = Long.parseLong(oneProduct);
		if (oneProduct != null)
		{
			EntityManager emf = DBUtil.getEmFactory().createEntityManager();
			//	model.ShoppingCart product = new ShoppingCart();
				model.ShoppingCart product = emf.createQuery("SELECT s FROM ShoppingCart s where s.productCode = :productCode",model.ShoppingCart.class).setParameter("productCode",product1).getSingleResult();				
			long code= product.getProductCode();
			String name= product.getProductName();
			String desc= product.getProductDescription();
			double price= product.getProductPrice();
			
			HttpSession sessionP = req.getSession();
			
			sessionP.setAttribute("productCode", product1);
			sessionP.setAttribute("productName", name);
			sessionP.setAttribute("productDescription", desc);
			sessionP.setAttribute("productPrice", price);
		
            
			// get the list of values to display
			String details = "<table class=" 
					+ "\"table table-striped\"" 
					+ "style=width:60%>";

			details += 
					"<tr>" 
							+"<th>" + "Product Code" + "</th> <br>"
							+"<th>" + "Product Name" + "</th> <br>"
							+"<th>" + "Product Description" + "</th> <br>"
							+"<th>" + "Product Price" + "</th> <br>"
							+ "</tr>";
			
			details += "<tr>" 
					+"<td>" +code+"</td>"
					+"<td>" +name+"</td>"
					+"<td>" +desc+"</td>"
					+"<td>" +price+"</td>"
					+"</tr>"
					;

	        	details += "</table>";
			req.setAttribute("message", details);
			getServletContext().getRequestDispatcher("/ProductDetailsOutput.jsp").forward(req, res);
		

	}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String user;
		String total="";
		double gTotal=0;
		// TODO Auto-generated method stub
		
		HttpSession session = req.getSession();
		user = (String) session.getAttribute("username");
		EntityManager emf = DBUtil.getEmFactory().createEntityManager();
		List <model.CartdbTemp> cart = emf.createQuery("SELECT c FROM CartdbTemp c where c.userId = :userId",model.CartdbTemp.class).setParameter("userId",user).getResultList();				

		// get the list of values to display
		String line = "<table class=" 
	    		+ "\"table table-striped\"" 
	    		+ "style=width:60%>";
	    
	    line += 
				"<tr>" 
				+"<th>" + "Product Code" + "</th> <br>"
				+"<th>" + "Product" + "</th> <br>"
				+"<th>" + "Item Price" + "</th> <br>"
				+"<th>" + "Quantity" + "</th> <br>"
				+"<th>" + "Subtotal" + "</th> <br>"
			//	+"<th>" + "Price" + "</th> <br>"
				+ "</tr>"
				;
	    
	    for(int i=0; i< cart.size(); i++){
	    	
	    	gTotal+=cart.get(i).getPSub();
		
	    	line += "<tr>" 
	    			+"<td>" +cart.get(i).getPCode()+"</td>"
	    			+"<td>" +cart.get(i).getPName()+ "</td>"
	    			+"<td>" +cart.get(i).getPPrice()+ "</td>"
	    			+"<td>" +cart.get(i).getPQty()+ "</td>"
	    			+"<td>" +cart.get(i).getPSub()+ "</td>"
	    			+"</tr>"
	    	        ;
	    	}
	    line += "</table>";
	    
	    total += "<table class=" 
	    		+ "\"table table-striped\"" 
	    		+ "style=width:60%>";
	    
	    total += 
				"<tr>" 
				+"<th>" + "Grand Total" + "</th> <br>"
				+ "</tr>"
				;

	    total += "<tr>" 
    			+"<td>" +gTotal+"</td>"
    			+"</tr>"
    	        ;
	    total += "</table>";
	    
		req.setAttribute("message", line);
		req.setAttribute("message2", total);
		getServletContext().getRequestDispatcher("/Checkout.jsp").forward(req, res);
		
		
	}

}

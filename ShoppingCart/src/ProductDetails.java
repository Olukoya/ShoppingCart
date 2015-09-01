

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
			
			HttpSession session = req.getSession();
			
			session.setAttribute("productCode", product1);
			session.setAttribute("productName", name);
			session.setAttribute("productDescription", desc);
			session.setAttribute("productPrice", price);
		
            
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
		// TODO Auto-generated method stub
	}

}

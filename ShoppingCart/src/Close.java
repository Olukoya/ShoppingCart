

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

import model.CartdbTemp;
import customTools.DBUtil;

/**
 * Servlet implementation class Close
 */
@WebServlet("/Close")
public class Close extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Close() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		
		EntityManager emf = DBUtil.getEmFactory().createEntityManager();		
		model.CartdbTemp cart = new CartdbTemp();
		HttpSession session = req.getSession();
		
		String quantityString = req.getParameter("quantity");
		Integer quantity = Integer.parseInt(quantityString);
		long code = (long) session.getAttribute("productCode");
		String codeString = Long.toString(code);
		String name = (String) session.getAttribute("productName");
		double price = (double) session.getAttribute("productPrice");
		String priceString = Double.toString(price);
		double subTotal = quantity*price;
		String subTotalString= Double.toString(subTotal);
		
		cart.setPCode((int) code);
		cart.setPName(name);
		cart.setPPrice(price);
		cart.setPQty(quantity);
		cart.setPSub(subTotal);
		
		Insert.insertCart(cart);
		List<String> cartList = Arrays.asList(codeString,name,priceString,quantityString,subTotalString);
		
		System.err.println(" To check if the list prints : " +cartList);

		
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
	    
	    for(int i=0; i<Insert.selectCart().size(); i++){
	    	
	    	gTotal+=Insert.selectCart().get(i).getPSub();
		
	    	line += "<tr>" 
	    			+"<td>" +Insert.selectCart().get(i).getPCode()+"</td>"
	    			+"<td>" + Insert.selectCart().get(i).getPName()+ "</td>"
	    			+"<td>" + Insert.selectCart().get(i).getPPrice()+ "</td>"
	    			+"<td>" + Insert.selectCart().get(i).getPQty()+ "</td>"
	    			+"<td>" + Insert.selectCart().get(i).getPSub()+ "</td>"
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

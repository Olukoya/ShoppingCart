

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CartdbTemp;
import model.OrderDb;
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
    
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	req.getSession().invalidate();
        res.sendRedirect(req.getContextPath() + "/index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		

		Random rand = new Random();
		int num = rand.nextInt(9000000) + 1000000;
		
		
		HttpSession session = req.getSession();
		String user= (String) session.getAttribute("username");
		
		double gTotal=0, tax=0, fullTotal=0;
		String total ="", random="";
		
		EntityManager emf = DBUtil.getEmFactory().createEntityManager();		
		List<CartdbTemp> cart = emf.createQuery("SELECT c FROM CartdbTemp c where c.userId = :userId",model.CartdbTemp.class).setParameter("userId",user).getResultList();
		model.OrderDb order = null;
		HttpSession sessionP = req.getSession();
		
//		String quantityString = req.getParameter("quantity");
//		Integer quantity = Integer.parseInt(quantityString);
//		long code = (long) sessionP.getAttribute("productCode");
//		String codeString = Long.toString(code);
//		String name = (String) sessionP.getAttribute("productName");
//		double price = (double) sessionP.getAttribute("productPrice");
//		String priceString = Double.toString(price);
//		double subTotal = quantity*price;
//		String subTotalString= Double.toString(subTotal);
		
		
		
	//	List<String> orderList = Arrays.asList(codeString,name,priceString,quantityString,subTotalString);
		
	//	System.err.println(" To check if the list prints : " +orderList);

		
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
	    	tax+= Insert.selectCart().get(i).getPSub() *0.06;
	    	fullTotal=gTotal+tax;
	    	
		
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
				+"<th>" + "Total" + "</th> <br>"
				+"<th>" + "Tax" + "</th> <br>"
				+"<th>" + "Grand Total" + "</th> <br>"
				+ "</tr>"
				;

	    total += "<tr>" 
    			+"<td>" +gTotal+"</td>"
    			+"<td>" +tax+"</td>"
    			+"<td>" +fullTotal+"</td>"
    			+"</tr>"
    	        ;
	    total += "</table>";
	    
	    random += "<table class=" 
	    		+ "\"table table-striped\"" 
	    		+ "style=width:60%>";
	    
	    random += 
				"<tr>" 
				+"<th>" + "Your order confirmation is: " + "</th> <br>"
				+ "</tr>"
				;

	    random += "<tr>" 
    			+"<td>" +num+"</td>"
    			+"</tr>"
    	        ;
	    random += "</table>";
	    
	    req.setAttribute("message1", random);
		req.setAttribute("message", line);
		req.setAttribute("message2", total);
		getServletContext().getRequestDispatcher("/Logout.jsp").forward(req, res);
		
		for(CartdbTemp c: cart){
			order = new OrderDb();
			order.setPCode(c.getPCode());
			order.setPName(c.getPName());
			order.setPPrice(c.getPPrice());
			order.setPQty(c.getPQty());
			order.setPSub(c.getPSub());
			
			order.setUserId(user);
			Insert.insertOrder(order);
			Insert.deleteCart(c);
		}
		
	}

}



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
		
		HttpSession session = req.getSession();
		String user= (String) session.getAttribute("username");
		
		double gTotal=0, tax=0, fullTotal=0;
		String total ="";
		
		EntityManager emf = DBUtil.getEmFactory().createEntityManager();		
		model.CartdbTemp cart = new CartdbTemp();
		model.OrderDb order = new OrderDb();
		HttpSession sessionP = req.getSession();
		
		String quantityString = req.getParameter("quantity");
		Integer quantity = Integer.parseInt(quantityString);
		long code = (long) sessionP.getAttribute("productCode");
		String codeString = Long.toString(code);
		String name = (String) sessionP.getAttribute("productName");
		double price = (double) sessionP.getAttribute("productPrice");
		String priceString = Double.toString(price);
		double subTotal = quantity*price;
		String subTotalString= Double.toString(subTotal);
		
		
		order.setPCode(cart.getPCode());
		order.setPName(cart.getPName());
		order.setPPrice(cart.getPPrice());
		order.setPQty(cart.getPQty());
		order.setPSub(cart.getPSub());
		
		order.setUserId(user);
		Insert.insertOrder(order);
		Insert.deleteCart(cart);
		
		List<String> orderList = Arrays.asList(codeString,name,priceString,quantityString,subTotalString);
		
		System.err.println(" To check if the list prints : " +orderList);

		
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
	    
	    for(int i=0; i<Insert.selectOrder().size(); i++){
	    	
	    	gTotal+=Insert.selectOrder().get(i).getPSub();
	    	tax+= Insert.selectOrder().get(i).getPSub() *0.06;
	    	fullTotal=gTotal+tax;
	    	
		
	    	line += "<tr>" 
	    			+"<td>" +Insert.selectOrder().get(i).getPCode()+"</td>"
	    			+"<td>" + Insert.selectOrder().get(i).getPName()+ "</td>"
	    			+"<td>" + Insert.selectOrder().get(i).getPPrice()+ "</td>"
	    			+"<td>" + Insert.selectOrder().get(i).getPQty()+ "</td>"
	    			+"<td>" + Insert.selectOrder().get(i).getPSub()+ "</td>"
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
	    
		req.setAttribute("message", line);
		req.setAttribute("message2", total);
		getServletContext().getRequestDispatcher("/Logout.jsp").forward(req, res);
		
	}

}

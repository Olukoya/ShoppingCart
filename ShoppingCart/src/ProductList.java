

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ShoppingCart;
import model.UserProfile;
import customTools.DBUtil;

/**
 * Servlet implementation class ProductList
 */
@WebServlet("/ProductList")
public class ProductList extends HttpServlet {
	static long pID;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {    
    	
    	EntityManager emf = DBUtil.getEmFactory().createEntityManager();
		model.UserProfile user = new UserProfile();
		
		String username= req.getParameter("username");
		String password=  req.getParameter("password");
		String fullname= req.getParameter("fullname");

		
		user.setUsername(username);
		user.setUserPassword(password);
		user.setUserFullname(fullname);

		Insert.insertUser(user);
		getServletContext().getRequestDispatcher("/Login.jsp").forward(req, res);

	}

protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{ //error here whem continue shopping. Does not get session
	System.out.println("In product list");
	
	boolean login = grabProduct.validity(req.getParameter("username"), req.getParameter("password"));
	if (login == true){
	
		EntityManager emf = DBUtil.getEmFactory().createEntityManager();
	
		model.ShoppingCart products = new ShoppingCart();
	
	
	// get the list of values to display
	    String line = "<table class=" 
	    		+ "\"table table-striped\"" 
	    		+ "style=width:60%>";
	    
	    line += 
				"<tr>" 
				+"<th>" + "Product ID" + "</th> <br>"
				+"<th>" + "Product" + "</th> <br>"
				+"<th>" + "Price" + "</th> <br>"
				+ "</tr>"
				;
	
	    for(int i=0; i<Insert.selectProduct().size(); i++){
	    	 pID = Insert.selectProduct().get(i).getProductCode();
		
	    	line += "<tr>" 
	    			+"<td>" +"<a href =" +"\"ProductDetails?pID=" +pID+"\""+">"+ pID +"</a>"+"</td>"
	    			+"<td>" + Insert.selectProduct().get(i).getProductName()+ "</td>"
	    			+"<td>" + Insert.selectProduct().get(i).getProductPrice()+ "</td>"
	    			+"</tr>"
	    	        ;
	    	}
	    
	    	line += "</table>";
		req.setAttribute("message", line);
		getServletContext().getRequestDispatcher("/ProductListOutput.jsp").forward(req, res);
		
		}
		
	}

protected void doProcess(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{ //error here whem continue shopping. Does not get session
	System.out.println("In product list");
	HttpSession session = req.getSession();
	session.setAttribute("username", req.getParameter("username"));
	session.setAttribute("password", req.getParameter("password"));
	
	boolean login = grabProduct.validity(req.getParameter("username"), req.getParameter("password"));
	if (login == true){
	
		EntityManager emf = DBUtil.getEmFactory().createEntityManager();
	
		model.ShoppingCart products = new ShoppingCart();
	
	
	// get the list of values to display
	    String line = "<table class=" 
	    		+ "\"table table-striped\"" 
	    		+ "style=width:60%>";
	    
	    line += 
				"<tr>" 
				+"<th>" + "Product ID" + "</th> <br>"
				+"<th>" + "Product" + "</th> <br>"
				+"<th>" + "Price" + "</th> <br>"
				+ "</tr>"
				;
	
	    for(int i=0; i<Insert.selectProduct().size(); i++){
	    	 pID = Insert.selectProduct().get(i).getProductCode();
		
	    	line += "<tr>" 
	    			+"<td>" +"<a href =" +"\"ProductDetails?pID=" +pID+"\""+">"+ pID +"</a>"+"</td>"
	    			+"<td>" + Insert.selectProduct().get(i).getProductName()+ "</td>"
	    			+"<td>" + Insert.selectProduct().get(i).getProductPrice()+ "</td>"
	    			+"</tr>"
	    	        ;
	    	}
	    
	    	line += "</table>";
		req.setAttribute("message", line);
		getServletContext().getRequestDispatcher("/ProductListOutput.jsp").forward(req, res);
		
		}
		
	}
	
}

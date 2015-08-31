

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ShoppingCart;
import customTools.DBUtil;

/**
 * Servlet implementation class ProductList
 */
@WebServlet("/ProductList")
public class ProductList extends HttpServlet {
	static String pName;
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

	}

protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
	EntityManager emf = DBUtil.getEmFactory().createEntityManager();
	
	model.ShoppingCart products = new ShoppingCart();
	
	
	// get the list of values to display
    String line = "<table class=" 
    		+ "\"table table-striped\"" 
    		+ "style=width:60%>";
    
    line += 
			"<tr>" 
			+"<th>" + "Product" + "</th> <br>"
			+"<th>" + "Price" + "</th> <br>"
			+ "</tr>"
			;

    for(int i=0; i<Insert.selectProduct().size(); i++){
    	 pName = Insert.selectProduct().get(i).getProductName();
	
    	line += "<tr>" 
    			+"<td>" +"<a href =" +"\"Read?pName=" +pName+"\""+">"+ pName +"</a>"+"</td>"
    			+"<td>" + Insert.selectProduct().get(i).getProductPrice()+ "</td>"
    			+"</tr>"
    	        ;
    	}
    
    	line += "</table>";
	req.setAttribute("message", line);
	getServletContext().getRequestDispatcher("/ProductListOutput.jsp").forward(req, res);
	
}

}
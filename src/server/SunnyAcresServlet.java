/*
 * Name: Duy Tran
 * Date: March 13, 2015
 */

package server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SunnyAcresServlet
 */
@WebServlet("/SunnyAcresServlet")
public class SunnyAcresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB CustomerInformationBean bean; 
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SunnyAcresServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		bean = new CustomerInformationBean();
		bean.setFirstName(request.getParameter("first"));
		bean.setLastName(request.getParameter("last"));
		bean.setAddress(request.getParameter("address"));
		bean.setCity(request.getParameter("city"));
		bean.setState(request.getParameter("state"));
		bean.setZip(request.getParameter("zip"));
		bean.setPhone(request.getParameter("phone"));
		bean.setEmail(request.getParameter("email"));
		bean.setEthnicity(request.getParameter("ethnicity"));
		bean.setGender(request.getParameter("gender"));
		bean.setFruits(request.getParameterValues("fruit"));
		bean.setComment(request.getParameter("comments"));
		
		out.print("<html>");	
		out.print("<head>");
		out.print("<style>");
		out.print("div.fruit_container {height: 100px;width: 90%;margin-bottom: 10px;padding-left: 50px;}");
		out.print("div.fruits {position: relative;width: 100px;height: 100px;position: relative;float: left;margin-left: 10px;margin-right: 10px;}");
		out.print("h3.heading {background-color: #CC9900;width: 100%;margin-bottom: 10px;margin-top: 10px;border-radius:20px;}");
		out.print(".heading{width: auto;font-family: sans-serif;text-indent: 5%;margin: 0;}");
		out.print("</style>");
		out.print("</head>");
		out.print("<body style=\"background-color:#F5EBCC\"><div class=\"personal_info\"><h3 class=\"heading\">Personal Information</h3><div>");
		//Personal Information
		out.print("Name: " + bean.getFirstName() + " " + bean.getLastName() + "<br/>");
		out.print("Address: " + bean.getAddress() + ", " + bean.getCity()
				+ ", " + bean.getState() + ", " + bean.getZip() + "<br/>");
		out.print("Phone: " + bean.getPhone() + "<br/>");
		out.print("Email: " + bean.getEmail() + "<br/>");
		
		out.print("</div><br/></div><div><h3 class=\"heading\">Demographic Information</h3><div>");
		//Demographics
		out.print("Ethnicity: " + bean.getEthnicity() + "<br/>");
		out.print("Gender: " + bean.getGender() + "<br/>");
		
		out.print("</div><br/><div><h3 class=\"heading\">Favorite Fruits</h3><div>");
		//Favorite Fruits
		out.print(bean.getFruits() + "<br/>");
		
		out.print("</div><br/><div><h3 class=\"heading\">Additional Comments</h3>");
		//Additional Comments
		out.print(bean.getComment() + "<br/>");
		
		out.print("</div></body></html>");
		
		
	}

}

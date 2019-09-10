/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;
import Model.Model;
import Beans.UsersBeans;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tipu
 */
@WebServlet(name = "CreateServlet", urlPatterns = {"/CreateServlet"})
public class CreateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        
       UsersBeans aaa = new UsersBeans();
       aaa.setName(name);
       aaa.setPassword(password);
       aaa.setEmail(email);
       aaa.setCountry(country);
       
       
       	int status= Model.create(aaa);
		if(status>0){
			pw.print("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("index.jsp").include(request, response);
		}else{
			pw.println("Sorry! unable to save record");
		}
		
		pw.close();
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            doGet(request, response);
}
}



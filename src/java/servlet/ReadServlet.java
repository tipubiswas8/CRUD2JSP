/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Beans.UsersBeans;
import Model.Model;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tipu
 */
@WebServlet(name = "ReadServlet", urlPatterns = {"/ReadServlet"})
public class ReadServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       		out.println("<a href='index.jsp'>Add New Employee</a>");
		out.println("<h1>Employees List</h1>");
		
		List<UsersBeans> userlist= Model.read();
                
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Country</th><th>Edit</th><th>Delete</th></tr>");
		for(UsersBeans ub :userlist){
	        out.print("<tr><td>"+ub.getId()+"</td><td>"+ub.getName()+"</td><td>"+ub.getPassword()+"</td><td>"+ub.getEmail()+"</td>"
                        + "<td>"+ub.getCountry()+"</td><td><a href='UpdateServlet2?id="+ub.getId()+"'>edit</a></td>"
                                + "<td><a href='DeleteServlet?id="+ub.getId()+"'>delete</a></td></tr>");
		}
		out.print("</table>");
        }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}

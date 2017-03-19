/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLET_PACKAGE;

import Tools.EmployeeHelper;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author zinia
 */
public class EmployeeServlet extends HttpServlet {

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
        try  {
             String command = request.getParameter("command");
            if(command.equalsIgnoreCase("ADDING"))
                EmployeeHelper.addEmployee(request, response);
            else if(command.equalsIgnoreCase("SHOWDETAILS"))
                EmployeeHelper.displayEmployee(request, response);
            else if (command.equalsIgnoreCase("EMFINDID"))
                EmployeeHelper.FindEmployeeId(request, response);
            else if (command.equalsIgnoreCase("EMPL"))
                EmployeeHelper.GetEmp(request, response);
            
            
            else if (command.equalsIgnoreCase("UPDATE_EMPLOYEE"))
                EmployeeHelper.UpdateEmployee(request, response);
            else if (command.equalsIgnoreCase("UPDATE_SALARY"))
                EmployeeHelper.UpdateSalary(request, response);
            else if (command.equalsIgnoreCase("UPDATE_ADDRESS"))
                EmployeeHelper.UpdateAdress(request, response);
            else if (command.equalsIgnoreCase("UPDATE_CONTACT"))
                EmployeeHelper.UpdateContact(request, response);
            else if (command.equalsIgnoreCase("UPDATE_POSITION"))
                EmployeeHelper.UpdatePosition(request, response);
            
            else out.println("Invalid command");
            /* TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Employeeservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Employeeservlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
        }
        finally {
            out.close();
    }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

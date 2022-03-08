/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gerson
 */
@WebServlet(name = "MathServlet", urlPatterns = {"/mathservlet.html"})
public class MathServlet extends HttpServlet {
    public double Calculo(int op, int n1, int n2)
    {
        double result = 0;
        switch (op){
            case 1:
                    result = n1 + n2;
                    break;
            case 2:
                    result = n1 - n2;
                    break;
            case 3:
                    result = n1 * n2;
                    break;
            case 4:
                    result = n1 / n2;
                    break;
        }
        return result;
    }
    
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
        
        int num1 = 0;
        int num2 = 0;
        int op = 0;
        String error = null;
       
        try{
            String pn1 = request.getParameter("num1");
            String pn2 = request.getParameter("num2");
            op = Integer.parseInt(request.getParameter("op"));
            num1 = Integer.parseInt(pn1);
            num2 = Integer.parseInt(pn2);
            
        }catch(Exception ex){
            error = ex.getMessage();
        }      
        
        try ( PrintWriter out = response.getWriter()) {          
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MathServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h4><a href='index.html'>Voltar</a></h4>");
            out.println("<h3>Gerson Rangel Garcia</h3>");
            out.println("<hr/>");
            out.println("<form>");
            out.println("<input type='number' name='num1' value='"+num1+"'/>");
            out.println("<select name='op'>");
            out.println("<option value='1'>+</option>");
            out.println("<option value='2'>-</option>");
            out.println("<option value='3'>*</option>");
            out.println("<option value='4'>/</option>");
            out.println("</select>");            
            out.println("<input type='number' name='num2' value='"+num2+"'/>");
            out.println("<input type='submit' value='Calcular'/>");
            out.println("</form>");
            out.println("</hr>");
            out.println("<h2>Resultado:" + Calculo(op,num1,num2) +  "</h2>");
            out.println("</body>");
            out.println("</html>");
            
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

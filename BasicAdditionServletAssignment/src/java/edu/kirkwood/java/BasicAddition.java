/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kirkwood.java;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sean Geraets
 */
public class BasicAddition extends HttpServlet {

    
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
        
        //Declare Variables
        String numberError1 = "";
        String result = "";
        String numberError2 = "";
        //Get Incoming Parameters
        String userNumber1 = request.getParameter("userNumber1");
        String userNumber2 = request.getParameter("userNumber2");
        
        //Validate and process
        if(null != userNumber1 && null != userNumber2){
            if(userNumber1.isBlank()){
                numberError1 = "First number cannot be blank";
            }else{
                try{
                    double number1 = Double.parseDouble(userNumber1);
                }catch(NumberFormatException ex){
                    numberError1 = "First number is not a number";
                }
            }
            if(userNumber2.isBlank()){
                numberError2 = "Second number cannot be blank";
            }else{
                try{
                    double number2 = Double.parseDouble(userNumber2);
                }catch(NumberFormatException ex){
                    numberError2 = "Second number is not a number";
                    
                }
            }
            try{
                double number1 = Double.parseDouble(userNumber1);
                double number2 = Double.parseDouble(userNumber2);
                result = "RESULT: " + userNumber1 + " + " + userNumber2 + " = " 
                    + (number1 + number2);
            }catch(NumberFormatException ex){
                result = "There is no current sum";
            }
            
        }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE HTML>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Basic Servlet Assignment</title>");
            out.println("</head>");
            out.println("<h1>Basic Servlet Assignment</h1>");
            out.println("<p>Please enter two number and click the "
                    + "submit button");
            out.println("<form action='' method='GET'>");
            out.println("<label for='userNumber1'>First Number: </label>");
            out.println("<input type='text' name='userNumber1'/>");
            out.println("<span style='color:red;'>");
            out.println(numberError1);
            out.println("</span><br />");
            out.println("<label for='userNumber2'>Second Number: </label>");
            out.println("<input type='text' name='userNumber2'/>");
            out.println("<span style='color:red;'>");
            out.println(numberError2);
            out.println("</span><br />");
            out.println("<input type='submit' value='Submit' />");
            out.println("</form>");
            out.println(result);
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

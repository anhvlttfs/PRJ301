/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.sampledbconnect;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Artist;
import Service.ArtistDAO;
import java.io.PrintWriter;

/**
 *
 * @author sh
 */
@WebServlet(name = "artist", urlPatterns = {"/artist"})
public class ArtistController extends HttpServlet {
    private void GetList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArtistDAO dbdat = new ArtistDAO();
        ArrayList<Artist> artists = dbdat.GetArtist();
        request.setAttribute("listArtists", artists);
        request.getRequestDispatcher("/WEB-INF/ArtistActions/artistGetList.jsp").forward(request, response);
    }
    
    private void GetCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/ArtistActions/artistGetCreate.jsp").forward(request, response);
    }
    
    private void GetEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/ArtistActions/artistGetEdit.jsp").forward(request, response);
    }
    
    private void GetDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/ArtistActions/artistGetDelete.jsp").forward(request, response);
    }
    
    private void EditArtist(HttpServletResponse response, int id, String name) throws IOException {
        ArtistDAO dbdat = new ArtistDAO();
        response.setContentType("text/plain;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            if (name.matches("[A-Za-z ]+")) {
                int sqlRes = dbdat.EditArtist(id, name);
                out.println("SQL Server returns: " + sqlRes);
            } else {
                response.setStatus(500);
                out.println("SQL Injection is not allowed.");
            }
        }
    }
    
    private void AddArtist(HttpServletResponse response, int id, String name) throws IOException {
        ArtistDAO dbdat = new ArtistDAO();
        response.setContentType("text/plain;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            if (name.matches("[A-Za-z ]+")) {
                int sqlRes = dbdat.AddArtist(id, name);
                out.println("SQL Server returns: " + sqlRes);
            } else {
                response.setStatus(500);
                out.println("SQL Injection is not allowed.");
            }
        }
    }
    
    private void RemoveArtist(HttpServletResponse response, int id, String name) throws IOException {
        ArtistDAO dbdat = new ArtistDAO();
        response.setContentType("text/plain;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            if (name.matches("[A-Za-z ]+")) {
                int sqlRes = dbdat.RemoveArtist(id, name);
                out.println("SQL Server returns: " + sqlRes);
            } else {
                response.setStatus(500);
                out.println("SQL Injection is not allowed.");
            }
        }
    }
    
    private void tryResponse(HttpServletResponse response, String notification) throws IOException {
        response.setContentType("text/plain;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println(notification);
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

        switch (request.getParameter("view")) {
            case null:
                this.GetList(request, response);
                break;
            case "list":
                this.GetList(request, response);
                break;
            case "create":
                this.GetCreate(request, response);
                break;
            case "edit":
                this.GetEdit(request, response);
                break;
            case "delete":
                this.GetDelete(request, response);
                break;
            default:
                break;
        }
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
//        processRequest(request, response);
        
        switch (request.getParameter("action")) {
            case null:
                break;
            case "create":
                this.AddArtist(
                        response, 
                        Integer.parseInt((String) request.getParameter("inputId")), 
                        (String) request.getParameter("inputName").trim()
                );
                break;
            case "edit":
                this.EditArtist(
                        response, 
                        Integer.parseInt((String) request.getParameter("inputId")), 
                        (String) request.getParameter("inputNewName").trim()
                );
                break;
            case "delete":
                this.RemoveArtist(
                        response, 
                        Integer.parseInt((String) request.getParameter("inputId")), 
                        (String) request.getParameter("inputName").trim()
                );
                break;
            default:
                break;
        }
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

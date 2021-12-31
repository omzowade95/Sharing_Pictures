package com.example.sharing_pictures.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/photos")
public class PhotoListController extends HttpServlet {
    private static final String VUE_PHOTOS = "/WEB-INF/photos.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("activePhoto", true);
        request.getRequestDispatcher(VUE_PHOTOS).forward(request, response);
    }
}

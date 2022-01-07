package com.example.sharing_pictures.controller;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/About")
public class AboutServlet extends HttpServlet {
    private static final String VUE_PHOTOS = "/WEB-INF/website/inc/about.jsp";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("activeAbout", true);
        request.getRequestDispatcher(VUE_PHOTOS).forward(request, response);

    }
}

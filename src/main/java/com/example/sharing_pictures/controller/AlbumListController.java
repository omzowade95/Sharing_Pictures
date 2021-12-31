package com.example.sharing_pictures.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Albums")
public class AlbumListController extends HttpServlet {
    private static final String VUE_lIST_ALBUM = "/WEB-INF/albums.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("activeAlbum", true);
        request.getRequestDispatcher(VUE_lIST_ALBUM).forward(request, response);
    }
}

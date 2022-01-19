package com.example.sharing_pictures.controller.forms;

import com.example.sharing_pictures.form.Users.AddUserForm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/incription")
public class Inscription extends HttpServlet {
    private static final String VUE_INSCRIPTION = "/WEB-INF/website/auth/inscription.jsp";
    private static final String VUE_LOGIN = "/WEB-INF/website/auth/login.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(VUE_INSCRIPTION).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AddUserForm form = new AddUserForm(request);
        if (form.add())
            response.sendRedirect(request.getContextPath()+"/login");
        else{
            this.getServletContext().getRequestDispatcher(VUE_INSCRIPTION).forward(request,response);
            request.setAttribute("form",form);
        }
    }
}

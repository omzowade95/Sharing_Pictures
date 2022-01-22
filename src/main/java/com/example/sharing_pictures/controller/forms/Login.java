package com.example.sharing_pictures.controller.forms;

import com.example.sharing_pictures.form.Users.AuthenticationForm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {
    private static final String VUE_LOGIN = "/WEB-INF/website/auth/login.jsp";
    private static final String HOME_VUE = "/index.jsp";
    String erreur = null ;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(VUE_LOGIN).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AuthenticationForm authenticationForm = new AuthenticationForm(request);
        if (authenticationForm.userAuth()) {
            getServletContext().getRequestDispatcher(HOME_VUE).forward(request,response);
        }else{
             erreur = "Login ou mode passe incorrect ";
            request.getServletContext().setAttribute("erreur",erreur);
            this.getServletContext().getRequestDispatcher(VUE_LOGIN).forward(request,response);
        }
    }
}

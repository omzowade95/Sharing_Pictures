package com.example.sharing_pictures.controller.Users;

import com.example.sharing_pictures.form.Users.AddUserForm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addUser")
public class AddUser extends HttpServlet {
    private static final String VUE_LIST_USERS = "/WEB-INF/website/utilisateur/list.jsp";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AddUserForm form = new AddUserForm(request);
        if (form.add())
            response.sendRedirect(request.getContextPath() + "/listUser");
        else{
            System.out.println("Inscription Echec");
            request.setAttribute("form",form);
        }
    }
}

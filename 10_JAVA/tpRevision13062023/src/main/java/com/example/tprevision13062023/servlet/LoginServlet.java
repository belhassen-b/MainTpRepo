package com.example.tprevision13062023.servlet;


import com.example.tprevision13062023.service.LoginService;
import com.example.tprevision13062023.service.LoginServiceImpl;
import com.example.tprevision13062023.util.HibernateSession;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {

    private LoginService loginService;

    @Override
    public void init()  {
        loginService = new LoginServiceImpl(HibernateSession.getSessionFactory());
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("action") != null && req.getParameter("action").equals("username") && !req.getParameter("username").equals("") && !req.getParameter("password").equals("")) {
            if(loginService.login(req.getParameter("username"),req.getParameter("password"))) {
                req.getSession().setAttribute ("IsLogged", true);
                resp.sendRedirect("/index");
            }
            else {
                req.setAttribute("messageError", "Erreur de login");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }

        }
    }


}

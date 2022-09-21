package com.myfirstservelet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
  description = "login Servlet Testing",
  urlPatterns = {"/LoginServe"},
  initParams = {
   @WebInitParam(name = "user", value = "animesh"),
   @WebInitParam(name = "pass", value = "ani100@")
  }

)
public class LoginServe extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userI = request.getParameter("user");
        String pwdI = request.getParameter("pwd");
        String userID = getServletConfig().getInitParameter("user");
        String password = getServletConfig().getInitParameter("pass");
        if(userID.equals(userI) && password.equals(pwdI)){
            request.setAttribute("user", userI);
            request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
        }
        else {
            RequestDispatcher r = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out = response.getWriter();
            out.println("<font color = red> invalid credential</font>");
            r.include(request, response);
        }
    }
}

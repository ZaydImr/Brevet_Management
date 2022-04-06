package com.brevets.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getServletPath();
		
		switch (path) {
			case "/domaine":{
				request.setAttribute("title", "Domaine");
				request.setAttribute("page", "../views/domaine.jsp");
			} break;
			default:{
				request.setAttribute("title", "Home");
				request.setAttribute("page", "../views/home.jsp");
			} break;
		}
		
		request.getRequestDispatcher("views/template.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

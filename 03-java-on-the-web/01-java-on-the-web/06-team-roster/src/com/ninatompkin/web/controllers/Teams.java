package com.ninatompkin.web.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Teams
 */
@WebServlet("/Teams")
public class Teams extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Teams() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Remember that the name of the parameter variables have to match what's coming from the url!
		String id = request.getParameter("id");
		String page = "";
		//This statement is checking if we've passed an id in with our url. If we have, that means we're looking at one specific team. 
		//If we haven't, it means we're looking at the list of all teams.
		System.out.println("id is "+id);
		if (id != null) {
			page = "/WEB-INF/TeamInfo.jsp";
		}else {
			page = "/WEB-INF/NewTeam.jsp";
		}
		RequestDispatcher view = request.getRequestDispatcher(page);
        view.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("I made it here!!");
		
		HttpSession session = request.getSession();
		response.sendRedirect("/TeamRoster/TeamInfo");
	}

}

package com.ninatompkin.web.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ninatompkin.web.models.Roster;
import com.ninatompkin.web.models.Team;

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
		HttpSession session = request.getSession();
		//Remember that the name of the parameter variables have to match what's coming from the url!
		String id = request.getParameter("id");
		String page = "";
		//This statement is checking if we've passed an id in with our url. If we have, that means we're looking at one specific team. 
		//If we haven't, it means we're looking at the list of all teams.
		System.out.println("id is "+id);
		System.out.println("I'm over here in the Teams Controller!");
		if (id != null) {
			//In order to render this specific teams info in our view, we have to use our roster's "getOneTeam" method to return information about the team with id we passed in.
			Roster roster = (Roster)session.getAttribute("roster");
			
			Team thisTeam = roster.getOneTeam(id);
			//We'll add this team into request so that we can access it in our view...
			request.setAttribute("thisTeam", thisTeam);
			
			//And we'll also add this team into session so that we can access it in our Players Controller 
			session.setAttribute("team", thisTeam);
			
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

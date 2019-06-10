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
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Each time we render the page, we check session for the existence of a roster.
		HttpSession session = request.getSession();
		Roster roster = (Roster)session.getAttribute("roster");
		
		//If there isn't a roster in session....
		if (roster == null ) {
			System.out.println("No roster detected. Creating new instance of Roster...");
			roster = new Roster();
			//BTW - we need session because session will make this content persist across different controllers
			session.setAttribute("roster", roster);
		}
		//Otherwise, if there is a roster in session, we want to display its attributes in our view.
		//Why use "request.setAttribute" instead of "session.setAttribute"? 
		//Request makes this roster available to the view. Using request (instead of session) is best practice.
		request.setAttribute("roster", roster);
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/index.jsp");
        view.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//After we've posted new Team Info from our New Team page...
		HttpSession session = request.getSession();
		
		//Pull out the name of the team from the form info and use it to create a new instance of a Team.
		String teamName = request.getParameter("teamName");
		Team team = new Team(teamName);
		System.out.println("The name of my new team is "+team.getName());
		
		//Now that we have a new Team instance, add it to our Roster.
		Roster roster = (Roster)session.getAttribute("roster");
		roster.addTeam(team);
		
		//Once this processing is complete, show the complete list of teams. We should see our new team on the page!
		response.sendRedirect("/TeamRoster/Home");
	}

}

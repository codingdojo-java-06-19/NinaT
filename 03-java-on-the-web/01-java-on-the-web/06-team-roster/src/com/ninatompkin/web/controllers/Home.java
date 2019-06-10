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
		HttpSession session = request.getSession();
		Roster roster = (Roster)session.getAttribute("roster");
		if (roster == null ) {
			roster = new Roster();
			//Session will make this content persist across different controllers
			session.setAttribute("roster", roster);
		}
		//Request makes this roster available to the view. Using request (instead of session) is best practice.
		request.setAttribute("roster", roster);
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/index.jsp");
        view.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println("I made it here from New Team!");
		String teamName = request.getParameter("teamName");
		Team team = new Team(teamName);
		Roster roster = (Roster)session.getAttribute("roster");
		roster.addTeam(team);
		System.out.println("The name of my new team is "+team.getName());
		doGet(request, response);
	}

}

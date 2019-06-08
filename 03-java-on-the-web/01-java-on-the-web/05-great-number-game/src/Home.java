

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Random;

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
    
    public String randomGenerator() {
    	Random rand = new Random();
    	String randNum = String.valueOf(rand.nextInt(100));
    	return randNum;
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
//		System.out.println("Is there something called randNum yet?" + session.getAttribute("randNum"));

		//If there's nothing called "RandNum" in session yet, that means that the game hasn't started. Therefore, we'll generate a random number and add it into session.
		if (session.getAttribute("randNum").equals(0)) {
			session.setAttribute("randNum", randomGenerator());
			System.out.println("Welcome to the Great Number Game! The secret random number is "+ session.getAttribute("randNum"));
		}		
		
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/index.jsp");
        view.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println("Shh, don't forget! The Secret random number is "+session.getAttribute("randNum"));
		
		//Gets the value of parameter sent via the form called "guess"...convert it into an integer
		String guess = request.getParameter("guess");
		session.setAttribute("guess", guess);
		System.out.println("Our users' guess is "+session.getAttribute("guess"));
		
		response.sendRedirect("/GreatNumberGame/Home");
	}

}

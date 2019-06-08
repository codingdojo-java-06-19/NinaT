

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
    
    public String randomGenerator(String num1, String num2) {
    	Random rand = new Random();
    	int lowNum = Integer.parseInt(num1);
    	int highNum = Integer.parseInt(num2);
    	String randNum = String.valueOf(rand.nextInt((highNum - lowNum) +1) + lowNum);
    	return randNum;
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/index.jsp");
        view.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		//The following 4 lines take the input from the form in order to generate their preferred random number and store it in session.
		String lowNum = request.getParameter("lowNum");
		session.setAttribute("lowNum", lowNum);
		String highNum = request.getParameter("highNum");
		session.setAttribute("highNum", highNum);
		System.out.println("The user wants to generate a random number between "+lowNum+" and "+highNum);
				
		if (session.getAttribute("randNum") == null) {
			session.setAttribute("randNum", randomGenerator(lowNum, highNum));
			System.out.println("Welcome to the Great Number Game! The secret random number is "+ session.getAttribute("randNum"));
		}
		
		
		System.out.println("Shh, don't tell! Out secret random number is "+session.getAttribute("randNum"));
		
		//Gets the value of parameter sent via the form called "guess"...convert it into an integer
		String guess = request.getParameter("guess");
		session.setAttribute("guess", guess);
		System.out.println("Our users' guess is "+session.getAttribute("guess"));
		
		response.sendRedirect("/GreatNumberGame/Home");
	}

}

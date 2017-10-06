package dev.testlogin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId, pwd;
		LoginService ls = new LoginService();
		User user;
		RequestDispatcher dispatcher;
		
		userId = request.getParameter("usr");
		pwd = request.getParameter("pwd");
		
		if(ls.checkLogin(userId, pwd)){
			user = new User(userId);
			user.setPwd(pwd);
			
			request.setAttribute("user", user);
			
			dispatcher = request.getRequestDispatcher("MainPaige.jsp");
			dispatcher.forward(request, response);
			return;
		}else{
			dispatcher = request.getRequestDispatcher("LoginError.jsp");
			dispatcher.forward(request, response);
			return;
		}
	}

}

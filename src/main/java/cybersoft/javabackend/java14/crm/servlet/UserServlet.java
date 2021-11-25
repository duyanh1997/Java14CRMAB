package cybersoft.javabackend.java14.crm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet (urlPatterns = {"/user-list", "/create-user"})
public class UserServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		switch(action) {
			case "/user-list":
				req.getRequestDispatcher("/WEB-INF/views/user/user-list.jsp").forward(req, resp);
				break;
			case "/create-user":
				req.getRequestDispatcher("/WEB-INF/views/user/create-user.jsp").forward(req, resp);
				break;
			default:
			break;
		}
	}
}

package cybersoft.javabackend.java14.crm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.Region;
@WebServlet (urlPatterns = {"/manager-project","/create-project"})
public class ProjectServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		switch(action) {
			case "/manager-project":
				req.getRequestDispatcher("/WEB-INF/views/project/manager-project.jsp").forward(req, resp);
				break;
			case "/create-project":
				req.getRequestDispatcher("/WEB-INF/views/project/create-project.jsp").forward(req, resp);
				break;
			default:
			break;
		}
	}
}

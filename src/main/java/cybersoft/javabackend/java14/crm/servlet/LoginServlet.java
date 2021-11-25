package cybersoft.javabackend.java14.crm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.Region;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import cybersoft.javabackend.java14.crm.model.User;
import cybersoft.javabackend.java14.crm.repository.UserRepository;

@WebServlet (urlPatterns = {"/login", "/signup"})
public class LoginServlet extends HttpServlet{
	private UserRepository userRepository;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathString  = req.getServletPath();
		switch(pathString) {
		case "/login":
			Cookie [] arr = req.getCookies();
			if(arr!=null) {
				for(Cookie o : arr) {
					if(o.getName().equals("emailC")) {
						req.setAttribute("email1", o.getValue());
					}
					if(o.getName().equals("passC")) {
						req.setAttribute("pass1", o.getValue());
					}
				}
			}
			req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
			break;
		case "/signup":
			req.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(req, resp);
			break;
			default:
				break;
		}
		
	}
	@Override
	public void init() throws ServletException {
		 userRepository = new UserRepository();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path =req.getServletPath();
		switch(path) {
		case "/login":
			String emailString  = req.getParameter("email");
			String password = req.getParameter("password");
			String remember = req.getParameter("remember");
			Cookie em = new Cookie("emailC", emailString);
			Cookie pw = new Cookie("passC", password);
			em.setMaxAge(60);
			
			if(remember != null) {
				
				pw.setMaxAge(60);
				
			}else {
				
				pw.setMaxAge(0);
			}
			resp.addCookie(em);
			resp.addCookie(pw);
			int flag = 0;
			for(User user : userRepository.getUser()) {
				if(user.getEmail().equals(emailString) && user.getPassword().equals(password)) {
					flag = 1;
				}
			}
			if(flag == 1) {
				resp.sendRedirect(req.getContextPath() + "/home");
			}else {
				req.getSession().setAttribute("isTrue", true);
				req.setAttribute("mess", "Wrong email or pass");
				resp.sendRedirect(req.getContextPath() + "/login");
			}
			break;
		case "/signup":
			String email = req.getParameter("email_2");
			String pass = req.getParameter("password_2");
			String fullname = req.getParameter("name_2");
			User user = new User(email, pass,fullname);
			
			userRepository.addUser(user);
			System.out.println(12334);
			resp.sendRedirect(req.getContextPath() + "/login");
			break;
			default:
				break;
		}
	}
}

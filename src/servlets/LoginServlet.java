package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;

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
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		UserDao userDao=new UserDao();
		try {
			boolean isUser=userDao.isUser(username);
			if(isUser){
				boolean isLegalUser=userDao.isLegalUser(username, password);
				if(isLegalUser){
					HttpSession session=request.getSession();
					session.setAttribute("username", username);
					response.sendRedirect("../View/welcome.jsp");
				}
				else{
					HttpSession session=request.getSession();
					session.setAttribute("msg", "密码错误");
					response.sendRedirect("../View/Login.jsp");
				}
			}
			else{
				HttpSession session=request.getSession();
				session.setAttribute("msg", "该用户未注册");
				response.sendRedirect("../View/Login.jsp");
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}

package picuser;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "pages/sample/login.jsp";
		
		HttpSession session = request.getSession();
		System.out.println("로그인페이지 로그인유저 : " + session.getAttribute("loginUser"));
		
		if(session.getAttribute("loginUser") != null) {
			url = "pages/sample/index.jsp";
		}
	
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String url = "pages/sample/login.jsp";

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		PicUserDAO udao = PicUserDAO.getInstance();
		int result = udao.userCheck(id, pw);		
		
		if(result == 1) {
			PicUserVO uvo = udao.getPicUser(id);
			session.setAttribute("loginUser", uvo);			
			
			url = "pages/sample/index.jsp";		
			
		}else if(result == 0) {
			request.setAttribute("message", "비밀번호가 다릅니다.");
		}else if(result == -1) {
			request.setAttribute("message", "존재하지 않는 회원입니다.");
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}

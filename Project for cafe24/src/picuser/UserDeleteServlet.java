package picuser;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/userdelete.do")
public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		System.out.println("탈퇴페이지 로그인유저 : " + session.getAttribute("loginUser"));
		
		String id = request.getParameter("id");
		PicUserDAO udao = PicUserDAO.getInstance();
		
		PicUserVO uvo = udao.getPicUser(id);
		request.setAttribute("uvo", uvo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("pages/sample/userDelete.jsp");
		dispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "pages/sample/userDelete.jsp";
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		PicUserDAO udao = PicUserDAO.getInstance();
		String dbpw = udao.getPw(id);
		System.out.println("dbpw : " + dbpw);	
		System.out.println("입력받은 pw : " + pw);
		
		PicUserVO uvo = udao.getPicUser(id);
		request.setAttribute("uvo", uvo);
		
		if(dbpw.equals(pw)) {
			request.setAttribute("message", "탈퇴에 성공했습니다.");
			url = "pages/sample/login.jsp";
			udao.deleteUser(id);
			HttpSession session = request.getSession();
			session.invalidate();
		}else {
			request.setAttribute("message", "비밀번호가 다릅니다.");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	
	}

}

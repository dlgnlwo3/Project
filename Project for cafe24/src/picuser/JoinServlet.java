package picuser;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("pages/sample/join.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		int birth = Integer.parseInt(request.getParameter("birth"));
		
		PicUserVO uvo = new PicUserVO();
		uvo.setId(id);
		uvo.setPw(pw);
		uvo.setName(name);
		uvo.setTel(tel);
		uvo.setEmail(email);
		uvo.setBirth(birth);
		
		PicUserDAO udao = PicUserDAO.getInstance();
		int result = udao.insertUser(uvo);
		
		HttpSession session = request.getSession();
		
		if(result == 1) {
			session.setAttribute("id", uvo.getId());
			request.setAttribute("message", "회원가입에 성공했습니다.");
		}else {
			request.setAttribute("message", "회원가입에 실패했습니다.");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("pages/sample/login.jsp");
		dispatcher.forward(request, response);
		
	}

}

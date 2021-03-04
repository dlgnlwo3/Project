package picuser;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/userupdate.do")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		System.out.println("업데이트페이지 로그인유저 : " + session.getAttribute("loginUser"));
		
		String id = request.getParameter("id");
		PicUserDAO udao = PicUserDAO.getInstance();
		
		PicUserVO uvo = udao.getPicUser(id);
		request.setAttribute("uvo", uvo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("pages/sample/userUpdate.jsp");
		dispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
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
		udao.updateUser(uvo);
		
		session.invalidate();
		
		response.sendRedirect("login.do");
	}

}

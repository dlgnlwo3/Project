package sell;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pages.Action;
import pages.ActionFactory;


@WebServlet("/SellServlet")
public class SellServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SellServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String command = request.getParameter("command");
		System.out.println("SellServlet에서 요청 받음을 확인 : " + command);
		
		HttpSession session = request.getSession();
		System.out.println("판매 페이지 로그인유저 : " + session.getAttribute("loginUser"));
		
		ActionFactory af = ActionFactory.getInstance();
		Action action = af.getAction(command);
		
		if(action != null) {
			action.execute(request, response);
		}
	
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}

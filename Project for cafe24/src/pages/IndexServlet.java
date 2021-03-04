package pages;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sell.SellDAO;
import sell.SellVO;


@WebServlet("*.do")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "pages/sample/index.jsp";
		
		HttpSession session = request.getSession();
		System.out.println("인덱스 페이지 로그인유저 : " + session.getAttribute("loginUser"));
		
		SellDAO sdao = SellDAO.getInstance();
		int sellTotal = sdao.getSellTotal();
		
		System.out.println("글의 수 : " + sellTotal);
		request.setAttribute("sellTotal", sellTotal);
		
		List<SellVO> sell = sdao.selectAllSell();
		request.setAttribute("sell", sell);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

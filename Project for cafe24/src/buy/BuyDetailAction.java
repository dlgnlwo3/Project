package buy;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pages.Action;

public class BuyDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "pages/sample/buy-detail.jsp";
		
		String buy_no = request.getParameter("buy_no");
		
		BuyDAO bdao = BuyDAO.getInstance();
		
		//쿠키를 이용한 무한실행 방지
		HttpSession session = request.getSession();
		
	  	Cookie[] cookieFromRequest = request.getCookies();
	  	String cookieValue = null;
	  	for(int i=0; i<cookieFromRequest.length; i++){
	  		cookieValue = cookieFromRequest[0].getValue();
	  	}
	  	
	  	if(session.getAttribute(buy_no+":cookie") == null) {
	  		session.setAttribute(buy_no+":cookie", buy_no+":"+cookieValue);
	  	}else {
	  		session.setAttribute(buy_no+":cookie ex", session.getAttribute(buy_no+":cookie"));
	  		if(!session.getAttribute(buy_no+":cookie").equals(buy_no+":"+cookieValue)) {
	  			session.setAttribute(buy_no+":cookie", buy_no+":"+cookieValue);
	  		}
	  	}
		
	  	if(!session.getAttribute(buy_no+":cookie").equals(session.getAttribute(buy_no+":cookie ex"))) {
	  		bdao.updateBuyCount(buy_no);
	  	}
		//쿠키 끝
		
		BuyVO bvo = bdao.selectOneBuy(buy_no);
		List<Buy_replyVO> replyList = bdao.selectAllReply(buy_no);
		
		request.setAttribute("buy", bvo);
		request.setAttribute("replyList", replyList);
		
		
		int pageno;
		if(request.getParameter("pageno") != null) {
			pageno = Integer.parseInt(request.getParameter("pageno"));
		}else {
			pageno = 1;
		}

		request.setAttribute("pageno", pageno);
		System.out.println("디테일 페이지 : " + pageno);

		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}

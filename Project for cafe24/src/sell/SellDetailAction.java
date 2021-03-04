package sell;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pages.Action;

public class SellDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "pages/sample/sell-detail.jsp";
		
		String sell_no = request.getParameter("sell_no");

		SellDAO sdao = SellDAO.getInstance();
		
		
		//쿠키를 이용한 무한실행 방지
		HttpSession session = request.getSession();
		
	  	Cookie[] cookieFromRequest = request.getCookies();
	  	String cookieValue = null;
	  	for(int i=0; i<cookieFromRequest.length; i++){
	  		cookieValue = cookieFromRequest[0].getValue();
	  	}
	  	
	  	if(session.getAttribute(sell_no+":cookie") == null) {
	  		session.setAttribute(sell_no+":cookie", sell_no+":"+cookieValue);
	  	}else {
	  		session.setAttribute(sell_no+":cookie ex", session.getAttribute(sell_no+":cookie"));
	  		if(!session.getAttribute(sell_no+":cookie").equals(sell_no+":"+cookieValue)) {
	  			session.setAttribute(sell_no+":cookie", sell_no+":"+cookieValue);
	  		}
	  	}
		
	  	if(!session.getAttribute(sell_no+":cookie").equals(session.getAttribute(sell_no+":cookie ex"))) {
	  		sdao.updateSellCount(sell_no);
	  	}
		//쿠키 끝
			
		SellVO svo = sdao.selectOneSell(sell_no);
		List<Sell_replyVO> replyList = sdao.selectAllReply(sell_no);
		
		
		request.setAttribute("sell", svo);
		request.setAttribute("replyList", replyList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}

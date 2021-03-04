package buy;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pages.Action;


public class BuyReplyWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BuyDAO bdao = BuyDAO.getInstance();
		Buy_replyVO brvo = new Buy_replyVO();
		
		int buy_no = Integer.parseInt(request.getParameter("buy_no"));
		String id = request.getParameter("id");
		String br_content = request.getParameter("br_content");
		
		System.out.println("댓글 입력 : " + buy_no + ", " + id + ", " + br_content);

		brvo.setBuy_no(buy_no);
		brvo.setId(id);
		brvo.setBr_content(br_content);

		bdao.insertBuyReply(brvo);
		
		request.setAttribute("buy_no", buy_no);
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("pages/sample/Dummy.jsp");
		dispatcher.forward(request, response);
		
	}

}

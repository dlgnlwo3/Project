package sell;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pages.Action;

public class SellReplyWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		SellDAO sdao = SellDAO.getInstance();
		Sell_replyVO srvo = new Sell_replyVO();
		
		int sell_no = Integer.parseInt(request.getParameter("sell_no"));
		String id = request.getParameter("id");
		String sr_content = request.getParameter("sr_content");
		
		System.out.println("댓글 입력 : " + sell_no + ", " + id + ", " + sr_content);
		
		srvo.setSell_no(sell_no);
		srvo.setId(id);
		srvo.setSr_content(sr_content);
		
		sdao.insertSellReply(srvo);
		
		request.setAttribute("sell_no", sell_no);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("pages/sample/Dummy.jsp");
		dispatcher.forward(request, response);
	}

}

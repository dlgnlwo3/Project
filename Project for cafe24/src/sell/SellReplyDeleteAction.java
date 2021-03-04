package sell;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pages.Action;

public class SellReplyDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		SellDAO sdao = SellDAO.getInstance();
		
		int sr_no = Integer.parseInt(request.getParameter("sr_no"));
		int sell_no = Integer.parseInt(request.getParameter("sell_no"));
		
		System.out.println("댓글 삭제 : sr_no=" + sr_no + ", sell_no=" + sell_no);

		sdao.deleteSellReply(sr_no);
		
		request.setAttribute("sell_no", sell_no);
		
		new SellDetailAction().execute(request, response);
		
	}

}

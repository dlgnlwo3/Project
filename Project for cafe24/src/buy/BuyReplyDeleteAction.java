package buy;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pages.Action;

public class BuyReplyDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BuyDAO bdao = BuyDAO.getInstance();
		
		int br_no = Integer.parseInt(request.getParameter("br_no"));
		int buy_no = Integer.parseInt(request.getParameter("buy_no"));
		
		System.out.println("댓글 삭제 : br_no=" + br_no + ", buy_no=" + buy_no);
		
		bdao.deleteBuyReply(br_no);
		
		request.setAttribute("buy_no", buy_no);
		
		new BuyDetailAction().execute(request, response);
		
	}

}

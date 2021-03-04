package buy;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pages.Action;

public class BuyUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "pages/sample/buy-update.jsp";
		
		String buy_no = request.getParameter("buy_no");
		
		BuyDAO bdao = BuyDAO.getInstance();
		bdao.updateBuyCount(buy_no);
		
		BuyVO bvo = bdao.selectOneBuy(buy_no);
		
		request.setAttribute("buy", bvo);
	
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	
	
}

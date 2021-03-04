package sell;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pages.Action;

public class SellUpdateFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "pages/sample/sell-update.jsp";
		
		String sell_no = request.getParameter("sell_no");
		
		SellDAO sdao = SellDAO.getInstance();
		
		SellVO svo = sdao.selectOneSell(sell_no);
		
		request.setAttribute("sell", svo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	
	
}

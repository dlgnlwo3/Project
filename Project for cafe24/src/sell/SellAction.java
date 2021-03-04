package sell;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import buy.BuyDAO;
import buy.BuyVO;
import pages.Action;

public class SellAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "pages/sample/sell.jsp";
		
		SellDAO sdao = SellDAO.getInstance();
		int sellTotal = sdao.getSellTotal();
		
		System.out.println("글의 수 : " + sellTotal);
		request.setAttribute("sellTotal", sellTotal);
		
		List<SellVO> sell = sdao.selectAllSell();
		request.setAttribute("sell", sell);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}

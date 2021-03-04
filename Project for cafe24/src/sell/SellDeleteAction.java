package sell;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import buy.BuyAction;
import buy.BuyDAO;
import pages.Action;

public class SellDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String sell_no = request.getParameter("sell_no");
		
		SellDAO sdao = SellDAO.getInstance();
		sdao.deleteSell(sell_no);
		
		new SellAction().execute(request, response);
		
	}

}

package buy;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pages.Action;

public class BuyDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String buy_no = request.getParameter("buy_no");
		
		BuyDAO bdao = BuyDAO.getInstance();
		bdao.deleteBuy(buy_no);
		
		new BuyAction().execute(request, response);

	}

}

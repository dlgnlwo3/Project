package buy;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pages.Action;

public class BuySearchAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "pages/sample/buy-search.jsp";
		
		BuyDAO bdao = BuyDAO.getInstance();
			
		//검색어를 받습니다.
		String search_keyword = request.getParameter("search_keyword");		
		String search_text = request.getParameter("search_text");
		
		System.out.println("키워드 : " + search_keyword + ", 텍스트 : " + search_text);
		
		
		//현재페이지 pageno
		int pageno;
		if(request.getParameter("pageno") != null) {
			pageno = Integer.parseInt(request.getParameter("pageno"));
		}else {
			pageno = 1;
		}
		
		//전체 글의 수 buyTotal
		int buyTotal = bdao.getSearchTotal(search_keyword, search_text);
		
		//마지막페이지 totalpage
		int totalpage = buyTotal / 10;
		if(buyTotal % 10 > 0) {
			totalpage++;
		}
		if(totalpage < pageno) {
			pageno = totalpage;
		}		
		
		
		//startpage, endpage
		int startpage = ((pageno-1)/10) * 10 + 1;
		int endpage = startpage + 10 - 1;
		
		if(endpage > totalpage) {
			endpage = totalpage;
		}
		
		System.out.println("글의 수 : " + buyTotal);
		System.out.println("현재 페이지 : " + pageno);
		System.out.println("startpage : " + startpage + ", endpage : " + endpage);

		request.setAttribute("buyTotal", buyTotal);
		request.setAttribute("pageno", pageno);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		
		//검색어
		request.setAttribute("search_keyword", search_keyword);
		request.setAttribute("search_text", search_text);
				
		List<BuyVO> buy = bdao.selectSearchBuy(pageno, search_keyword, search_text);
		request.setAttribute("buy", buy);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}

package sell;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import buy.BuyAction;
import pages.Action;

public class SellUpdateAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		SellDAO sdao = SellDAO.getInstance();
		
		String realFolder = "";

		String saveFolder = "/sell_upload";
		
		String encType = "UTF-8";
		int maxSize = 1024*1024*20; //20mb
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		
		MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());

		SellVO svo = new SellVO();
		String sell_title = multi.getParameter("sell_title");
		String sell_no = multi.getParameter("sell_no");
		String sell_genre = multi.getParameter("sell_genre");
		String id = multi.getParameter("id");
		String sell_image1 = multi.getFilesystemName("sell_image1");
		String sell_image2 = multi.getFilesystemName("sell_image2");
		String sell_image3 = multi.getFilesystemName("sell_image3");
		String sell_content = multi.getParameter("sell_content");	
		
		svo.setSell_title(sell_title);
		svo.setSell_genre(sell_genre);
		svo.setSell_no(Integer.parseInt(sell_no));
		svo.setId(id);
		svo.setSell_content(sell_content);
		
		//image가 null일 경우
		SellVO dbvo = sdao.selectOneSell(sell_no);
		if(sell_image1 == null) {
			System.out.println("입력된 image1이 null이므로 db에서 불러옵니다.");
			svo.setSell_image1(dbvo.getSell_image1());
		}else {
			svo.setSell_image1(sell_image1);
		}
		
		if(sell_image2 == null) {
			System.out.println("입력된 image2가 null이므로 db에서 불러옵니다.");
			svo.setSell_image2(dbvo.getSell_image2());
		}else {
			svo.setSell_image2(sell_image2);
		}
		
		if(sell_image3 == null) {
			System.out.println("입력된 image3이 null이므로 db에서 불러옵니다.");
			svo.setSell_image3(dbvo.getSell_image3());
		}else {
			svo.setSell_image3(sell_image3);
		}

		System.out.println("업데이트 성공");
		
		sdao.updateSell(svo);
		
		new SellAction().execute(request, response);

	}

	
	
}

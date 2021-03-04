package sell;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import pages.Action;

public class SellWriteAction implements Action {

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
		String sell_genre = multi.getParameter("sell_genre");
		String id = multi.getParameter("id");
		String tel = multi.getParameter("tel");
		String email = multi.getParameter("email");
		String sell_content = multi.getParameter("sell_content");
		String sell_image1 = multi.getFilesystemName("sell_image1");
		String sell_image2 = multi.getFilesystemName("sell_image2");
		String sell_image3 = multi.getFilesystemName("sell_image3");

		System.out.println("title : " + sell_title + ", genre : " + sell_genre + ", id : " + id + ", tel : " + tel + ", email : " + email + ", content : " + sell_content + ", image1 : " + sell_image1+ ", image2 : " + sell_image2+ ", image3 : " + sell_image3);
		
		svo.setSell_title(sell_title);
		svo.setSell_genre(sell_genre);
		svo.setId(id);
		svo.setTel(tel);
		svo.setEmail(email);
		svo.setSell_content(sell_content);
		svo.setSell_image1(sell_image1);
		svo.setSell_image2(sell_image2);
		svo.setSell_image3(sell_image3);
		
		
		sdao.insertSell(svo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("pages/sample/Dummy3.jsp");
		dispatcher.forward(request, response);
	}

}

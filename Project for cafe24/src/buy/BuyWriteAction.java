package buy;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import pages.Action;

public class BuyWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BuyDAO bdao = BuyDAO.getInstance();
		
		//파일이 업로드 될 서버상의 물리적인 경로
		String realFolder = "";
		
		//파일이 업로드 될 논리적인 디렉토리 이름 정의
		String saveFolder = "/buy_upload";
		
		//MultipartRequest 속성 지정
		String encType = "UTF-8";
		int maxSize = 1024*1024*20; //20mb
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		
		//업로드에는 cos 라이브러리 필요
		MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
		
				
		BuyVO bvo = new BuyVO();
		String title = multi.getParameter("buy_title");
		String id = multi.getParameter("id");
		String time = multi.getParameter("buy_deadline");
		//서버상에 업로드 될 이미지파일
		String image = multi.getFilesystemName("buy_image");
		String content = multi.getParameter("buy_content");
		
		System.out.println("title : " + title + ", id : " + id + ", time : " + time + ", image : " + image + ", content : " + content);
		
		bvo.setBuy_title(title);
		bvo.setId(id);
		bvo.setBuy_deadline(time);
		bvo.setBuy_image(image);
		bvo.setBuy_content(content);

		bdao.insertBuy(bvo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("pages/sample/Dummy2.jsp");
		dispatcher.forward(request, response);
		//new BuyAction().execute(request, response);
		
	}

	
	
}

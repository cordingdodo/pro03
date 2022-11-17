package kr.go.gunsan.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.gunsan.dto.NoticeDTO;
import kr.go.gunsan.model.NoticeDAO;

@WebServlet("/GetNoticeCtrl.do")
public class GetNoticeCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int no 받고
		int no = Integer.parseInt(request.getParameter("no"));
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//dao 받아서 뿌려주기
		NoticeDAO dao = new NoticeDAO();
		NoticeDTO dto = dao.getNotice(no);
		
		//dao로 부터 받은 데이터를 view에 디스패치함
		request.setAttribute("dto", dto);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/notice/noticeDetail.jsp");
		view.forward(request, response);
	}

}

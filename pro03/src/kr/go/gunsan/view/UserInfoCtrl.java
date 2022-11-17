package kr.go.gunsan.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.go.gunsan.dto.UserDTO;
import kr.go.gunsan.model.UserDAO;

@WebServlet("/UserInfoCtrl.do")
public class UserInfoCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//UTF-8 초기화
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("sid");
		
		//dao에서 목록 불러오기 호출하여 반환받음
		UserDAO dao = new UserDAO();
		UserDTO dto = dao.userInfo(id);
		
		//dao로 부터 받은 데이터를 view에 디스패치함
		request.setAttribute("dto", dto);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/user/userUpdate.jsp");
		view.forward(request, response);
	}

}

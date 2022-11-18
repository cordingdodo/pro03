package kr.go.gunsan.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.gunsan.dto.TourDTO;
import kr.go.gunsan.model.TourDAO;



@WebServlet("/ModifyProTourCtrl.do")
public class ModifyProTourCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//UTF-8 초기화
				request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset=UTF-8");
				
				int no = Integer.parseInt(request.getParameter("no"));
				String cate = request.getParameter("cate");
				String tourno = request.getParameter("tourno");
				String place = request.getParameter("place");
				String comment1 = request.getParameter("comment1");
				String comment2 = request.getParameter("comment2");
				
				String address1 = request.getParameter("address1");
				String address2 = request.getParameter("address2");
				String addr = "";
				
				if(address1!=""){
						addr = address1 + address2;
				} else {
						addr = request.getParameter("addr");
				}
				
				//dao에서 목록 불러오기 호출하여 반환받음
				TourDTO dto = new TourDTO();
				dto.setNo(no);
				dto.setTourno(tourno);
				dto.setPlace(place);
				dto.setComment1(comment1);
				dto.setComment2(comment2);
				dto.setAddr(addr);
				
				TourDAO dao = new TourDAO(); 
				int cnt= dao.modifyTour(dto);
				
				if(cnt>=1){
					response.sendRedirect("GetTourListCtrl.do");
				} else {
					response.sendRedirect("ModifyTourCtrl?no="+no);
				}
	}
	
}


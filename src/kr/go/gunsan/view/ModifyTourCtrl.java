package kr.go.gunsan.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.gunsan.dto.PicDTO;
import kr.go.gunsan.dto.TourDTO;
import kr.go.gunsan.model.TourDAO;

@WebServlet("/ModifyTourCtrl.do")
public class ModifyTourCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		//UTF-8 초기화
				request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset=UTF-8");
				
				//dao에서 목록 불러오기 호출하여 반환받음
				TourDAO dao = new TourDAO();
				TourDTO dto = dao.DetailTour(no);
				
				ArrayList<PicDTO> picList = new ArrayList<PicDTO>();
				
				//dao로 부터 받은 데이터를 view에 디스패치함
				request.setAttribute("dto", dto);
				request.setAttribute("picList", picList);
				
				RequestDispatcher view = request.getRequestDispatcher("/tour/tourUpdate.jsp");
				view.forward(request, response);
			}
		}
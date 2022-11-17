package kr.go.gunsan.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.gunsan.model.NoticeDAO;

@WebServlet("/DelNoticeCtrl.do")
public class DelNoticeCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		//UTF-8 초기화
				request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset=UTF-8");
				
				//dao에서 목록 불러오기 호출하여 반환받음
				NoticeDAO dao = new NoticeDAO();
				
				
				int cnt = dao.delNotice(no);

				if(cnt>=1){
					response.sendRedirect("GetNoticeListCtrl.do");
				} else {
					response.sendRedirect("GetNoticeCtrl.do?no="+no);
				}
			}
		}
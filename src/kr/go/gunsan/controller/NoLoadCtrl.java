package kr.go.gunsan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.gunsan.dto.PicDTO;
import kr.go.gunsan.model.TourDAO;
import net.sf.json.JSONObject;

@WebServlet("/NoLoadCtrl.do")
public class NoLoadCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
				//UTF-8 초기화
				request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset=UTF-8");
				
				TourDAO dao = new TourDAO();
				int firstNo = dao.loadLastNo();
				String no = "";
				if(firstNo<=9){
						no = "000"+firstNo;
				} else if(firstNo<=99){
						no = "00"+firstNo;
				} else {
						no = ""+firstNo;
				}
				JSONObject json = new JSONObject();	
				json.put("no", no);
				PrintWriter out = response.getWriter();
				out.println(json.toString());
				
				}
		}
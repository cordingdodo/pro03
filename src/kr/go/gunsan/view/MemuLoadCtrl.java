package kr.go.gunsan.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.go.gunsan.dto.TourDTO;
import kr.go.gunsan.model.TourDAO;
import net.sf.json.*;

@WebServlet("/MemuLoadCtrl.do")
public class MemuLoadCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//UTF-8 초기화
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
/*		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("sid");*/
		
		//dao에서 목록 불러오기 호출하여 반환받음
		TourDAO dao = new TourDAO();
		
		ArrayList<TourDTO> data = dao.JSONPlaceList();
		/*for(int i=0;i<data.size();i++){
			TourDTO dto = data.get(i);
			System.out.println(dto.toString());
		}*/
		//dao로 부터 받은 데이터를 view에 디스패치함
		PrintWriter out = response.getWriter();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("data", data);
		
		//System.out.println(map);
		JSONObject json = new JSONObject();
		json.putAll(map);
		out.println(json.toString());
	}

}

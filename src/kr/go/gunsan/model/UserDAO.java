package kr.go.gunsan.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.go.gunsan.dto.UserDTO;

import com.crypto.util.AES256;

public class UserDAO { //얘에 계속 추가하는 것임!
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	String sql = "";
	String key = "%02x";

	public ArrayList<UserDTO> getUserList() {
		ArrayList<UserDTO> userList = new ArrayList<UserDTO>();
		try {
			con = Maria.getConnection();
			pstmt = con.prepareStatement(Maria.USER__select_all);
			rs = pstmt.executeQuery();
			while(rs.next()){
				UserDTO dto = new UserDTO();
				dto.setId(rs.getString("id"));
				dto.setPw(AES256.decryptAES256(rs.getString("pw"), key));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setTel(rs.getString("tel"));
				dto.setRank(rs.getString("rank"));
				dto.setAddr(rs.getString("addr"));
				dto.setBirth(rs.getString("birth"));
				dto.setPoint(rs.getInt("point"));
				dto.setVisited(rs.getInt("visited"));
				dto.setRegdate(rs.getString("regdate"));
				System.out.println(dto.getId());
				userList.add(dto);
			}
		} catch(ClassNotFoundException e){
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		} catch(SQLException e){
			System.out.println("SQL 오류");
			e.printStackTrace();
		} catch(Exception e){
			System.out.println("잘못된 연산 및 요청 오류");
		} finally {
			Maria.close(rs, pstmt, con);
		}
		return userList;
	}

	public int idCheckPro(String id) { //중복 아이디 체크 / 회원가입시 가입전 체크		
		int cnt = 0;
		try {
			con = Maria.getConnection();
			pstmt = con.prepareStatement(Maria.USER_ID_CHECK);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {cnt = cnt +1; } else { cnt = 0;}
		} catch(ClassNotFoundException e){
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		} catch(SQLException e){
			System.out.println("SQL 오류");
			e.printStackTrace();
		} catch(Exception e){
			System.out.println("잘못된 연산 및 요청 오류");
		} finally {
			Maria.close(rs, pstmt, con);
		}

		return cnt;
	}
	
	public int addUser(UserDTO user) {
		int cnt=0;
		try { 
			//(id, pw, name, birth, tel, email, addr
			con = Maria.getConnection();
			pstmt = con.prepareStatement(Maria.USER_JOIN);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPw());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getBirth());
			pstmt.setString(5, user.getTel());	
			pstmt.setString(6, user.getEmail());					
			pstmt.setString(7, user.getAddr());
			cnt = pstmt.executeUpdate();
			
		} catch(ClassNotFoundException e){
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		} catch(SQLException e){
			System.out.println("SQL 오류");
			e.printStackTrace();
		} catch(Exception e){
			System.out.println("잘못된 연산 및 요청 오류");
		} finally {
			Maria.close(pstmt, con);
		}
		return cnt;
	}


	public int userLogin(String id, String pw){
		int cnt = 0;
		String qpw = "";
		
		try {
			con = Maria.getConnection();
			//읽은 횟수 증가
			pstmt = con.prepareStatement(Maria.VISIT_UPDATE);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
			
			pstmt = con.prepareStatement(Maria.USER_ID_CHECK);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				qpw = AES256.decryptAES256(rs.getString("pw"), key);
				System.out.println("비밀번호 복호화 : "+qpw);
				if(pw.equals(qpw)){
					cnt = 1;
				} else {
					cnt = 0;
				} 
			} else {
				cnt = 9;
			}
		} catch(ClassNotFoundException e){
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		} catch(SQLException e){
			System.out.println("SQL 구문이 처리되지 못했습니다.");
			e.printStackTrace();
		} catch(Exception e){
			System.out.println("잘못된 연산 및 요청으로 인해 목록을 불러오지 못했습니다.");
		} finally {
			Maria.close(pstmt, con);
		}
		return cnt;
	}

	public UserDTO userInfo(String id) {
		UserDTO dto = new UserDTO();
		try {
			con=Maria.getConnection();
			pstmt = con.prepareStatement(Maria.USER_ID_CHECK);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				dto.setId(rs.getString("id"));
				dto.setPw(AES256.decryptAES256(rs.getString("pw"), key));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setTel(rs.getString("tel"));
				dto.setRank(rs.getString("rank"));
				dto.setAddr(rs.getString("addr"));
				dto.setPoint(rs.getInt("point"));
				dto.setVisited(rs.getInt("visited"));
				dto.setBirth(rs.getString("birth"));
				dto.setRegdate(rs.getString("regdate"));
				
			}
		} catch(ClassNotFoundException e){
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		} catch(SQLException e){
			System.out.println("SQL 구문이 처리되지 못했습니다.");
			e.printStackTrace();
		} catch(Exception e){
			System.out.println("잘못된 연산 및 요청으로 인해 목록을 불러오지 못했습니다.");
		} finally {
			Maria.close(pstmt, con);
		}
		return dto;
	
}


	//회원정보 변경
	public int updateUser(UserDTO user) {
		int cnt = 0;
		try {
			con = Maria.getConnection();
			//읽은 횟수 증가
			pstmt = con.prepareStatement(Maria.UPDATE_USER);
			//pw=?,name=?, addr=?, tel=?, email=? birth=? where id=?
			pstmt.setString(1, user.getPw());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getBirth());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getTel());
			pstmt.setString(6, user.getAddr());
			pstmt.setString(7, user.getId());
			cnt = pstmt.executeUpdate();
		} catch(ClassNotFoundException e){
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		} catch(SQLException e){
			System.out.println("SQL 구문이 처리되지 못했습니다.");
			e.printStackTrace();
		} catch(Exception e){
			System.out.println("잘못된 연산 및 요청으로 인해 목록을 불러오지 못했습니다.");
		} finally {
			Maria.close(pstmt, con);
		}
		return cnt;
	}
	
}

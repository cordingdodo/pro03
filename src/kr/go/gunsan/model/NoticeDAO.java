package kr.go.gunsan.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.go.gunsan.dto.NoticeDTO;

public class NoticeDAO { //얘에 계속 추가하는 것임!
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	String sql = "";
	
	public ArrayList<NoticeDTO> getNoticeList() {
		ArrayList<NoticeDTO> notiList = new ArrayList<NoticeDTO>();
		try {
			con = Maria.getConnection();
			pstmt = con.prepareStatement(Maria.Notice_SELECT_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()){
				NoticeDTO dto = new NoticeDTO();
				dto.setNo(rs.getInt("no"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setVisited(rs.getInt("visited"));
				notiList.add(dto);
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
		return notiList;
	}


	public NoticeDTO getNotice(int no){
		NoticeDTO dto = new NoticeDTO();
		try { 
			con = Maria.getConnection();
			//읽은 횟수 증가
			pstmt = con.prepareStatement(Maria.NOTICE_VISITED_UPDATE);
			pstmt.setInt(1, no);
			pstmt.executeQuery();
			pstmt.close();
			//해당 레코드 검색하기
			pstmt = con.prepareStatement(Maria.Notice_SELECT_ONE);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()){
				dto.setNo(rs.getInt("no"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setVisited(rs.getInt("visited"));
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
		return dto;
	}


	public int addNotice(NoticeDTO dto) {
		int cnt=0;
		try { 
			con = Maria.getConnection();
			//읽은 횟수 증가
			pstmt = con.prepareStatement(Maria.Notice_insert);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
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
	
	public int modifyNotice(NoticeDTO dto) {
		int cnt=0;
		try { 
			con = Maria.getConnection();
			pstmt = con.prepareStatement(Maria.Notice_update);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setInt(3, dto.getNo());
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

	public int delNotice(int no) {
		int cnt=0;
		try { 
			con = Maria.getConnection();
			pstmt = con.prepareStatement(Maria.Notice_DEL);
			pstmt.setInt(1, no);
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

	
}
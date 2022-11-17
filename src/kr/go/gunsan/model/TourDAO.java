package kr.go.gunsan.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.go.gunsan.dto.PicDTO;
import kr.go.gunsan.dto.TourDTO;

public class TourDAO { //얘에 계속 추가하는 것임!
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	String sql = "";
	
	public TourDTO DetailTour(int no){
		TourDTO tour = new TourDTO();
		try {
			con = Maria.getConnection();
			pstmt = con.prepareStatement(Maria.TourList_detail);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();			
			while(rs.next()){
				tour.setNo(rs.getInt("no"));
				tour.setTourno(rs.getString("tourno"));
				tour.setCate(rs.getString("cate"));
				tour.setPlace(rs.getString("place"));
				tour.setComment1(rs.getString("comment1"));
				tour.setComment2(rs.getString("comment2"));
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
		return tour;
	}
	
	public ArrayList<TourDTO> getTourList() {
		ArrayList<TourDTO> tourList = new ArrayList<TourDTO>();
		try {
			con = Maria.getConnection();
			pstmt = con.prepareStatement(Maria.TourList_All);
			rs = pstmt.executeQuery();
			while(rs.next()){
				TourDTO dto = new TourDTO();
				dto.setNo(rs.getInt("no"));
				dto.setTourno(rs.getString("tourno"));
				dto.setCate(rs.getString("cate"));
				dto.setPlace(rs.getString("place"));
				dto.setComment1(rs.getString("comment1"));
				dto.setComment2(rs.getString("comment2"));
				dto.setImgURL(rs.getString("imgurl"));
				tourList.add(dto);
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
		return tourList;
	}

	public ArrayList<PicDTO> JSONPicList(String tourno) {
		ArrayList<PicDTO> picList = new ArrayList<PicDTO>();
		try {
			con = Maria.getConnection();
			pstmt = con.prepareStatement(Maria.JsonPicList);
			pstmt.setString(1, tourno);
			rs = pstmt.executeQuery();
			while(rs.next()){
				PicDTO pic = new PicDTO();
				pic.setNo(rs.getInt("no"));
				pic.setTourno(rs.getString("tourno"));
				pic.setPicname(rs.getString("picname"));
				pic.setPos(rs.getInt("pos"));
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
		return picList;
	}

	public int addTour(TourDTO dto) {
		int cnt=0;

		try {
			//tourno, cate, place, comment1, comment2
			con = Maria.getConnection();
			pstmt = con.prepareStatement(Maria.insertTour);
			pstmt.setString(1, dto.getTourno());
			pstmt.setString(2, dto.getCate());
			pstmt.setString(3, dto.getPlace());
			pstmt.setString(4, dto.getComment1());
			pstmt.setString(5, dto.getComment2());
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
			Maria.close(rs, pstmt, con);
		}
		return cnt;
	}
}
package kr.go.gunsan.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Maria {
    static final String DRIVER = "org.mariadb.jdbc.Driver";
    static final String URL = "jdbc:mariadb://127.0.0.1:3308/goverment?serverTimezone=Asia/Seoul";
    static final String USER = "root";
    static final String PW = "1234";
	
    public final static String Notice_SELECT_ONE = "select * from notice where no=?";
	public final static String Notice_SELECT_ALL = "select * from notice order by no";
	public final static String Notice_DEL = "delete from notice where no=?";
	public final static String Notice_update = "update notice set title=?, content=? where no=?";
	public final static String Notice_insert = "insert into notice(title, content) values(?, ?)";
	public final static String NOTICE_VISITED_UPDATE = "update notice set visited=visited+1 where no=?";
	
	public final static String USER__select_all = "select * from user order by regdate";
	public final static String USER_JOIN = "insert into user(id, pw, name, birth, tel, email, addr) values(?,?,?,?,?,?,?)";
	public final static String USER_DELETE = "delete from user where id=?";
	public final static String USER_ID_CHECK = "select * from user where id = ?";
	public final static String UPDATE_USER = "update user set pw=?, name=?, birth=?, email=?, tel=?, addr=? where id=?";
	public final static String VISIT_UPDATE = "update user set visited=1+visited where id=?";
	
	public final static String user_login = "select * from user where id=? and pw=?";
	public final static String user_id_check = "select * from user where id=?";
	public final static String test_DataOne = "select * from test where name=?";
	public final static String test_Dataall = "select * from test";
	
	public final static String TourList_All = "select * from tour";
	public final static String TourList_detail = "select * from tour where no=?";
	public static final String JsonPicList = "select * from pic where tourno=?";
	public static final String insertTour = "insert into tour(tourno, cate, place, comment1, comment2) value(?, ?, ?, ?, ?)";
	public static final String File_Upload = "insert into pic(tourno, picname, pos) values (?,?,?)";
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		Connection con = DriverManager.getConnection(URL, USER, PW);
		return con;
	}
	
	
	public static void close(PreparedStatement pstmt, Connection con) {
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		if(con!=null){
			try {
				con.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection con) {
		if(rs!=null){
			try {
				rs.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		if(con!=null){
			try {
				con.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
}

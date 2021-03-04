package picuser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import util.DBManager;

public class PicUserDAO {

	public PicUserDAO() { }
	
	private static PicUserDAO instance = new PicUserDAO();
	
	public static PicUserDAO getInstance() {
		return instance;
	}
	

	//사용자 인증시 사용
	public int userCheck(String id, String pw) {
		
		int result = -1;
		String sql = "select pw from picuser where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				if(rs.getString("pw") != null && rs.getString("pw").equals(pw)) {
					result = 1;
				}else {
					result = 0;
				}
				
			}else {
				result = -1;
			}		
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return result;
	}
	
	
	//아이디로 회원 정보를 가져옴
	public PicUserVO getPicUser(String id) {
		
		PicUserVO uvo = null;
		String sql = "select * from picuser where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				uvo = new PicUserVO();
				uvo.setId(rs.getString("id"));
				uvo.setPw(rs.getString("pw"));
				uvo.setName(rs.getString("name"));
				uvo.setTel(rs.getString("tel"));
				uvo.setEmail(rs.getString("email"));
				uvo.setBirth(rs.getInt("birth"));
			}		
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		
		return uvo;
	}
	
	
	
	//아이디 중복체크
	public int confirmID(String id) {
		
		int result = -1;
		String sql = "select id from picuser where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = 1;
			}else {
				result = -1;
			}		
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}		
		
		return result;
	}
	
	
	
	//회원가입
	public int insertUser(PicUserVO uvo) {
		
		int result = -1;
		String sql = "insert into picuser values(?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uvo.getId());
			pstmt.setString(2, uvo.getPw());
			pstmt.setString(3, uvo.getName());
			pstmt.setString(4, uvo.getTel());
			pstmt.setString(5, uvo.getEmail());
			pstmt.setInt(6, uvo.getBirth());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}		
		
		return result;
	}
	

	
	//회원정보수정
	public int updateUser(PicUserVO uvo) {
		
		int result = -1;
		String sql = "update picuser set pw=?, name=?, tel=?, email=?, birth=? where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uvo.getPw());
			pstmt.setString(2, uvo.getName());
			pstmt.setString(3, uvo.getTel());
			pstmt.setString(4, uvo.getEmail());
			pstmt.setInt(5, uvo.getBirth());
			pstmt.setString(6, uvo.getId());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
		return result;
	}
	
	
	//비밀번호만 불러오는 메소드
	public String getPw(String id) {
		
		String dbpw = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select pw from picuser where id=?";
		
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dbpw = rs.getString("pw");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
			
		return dbpw;
	}
	
	
	//회원탈퇴
	public void deleteUser(String id) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "delete from picuser where id=?";
		
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
	
	
	
	
	
}

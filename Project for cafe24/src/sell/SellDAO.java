package sell;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBManager;

public class SellDAO {

	public SellDAO() {

	}

	private static SellDAO instance = new SellDAO();
	
	public static SellDAO getInstance() {
		return instance;
	}
	
	
	public List<SellVO> selectAllSell() {
		
		String sql = "select * from sell order by sell_no desc";
		
		List<SellVO> list = new ArrayList<SellVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				SellVO svo = new SellVO();
				
				svo.setSell_no(rs.getInt("sell_no"));
				svo.setSell_title(rs.getString("sell_title"));
				svo.setSell_genre(rs.getString("sell_genre"));
				svo.setId(rs.getString("id"));
				svo.setSell_count(rs.getInt("sell_count"));
				svo.setTel(rs.getString("tel"));
				svo.setEmail(rs.getString("email"));
				svo.setSell_content(rs.getString("sell_content"));
				svo.setSell_image1(rs.getString("sell_image1"));
				svo.setSell_image2(rs.getString("sell_image2"));
				svo.setSell_image3(rs.getString("sell_image3"));
				
				list.add(svo);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return list;
	}
	
	
	public int getSellTotal() {
		
		String sql = "select count(*) as selltotal from sell";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int sellTotal = 0;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				sellTotal = rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return sellTotal;
	}
	
	
	
	public void insertSell(SellVO svo) {
		
		String sql = "insert into sell (sell_title, sell_genre, id, tel, email, sell_content, sell_image1, sell_image2, sell_image3) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, svo.getSell_title());
			pstmt.setString(2, svo.getSell_genre());
			pstmt.setString(3, svo.getId());
			pstmt.setString(4, svo.getTel());
			pstmt.setString(5, svo.getEmail());
			pstmt.setString(6, svo.getSell_content());
			pstmt.setString(7, svo.getSell_image1());
			pstmt.setString(8, svo.getSell_image2());
			pstmt.setString(9, svo.getSell_image3());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
		
	}
	
	
	
	public SellVO selectOneSell(String sell_no) {
		
		String sql = "select * from sell where sell_no=?";
		
		SellVO svo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sell_no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				svo = new SellVO();
				
				svo.setSell_no(rs.getInt("sell_no"));
				svo.setSell_title(rs.getString("sell_title"));
				svo.setSell_genre(rs.getString("sell_genre"));
				svo.setId(rs.getString("id"));
				svo.setSell_count(rs.getInt("sell_count"));
				svo.setTel(rs.getString("tel"));
				svo.setEmail(rs.getString("email"));
				svo.setSell_content(rs.getString("sell_content"));
				svo.setSell_image1(rs.getString("sell_image1"));
				svo.setSell_image2(rs.getString("sell_image2"));
				svo.setSell_image3(rs.getString("sell_image3"));				
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}	
		
		return svo;
	}
	
	
	
	
	public void updateSellCount(String sell_no) {
		
		String sql = "update sell set sell_count=sell_count+1 where sell_no=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sell_no);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
	}	
	
	
	
	public void updateSell(SellVO svo) {
		
		String sql = "update sell set sell_title=?, sell_genre=?, sell_content=?, sell_image1=?, sell_image2=?, sell_image3=? where sell_no=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, svo.getSell_title());
			pstmt.setString(2, svo.getSell_genre());
			pstmt.setString(3, svo.getSell_content());
			pstmt.setString(4, svo.getSell_image1());
			pstmt.setString(5, svo.getSell_image2());
			pstmt.setString(6, svo.getSell_image3());
			pstmt.setInt(7, svo.getSell_no());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
		
	}
	
	
	
	
	public void deleteSell(String sell_no) {
		
		String sql = "delete from sell where sell_no=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sell_no);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
	
	
	
	//댓글임
	public List<Sell_replyVO> selectAllReply(String sell_no){
		
		String sql = "select * from sell_reply where sell_no=? order by sr_no desc";
		List<Sell_replyVO> replyList = new ArrayList<Sell_replyVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sell_no);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Sell_replyVO srvo = new Sell_replyVO();
				srvo.setSell_no(rs.getInt("sell_no"));
				srvo.setSr_no(rs.getInt("sr_no"));
				srvo.setId(rs.getString("id"));
				srvo.setSr_date(rs.getTimestamp("sr_date"));
				srvo.setSr_content(rs.getString("sr_content"));
				replyList.add(srvo);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}		
		
		return replyList;
	}
	
	
	
	public void insertSellReply(Sell_replyVO srvo) {
		
		String sql = "insert into sell_reply (sell_no, id, sr_date, sr_content) values (?, ?, now(), ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, srvo.getSell_no());
			pstmt.setString(2, srvo.getId());
			pstmt.setString(3, srvo.getSr_content());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
	
	
	public void deleteSellReply(int sr_no) {
		
		String sql = "delete from sell_reply where sr_no=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sr_no);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
			
	}
	
	
	
	
	
	
	
	
	
}

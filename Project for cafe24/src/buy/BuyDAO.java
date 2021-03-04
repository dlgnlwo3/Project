package buy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBManager;

public class BuyDAO {

	public BuyDAO() {
		
	}
	
	private static BuyDAO instance = new BuyDAO();
	
	public static BuyDAO getInstance() {
		return instance;
	}
	
		
	public List<BuyVO> selectAllBuy(int pageno){
		
		String sql = "SELECT * FROM buy ORDER BY buy_no DESC LIMIT ?, 10";
		
		List<BuyVO> list = new ArrayList<BuyVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (pageno - 1) * 10);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BuyVO bvo = new BuyVO();
				
				bvo.setBuy_no(rs.getInt("buy_no"));
				bvo.setBuy_title(rs.getString("buy_title"));
				bvo.setId(rs.getString("id"));
				bvo.setBuy_count(rs.getInt("buy_count"));
				bvo.setBuy_date(rs.getTimestamp("buy_date"));
				bvo.setBuy_deadline(rs.getString("buy_deadline"));
				bvo.setBuy_image(rs.getString("buy_image"));
				bvo.setBuy_content(rs.getString("buy_content"));
				
				list.add(bvo);
			}		
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	
	
	public List<BuyVO> selectSearchBuy(int pageno, String search_keyword, String search_text){
		
		String sql = "SELECT * FROM buy WHERE "+search_keyword+" LIKE '%"+search_text+"%' ORDER BY buy_no DESC LIMIT ?, 10";
			
		List<BuyVO> list = new ArrayList<BuyVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (pageno - 1) * 10);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BuyVO bvo = new BuyVO();
				
				bvo.setBuy_no(rs.getInt("buy_no"));
				bvo.setBuy_title(rs.getString("buy_title"));
				bvo.setId(rs.getString("id"));
				bvo.setBuy_count(rs.getInt("buy_count"));
				bvo.setBuy_date(rs.getTimestamp("buy_date"));
				bvo.setBuy_deadline(rs.getString("buy_deadline"));
				bvo.setBuy_image(rs.getString("buy_image"));
				bvo.setBuy_content(rs.getString("buy_content"));
				
				list.add(bvo);
			}		
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	
	
	
	
	
	
	public void insertBuy(BuyVO bvo) {
		
		String sql = "insert into buy (buy_title, id, buy_count, buy_deadline, buy_image, buy_content) values (?, ?, default, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bvo.getBuy_title());
			pstmt.setString(2, bvo.getId());
			pstmt.setString(3, bvo.getBuy_deadline());
			pstmt.setString(4, bvo.getBuy_image());
			pstmt.setString(5, bvo.getBuy_content());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
	
	
	public void updateBuyCount(String buy_no) {
		
		String sql = "update buy set buy_count=buy_count+1 where buy_no=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, buy_no);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
	
	
	public BuyVO selectOneBuy(String buy_no) {
		
		String sql = "select * from buy where buy_no=?";
		
		BuyVO bvo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, buy_no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				bvo = new BuyVO();
				
				bvo.setBuy_no(rs.getInt("buy_no"));
				bvo.setBuy_title(rs.getString("buy_title"));
				bvo.setId(rs.getString("id"));
				bvo.setBuy_count(rs.getInt("buy_count"));
				bvo.setBuy_date(rs.getTimestamp("buy_date"));
				bvo.setBuy_deadline(rs.getString("buy_deadline"));
				bvo.setBuy_image(rs.getString("buy_image"));
				bvo.setBuy_content(rs.getString("buy_content"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return bvo;
	}
	
	
	
	public void updateBuy(BuyVO bvo) {
		
		String sql = "update buy set buy_title=?, buy_date=now(), buy_deadline=?, buy_image=?, buy_content=? where buy_no=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bvo.getBuy_title());
			pstmt.setString(2, bvo.getBuy_deadline());
			pstmt.setString(3, bvo.getBuy_image());
			pstmt.setString(4, bvo.getBuy_content());
			pstmt.setInt(5, bvo.getBuy_no());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	
	
	public void deleteBuy(String buy_no) {
		
		String sql = "delete from buy where buy_no=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, buy_no);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}

	}
	
	
	
	//여기서부터 댓글
	public List<Buy_replyVO> selectAllReply(String buy_no) {
		
		String sql = "select * from buy_reply where buy_no=? order by br_no desc";
		List<Buy_replyVO> replyList = new ArrayList<Buy_replyVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, buy_no);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Buy_replyVO brvo = new Buy_replyVO();
				brvo.setBuy_no(rs.getInt("buy_no"));
				brvo.setBr_no(rs.getInt("br_no"));
				brvo.setId(rs.getString("id"));
				brvo.setBr_date(rs.getTimestamp("br_date"));
				brvo.setBr_content(rs.getString("br_content"));
				replyList.add(brvo);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return replyList;
	}
	
	
	
	
	public void insertBuyReply(Buy_replyVO brvo) {
		
		String sql = "insert into buy_reply (buy_no, id, br_date, br_content) values (?, ?, now(), ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, brvo.getBuy_no());
			pstmt.setString(2, brvo.getId());
			pstmt.setString(3, brvo.getBr_content());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
	
	
	public void deleteBuyReply(int br_no) {
		
		String sql = "delete from buy_reply where br_no=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, br_no);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
	
	
	
	
	//페이징 처리를 위한 count
	public int getBuyTotal() {
		
		String sql = "select count(*) as buytotal from buy";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int buyTotal = 0;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				buyTotal = rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return buyTotal;
	}
	
	
	
	public int getSearchTotal(String search_keyword, String search_text) {
		
		String sql = "select count(*) as buytotal from buy where "+search_keyword+" like '%"+search_text+"%'";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int buyTotal = 0;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				buyTotal = rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return buyTotal;
	}
	
	
	
	
}

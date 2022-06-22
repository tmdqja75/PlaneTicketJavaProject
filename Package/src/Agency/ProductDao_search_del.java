package travel_agency;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.MysqlConnect;

public class ProductDao {
	
	private MysqlConnect dbconn;


	public ProductDao() {
		dbconn = MysqlConnect.getInstance();
	}
	
	//국가명으로 검색
	public ArrayList<Product> SearchByNation(String nation) {
		ResultSet rs = null;
		ArrayList<Product> list = new ArrayList<Product>();
		
		Connection conn = dbconn.getConn();
		
		//국가명 테이블 필요
		String sql = "select * from product where nation = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, nation);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int num = rs.getInt(1);
				String air_id = rs.getString(2);
				String agency = rs.getString(3);
				String dest = rs.getString(4);
				int period = rs.getInt(5); //날짜? 
				String details = rs.getString(6);
				boolean hotel = rs.getBoolean(7);
				boolean need_pspt = rs.getBoolean(8);
				int price = rs.getInt(9);
				
				list.add(new Product(num, air_id, agency, dest, period, details, hotel, need_pspt, price));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	//항공사로 검색
	public ArrayList<Product> SearchByAgency(String air_corp) {
		ResultSet rs = null;
		ArrayList<Product> list = new ArrayList<Product>();
		
		Connection conn = dbconn.getConn();
		
		//국가명 테이블 필요
		String sql = "select * from product where agency = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, air_corp);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int num = rs.getInt(1);
				String air_id = rs.getString(2);
				String agency = rs.getString(3);
				String dest = rs.getString(4);
				int period = rs.getInt(5); //날짜? 
				String details = rs.getString(6);
				boolean hotel = rs.getBoolean(7);
				boolean need_pspt = rs.getBoolean(8);
				int price = rs.getInt(9);
				
				list.add(new Product(num, air_id, agency, dest, period, details, hotel, need_pspt, price));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	//전체 검색 기능
	public ArrayList<Product> SearchAll() {
		ResultSet rs = null;
		ArrayList<Product> list = new ArrayList<Product>();
		
		Connection conn = dbconn.getConn();
		
		String sql = "select * from product";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int num = rs.getInt(1);
				String air_id = rs.getString(2);
				String agency = rs.getString(3);
				String dest = rs.getString(4); 
				int period = rs.getInt(5); //날짜? 기간?
				String details = rs.getString(6);
				boolean hotel = rs.getBoolean(7);
				boolean need_pspt = rs.getBoolean(8);
				int price = rs.getInt(9);
				
				list.add(new Product(num, air_id, agency, dest, period, details, hotel, need_pspt, price));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try{
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
		//해당 상품 번호 삭제
		public boolean delProduct(int pnum) {
			Connection conn = dbconn.getConn();
			
			String sql = "delete from product where product_number = ?";
			
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, pnum);
				
				int cnt = pstmt.executeUpdate();
				if (cnt > 0) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return false;
		}
}

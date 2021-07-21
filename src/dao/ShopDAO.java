package dao;

import java.sql.*;
import static db.JdbcUtil.*;
import java.util.ArrayList;

import vo.Shop;

public class ShopDAO {
	
	Connection con;
	private static ShopDAO shopDAO;
	
	private ShopDAO() {}
	
	public void setConnection(Connection con) {
		this.con=con;
	}
	public static ShopDAO getInstance() {
		if(shopDAO == null) {
			shopDAO = new ShopDAO();
		}
		return shopDAO;
	}
	//물건리스트 가져오기 
	public ArrayList<Shop> selectShopList() {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Shop> shopList = null;
		
		try {
			pstmt = con.prepareStatement("select * from shop");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				shopList = new ArrayList<Shop>();
				
				do {
					shopList.add(new Shop(
							rs.getInt("id"),
							rs.getString("kind"),
							rs.getInt("price"),
							rs.getString("image"),
							rs.getString("size"),
							rs.getString("content"),
							rs.getInt("readcount")
							));
				}while(rs.next());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
			
		}
		return shopList;
	}
	//선택된 물품 가져오기 
	public Shop selectShopList(int id) {
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		Shop goods = null;
	
		try {
			pstmt=con.prepareStatement("select * from shop where id=?");
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				goods = new Shop(
								rs.getInt("id"),
								rs.getString("kind"),
								rs.getInt("price"),
								rs.getString("image"),
								rs.getString("size"),
								rs.getString("content"),
								rs.getInt("readcount"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
			
		}
		return goods;
	}
	//조회수 카운트 
	public int updateReadCount(int id) {
		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql_count="update shop set readcount = readcount +1 where id=?";
		
		try {
			
			pstmt=con.prepareStatement(sql_count);
			pstmt = con.prepareStatement(sql_count);
			pstmt.setInt(1, id);
			updateCount = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return updateCount;
	}
	
	
}

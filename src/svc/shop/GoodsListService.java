package svc.shop;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ShopDAO;
import vo.Shop;
import static db.JdbcUtil.*;
public class GoodsListService {

	public ArrayList<Shop> getShopList() {
		
			Connection con=null;
			ArrayList<Shop> shopList=null;
			
			try {
				con = getConnection();
				ShopDAO shopDAO = ShopDAO.getInstance();
				shopDAO.setConnection(con);
				shopList = shopDAO.selectShopList();
			}catch(Exception e ) {
				e.printStackTrace();
			}finally {
				close(con);
			}
		return shopList;
	}

}

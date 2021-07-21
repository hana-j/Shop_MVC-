package svc.shop;

import java.sql.Connection;
import static db.JdbcUtil.*;
import dao.ShopDAO;
import vo.Shop;

public class GoodsViewService {

	public Shop getGoods(int id) {
		
		Connection  con = null;
		ShopDAO shopDAO = null;
		Shop shop = null;
		try {
			con = getConnection();
			shopDAO=ShopDAO.getInstance();
			shopDAO.setConnection(con);
			
			int updateCount = shopDAO.updateReadCount(id);
			
			if(updateCount > 0 ) {
				
				shop = shopDAO.selectShopList(id);
				commit(con);

			}else {
				rollback(con);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			close(con);
		}
		return shop;
	}
}

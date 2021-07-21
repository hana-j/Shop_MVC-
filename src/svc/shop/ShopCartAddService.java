package svc.shop;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static db.JdbcUtil.*;
import dao.ShopDAO;
import vo.Cart;
import vo.Shop;

public class ShopCartAddService {

	public Shop getCartShop(int id) {
		Connection con = null;
		ShopDAO shopDAO = null;
		Shop shop=null;
		try {
			con = getConnection();
			shopDAO = ShopDAO.getInstance();
			shopDAO.setConnection(con);
			shop = shopDAO.selectShopList(id);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return shop;
	}

	public void addCart(HttpServletRequest request, Shop cartShop) {
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		
		if(cartList == null) {
			cartList = new ArrayList<Cart>();
			session.setAttribute("cartList", cartList);
		}
		boolean isNewCart = true;
		//지금 장바구니에 담는 항복이 새로 추가되는 항목인지를 저장할 변수 
		for(int i = 0; i<cartList.size();i++) {
			if(cartShop.getKind().equals(cartList.get(i).getKind())) {
				isNewCart = false;
				cartList.get(i).setQty(cartList.get(i).getQty()+1);
				break;
			}
		}
		if(isNewCart) {
			Cart cart = new Cart();
			cart.setImage(cartShop.getImage());
			cart.setKind(cartShop.getKind());
			cart.setPrice(cartShop.getPrice());
			cart.setQty(1);
			cartList.add(cart);
		}
	}

}

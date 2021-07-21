package svc.shop;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.Cart;

public class ShopCartListService {

	public ArrayList<Cart> getCartList(HttpServletRequest request) {
		//세션을 이용해서 장바구니 기능 구현 차후에 db사용 법을 다시 구현 해볼것 
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		return cartList;
	}

}

package action.shop;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.shop.ShopCartListService;
import vo.ActionForward;
import vo.Cart;

public class ShopCartListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ShopCartListService shopCartSvc = new ShopCartListService();
		ArrayList<Cart> cartList = shopCartSvc.getCartList(request);
		
		int totalMoney = 0;
		int money = 0;
		ActionForward forward = new ActionForward();
		
		if(cartList!=null) {
			for(int i =0;i<cartList.size();i++) {
				money = cartList.get(i).getPrice()*cartList.get(i).getQty();
				totalMoney += money;
			}
			
			request.setAttribute("totalMoney", totalMoney);
			request.setAttribute("cartList", cartList);
			request.setAttribute("pagefile", "/shop/shopCartList.jsp");
			forward.setRedirect(false);
			forward.setPath("template.jsp");
			
		}
		return forward;
	}

}

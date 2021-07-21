package action.shop;

import java.io.PrintWriter;
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
			request.setAttribute("pagefile", "shop/shopCartList.jsp");
		}else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out= response.getWriter();
			out.println("<script>");
			out.println("alert('장바구니가 비었습니다.');");
			out.println("location.href='goodsList.shop';");
			out.println("</script>");
		}
		return forward;
	}

}

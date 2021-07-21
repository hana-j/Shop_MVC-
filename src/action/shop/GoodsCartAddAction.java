package action.shop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.shop.ShopCartAddService;
import vo.ActionForward;
import vo.Shop;

public class GoodsCartAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ShopCartAddService shopCartAddSvc = new ShopCartAddService();
		int id = Integer.parseInt(request.getParameter("id"));
		
		Shop cartShop = shopCartAddSvc.getCartShop(id);
		shopCartAddSvc.addCart(request, cartShop);
		request.setAttribute("pagefile", "goodsCartAdd.shop");
		ActionForward forward = new ActionForward("template.jsp", false);
		return forward;
	}

}

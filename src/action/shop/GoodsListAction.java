package action.shop;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.shop.GoodsListService;
import vo.ActionForward;
import vo.Shop;

public class GoodsListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		GoodsListService goodsListSvc = new GoodsListService();
		ArrayList<Shop> shopList = goodsListSvc.getShopList();
		request.setAttribute("shopList", shopList);
		request.setAttribute("pagefile", "shop/shopList.jsp");
		ActionForward forward = new ActionForward("template.jsp", false);
		return forward;
	}

}

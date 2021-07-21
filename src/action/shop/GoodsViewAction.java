package action.shop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.shop.GoodsViewService;
import vo.ActionForward;
import vo.Shop;

public class GoodsViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		GoodsViewService goodsViewSvc = new GoodsViewService();
		int id = Integer.parseInt(request.getParameter("id"));
		Shop goods = goodsViewSvc.getGoods(id);
		
		System.out.println(id);
		
		request.setAttribute("goods",goods );
		
		request.setAttribute("pagefile", "shop/goodsView.jsp");
		forward.setPath("template.jsp");
		return forward;
	}

}

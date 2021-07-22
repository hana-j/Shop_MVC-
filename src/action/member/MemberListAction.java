package action.member;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.member.MemberListService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		ActionForward forward = null;
		//인터셉트 
		if(id ==null) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./memberLogin.mem");
			
		}else if(!id.equals("admin")) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('관리자사용 페이지 입니다.);");
			out.println("location.href='./shopList.shop");
			out.println("</script>");
		}
		else {
			
			forward = new ActionForward();
			MemberListService memberListSvc = new MemberListService();
			ArrayList<MemberBean> memberList= memberListSvc.getMemberList();
			request.setAttribute("memberList", memberList);
			request.setAttribute("pagefile", "member/member_list.jsp");
			forward.setRedirect(false);
			forward.setPath("template.jsp");
			System.out.println(memberList);
		}
		return forward;
	}

}

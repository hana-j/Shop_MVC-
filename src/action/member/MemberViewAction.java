package action.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.member.MemberViewService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id= (String)session.getAttribute("id");
		
		ActionForward forward = null;
		if(id==null) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./memberLogin.mem");
		}else if(!id.equals("admin")) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('관리자 권한 페이지 입니다.');");
			out.println("history.back();");
			out.println("</script>");
		}else {
			forward = new ActionForward();
			String ListID = request.getParameter("id");
			MemberViewService memberViewSvc = new MemberViewService();
			MemberBean member = memberViewSvc.getMember(ListID);
			request.setAttribute("member", member);
			request.setAttribute("pagefile", "member/member_view.jsp");
			forward.setRedirect(false);
			forward.setPath("template.jsp");
		}
		return forward;
	}

}

package action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import action.Action;
import svc.member.MemberModFormService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberModifyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		String id = (String)request.getParameter("id");
		
		MemberModFormService memberModSvc = new MemberModFormService();
		MemberBean member = memberModSvc.getMember(id);
		
		request.setAttribute("member", member);
		request.setAttribute("pagefile", "member/member_mod.jsp");
		forward.setPath("template.jsp");
		return forward;
	}

}

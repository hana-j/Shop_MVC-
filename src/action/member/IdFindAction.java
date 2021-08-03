package action.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.member.IdFindService;
import vo.ActionForward;
import vo.MemberBean;

public class IdFindAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		MemberBean member = new MemberBean();
		String email = request.getParameter("email");
		
		IdFindService memberFindService = new IdFindService();
		member= memberFindService.findID(email);
		String getEmail = member.getEmail();
		
		
		if(email.equals(getEmail)) {
			String id = member.getId();
			forward = new ActionForward();
			request.setAttribute("id", id);
			request.setAttribute("pagefile", "member/IdFindOk.jsp");
			forward.setPath("template.jsp");
		}else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('아이디가 존재하지 않습니다.');");
			out.println("history.back();");
			out.println("<script>");
		}
		
		return forward;
	}

}

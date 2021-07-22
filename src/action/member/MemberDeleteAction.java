package action.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.member.MemberDeleteService;
import vo.ActionForward;

public class MemberDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		HttpSession session = request.getSession();
		String id =(String)session.getAttribute("id");
		
		if(id == null) {
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
			String delId = request.getParameter("id");
			MemberDeleteService memberDeleteSvc = new MemberDeleteService();
			boolean deleteResult = memberDeleteSvc.deleteMember(delId);
			
			if(deleteResult) {
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("./memberListAction.mem");
			}else {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('회원정보 삭제 실패');");
				out.println("history.back();");
				out.println("</script>");
			}
		}
		return forward;
	}

}

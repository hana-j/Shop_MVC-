package action.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.member.MemberJoinService;
import vo.ActionForward;
import vo.MemberBean;
import vo.SHA256;

public class MemberJoinAction extends ActionForward implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberBean member = new MemberBean();
		boolean joinResult = false;
		//해싱한 비민번호 받아
		String password = request.getParameter("pass");
		String hash_password = SHA256.endcodSha256(password);
		
		member.setId(request.getParameter("id"));
		member.setPassword(hash_password);
		member.setName(request.getParameter("name"));
		member.setAge(Integer.parseInt(request.getParameter("age")));
		member.setGender(request.getParameter("gender"));
		member.setEmail(request.getParameter("email"));
		MemberJoinService memberJoinSvc = new MemberJoinService();
		joinResult = memberJoinSvc.joinMember(member);
		
		ActionForward forward = null;
		if(joinResult ==false) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원가입실패');");
			out.println("history.back()");
			out.println("</script>");
		}else {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./memberLogin.mem");
		}
		return forward;
	}

}

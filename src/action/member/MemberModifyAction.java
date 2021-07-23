package action.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.member.MemberModifyService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		boolean isModSuccess = false;
		//ModForm에서받아온 파람값 member객체에 저장 
		MemberBean member= new MemberBean();
		member.setId(request.getParameter("id"));
		member.setPassword(request.getParameter("password"));
		member.setName(request.getParameter("name"));
		member.setAge(Integer.parseInt(request.getParameter("age")));
		member.setGender(request.getParameter("gender"));
		member.setEmail(request.getParameter("email"));
		//변경에 성공했는지 실패했는지 받아오는 로직생성 
		MemberModifyService memberModSvc = new MemberModifyService();
		isModSuccess = memberModSvc.modInfo(member);
		
		if(isModSuccess == false) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('정보수정에 실패했습니다. 다시시도해주세요');");
			out.println("history.back();");
			out.println("</script>");
		}else {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("memberViewAction.mem?id="+member.getId());
		}
		return forward;
	}

}

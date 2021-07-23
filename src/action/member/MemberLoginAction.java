package action.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.member.MemberLoginService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberLoginAction extends ActionForward implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		//session에 저장된 값 받아오기 
		HttpSession session = request.getSession();
		MemberBean member = new MemberBean();
		//받아온 파람값을 생성한 멤버 객체에 저장 
		member.setId(request.getParameter("id"));
		member.setPassword(request.getParameter("pass"));
		
		MemberLoginService memberLoginSvc = new MemberLoginService();
		boolean loginResult = memberLoginSvc.login(member);
		if(!loginResult) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('아이디나 비밀번호가 일치하지 않습니다.');");
			out.println("location.href='./memberLogin.mem';");
			out.println("</script>");
		}else {
			forward = new ActionForward();
			session.setAttribute("id", member.getId());
			//관리자로그인시 멤버리스트 확인 가능 
			if(member.getId().equals("admin")) {
				forward.setRedirect(true);
				forward.setPath("./memberListAction.mem");
				
			}else {
				forward.setRedirect(true);
				forward.setPath("./goodsList.shop");
			}
		}
		
		return forward;
	}

}

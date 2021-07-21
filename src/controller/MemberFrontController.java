package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import action.Action;

import action.member.MemberJoinAction;

import action.member.MemberLoginAction;


import vo.ActionForward;

/**
 * Servlet implementation class MemberFrontController
 */
@WebServlet("*.mem")
public class MemberFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command= RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;
		System.out.println(command);
		
        //요청처리 부분 
		if(command.equals("/memberLogin.mem")) {
			forward = new ActionForward();
			request.setAttribute("pagefile", "member/loginForm.jsp");
			forward.setPath("template.jsp");
		}
		else if(command.equals("/memberJoin.mem")) {
			forward = new ActionForward();
			request.setAttribute("pagefile", "member/joinForm.jsp");
			forward.setPath("template.jsp");
		}
		else if(command.equals("/memberLoginAction.mem")) {
			action = new MemberLoginAction();
			try {
				forward= action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/memberJoinAction.mem")) {
			action = new MemberJoinAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
//		else if(command.equals("/memberListAction.me")) {
//			action = new MemberListAction();
//			try {
//				forward=action.execute(request, response);
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
//		else if(command.equals("/memberViewAction.me")) {
//			action = new MemberViewAction();
//			try {
//				forward= action.execute(request, response);
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
//		else if(command.equals("/memberDeleteAction.me")) {
//			action = new MemberDeleteAction();
//			try {
//				forward = action.execute(request, response);
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
//		else if(command.equals("/memberLogout.me")) {
//			HttpSession session = request.getSession();
//			session.removeAttribute("id");
//			response.setContentType("text/html;charset=utf-8");
//			forward = new ActionForward();
//			forward.setPath("dogList.dog");
//		}
//		else if(command.equals("/memberModifyFormAction.me")) {
//			action = new MemberModifyFormAction();
//			try {
//				forward = action.execute(request, response);
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}else if(command.equals("/memberModifyAction.me")) {
//			action = new MemberModifyAction();
//			try {
//				forward = action.execute(request, response);
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
		//3.포워딩 
		if(forward!=null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dispathcer = request.getRequestDispatcher(forward.getPath());
				dispathcer.forward(request, response);
			}
		}
	}

}

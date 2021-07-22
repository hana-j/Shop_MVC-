package svc.member;

import java.sql.Connection;
import java.util.ArrayList;
import static db.JdbcUtil.*;
import dao.MemberDAO;
import vo.MemberBean;

public class MemberListService {

	public ArrayList<MemberBean> getMemberList() {
		Connection con = null;
		MemberDAO memberDAO = null;
		ArrayList<MemberBean> memberList = null;
		
		try {
			con = getConnection();
			memberDAO = MemberDAO.getInstance();
			memberDAO.setConnection(con);
			memberList = memberDAO.selectMemberList();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		
		return memberList;
	}

}

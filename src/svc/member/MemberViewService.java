package svc.member;

import java.sql.Connection;
import static db.JdbcUtil.*;
import dao.MemberDAO;
import vo.MemberBean;

public class MemberViewService {

	public MemberBean getMember(String listID) {
		Connection con = null;
		MemberDAO memberDAO = null;
		MemberBean member = null;
		try {
			con = getConnection();
			memberDAO = MemberDAO.getInstance();
			memberDAO.setConnection(con);
			member= memberDAO.selectID(listID);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return member;
	}

}

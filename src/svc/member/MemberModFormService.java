package svc.member;

import java.sql.Connection;
import static db.JdbcUtil.*;
import dao.MemberDAO;
import vo.MemberBean;

public class MemberModFormService {

	public MemberBean getMember(String id) {
		Connection con = null;
		MemberDAO memberDAO = null;
		MemberBean member = null;
		try {
			con = getConnection();
			memberDAO = MemberDAO.getInstance();
			memberDAO.setConnection(con);
			member = memberDAO.selectID(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return member;
	}

}

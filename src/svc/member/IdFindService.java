package svc.member;

import java.sql.Connection;
import static db.JdbcUtil.*;
import dao.MemberDAO;
import vo.MemberBean;

public class IdFindService {

	public MemberBean findID(String email) {
		Connection con = null;
		MemberDAO memberDAO = null;
		MemberBean member = null;
		
		try {
			con = getConnection();
			memberDAO = MemberDAO.getInstance();
			memberDAO.setConnection(con);
			member= memberDAO.findID(email);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return member;
	}

}

package svc.member;

import java.sql.Connection;
import static db.JdbcUtil.*;
import dao.MemberDAO;
import vo.MemberBean;

public class MemberLoginService {

	public boolean login(MemberBean member) {
		
		Connection con = null;
		MemberDAO memberDAO = null;
		boolean loginResult = false;
		
		try {
			con =getConnection();
			memberDAO = MemberDAO.getInstance();
			memberDAO.setConnection(con);
			
			String loginId = memberDAO.selectID(member);
			
			if(loginId !=null) {
				loginResult = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return loginResult;
	}

}

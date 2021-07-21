package svc.member;

import java.sql.Connection;
import static db.JdbcUtil.*;
import dao.MemberDAO;
import vo.MemberBean;

public class MemberJoinService {

	public boolean joinMember(MemberBean member) {
		boolean joinSuccess = false;
		Connection con = null;
		MemberDAO memberDAO = null;
		
		try {
			con = getConnection();
			memberDAO = MemberDAO.getInstance();
			memberDAO.setConnection(con);
			int insertCount = memberDAO.joinMember(member);
			
			if(insertCount > 0 ) {
				joinSuccess = true;
				commit(con);
			}else {
				rollback(con);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return joinSuccess;
	}

}

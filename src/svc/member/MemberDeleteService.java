package svc.member;

import java.sql.Connection;
import static db.JdbcUtil.*;
import dao.MemberDAO;

public class MemberDeleteService {

	public boolean deleteMember(String delId) {
		Connection con = null;
		MemberDAO memberDAO = null;
		boolean deleteResult = false;
		
		try {
			con = getConnection();
			memberDAO = MemberDAO.getInstance();
			memberDAO.setConnection(con);
			int delCount = memberDAO.deleteMember(delId);
			
			if(delCount > 0) {
				deleteResult =true;
				commit(con);
			}else {
				rollback(con);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return deleteResult;
	}

}

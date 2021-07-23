package svc.member;

import java.sql.Connection;
import static db.JdbcUtil.*;
import dao.MemberDAO;
import vo.MemberBean;

public class MemberModifyService {

	public boolean modInfo(MemberBean member) {
		Connection con = null;
		MemberDAO memberDAO = null;
		boolean isModSuccess = false;
		
		try {
			con = getConnection();
			memberDAO = MemberDAO.getInstance();
			memberDAO.setConnection(con);
			int modCount = memberDAO.modSuccess(member);
			
			if(modCount > 0) {
				commit(con);
				isModSuccess= true;
			}else {
				rollback(con);
			}
		}finally {
			close(con);
		}
		return isModSuccess;
	}

}

package dao;

import java.sql.*;
import static db.JdbcUtil.*;

import javax.sql.DataSource;

import vo.MemberBean;

public class MemberDAO {

	public static MemberDAO instance;
	DataSource ds;
	ResultSet rs;
	Connection con;
	PreparedStatement pstmt;
	//싱글톤객체 생성 
	private MemberDAO() {}
	
	public static MemberDAO getInstance() {
		if(instance == null) {
			instance = new MemberDAO();
		}
		return instance;
	}
	public void setConnection(Connection con) {
		this.con = con;
	}
	//로그인시 아이디 확인 
	public String selectID(MemberBean member) {
		String loginID = null;
		
		try {
			pstmt = con.prepareStatement("select id from member where id=? and password=?");
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				loginID = rs.getString("id");
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("loginID 확인에러 : "+e);
		}finally {
			close(rs);
			close(pstmt);
		}
		return loginID;
	}
	//회원가입 
	public int joinMember(MemberBean member) {
		String sql_j = "insert into member values (?,?,?,?,?,?)";
		int insertCount = 0;

		try {
			pstmt = con.prepareStatement(sql_j);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setInt(4, member.getAge());
			pstmt.setString(5, member.getGender());
			pstmt.setString(6, member.getEmail());
			insertCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return insertCount;
	}
}

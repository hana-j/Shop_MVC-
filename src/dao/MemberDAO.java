package dao;

import java.sql.*;
import java.util.ArrayList;

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
	//회원리스트 검색 
	public ArrayList<MemberBean> selectMemberList() {
		ArrayList<MemberBean> memberList = new ArrayList<>();
		MemberBean list = null;
		try {
			pstmt = con.prepareStatement("select * from member");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				do {
						list = new MemberBean();
						list.setId(rs.getString("id"));
						list.setPassword(rs.getString("password"));
						list.setName(rs.getString("name"));
						list.setAge(rs.getInt("age"));
						list.setGender(rs.getString("gender"));
						list.setEmail(rs.getString("email"));
						memberList.add(list);//제발!!! 읽어오면 저장하자 공백넘어가잖아 
				}while(rs.next());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		System.out.println(memberList);
		return memberList;
	}
	//회원정보 보기 
	public MemberBean selectID(String listID) {
		MemberBean info = null;
		
		try {
			pstmt=con.prepareStatement("select * from member where id=?");
			pstmt.setString(1, listID);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				info= new MemberBean();
				info.setId(rs.getString("id"));
				info.setPassword(rs.getString("password"));
				info.setName(rs.getString("name"));
				info.setAge(rs.getInt("age"));
				info.setGender(rs.getString("gender"));
				info.setEmail(rs.getString("email"));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt); 
		}
		return info;
	}
	//회원 삭제 
	public int deleteMember(String delId) {
		int deleteCount = 0;
		try {
			pstmt=con.prepareStatement("delete member where id=?");
			pstmt.setString(1, delId);
			deleteCount = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return deleteCount;
	}
	//회원정보 수정 
	public int modSuccess(MemberBean member) {
		int modCount = 0;
		String sql_mod="update member set password=?, name=?, age=?, gender=?, email=? where id=?";
		
		try {
			pstmt = con.prepareStatement(sql_mod);
			pstmt.setString(1, member.getPassword());
			pstmt.setString(2,member.getName());
			pstmt.setInt(3, member.getAge());
			pstmt.setString(4, member.getGender());
			pstmt.setString(5, member.getEmail());
			pstmt.setString(6, member.getId());
			modCount = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return modCount;
	}
	//아이디찾기 
	public MemberBean findID(String email) {
		
		String sql_f="select * from member where email=?";
		MemberBean member = null;
		
		try {
			pstmt =con.prepareStatement(sql_f);
			pstmt.setString(1, email);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				member = new MemberBean();
				member.setId(rs.getString("id"));
				member.setEmail(rs.getString("email"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return member;
	}
}

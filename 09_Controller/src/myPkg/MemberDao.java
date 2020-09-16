package myPkg;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDao {

	private static MemberDao dao = null;
	DataSource ds = null;
	Connection con = null;
	PreparedStatement ps =null;
	ResultSet rs = null;

	private MemberDao(){

		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc/OracleDB");
			con = ds.getConnection(); 

		} catch (NamingException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static MemberDao getInstance() {
		if(dao == null) {
			dao = new MemberDao();
		}
		return dao;
	}
	public void insertData(String id,String passwd,String name) {
		String sql = "insert into member values(m_seq.nextval,?,?,?,default)";
		System.out.println(name);
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, passwd);
			ps.setString(3, name);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}
	public ArrayList<MemberBean> getSelectAll() {
		String sql ="select * from member order by num asc";
		ArrayList<MemberBean> list = new ArrayList<MemberBean>();
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while (rs.next()) {
				int num = rs.getInt(1);
				String id = rs.getString(2);
				String passwd=rs.getString(3);
				String name = rs.getString(4);
				//String register = rs.getString(5);//날짜시간모두 출력됨
				String register = String.valueOf(rs.getDate(5));//날짜만 받아오기 가능
				MemberBean bean = new MemberBean(num, id, passwd, name, register);
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}

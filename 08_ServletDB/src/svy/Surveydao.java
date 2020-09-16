package svy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Surveydao {
	private String driver;
	private String url1;
	private String user;
	private String pw;
	/*
	 * private String driver = "oracle.jdbc.driver.OracleDriver"; private String
	 * url1="jdbc:oracle:thin:@localhost:1521:orcl"; private String user="jspid";
	 * private String pw="jsppw";
	 */	PreparedStatement ps = null;
	Connection con = null;
	ResultSet rs = null;

	
	public Surveydao(String driver, String url1, String user, String pw) {
		super();
		this.driver = driver;
		this.url1 = url1;
		this.user = user;
		this.pw = pw;
		try {
			Class.forName(driver);
			try {
				con=DriverManager.getConnection(url1, user, pw);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * public Surveydao() { try { Class.forName(driver); try { con=
	 * DriverManager.getConnection(url1, user, pw); } catch (SQLException e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); } } catch
	 * (ClassNotFoundException e) { e.printStackTrace(); }
	 * 
	 * }
	 */
	public ArrayList<Surveybean> selectall(){
		ArrayList<Surveybean> list = new ArrayList<Surveybean>();
		String sql = "select * from survey";
		try {ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		while (rs.next()) {
			int no = rs.getInt(1);
			String name =rs.getString(2);
			String company =rs.getString(3);
			String email =rs.getString(4);
			String satisfaction =rs.getString(5);
			String part = rs.getString(6);
			String howto =rs.getString(7);
			int agree =rs.getInt(8);

			Surveybean bean = new Surveybean(no, name, company, email, satisfaction, part, howto, agree);
			list.add(bean);
		}}catch(Exception e) {

		}finally {
			try {
				if(ps!=null)
					ps.close();
				if(rs!=null)
					rs.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	public ArrayList<Surveybean> selectone(String no1){
		ArrayList<Surveybean> list = new ArrayList<Surveybean>();
		String sql = "select * from survey where no=?";
		try {ps = con.prepareStatement(sql);
		ps.setString(1, no1);
		rs = ps.executeQuery();
		while (rs.next()) {
			int no = rs.getInt(1);
			String name =rs.getString(2);
			String company =rs.getString(3);
			String email =rs.getString(4);
			String satisfaction =rs.getString(5);
			String part = rs.getString(6);
			String howto =rs.getString(7);
			int agree =rs.getInt(8);
			
			Surveybean bean = new Surveybean(no, name, company, email, satisfaction, part, howto, agree);
			list.add(bean);
		}}catch(Exception e) {
			
		}finally {
			try {
				if(ps!=null)
					ps.close();
				if(rs!=null)
					rs.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	public void insert(Surveybean bean) {
		String sql="insert into survey values(seqmy.nextval,?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getCompany());
			ps.setString(3, bean.getEmail());
			ps.setString(4, bean.getSatisfaction());
			ps.setString(5,bean.getPart());
			ps.setString(6, bean.getHowto());
			ps.setInt(7, bean.getAgree());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null)
					ps.close();
				if(rs!=null)
					rs.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	public void update(Surveybean bean) {
		String sql="update survey set name=?, company=?, email=?, satisfaction=?, part=?, howto=?, agree=? where no=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getCompany());
			ps.setString(3, bean.getEmail());
			ps.setString(4, bean.getSatisfaction());
			ps.setString(5,bean.getPart());
			ps.setString(6, bean.getHowto());
			ps.setInt(7, bean.getAgree());
			ps.setInt(8, bean.getNo());
			ps.executeUpdate();
			
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
	}
	public void delete(String no) {
		String sql="delete survey where no=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, no);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null)
					ps.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}

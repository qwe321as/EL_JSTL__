package myPkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MymemDao {

	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:orcl";
	private String user="jspid";
	private String password="jsppw";
	private Connection conn  = null ;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public MymemDao() {
		try {
			Class.forName( driver ) ;

			conn = DriverManager.getConnection( url, user, password ) ;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // ������

	public int deleteMymem(String id) {

		int cnt = -1;
		String sql = "delete mymem where id =? ";
		try {
			//3.
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			//4.
			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
			}catch(SQLException e) {

			}
		}
		
		return cnt;
	}// deleteMymem
	public int insertMymem(MymemBean bean) {
		
		int cnt = -1;
		String sql = "insert into mymem(id,name,password) values(seqmem.nextval,?,?)";
		
		try {
			//3.
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,bean.getName());
			pstmt.setString(2, bean.getPassword());
			
			//4.
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
			}catch(SQLException e) {
				
			}
		}
		
		return cnt;
	}// insert
	public void getupate(MymemBean bean) {
		String sql = "update mymem set name=?,password=? where id=?" ;
		try {
			//3.
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,bean.getName());
			pstmt.setString(2, bean.getPassword());
			pstmt.setInt(3, bean.getId());
			
			//4.
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
			}catch(SQLException e) {
				
			}
		}
	}//getupate

	public ArrayList<MymemBean> getMymemList(){
		
		String sql = "select * from mymem order by id asc";
		
		ArrayList<MymemBean> lists = new ArrayList<MymemBean>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String password = rs.getString("password");
				MymemBean bean = new MymemBean(id, name, password);
				lists.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
			}catch(SQLException e) {

			}
		}
		return lists;
	}

	public MymemBean getOneSelect(String id1){
		MymemBean bean = null;
		String sql = "select * from mymem where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id1);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String password = rs.getString("password");
				 bean = new MymemBean(id, name, password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
			}catch(SQLException e) {
				
			}
		}
		return bean;
	}
	
}













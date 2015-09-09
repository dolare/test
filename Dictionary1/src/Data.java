
import java.sql.*;

import javax.swing.JOptionPane;

/**
 * �������ݿ����
 */
public class Data {
	
    Statement stmt=null;
	ResultSet rs=null;
    Connection conn=null;
	String sql;
	String strurl="jdbc:odbc:JavaTest";
	
	public Data(){
	}
	
	/**
	 * �����ݿ�����
	 */
	public void OpenConn()throws Exception{
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
			conn=DriverManager.getConnection(strurl);
		}
		catch(Exception e){ 
			System.err.println("OpenConn:"+e.getMessage());
		}
	}

	/**
	 * ִ��sql��䣬���ؽ����rs
	 */
	public ResultSet executeQuery(String sql){
		stmt = null;
		rs=null;
		try{
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs=stmt.executeQuery(sql);
		}
		catch(SQLException e){
			System.err.println("executeQuery:"+e.getMessage());
		}
		return rs;
	}

	/**
	 * ִ��sql���
	 */
	public void executeUpdate(String sql){
		stmt=null;
		rs=null;
		try{
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			stmt.executeUpdate(sql);
			conn.commit();
		}
		catch(SQLException e){
			//���õ����Ѿ����ڣ�������ʾ��
			if(e.getErrorCode()==-1605){
				JOptionPane.showMessageDialog(AddWord.Frame, "�õ����Ѿ����ڣ�������ӣ�");
			}
		}
	}
	
	public void closeStmt(){
		try{
			stmt.close();
		}
		catch(SQLException e){
			System.err.println("closeStmt:"+e.getMessage()); 
		}
	}

	/**
	 * �ر����ݿ�����
	 */
	public void closeConn(){
		try{
			conn.close();
		}
		catch(SQLException ex){
			System.err.println("aq.closeConn:"+ex.getMessage()); 
		}
	}
}
	
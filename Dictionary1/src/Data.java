
import java.sql.*;

import javax.swing.JOptionPane;

/**
 * 连接数据库的类
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
	 * 打开数据库连接
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
	 * 执行sql语句，返回结果集rs
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
	 * 执行sql语句
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
			//若该单词已经存在，弹出提示框
			if(e.getErrorCode()==-1605){
				JOptionPane.showMessageDialog(AddWord.Frame, "该单词已经存在，不用添加！");
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
	 * 关闭数据库连接
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
	
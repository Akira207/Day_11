package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
	 public static Connection getMSSQLConnections() throws SQLException, ClassNotFoundException{
	        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	       String url = "jdbc:sqlserver://ADMIN\\SQLEXPRESS:1433;databaseName=PhanLacTuan_2110900074_Dbs;encrypt=false";
	       String user = "sa";
	       String password = "sa123";

	        Connection conn = DriverManager.getConnection(url, user,password);
	        return conn;
	    }
	    public static void closeQuietly(Connection conn){
	        try {
	        conn.close();
	        }catch (Exception e){

	        }
	    }

	    public  static void rollbackQuietly(Connection conn){
	        try {
	conn.rollback();
	        }catch (Exception e){

	        }
	    }

	    public static void main(String[] args) throws SQLException,ClassNotFoundException {
	        Connection conn = getMSSQLConnections();
	        System.out.println("connection " + conn);
	        System.out.println("done");

	    }
}
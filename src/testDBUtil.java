import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Connection;


public class testDBUtil {
	private static String driverName;
	private static String host;
	private static  String username;
	private static String password;
	
	static{
		
		try {
			Properties prop=new Properties();
			prop.load(new FileInputStream(
				    "config.properties"));
			driverName=prop.getProperty("driverName");
			host=prop.getProperty("host");
			username=prop.getProperty("username");
			password=prop.getProperty("password");
			System.out.println("初始化完毕");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void closeConnection(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName(driverName);
		Connection conn =(Connection) DriverManager.getConnection(host,username,password);
		return conn;
		
	}
}

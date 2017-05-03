import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;


public class testDAO {
	public static void main(String[] args){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ibm?useUnicode=true&characterEncoding=utf-8", "root", "");
				System.out.println("与数据库建立连接!");
				Statement state =(Statement) conn.createStatement();
				String sql="select * from dept";
				ResultSet rs=(ResultSet) state.executeQuery(sql);
				while(rs.next()){
					int did=rs.getInt("did");
					String dname=rs.getString("dname");
					String location =rs.getString("location");
					System.out.println(did+","+dname+","+location);
					
				}
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("数据库访问异常!");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("驱动类无法找到!");
		}
	}
	
}

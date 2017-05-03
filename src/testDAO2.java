import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class testDAO2 {
	public static void main(String[] args){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection conn =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ibm?useUnicode=true&amp;characterEncoding=utf-8","root","");
				Statement state =(Statement) conn.createStatement();
				String sql="insert into dept values(50,'市场部','海口')";
				int i=state.executeUpdate(sql);
				if(i>0){
					System.out.println("插入完毕");
				}
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

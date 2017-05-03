import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class testCreateTable {
	public static void main(String[] args){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection conn =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ibm?useUnicode=true&amp;characterEncoding=utf-8","root","");
				Statement state =(Statement) conn.createStatement();
				String sql="CREATE TABLE emp1( "
						+"eid INT PRIMARY KEY AUTO_INCREMENT, "
						+"ename VARCHAR(32), "
						+"salary FLOAT(8,2), "
						+"hireDate DATE, "
						+"isOnDuty BOOLEAN, "
						+"deptId INT"
						+");";
				state.execute(sql);
				System.out.println("创建完毕");				
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

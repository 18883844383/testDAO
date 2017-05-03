import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class testDBUtil2 {
	public static void main(String[] args){
		Connection conn=null;
		try {
			conn=testDBUtil.getConnection();
			String sql="insert into dept values(?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, 60);
			ps.setString(2, "技术部");
			ps.setString(3, "海南");
			int d =ps.executeUpdate();
			if(d>0){
				System.out.println("插入完毕");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo5 {
	public static void main(String[] args) {
		// 加载驱动
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 定义sql语句
			String sql = "DELETE FROM `count` WHERE `no`=2 ";
			// 建立connection对象连接
			conn = DriverManager.getConnection("jdbc:mysql:///test", "root", "1");
			// 定义执行SQL的对象
			stat = conn.createStatement();
			// 执行sql语句
			int i = stat.executeUpdate(sql);
			System.out.println(i);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		// 关闭资源
		finally {
			if (stat != null) {
				try {
					stat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

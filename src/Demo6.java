import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo6 {
	public static void main(String[] args) {
		ResultSet rs = null;
		Statement stat = null;
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String sql = "SELECT * FROM `count`";
			conn = DriverManager.getConnection("jdbc:mysql:///test", "root", "1");
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				int a = rs.getInt("no");
				int b = rs.getInt("score");
				System.out.println(a + "----" + b);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
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

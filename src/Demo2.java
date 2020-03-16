import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo2 {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/epet", "root", "1");
		} catch (SQLException e) {

			e.printStackTrace();
		}
		Statement stat = null;
		try {
			stat = conn.createStatement();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = stat.executeQuery("SELECT `name` FROM `master`");
		} catch (SQLException e) {

			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				String name = rs.getString("name");
				System.out.println(name);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
			try {
				stat.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

}

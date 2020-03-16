import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo5 {
	public static void main(String[] args) {
		// ��������
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// ����sql���
			String sql = "DELETE FROM `count` WHERE `no`=2 ";
			// ����connection��������
			conn = DriverManager.getConnection("jdbc:mysql:///test", "root", "1");
			// ����ִ��SQL�Ķ���
			stat = conn.createStatement();
			// ִ��sql���
			int i = stat.executeUpdate(sql);
			System.out.println(i);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		// �ر���Դ
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

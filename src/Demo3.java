import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo3 {
   public static void main(String[] args) {
	   Statement stat=null;
	   Connection  conn=null;
		   try {
			Class.forName("com.mysql.jdbc.Driver");
			   conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/epet", "root", "1");
			  String sql="INSERT INTO `master`(`name`,`number`)\r\n" + 
			  		"VALUES('�ŷ�',100),('����',120)";
			 stat=conn.createStatement();
			  int flag=stat.executeUpdate(sql);
				
		         if(flag>0) {
		        	 System.out.println("�����ɹ�");
		        	 
		         }else {
		        	 System.out.println("ʧ��");
		         }
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	
	 

	        
		

			 finally {
				 try {
					stat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
			 }
	 }
	   
	   
}

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
			  		"VALUES('张飞',100),('关羽',120)";
			 stat=conn.createStatement();
			  int flag=stat.executeUpdate(sql);
				
		         if(flag>0) {
		        	 System.out.println("新增成功");
		        	 
		         }else {
		        	 System.out.println("失败");
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

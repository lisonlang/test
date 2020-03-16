import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo4 {
      public static void main(String[] args) {
		
    	  Connection conn=null;
    			  Statement stat=null;
    	  
    	  //加载驱动
    	  try {
			Class.forName("com.mysql.jdbc.Driver");
			//定义sql语句
			String sql="INSERT INTO `count`(`no`,`score`)\r\n" + 
					" VALUES('3','56')";
			//建立连接获取connection对象
			 conn=DriverManager.getConnection("jdbc:mysql:///test","root","1");
			//获取执行sql语句的的对象
			       stat=conn.createStatement();
			//执行sql语句
			  int info= stat.executeUpdate(sql);//影响的行数
			  //处理结果
			System.out.println(info);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	  
    	  finally {
    		  if(stat!=null) {
    			  try {
					stat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			  if(conn!=null) {
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
	

}

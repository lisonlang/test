import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo4 {
      public static void main(String[] args) {
		
    	  Connection conn=null;
    			  Statement stat=null;
    	  
    	  //��������
    	  try {
			Class.forName("com.mysql.jdbc.Driver");
			//����sql���
			String sql="INSERT INTO `count`(`no`,`score`)\r\n" + 
					" VALUES('3','56')";
			//�������ӻ�ȡconnection����
			 conn=DriverManager.getConnection("jdbc:mysql:///test","root","1");
			//��ȡִ��sql���ĵĶ���
			       stat=conn.createStatement();
			//ִ��sql���
			  int info= stat.executeUpdate(sql);//Ӱ�������
			  //������
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

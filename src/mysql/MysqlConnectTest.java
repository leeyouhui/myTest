package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class MysqlConnectTest {

	public static final String url = "jdbc:mysql://127.0.0.1/test";  
    public static final String name = "com.mysql.jdbc.Driver";  
    public static final String user = "root";  
    public static final String password = "root";  
  
    public static Connection conn = null;  
    public static Statement st = null;
    public static PreparedStatement pst = null;
	
    static {
    	initDBConnection();
    }
    
    public static void initDBConnection(){
    	try {  
            Class.forName(name);//指定连接类型  
            conn = DriverManager.getConnection(url, user, password);//获取连接 
            st = conn.createStatement();
//            pst = conn.prepareStatement(sql);//准备执行语句  
        } catch (Exception e) {  
            e.printStackTrace();  
        }
    }
	public static void main(String[] args) {

	}

}

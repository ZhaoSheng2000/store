package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
public class DbUtil {
	/**
    *
    * jdbc简单配置
    * dburl
    * dbusername
    * dbpassword
    * jdbcName
    *
    */
   private String dbUrl = "jdbc:mysql://localhost:3306/kingstore";
   private String dbUserName = "root";
   private String dbPassword = "password";

   private String jdbcName = "com.mysql.cj.jdbc.Driver";

   /**
    * 获取数据库连接
    * return
    * throws Exception
    */
   public Connection getCon() throws Exception{
       Class.forName(jdbcName);
       Connection connection = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
       return connection;
   }
   /**
    * 关闭数据库
    * 设置con参数
    * throws Exception
    */
   public void closeCon(Connection connection) throws Exception{
       if (connection!= null){
           connection.close();
       }
   }
   /**
    * 建立main方法测试连接
    */
   public static void main(String[] args){
       DbUtil dbUtil = new DbUtil();
       try {
           dbUtil.getCon();
           System.out.println("数据库连接成功");
       } catch (Exception e){
           e.printStackTrace();
       }
   }
public ResultSet searchSQL(String sql) {
	// TODO Auto-generated method stub
	return null;
}
}

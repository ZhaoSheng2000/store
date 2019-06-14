package DAO;
import java.sql.*;
import javax.swing.JOptionPane;

import store.Temp;
import util.DbUtil;
public class LoginJdbc {
    Connection con=null;
    Statement statement =null;
    ResultSet res=null;
    public LoginJdbc() {
        new DbUtil();
    }
    //验证用户名和密码
    public boolean compare(String username, String password){
        boolean m = false;
        String sql = "select password from user where username='"+username+"'";
        try{
            DbUtil dbutil = new DbUtil();
            con = dbutil.getCon();
            statement = con.createStatement();
            res =statement.executeQuery(sql);
            if(res.next()){
                String p = res.getString(1);
                if(p.equals(password)){
                    System.out.println(username+"   账号登入");
                    Temp.user = username;
                    m = true;
                }else {
                    JOptionPane.showMessageDialog(null, "密码错误！");
                }
            }else {
                JOptionPane.showMessageDialog(null, "用户名不存在！");
            }
            String sql1 = "select * from user";
            res =statement.executeQuery(sql1);
            while(res.next()) {
                if(Temp.user.equals(res.getString("username"))){
                    Temp.name =res.getString("name");
                }
            }

            //  res.close();
            //  statement.close();
            //  con.close();
        }catch(SQLException e){
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return m;
    }
}

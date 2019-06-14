package store;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import util.DbUtil;
import util.Style;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminPersonal extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try{
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        }catch (Exception e) {
            e.printStackTrace();
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPersonal frame = new AdminPersonal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminPersonal() {
		try{
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        }catch (Exception e) {
            e.printStackTrace();
        }
		
		 
		 //样式
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				dispose();
			}
		});
		setBounds(800, 200, 344, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		
		JLabel lblNewLabel = new JLabel("管理员个人详情");
		lblNewLabel.setFont(new Font("微软雅黑 Light", Font.PLAIN, 17));
		lblNewLabel.setBounds(84, 10, 127, 40);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("账号：");
		lblNewLabel_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 60, 80, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("姓名：");
		lblNewLabel_2.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 105, 42, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("性别：");
		lblNewLabel_3.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 159, 42, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("部门：");
		lblNewLabel_4.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 203, 42, 22);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("职务：");
		lblNewLabel_5.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(10, 254, 42, 15);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("注册时间：");
		lblNewLabel_6.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(10, 305, 70, 15);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("新密码：");
		lblNewLabel_7.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(10, 358, 56, 22);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("确认密码：");
		lblNewLabel_8.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(10, 399, 70, 22);
		contentPane.add(lblNewLabel_8);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(84, 401, 185, 31);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(84, 360, 185, 31);
		contentPane.add(passwordField_1);
		
		JButton btnNewButton = new JButton("确认修改");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = String.valueOf(passwordField.getPassword());
				String password1 = String.valueOf(passwordField_1.getPassword());
				Connection con1=null;
				Statement statement1 =null;
				 new DbUtil();
				 if(!password.equals(password1)) {
			        	JOptionPane.showMessageDialog(null,"两次密码输入不相同！");
				 }else {
					 String sql1 = "update user set password='"+password1+"'where username='"+Temp.user+"'";
					
					 try {
						 DbUtil dbutil = new DbUtil();
						 	con1 = dbutil.getCon();
						 statement1 = con1.createStatement();
						if(statement1.executeUpdate(sql1)==1) {
							JOptionPane.showMessageDialog(null,"密码修改成功！");
							System.out.println("管理员："+Temp.name+"修改密码成功！");
						 }
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null,"密码修改失败！");
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				 }
			}
		});
		btnNewButton.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		btnNewButton.setBounds(95, 449, 116, 30);
		contentPane.add(btnNewButton);
		
		lblNewLabel_9 = new JLabel();
		lblNewLabel_9.setBounds(57, 61, 194, 15);
		contentPane.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel();
		lblNewLabel_10.setBounds(57, 106, 224, 15);
		contentPane.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel();
		lblNewLabel_11.setBounds(57, 160, 178, 15);
		contentPane.add(lblNewLabel_11);
		
		lblNewLabel_12 = new JLabel();
		lblNewLabel_12.setBounds(57, 208, 154, 15);
		contentPane.add(lblNewLabel_12);
		
		lblNewLabel_13 = new JLabel();
		lblNewLabel_13.setBounds(57, 255, 178, 15);
		contentPane.add(lblNewLabel_13);
		
		lblNewLabel_14 = new JLabel();
		lblNewLabel_14.setBounds(84, 306, 185, 15);
		contentPane.add(lblNewLabel_14);
		//连接数据库
				Connection con=null;
				Statement statement =null;
				 ResultSet res=null;
				 new DbUtil();
				 String sql = "select * from user";
				 try {		
					 DbUtil dbutil = new DbUtil();
					 	con = dbutil.getCon();
					 	statement = con.createStatement();
					 	res =statement.executeQuery(sql);
					 	while(res.next()) {
					 		//匹配账号并写入界面数据
					 		if(Temp.user.equals(res.getString("username"))) {
					 			lblNewLabel_9.setText(res.getString("username"));
					 			lblNewLabel_10.setText(res.getString("name"));
					 			lblNewLabel_11.setText(res.getString("gender"));
					 			lblNewLabel_12.setText(res.getString("department"));
					 			lblNewLabel_13.setText(res.getString("duties"));
					 			lblNewLabel_14.setText(res.getString("time"));
					 		}
					 	}
					 	
					 	
				 }catch (Exception e) { 
				}
	
	}
	
		
}

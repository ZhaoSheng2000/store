package store;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import util.DbUtil;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Vipinfo_chaxun extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

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
					Vipinfo_chaxun frame = new Vipinfo_chaxun();
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
	public Vipinfo_chaxun() {
		setTitle("查询VIP用户");
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				dispose();
			}
		});
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 538);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("请输入账号：");
		lblNewLabel.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 26, 108, 32);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		textField.setBounds(128, 26, 249, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblNewLabel_2 = new JLabel("姓名：");
		lblNewLabel_2.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 125, 54, 31);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("性别：");
		lblNewLabel_3.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 166, 54, 32);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("住址：");
		lblNewLabel_4.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 216, 54, 32);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("电话：");
		lblNewLabel_5.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(10, 281, 59, 31);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("折扣：");
		lblNewLabel_6.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(10, 339, 54, 31);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("注册时间：");
		lblNewLabel_7.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(10, 399, 70, 31);
		contentPane.add(lblNewLabel_7);
		
		textField_1 = new JTextField();
		textField_1.setBounds(74, 131, 284, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(74, 173, 284, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(74, 223, 284, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(74, 287, 284, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(74, 345, 284, 21);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setEnabled(false);
		textField_6.setBounds(74, 405, 284, 21);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				
				String id = textField.getText();
				//连接数据库
				Connection con=null;
				Statement statement =null;
				 ResultSet res=null;
				 new DbUtil();
				 String sql = "select * from vip_info";
				 try {		
					 DbUtil dbutil = new DbUtil();
					 	try {
							con = dbutil.getCon();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					 	statement = con.createStatement();
					 	res =statement.executeQuery(sql);
					 	int q=0;
					 	while(res.next()) {
					 		//匹配账号并写入界面数据
					 		if(id.equals(res.getString("id"))) {
					 			q =1;
					 			textField_1.setText(res.getString(3));
					 			textField_2.setText(res.getString(4));
					 			textField_3.setText(res.getString(5));
					 			textField_4.setText(res.getString(6));
					 			textField_5.setText(res.getString(7));
					 			textField_6.setText(res.getString(8));
					 			//textField_7.setText(res.getString(8));
					 		}
					 	}if(q==0) {
					 		
					 		JOptionPane.showMessageDialog(null,"查询不到此用户！");
					 		
					 	}
					 	
					 	
					 	
					 	
				 } catch (SQLException e1) {
					 System.out.println(e1);
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		btnNewButton.setBounds(108, 68, 93, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("修改");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				String name = textField_1.getText();
				String gender = textField_2.getText();
				String address = textField_3.getText();
				String phone = textField_4.getText();
				String discount = textField_5.getText();
				
				//连接数据库
				Connection con=null;
				Statement statement =null;
				 new DbUtil();
				 String sql = "update vip_info set name = '"+name+"', gender = '"+gender+"',phone = '"+phone+"',address = '"+address+"',discount = '"+discount+"' where id = '"+id+"'";
				 try {		
					 DbUtil dbutil = new DbUtil();
					 	con = dbutil.getCon();
					 	statement = con.createStatement();
					 	statement.executeUpdate(sql);
					 
					 	System.out.println(statement.executeUpdate(sql));
					 	if(statement.executeUpdate(sql)==1) {
					 		 JOptionPane.showMessageDialog(null,"修改成功！");
					 	}
					 	
					 
					 	
					 	
				 }catch (Exception e1) { 
					 JOptionPane.showMessageDialog(null,"修改失败！");
					 System.out.println(e1);
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		btnNewButton_1.setBounds(265, 68, 93, 23);
		contentPane.add(btnNewButton_1);
	}

}

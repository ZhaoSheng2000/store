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
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class PersonelInfo_chaxun extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JButton btnNewButton_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;

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
					PersonelInfo_chaxun frame = new PersonelInfo_chaxun();
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
	public PersonelInfo_chaxun() {
		setResizable(false);
		setTitle("查询员工");
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				dispose();
			}
		});
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 677);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("请输入员工工号：");
		lblNewLabel.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 10, 144, 25);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(144, 13, 244, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");
				textField_9.setText("");
				textField_10.setText("");
				textField_11.setText("");
				
				
				String id =textField.getText(); 
				//连接数据库
				Connection con=null;
				Statement statement =null;
				 ResultSet res=null;
				 new DbUtil();
				 String sql = "select * from personnel_info";
				 try {		
					 DbUtil dbutil = new DbUtil();
					 	con = dbutil.getCon();
					 	statement = con.createStatement();
					 	res =statement.executeQuery(sql);
					 	int q = 0;
					 	while(res.next()) {
					 		//匹配账号并写入界面数据
					 		if(id.equals(res.getString("id"))) {
					 			q=1;
					 			textField_1.setText(res.getString(1));
					 			textField_2.setText(res.getString(2));
					 			textField_3.setText(res.getString(3));
					 			textField_4.setText(res.getString(4));
					 			textField_5.setText(res.getString(5));
					 			textField_6.setText(res.getString(6));
					 			textField_7.setText(res.getString(7));
					 			textField_8.setText(res.getString(8));	
					 			textField_9.setText(res.getString(9));	
					 			textField_10.setText(res.getString(10));	
					 			textField_11.setText(res.getString(11));	
					 		}
					 		
					 	}if(q==0) {
					 		JOptionPane.showMessageDialog(null,"查询不到此人的信息！");
					 		
					 	}
					 
					 	
					 	
				 }catch (Exception e1) { 
					 
				}

			}
		});
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setBounds(57, 92, 331, 31);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(57, 133, 331, 31);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(57, 174, 331, 31);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(57, 209, 331, 31);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(57, 263, 331, 31);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(57, 309, 331, 31);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(57, 357, 331, 31);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(57, 402, 331, 31);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(57, 451, 331, 31);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(57, 498, 331, 31);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setEnabled(false);
		textField_11.setBounds(72, 546, 316, 31);
		contentPane.add(textField_11);
		textField_11.setColumns(10);
		
		btnNewButton_1 = new JButton("修改");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField_1.getText();
				String name = textField_2.getText();
				String gender = textField_3.getText();
				String age = textField_4.getText();
				String department = textField_5.getText();
				String duties = textField_6.getText();
				String phone = textField_7.getText();
				String wages = textField_8.getText();
				String address = textField_9.getText();
				String state = textField_10.getText();
				//连接数据库
				Connection con=null;
				Statement statement =null;
				 
				 new DbUtil();
				 String sql = "update personnel_info set name = '"+name+"', gender = '"+gender+"',age = '"+age+"',department = '"+department+"',duties = '"+duties+"',phone = '"+phone+"',wages = '"+wages+"',address = '"+address+"',state = '"+state+"' where id = '"+id+"'";
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
		btnNewButton_1.setBounds(293, 45, 93, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 14));
		btnNewButton.setBounds(61, 45, 93, 23);
		contentPane.add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("工号：");
		lblNewLabel_1.setBounds(10, 103, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("姓名：");
		lblNewLabel_2.setBounds(10, 136, 54, 15);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("性别：");
		lblNewLabel_3.setBounds(10, 177, 54, 15);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("年龄：");
		lblNewLabel_4.setBounds(10, 212, 54, 15);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("部门：");
		lblNewLabel_5.setBounds(10, 266, 54, 15);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("职务：");
		lblNewLabel_6.setBounds(10, 312, 54, 15);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("电话：");
		lblNewLabel_7.setBounds(10, 360, 54, 15);
		contentPane.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("月薪：");
		lblNewLabel_8.setBounds(10, 405, 54, 15);
		contentPane.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("住址：");
		lblNewLabel_9.setBounds(10, 454, 54, 15);
		contentPane.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("状态：");
		lblNewLabel_10.setBounds(10, 501, 54, 15);
		contentPane.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("注册时间：");
		lblNewLabel_11.setBounds(10, 549, 65, 15);
		contentPane.add(lblNewLabel_11);
	}

}

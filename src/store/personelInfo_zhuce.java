package store;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import util.DbUtil;
import util.NowTime;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class personelInfo_zhuce extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

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
					personelInfo_zhuce frame = new personelInfo_zhuce();
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
	public personelInfo_zhuce() {
		setTitle("注册新员工");
		setResizable(false);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				dispose();
			}
		});
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 603);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("工号：");
		lblNewLabel.setBounds(10, 23, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("姓名：");
		lblNewLabel_1.setBounds(10, 58, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("性别：");
		lblNewLabel_2.setBounds(10, 99, 54, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("年龄：");
		lblNewLabel_3.setBounds(10, 140, 54, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("部门：");
		lblNewLabel_4.setBounds(10, 185, 54, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("职务：");
		lblNewLabel_5.setBounds(10, 235, 54, 15);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("月薪：");
		lblNewLabel_6.setBounds(10, 283, 54, 15);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("状态：");
		lblNewLabel_7.setBounds(10, 332, 54, 15);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("电话：");
		lblNewLabel_8.setBounds(10, 375, 54, 15);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("住址：");
		lblNewLabel_9.setBounds(10, 419, 54, 15);
		contentPane.add(lblNewLabel_9);
		
		textField = new JTextField();
		textField.setBounds(88, 20, 294, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(88, 55, 294, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(88, 96, 294, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(88, 137, 294, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(88, 182, 294, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(88, 232, 294, 21);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(88, 280, 294, 21);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(88, 329, 294, 21);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(88, 372, 294, 21);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(88, 416, 294, 21);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		JButton btnNewButton = new JButton("确认注册");
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				String name = textField_1.getText();
				String gender = textField_2.getText();
				String age = textField_3.getText();
				String department = textField_4.getText();
				String duties = textField_5.getText();
				String wages = textField_6.getText();
				String  state= textField_7.getText();
				String phone = textField_8.getText();
				String address = textField_9.getText();
				String time = new NowTime().getSystemTime();
				//连接数据库
				Connection con=null;
				Statement statement =null;
				 ResultSet res=null;
				 PreparedStatement preparedStatement = null;
				 new DbUtil();
				 String sql = "insert into personnel_info values(?,?,?,?,?,?,?,?,?,?,?)";
				 try {		
					 DbUtil dbutil = new DbUtil();
					 	con = dbutil.getCon();
					 	statement = con.createStatement();
					 	preparedStatement = con.prepareStatement(sql);
					 	preparedStatement.setString(1,id);
					 	preparedStatement.setString(2,name);
					 	preparedStatement.setString(3,gender);
					 	preparedStatement.setString(4,age);
					 	preparedStatement.setString(5,department);
					 	preparedStatement.setString(6,duties);
					 	preparedStatement.setString(7,phone);
					 	preparedStatement.setString(8,wages);
					 	preparedStatement.setString(9,address);
					 	preparedStatement.setString(10,state);
					 	preparedStatement.setString(11,time);
					 	
					 	preparedStatement.executeUpdate();
					 	JOptionPane.showMessageDialog(null,"成功注册！");
				 }catch (SQLException e1) { 
					 JOptionPane.showMessageDialog(null,"注册失败！请确认数据是否正确后重新注册！");
					 
					 System.out.println(e1);

								} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(105, 472, 230, 35);
		contentPane.add(btnNewButton);
	}

}

package store;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import util.DbUtil;
import util.NowTime;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class vipinfo_zhuce extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
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
					vipinfo_zhuce frame = new vipinfo_zhuce();
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
	public vipinfo_zhuce() {
		setBackground(new Color(240, 240, 240));
		setTitle("注册vip用户");
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				dispose();
			}
		});
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 611);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("账号：");
		lblNewLabel.setFont(new Font("微软雅黑 Light", Font.PLAIN, 16));
		lblNewLabel.setBounds(21, 61, 54, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密码：");
		lblNewLabel_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(21, 115, 54, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("姓名：");
		lblNewLabel_2.setFont(new Font("微软雅黑 Light", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(21, 169, 54, 22);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("性别：");
		lblNewLabel_3.setFont(new Font("微软雅黑 Light", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(21, 227, 54, 22);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("住址：");
		lblNewLabel_4.setFont(new Font("微软雅黑 Light", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(21, 289, 54, 22);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("电话：");
		lblNewLabel_5.setFont(new Font("微软雅黑 Light", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(21, 345, 54, 22);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("折扣：");
		lblNewLabel_6.setFont(new Font("微软雅黑 Light", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(21, 407, 54, 22);
		contentPane.add(lblNewLabel_6);
		
		
		
		textField = new JTextField();
		textField.setBounds(73, 64, 277, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(73, 118, 277, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(73, 172, 277, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(73, 230, 277, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(73, 292, 277, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(73, 348, 277, 21);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(73, 410, 277, 21);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton = new JButton("确认注册");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//获取数据
				String id = textField.getText();
				String password = textField_1.getText();
				String name = textField_2.getText();
				String gender = textField_3.getText();
				String address = textField_4.getText();
				String phone = textField_5.getText();
				String discount = textField_6.getText();
				String time = new NowTime().getSystemTime();
				
				//连接数据库
				Connection con=null;
				Statement statement =null;
				 ResultSet res=null;
				 PreparedStatement preparedStatement = null;
				 new DbUtil();
				 String sql = "insert into vip_info values(?,?,?,?,?,?,?,?)";
				 try {		
					 DbUtil dbutil = new DbUtil();
					 	con = dbutil.getCon();
					 	statement = con.createStatement();
					 	preparedStatement = con.prepareStatement(sql);
					 	preparedStatement.setString(1,id);
					 	preparedStatement.setString(2,password);
					 	preparedStatement.setString(3,name);
					 	preparedStatement.setString(4,gender);
					 	preparedStatement.setString(5,address);
					 	preparedStatement.setString(6,phone);
					 	preparedStatement.setString(7,discount);
					 	preparedStatement.setString(8,time);
					 	preparedStatement.executeUpdate();
					 	JOptionPane.showMessageDialog(null,"成功录入！");
				 }catch (SQLException e1) { 
					 JOptionPane.showMessageDialog(null,"录入失败！请确认数据是否正确后重新录入！");
					 
					 System.out.println(e1);

								} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				
				
				
				
			}
		});
		btnNewButton.setFont(new Font("微软雅黑 Light", Font.PLAIN, 16));
		btnNewButton.setBounds(120, 472, 139, 41);
		contentPane.add(btnNewButton);
	}

}

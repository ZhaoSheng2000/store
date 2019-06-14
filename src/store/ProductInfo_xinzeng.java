package store;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import util.DbUtil;
import util.NowTime;

import java.awt.Color;
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

public class ProductInfo_xinzeng extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JButton btnNewButton;

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
					ProductInfo_xinzeng frame = new ProductInfo_xinzeng();
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
	public ProductInfo_xinzeng() {
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				dispose();
			}
		});
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 538);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		lblNewLabel_3 = new JLabel("编号：");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(28, 86, 54, 15);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("商品：");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBackground(Color.BLACK);
		lblNewLabel_4.setBounds(28, 119, 54, 15);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("厂商：");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(28, 155, 54, 15);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("类别：");
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(28, 190, 54, 15);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("进价：");
		lblNewLabel_7.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setBounds(28, 229, 54, 15);
		contentPane.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("数量：");
		lblNewLabel_8.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setBounds(28, 264, 54, 15);
		contentPane.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("售价：");
		lblNewLabel_9.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setBounds(28, 300, 54, 15);
		contentPane.add(lblNewLabel_9);
		
		lblNewLabel_11 = new JLabel("总进价：");
		lblNewLabel_11.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_11.setForeground(Color.WHITE);
		lblNewLabel_11.setBounds(28, 332, 62, 15);
		contentPane.add(lblNewLabel_11);
		
		lblNewLabel = new JLabel("请输入新进商品信息：");
		lblNewLabel.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(74, 21, 257, 55);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(84, 83, 244, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(87, 116, 244, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(87, 152, 244, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(87, 187, 244, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(87, 226, 244, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(86, 261, 245, 21);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(87, 297, 244, 21);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(87, 329, 244, 21);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		
		btnNewButton = new JButton("确认录入");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//获取数据
				String id = textField.getText();
				String  name= textField_1.getText();
				String  factory= textField_2.getText();
				String  category= textField_3.getText();
				String   feedprice= textField_4.getText();
				String  number= textField_5.getText();
				String  price= textField_6.getText();
				String  time= new NowTime().getSystemTime();
				String  allprice= textField_7.getText();
				//连接数据库
				Connection con=null;
				Statement statement =null;
				 ResultSet res=null;
				 PreparedStatement preparedStatement = null;
				 new DbUtil();
				 String sql = "insert into product_info values(?,?,?,?,?,?,?,?,?)";
				 try {		
					 DbUtil dbutil = new DbUtil();
					 	con = dbutil.getCon();
					 	statement = con.createStatement();
					 	preparedStatement = con.prepareStatement(sql);
					 	preparedStatement.setString(1,id);
					 	preparedStatement.setString(2,name);
					 	preparedStatement.setString(3,factory);
					 	preparedStatement.setString(4,category);
					 	preparedStatement.setString(5,feedprice);
					 	preparedStatement.setString(6,number);
					 	preparedStatement.setString(7,price);
					 	preparedStatement.setString(8,time);
					 	preparedStatement.setString(9,allprice);
					 	preparedStatement.executeUpdate();
					 	JOptionPane.showMessageDialog(null,"成功录入此商品！");
				 }catch (SQLException e1) { 
					 JOptionPane.showMessageDialog(null,"录入失败！请确认数据是否正确后重新录入！");
					 
					 System.out.println(e1);

								} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 16));
		btnNewButton.setBounds(82, 387, 246, 38);
		contentPane.add(btnNewButton);
	}

}

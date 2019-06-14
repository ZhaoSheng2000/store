package store;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import util.DbUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class ProductInfo_xinjin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

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
					ProductInfo_xinjin frame = new ProductInfo_xinjin();
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
	public ProductInfo_xinjin() {
		setTitle("更改商品数量");
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				dispose();
			}
		});
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 340);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JLabel lblNewLabel = new JLabel("更改商品数量");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		lblNewLabel.setBounds(138, 10, 124, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("商品名称：");
		lblNewLabel_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 16));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(20, 68, 107, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("更改后数量：");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("微软雅黑 Light", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(20, 116, 107, 30);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(118, 119, 237, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(118, 71, 237, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("确认更改");
		btnNewButton.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				String name = textField_1.getText();
				String number = textField.getText();
				//连接数据库
				Connection con=null;
				Statement statement1 =null;
				Statement statement =null;
				Statement statement2 =null;
				ResultSet res = null;
				 new DbUtil();
				 String sql = "update product_info set number = '"+number+"' where name = '"+name+"'  ";
				 String sql2 = "select price from product_info where name = '"+name+"'";
				 try {		
					 DbUtil dbutil = new DbUtil();
					 	con = dbutil.getCon();
					 	int q=1;
					 	statement = con.createStatement();
					 	statement1 = con.createStatement();
					 	statement2 = con.createStatement();
					 	res = statement.executeQuery(sql2);
					 	while(res.next()) {
					 		q=0;
					 		String price = res.getString("price");
					 		int allprice = new Integer(price) * new Integer(number);
					 		String sql1 = "update product_info set allprice = '"+allprice+"' where name = '"+name+"'";
					 		statement1.executeUpdate(sql1);
					 		//Statement prepareStatement1 = con.prepareStatement(sql1);
					 		System.out.println(allprice);
					 		System.out.println(price);
					 	}
					 	statement2 = con.createStatement();
					 	statement2.executeUpdate(sql);
					 	if(statement2.executeUpdate(sql)==1){
					 		JOptionPane.showMessageDialog(null,"商品数量修改成功！");
		}
					 	if(q==1) {
					 		
					 		JOptionPane.showMessageDialog(null,"商品数量修改失败，请检查是否存在该商品！");
					 	}
				 }catch (Exception e1) { 
					 System.out.println(e1);
					 e1.printStackTrace();
				}

			}
		});
		btnNewButton.setFont(new Font("微软雅黑 Light", Font.PLAIN, 16));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(138, 188, 124, 30);
		contentPane.add(btnNewButton);
	}

}

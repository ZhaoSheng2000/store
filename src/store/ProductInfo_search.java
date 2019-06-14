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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class ProductInfo_search extends JFrame {

	private static final String Connection = null;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_12_1;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_15;
	private JLabel lblNewLabel_16;
	private JLabel lblNewLabel_17;
	private JLabel lblNewLabel_18;
	private JLabel lblNewLabel_19;
	private Object con;
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
					ProductInfo_search frame = new ProductInfo_search();
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
	public ProductInfo_search() {
		setTitle("商品查询");
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				dispose();
			}
		});
		setBounds(100, 100, 550, 627);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("请输入需要查询的物品名称：");
		lblNewLabel.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(111, 63, 241, 44);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 16));
		textField.setForeground(Color.BLACK);
		textField.setBackground(Color.WHITE);
		textField.setBounds(28, 117, 355, 44);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("查询结果如下：");
		lblNewLabel_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(56, 171, 149, 25);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_3 = new JLabel("编号：");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(28, 220, 54, 15);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("商品：");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBackground(Color.BLACK);
		lblNewLabel_4.setBounds(28, 250, 54, 15);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("厂商：");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(28, 280, 54, 15);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("类别：");
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(28, 310, 54, 15);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("进价：");
		lblNewLabel_7.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setBounds(28, 350, 54, 15);
		contentPane.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("数量：");
		lblNewLabel_8.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setBounds(28, 380, 54, 15);
		contentPane.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("售价：");
		lblNewLabel_9.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setBounds(28, 410, 54, 15);
		contentPane.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("进货时间：");
		lblNewLabel_10.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_10.setForeground(Color.WHITE);
		lblNewLabel_10.setBounds(28, 440, 75, 15);
		contentPane.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("总进价：");
		lblNewLabel_11.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_11.setForeground(Color.WHITE);
		lblNewLabel_11.setBounds(28, 470, 62, 15);
		contentPane.add(lblNewLabel_11);
		
		lblNewLabel_12 = new JLabel();
		lblNewLabel_12.setForeground(Color.WHITE);
		lblNewLabel_12.setBounds(100, 220, 349, 15);
		contentPane.add(lblNewLabel_12);
		
		lblNewLabel_12_1 = new JLabel();
		lblNewLabel_12_1.setForeground(Color.WHITE);
		lblNewLabel_12_1.setBounds(100, 250, 358, 15);
		contentPane.add(lblNewLabel_12_1);
		
		lblNewLabel_13 = new JLabel();
		lblNewLabel_13.setForeground(Color.WHITE);
		lblNewLabel_13.setBounds(100, 280, 332, 15);
		contentPane.add(lblNewLabel_13);
		
		lblNewLabel_14 = new JLabel();
		lblNewLabel_14.setForeground(Color.WHITE);
		lblNewLabel_14.setBounds(100, 310, 254, 15);
		contentPane.add(lblNewLabel_14);
		
		lblNewLabel_15 = new JLabel();
		lblNewLabel_15.setForeground(Color.WHITE);
		lblNewLabel_15.setBounds(100, 440, 366, 15);
		contentPane.add(lblNewLabel_15);
		
		lblNewLabel_16 = new JLabel();
		lblNewLabel_16.setForeground(Color.WHITE);
		lblNewLabel_16.setBounds(100, 470, 375, 15);
		contentPane.add(lblNewLabel_16);
		
		lblNewLabel_17 = new JLabel();
		lblNewLabel_17.setForeground(Color.WHITE);
		lblNewLabel_17.setBounds(100, 350, 379, 18);
		contentPane.add(lblNewLabel_17);
		
		lblNewLabel_18 = new JLabel();
		lblNewLabel_18.setForeground(Color.WHITE);
		lblNewLabel_18.setBounds(100, 380, 343, 15);
		contentPane.add(lblNewLabel_18);
		
		lblNewLabel_19 = new JLabel();
		lblNewLabel_19.setForeground(Color.WHITE);
		lblNewLabel_19.setBounds(100, 410, 406, 15);
		contentPane.add(lblNewLabel_19);
		
		btnNewButton = new JButton("查  询");
		btnNewButton.setFont(new Font("微软雅黑 Light", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_12_1.setText("");
				lblNewLabel_12.setText("");
				lblNewLabel_13.setText("");
				lblNewLabel_14.setText("");
				lblNewLabel_15.setText("");
				lblNewLabel_16.setText("");
				lblNewLabel_17.setText("");
				lblNewLabel_18.setText("");
				lblNewLabel_19.setText("");
				String name = textField.getText();
				//连接数据库
				Connection con=null;
				Statement statement =null;
				 ResultSet res=null;
				 new DbUtil();
				 String sql = "select * from product_info";
				 try {		
					 DbUtil dbutil = new DbUtil();
					 	con = dbutil.getCon();
					 	statement = con.createStatement();
					 	res =statement.executeQuery(sql);
					 	int q = 0;
					 	while(res.next()) {
					 		//匹配账号并写入界面数据
					 		if(name.equals(res.getString("name"))) {
					 			q=1;
					 			lblNewLabel_12.setText(res.getString(1));
					 			lblNewLabel_12_1.setText(res.getString(2));
					 			lblNewLabel_13.setText(res.getString(3));
					 			lblNewLabel_14.setText(res.getString(4));
					 			lblNewLabel_15.setText(res.getString(8));
					 			lblNewLabel_16.setText(res.getString(9));
					 			lblNewLabel_17.setText(res.getString(5));
					 			lblNewLabel_18.setText(res.getString(6));
					 			lblNewLabel_19.setText(res.getString(9));	
					 		}
					 		
					 	}if(q==0) {
					 		JOptionPane.showMessageDialog(null,"查询不到此商品！");
					 		
					 	}
					 
					 	
					 	
				 }catch (Exception e1) { 
					 
				}

			}
		});
		btnNewButton.setBounds(400, 116, 93, 44);
		contentPane.add(btnNewButton);
		
		
	
}
	}



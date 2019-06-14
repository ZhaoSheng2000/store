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
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Vipinfo_zhuxiao extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel_1;

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
					Vipinfo_zhuxiao frame = new Vipinfo_zhuxiao();
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
	public Vipinfo_zhuxiao() {
		setTitle("注销VIP用户");
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				dispose();
			}
		});
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 430);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("请输入注销用户的账号");
		lblNewLabel.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		lblNewLabel.setBounds(50, 24, 213, 42);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("建议查询确认后注销");
		lblNewLabel_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(50, 76, 213, 33);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		textField.setBounds(50, 119, 281, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("确认注销");
		btnNewButton.addActionListener(new ActionListener() {
			private int res;

			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				Connection con=null;
				Statement statement =null;
				 new DbUtil();
				 String sql = "delete from vip_info where id='"+id+"'";
				 try {		
					 DbUtil dbutil = new DbUtil();
					 	con = dbutil.getCon();
					 	statement = con.createStatement();
					 	res =statement.executeUpdate(sql);
					 	if(res== 1) {
					 		JOptionPane.showMessageDialog(null,"账号："+id+" 成功注销！");		 			 	
					 	}else {
					 		JOptionPane.showMessageDialog(null,"注销失败，请输入正确的账号！");	
					 	}
				 }catch (Exception e1) { 
					 System.out.println(e1);
				}
			}
		});
		btnNewButton.setFont(new Font("微软雅黑 Light", Font.PLAIN, 16));
		btnNewButton.setBounds(90, 206, 213, 42);
		contentPane.add(btnNewButton);
	}

}

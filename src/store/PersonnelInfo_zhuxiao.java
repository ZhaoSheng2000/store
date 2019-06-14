package store;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import util.DbUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PersonnelInfo_zhuxiao extends JFrame {

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
					PersonnelInfo_zhuxiao frame = new PersonnelInfo_zhuxiao();
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
	public PersonnelInfo_zhuxiao() {
		setTitle("注销员工");
		setResizable(false);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				dispose();
			}
		});
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("请输入注销员工id：");
		lblNewLabel.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 10, 169, 28);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		textField.setBounds(177, 10, 230, 28);
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
				 String sql = "delete from personnel_info where id='"+id+"'";
				 try {		
					 DbUtil dbutil = new DbUtil();
					 	con = dbutil.getCon();
					 	statement = con.createStatement();
					 	res =statement.executeUpdate(sql);
					 	if(res== 1) {
					 		JOptionPane.showMessageDialog(null,"工号："+id+" 成功注销！");		 			 	
					 	}else {
					 		JOptionPane.showMessageDialog(null,"注销失败，请输入正确的工号！");	
					 	}
				 }catch (Exception e1) { 
					 System.out.println(e1);
				}
				
			}
		});
		btnNewButton.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		btnNewButton.setBounds(113, 173, 230, 33);
		contentPane.add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("建议查询确认后再进行注销，一旦注销不可恢复！");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(53, 87, 419, 38);
		contentPane.add(lblNewLabel_1);
	}

}

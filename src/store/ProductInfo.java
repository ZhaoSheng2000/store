package store;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import util.DbUtil;
import util.Style;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ProductInfo extends JFrame {
	DefaultTableModel defaultTableModel;           
	JTable jTable;
	private JPanel contentPane;
	private JPanel panel;
	private Vector<Object> columnNames;
	private Vector<Object> rowData;
	private JTable jtable;
	private TableModel tableModel;
	private Component jscrollpane;
	private Component header;
	

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
					ProductInfo frame = new ProductInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public ProductInfo() throws Exception {
		try{
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        }catch (Exception e) {
            e.printStackTrace();
        }
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				dispose();
			}
		});
		new Style();
		setTitle("商品信息管理");
		
		setBounds(100, 100, 1076, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("查   询");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
		            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		        }catch (Exception e1) {
		            e1.printStackTrace();
		        }
				ProductInfo_search frame = new ProductInfo_search();
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		btnNewButton_1.setBounds(10, 61, 120, 30);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("更   改");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
		            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		        }catch (Exception e1) {
		            e1.printStackTrace();
		        }
				ProductInfo_xinjin frame = new ProductInfo_xinjin();
				frame.setVisible(true);
			}
			
		});
		
		btnNewButton_2.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		btnNewButton_2.setBounds(10, 151, 120, 30);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("新   增");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductInfo_xinzeng frame = new ProductInfo_xinzeng();
				frame.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		btnNewButton_3.setBounds(10, 244, 120, 30);
		contentPane.add(btnNewButton_3);
		
		JPanel panel = new JPanel();
		panel.setBounds(160, 10, 699, 428);
		Look();
		//设置字体大小
		jtable.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		//设置表头字体大小
		JTableHeader header = jtable.getTableHeader();
		//设置行高
//		jtable.setRowHeight(30);
		
		//jtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//取消自动调整
		//设置滚轮面板
		jscrollpane = new JScrollPane(jtable);
		jscrollpane.setBounds(153, 10, 855, 430);
		contentPane.add(jscrollpane);
		((JComponent) jscrollpane).setOpaque(false);
		jtable.setOpaque(false);
	
	}

	
	public void Look()
	{
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				dispose();
			}
		});
		//导入数据设计
		columnNames = new Vector<>();
		columnNames.add("编号");
		columnNames.add("商品");
		columnNames.add("厂商");
		columnNames.add("类别");
		columnNames.add("进价");
		columnNames.add("数量");
		columnNames.add("售价");
		columnNames.add("进货时间");
		columnNames.add("总进价");
		rowData = new Vector<>();
				
		//连接数据库
		 
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		Statement statement = null;
		try {
			DbUtil dbutil = new DbUtil();
			try {
				con = dbutil.getCon();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//创建一个Statement对象
			statement = con.createStatement();
			ps = con.prepareStatement("select * from product_info");
			rs = ps.executeQuery();
			while(rs.next())
			{
				Vector<Object> hang = new Vector<>();
				hang.add(rs.getString(1));
				hang.add(rs.getString(2));
				hang.add(rs.getString(3));
				hang.add(rs.getString(4));
				hang.add(rs.getString(5));
				hang.add(rs.getString(6));
				hang.add(rs.getString(7));
				hang.add(rs.getString(8));
				hang.add(rs.getString(9));
				rowData.add(hang);
			}
			
		} catch (SQLException e1) {
			System.out.println("fail to connect the database！");
			e1.printStackTrace();
		}
		finally
		{
			try
			{
				rs.close();
				ps.close();
				statement.close();
				if(con!=null)
					con.close();
			}
			catch(SQLException e1)
			{
				System.out.println("conn close fall");
			}
		}
		//设置表格
		tableModel = new DefaultTableModel(rowData, columnNames);
		//设置表格及不可编辑
				jtable = new JTable(tableModel)
				{
					private static final long serialVersionUID = -4085954475206341833L;

					public boolean isCellEditable(int row,int column)
					{
						return false;
					}
				};
				//设置字体大小
				jtable.setFont(new Font("微软雅黑",5,14));
				//设置表头字体大小
				JTableHeader header = jtable.getTableHeader();
				header.setPreferredSize(new Dimension(header.getWidth(),40));
				header.setFont(new Font("楷体",5,15));
				
				

						
		//设置列宽
	jtable.getColumnModel().getColumn(7).setPreferredWidth(175);
//		jtable.getColumnModel().getColumn(1).setPreferredWidth(300);
//		jtable.getColumnModel().getColumn(2).setPreferredWidth(75);
//		jtable.getColumnModel().getColumn(3).setPreferredWidth(250);
//		jtable.getColumnModel().getColumn(4).setPreferredWidth(75);
//		jtable.getColumnModel().getColumn(5).setPreferredWidth(75);
//		jtable.getColumnModel().getColumn(6).setPreferredWidth(75);
//		jtable.getColumnModel().getColumn(7).setPreferredWidth(75);
//		jtable.getColumnModel().getColumn(8).setPreferredWidth(85);
		
	}

	

}

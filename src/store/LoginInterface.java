package store;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.LoginJdbc;
import util.Style;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.SystemColor;

public class LoginInterface extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField textField;
    private JButton btnNewButton_1;
    private JPasswordField passwordField;
    private JPasswordField passwordField_1;

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
                    LoginInterface frame = new LoginInterface();
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
    public LoginInterface() {
        try{
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        }catch (Exception e) {
            e.printStackTrace();
        }
        //new Style();
        setTitle("king商场信息管理系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 474, 434);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.inactiveCaptionBorder);
        contentPane.setForeground(Color.CYAN);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        JLabel picture = new JLabel();
        picture.setIcon(new ImageIcon("imgs/logo.png"));
        this.getLayeredPane().add(picture,new Integer(Integer.MIN_VALUE));
        picture.setBounds(0,0,483,384);

        JPanel c = new JPanel();
        c = (JPanel)getContentPane();
        c.setOpaque(false);


        JLabel label = new JLabel("用户名：");
        label.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
        label.setBounds(76, 152, 65, 27);
        contentPane.add(label);

        JLabel label_1 = new JLabel("密码：");
        label_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
        label_1.setBounds(76, 189, 65, 37);
        contentPane.add(label_1);

        textField = new JTextField();
        textField.setBounds(151, 146, 149, 33);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel label_2 = new JLabel("确认密码：");
        label_2.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
        label_2.setBounds(76, 236, 78, 37);
        contentPane.add(label_2);

        JButton btnNewButton = new JButton("登      陆 ");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoginJdbc d = new LoginJdbc();
                String username = textField.getText();
                String password = String.valueOf(passwordField.getPassword());
                String password1 = String.valueOf(passwordField_1.getPassword());
                if(!password.equals(password1)) {
                    JOptionPane.showMessageDialog(null,"两次密码输入不相同！");
                }else if(d.compare(username, password)) {
                    JOptionPane.showMessageDialog(null,"登陆成功");
                    MainInterface frame = new MainInterface();
                    frame.setVisible(true);
                    dispose();

                }
            }
        });
        btnNewButton.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
        btnNewButton.setForeground(Color.BLACK);
        btnNewButton.setBounds(61, 298, 93, 37);
        contentPane.add(btnNewButton);

        btnNewButton_1 = new JButton("重      置");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
                passwordField.setText("");
                passwordField_1.setText("");
            }
        });
        btnNewButton_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
        btnNewButton_1.setBounds(221, 298, 93, 37);
        contentPane.add(btnNewButton_1);

        passwordField = new JPasswordField();
        passwordField.setBounds(151, 237, 149, 37);
        contentPane.add(passwordField);

        passwordField_1 = new JPasswordField();
        passwordField_1.setBounds(151, 189, 149, 37);
        contentPane.add(passwordField_1);
    }
    @Override
    public void actionPerformed(ActionEvent e) {


    }


}


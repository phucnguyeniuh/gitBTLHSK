package FrmDangNhap;

import java.awt.EventQueue;

import javax.swing.JFrame;

import ConnectDB.connectDB;
import TrangChu.JMenuTrangChu;

import java.awt.Panel;
import java.awt.Color;
import java.awt.Label;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class signUp extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtAccount;
	private JPasswordField txtPassword;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signUp frame = new signUp();
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
	
	public boolean validateLogin() {
		String name = txtAccount.getText();
		char[] pwd = txtPassword.getPassword();
		

	    if (name == null || name.equals("")) {
	        JOptionPane.showMessageDialog(this, "Tài khoản không được để trống!!!");
	        return false;
	    }

	    if (pwd == null || String.valueOf(pwd).equals("")) {
	        JOptionPane.showMessageDialog(this, "Mật khẩu không được để trống!!!");
	        return false;
	    }
		
		return true;
	}
	public signUp() {
		
		connectDB.getinstance().connect();

		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 1051, 650);
		getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 689, 613);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		Label label = new Label("GROUP");
		label.setForeground(new Color(255, 51, 51));
		label.setFont(new Font("Segoe UI", Font.BOLD, 18));
		label.setBounds(10, 8, 87, 33);
		panel.add(label);
		
		Label label_1 = new Label("15");
		label_1.setForeground(new Color(102, 102, 255));
		label_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		label_1.setBounds(98, 8, 36, 33);
		panel.add(label_1);
		
		Label label_2 = new Label("Welcome To");
		label_2.setForeground(new Color(255, 51, 51));
		label_2.setFont(new Font("Segoe UI", Font.BOLD, 25));
		label_2.setBounds(250, 76, 200, 33);
		panel.add(label_2);
		
		Label label_1_1 = new Label("Motorbike Store Management ");
		label_1_1.setForeground(new Color(102, 102, 255));
		label_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		label_1_1.setBounds(179, 116, 393, 28);
		panel.add(label_1_1);
		
		
		JLabel lblMain = new JLabel("");
		lblMain.setIcon(new ImageIcon("HinhAnh/singUpMain.png"));
		lblMain.setBounds(33, 170, 616, 433);
		panel.add(lblMain);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(120, 120, 255));
		panel_1.setBounds(690, 0, 347, 613);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		Label label_2_1 = new Label("Login Page");
		label_2_1.setForeground(new Color(255, 255, 255));
		label_2_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		label_2_1.setBounds(106, 118, 179, 33);
		panel_1.add(label_2_1);
		
		Label label_2_1_1 = new Label("Login To Your Account");
		label_2_1_1.setForeground(Color.WHITE);
		label_2_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		label_2_1_1.setBounds(63, 157, 224, 28);
		panel_1.add(label_2_1_1);
		
		txtAccount = new JTextField();
		txtAccount.setText("NV001");
		txtAccount.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
			}
		});
		txtAccount.setBounds(103, 282, 184, 28);
		panel_1.add(txtAccount);
		txtAccount.setColumns(10);
		
		Label label_2_1_1_1 = new Label("Account");
		label_2_1_1_1.setForeground(Color.WHITE);
		label_2_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		label_2_1_1_1.setBounds(98, 242, 89, 33);
		panel_1.add(label_2_1_1_1);
		
		Label label_2_1_1_1_1 = new Label("Password");
		label_2_1_1_1_1.setForeground(Color.WHITE);
		label_2_1_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		label_2_1_1_1_1.setBounds(98, 322, 89, 33);
		panel_1.add(label_2_1_1_1_1);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(103, 362, 179, 28);
		panel_1.add(txtPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings({ "deprecation", "static-access" })
			public void actionPerformed(ActionEvent e) {
				  if (validateLogin()) {
				        Connection con = null;
				        PreparedStatement pst = null;
				        ResultSet rs = null;

				        try {
				            con = connectDB.getConnection();
				            String sql = "SELECT * FROM NhanVien WHERE MaNhanVien = ? AND MatKhau = ?";
				            pst = con.prepareStatement(sql);
				            pst.setString(1, txtAccount.getText());
				            pst.setString(2, new String(txtPassword.getPassword()));
				            rs = pst.executeQuery();

				            if (rs.next()) {
				                new JMenuTrangChu();
				                dispose();
				            } else {
				                JOptionPane.showMessageDialog(null, "Sai tài khoản hoặc mật khẩu!!!");
				                txtAccount.setText("");
				                txtPassword.setText("");
				            }
				        } catch (SQLException ex) {
				            JOptionPane.showMessageDialog(null, ex.toString());
				        } finally {
				            try {
				                if (rs != null) {
				                    rs.close();
				                }
				                if (pst != null) {
				                    pst.close();
				                }
				                if (con != null) {
				                    con.close();
				                }
				            } catch (SQLException ex) {
				                JOptionPane.showMessageDialog(null, ex.toString());
				            }
				        }
				    }
			}
			});
		btnLogin.setBounds(116, 438, 107, 33);
		panel_1.add(btnLogin);
		btnLogin.setBackground(new Color(59, 89, 182));
		btnLogin.setFont(new Font("BOLD", Font.PLAIN, 17));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("HinhAnh/icons8_Account_50px.png"));
		lblNewLabel.setBounds(43, 261, 50, 50);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("HinhAnh/icons8_Secure_50px.png"));
		lblNewLabel_1.setBounds(44, 340, 50, 50);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mật khẩu của NV001 là 123456");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setBounds(113, 400, 200, 13);
		panel_1.add(lblNewLabel_2);
	}
}

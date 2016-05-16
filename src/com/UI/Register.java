package com.UI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.Dao.RegisterDao;
import com.model.User;
import com.util.JDBC;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField user_txt;
	private JTextField psd_txt;
	private JTextField rpsd_txt;
	private User user;
	private JDBC jdbc;
	private Connection conn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel user_lab = new JLabel("\u7528\u6237\u540D");
		
		JLabel psd_lab = new JLabel("\u5BC6\u7801");
		
		user_txt = new JTextField();
		user_txt.setColumns(10);
		
		psd_txt = new JTextField();
		psd_txt.setColumns(10);
		
		JLabel rpsd_lab = new JLabel("\u786E\u8BA4\u5BC6\u7801");
		
		rpsd_txt = new JTextField();
		rpsd_txt.setColumns(10);
		psd_txt.setName("psd_txt");
		user_txt.setName("user_txt");
		
		
		JButton submit_btn = new JButton("\u63D0\u4EA4");
		submit_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*user=new User(user_txt.getText(),psd_txt.getText(),1);
				jdbc=new JDBC();
				try {
					conn=jdbc.getCon();
					if(user_txt.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "用户名不能为空！");										
					}
					else if(psd_txt.getText().equals(""))
						JOptionPane.showMessageDialog(null, "密码不能为空！");					
					else if(psd_txt.getText().length()< 6)
						JOptionPane.showMessageDialog(null, "密码不能少于6位！");
					else if(!psd_txt.getText().equals(rpsd_txt.getText()))
						JOptionPane.showMessageDialog(null, "两次输入密码不一致！");
					else if(RegisterDao.Register(conn, user)==1)
						JOptionPane.showMessageDialog(null, "注册成功");;
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally{
					try {
						conn.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}*/
				
				
			}
		});
		submit_btn.setName("submit_btn");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(104)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(rpsd_lab)
						.addComponent(psd_lab)
						.addComponent(user_lab))
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(submit_btn)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(user_txt, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
							.addComponent(psd_txt)
							.addComponent(rpsd_txt)))
					.addContainerGap(114, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(user_lab)
						.addComponent(user_txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(psd_lab)
						.addComponent(psd_txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(rpsd_lab)
						.addComponent(rpsd_txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
					.addComponent(submit_btn)
					.addGap(36))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

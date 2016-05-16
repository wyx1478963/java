package com.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.Dao.UserDao;
import com.model.User;
import com.util.JDBC;
import com.util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentMain extends JFrame {

	private JPanel contentPane;
	private JTextField user_txt;
	private JTextField psd_txt;
	//private JPasswordField psd_ptxt;
	

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentMain frame = new StudentMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void closeForm(){
		this.dispose();		
	}

	/**
	 * Create the frame.
	 */
	public StudentMain() {
		setTitle("\u5B66\u751F\u7BA1\u7406\u7CFB\u7EDF");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		final JLabel user_lab = new JLabel("\u7528\u6237\u540D");
		
		final JLabel psd_lab = new JLabel("\u5BC6\u7801");
		
		user_txt = new JTextField();
		user_txt.setColumns(10);
		psd_txt=new JTextField();		
		JButton login_btn = new JButton("\u767B\u5F55");
		login_btn.setName("login_btn");
		psd_txt.setName("psd_txt");
		user_txt.setName("user_txt");
		login_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JDBC jdbc=new JDBC();
				Connection conn=null;
				if(StringUtil.IsEmpty(user_txt.getText()))
				{
					JOptionPane.showMessageDialog(null, "用户名不能为空");
					return ;
				}
				/*if(StringUtil.IsEmpty(new String(psd_ptxt.getPassword())))
				{
					JOptionPane.showMessageDialog(null, "密码不能为空");
					return ;
					
				}
				User user=new User(user_txt.getText(),new String(psd_ptxt.getPassword()));*/
				if(StringUtil.IsEmpty(psd_txt.getText()))
				{
					JOptionPane.showMessageDialog(null, "密码不能为空");
					return ;
					
				}
				User user=new User(user_txt.getText(),psd_txt.getText());				
				try {
					conn = jdbc.getCon();
					User resultUser=UserDao.student_login(conn, user);
					User teacherUser=UserDao.teacher_login(conn, user);
					if(resultUser!=null)
					{
						if(resultUser.getType()==2)
						{
							JOptionPane.showMessageDialog(null, "登陆成功");
						    closeForm();
							new studentMainForm().setVisible(true);
						}
						
						
						
					}
					else if(teacherUser!=null)
					{
						JOptionPane.showMessageDialog(null, "教师登陆成功");
						closeForm();
						new TeacherMainForm().setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "用户名或密码错误");
					}
					} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					JDBC.closeConn(conn);
					
				}
				
			}
				
			
		});
		
		/*login_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				JDBC jdbc=new JDBC();
				Connection conn=null;
				if(StringUtil.IsEmpty(user_txt.getText()))
				{
					JOptionPane.showMessageDialog(null, "用户名不能为空");
					return ;
				}
				if(StringUtil.IsEmpty(new String(psd_ptxt.getPassword())))
				{
					JOptionPane.showMessageDialog(null, "密码不能为空");
					return ;
					
				}
				User user=new User(user_txt.getText(),new String(psd_ptxt.getPassword()));
								
				try {
					conn = jdbc.getCon();
					User resultUser=UserDao.student_login(conn, user);
					if(resultUser!=null)
					{
						JOptionPane.showMessageDialog(null, "登陆成功");
						closeForm();
						new studentMainForm().setVisible(true);;
						
					}
					else
					{
						JOptionPane.showMessageDialog(null, "用户名或密码错误");
					}
					} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					JDBC.closeConn(conn);
					
				}
				
			}
				
			
		});*/
		
		JButton reg_btn = new JButton("\u6CE8\u518C");
		reg_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Register().show();
			}
		});
		
		//psd_ptxt = new JPasswordField();
		//psd_txt=new JTextField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(71)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(login_btn)
							.addPreferredGap(ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
							.addComponent(reg_btn)
							.addGap(94))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(user_lab, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
								.addComponent(psd_lab))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(user_txt)
								.addComponent(psd_txt, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
							.addContainerGap(85, Short.MAX_VALUE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(49)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(user_lab)
						.addComponent(user_txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(psd_lab)
						.addComponent(psd_txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(58)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(reg_btn)
						.addComponent(login_btn))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}

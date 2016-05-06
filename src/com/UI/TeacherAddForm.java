package com.UI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

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

import com.Dao.CourseDao;
import com.model.Course;
import com.util.JDBC;
import com.util.StringUtil;

public class TeacherAddForm extends JFrame {

	private JPanel contentPane;
	private JTextField cid_txt;
	private JTextField cname_txt;
	private JTextField tid_txt;
	Connection conn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherAddForm frame = new TeacherAddForm();
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
	public TeacherAddForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel cid_lab = new JLabel("\u8BFE\u7A0B\u7F16\u53F7");
		
		JLabel cname_lab = new JLabel("\u8BFE\u7A0B\u540D\u79F0");
		
		JLabel tid_lab = new JLabel("\u6559\u5E08\u7F16\u53F7");
		
		JLabel add_lab = new JLabel("\u6DFB\u52A0\u8BFE\u7A0B");
		
		cid_txt = new JTextField();
		cid_txt.setColumns(10);
		
		cname_txt = new JTextField();
		cname_txt.setColumns(10);
		
		tid_txt = new JTextField();
		tid_txt.setColumns(10);
		
		JButton submit_btn = new JButton("submit");
		submit_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(StringUtil.IsEmpty(cid_txt.getText())||StringUtil.IsEmpty(tid_txt.getText())||StringUtil.IsEmpty(cname_txt.getText()))
					JOptionPane.showMessageDialog(null, "填写项不能为空");
				else
				{
					Integer cid=new Integer(cid_txt.getText());
					Integer tid=new Integer(tid_txt.getText());
					Course course=new Course();
					course.setCid(cid);
					course.setCname(cname_txt.getText());
					course.setTid(tid);
			
					try {
						conn=new JDBC().getCon();
						int flag=CourseDao.CourseAdd(conn, course);
						if(flag==0)
							JOptionPane.showMessageDialog(null, "添加失败");
						else{
							JOptionPane.showMessageDialog(null, "添加成功");
							cid_txt.setText("");
							cname_txt.setText("");
							tid_txt.setText("");
							conn.close();
							
						}
							
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}         
					
				}
				
				
				
			}
		});
		
		JButton reset_btn = new JButton("reset");
		reset_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cid_txt.setText("");
				tid_txt.setText("");
				cname_txt.setText("");
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(cid_lab)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(tid_lab)
								.addComponent(cname_lab))))
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(submit_btn)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(reset_btn)
							.addGap(110))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(cname_txt, Alignment.LEADING)
								.addComponent(tid_txt, Alignment.LEADING)
								.addComponent(cid_txt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
							.addGap(86))))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(188)
					.addComponent(add_lab)
					.addContainerGap(188, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(28)
					.addComponent(add_lab)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(cid_txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cid_lab))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(cname_txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cname_lab))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(tid_txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tid_lab))
					.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(reset_btn)
						.addComponent(submit_btn))
					.addGap(27))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

package com.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.Dao.CourseDao;
import com.model.Course;
import com.util.JDBC;

public class StudentSearchForm extends JFrame {

	private JPanel contentPane;
	private JTextField search_txt;
	private JTable search_tab;
	JDBC jdbc=new JDBC();
	CourseDao cd=new CourseDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentSearchForm frame = new StudentSearchForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private void fillTable(Course course){
		DefaultTableModel dtm=(DefaultTableModel)search_tab.getModel();
		dtm.setRowCount(0);
		Connection conn=null;
		try {
			conn=jdbc.getCon();
			ResultSet rs=cd.courseList(conn, course);
			while(rs.next())
			{
				Vector v=new Vector();
				v.add(rs.getInt("cid"));
				v.add(rs.getString("cname"));
				v.add(rs.getInt("tid"));
				dtm.addRow(v);
			}
			if(dtm.getRowCount()==0){
				JOptionPane.showMessageDialog(null,"课程尚未开设或输入有误");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				jdbc.closeConn(conn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}

	/**
	 * Create the frame.
	 */
	public StudentSearchForm() {
		setTitle("\u8BFE\u7A0B\u67E5\u8BE2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		search_txt = new JTextField();
		search_txt.setBounds(152, 46, 116, 21);
		contentPane.add(search_txt);
		search_txt.setColumns(10);
		
		JLabel search_lab = new JLabel("\u67E5\u8BE2\u8BFE\u7A0B");
		search_lab.setBounds(67, 49, 54, 15);
		contentPane.add(search_lab);
		
		JButton search_btn = new JButton("\u67E5\u8BE2");
		search_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String courseName=search_txt.getText();
				Course course=new Course();
				course.setCname(courseName);
				fillTable(course);
				
				
			}

		
		});
		search_btn.setBounds(278, 45, 93, 23);
		contentPane.add(search_btn);
		
		search_tab = new JTable();
		search_tab.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"cid", "cname", "tid"
			}
		));
		search_tab.setBounds(116, 109, 228, 132);
		contentPane.add(search_tab);
	}
}

package com.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class studentMainForm extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentMainForm frame = new studentMainForm();
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
	public studentMainForm() {
		setForeground(UIManager.getColor("Button.darkShadow"));
		setTitle("\u5B66\u751F\u767B\u9646\u6210\u529F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);//最大化显示
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
	
		JMenu menu = new JMenu("\u529F\u80FD");
		menuBar.add(menu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u8BFE\u7A0B\u67E5\u8BE2");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new StudentSearchForm().setVisible(true);
			}
		});
		menu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu = new JMenu("\u5173\u4E8E");
		menuBar.add(mnNewMenu);
	}

}

package test;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PanelChange extends JFrame implements ActionListener{
	
	JPanel oyaPanel;
	CardLayout layout;

	public static void main(String[] args) {
		PanelChange frame = new PanelChange();
		frame.setTitle("画面遷移テスト");
		frame.setSize(900,600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public PanelChange() {
		//panel1
		JPanel panel1 = new JPanel();
		JButton btn1 = new JButton("panel1");
		panel1.add(btn1);
		
		//panel2
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.DARK_GRAY);
		JButton btn2 = new JButton("panel2");
		panel2.add(btn2);
		
		//panel3
		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.LIGHT_GRAY);
		JButton btn3 = new JButton("panel3");
		panel3.add(btn3);
		
		//CardLayout用パネル
		oyaPanel = new JPanel();
		layout = new CardLayout();
		oyaPanel.setLayout(layout);
		
		oyaPanel.add(panel1,"panel1");
		oyaPanel.add(panel2,"panel2");
		oyaPanel.add(panel3,"panel3");
		
		//移動用ボタン
		JButton firstButton = new JButton("panel1");
		firstButton.addActionListener(this);
		firstButton.setActionCommand("panel1");
		
		JButton secondButton = new JButton("panel2");
		secondButton.addActionListener(this);
		secondButton.setActionCommand("panel2");
		
		JButton thirdButton = new JButton("panel3");
		thirdButton.addActionListener(this);
		thirdButton.setActionCommand("panel3");
		
		JPanel btnPanel = new JPanel();
		btnPanel.add(firstButton);
		btnPanel.add(secondButton);
		btnPanel.add(thirdButton);
		
		//oyaPanelと移動用ボタンをJFrameに配置
		Container contentPane = getContentPane();
		contentPane.add(oyaPanel,BorderLayout.CENTER);
		contentPane.add(btnPanel,BorderLayout.PAGE_END);
	}
	
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		layout.show(oyaPanel,cmd);
	}
}
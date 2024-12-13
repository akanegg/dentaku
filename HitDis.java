package jp.ac.meiseiu.stu.j225012.HitBlow;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;

public class HitDis extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HitDis frame = new HitDis();
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
	public HitDis() {
		setTitle("Hit&Blow");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 484, 276);
		contentPane.add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(12, 10, 460, 178);
		panel.add(table);
		
		textField = new JTextField();
		textField.setBounds(22, 215, 440, 35);
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 275, 484, 300);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBounds(0, 0, 484, 150);
		panel_1.add(buttonsPanel);
		buttonsPanel.setLayout(new GridLayout(3, 4, 0, 0));
		
		JButton b0 = new JButton("0");
		buttonsPanel.add(b0);
		
		JButton b1 = new JButton("1");
		buttonsPanel.add(b1);
		
		JButton b2 = new JButton("2");
		buttonsPanel.add(b2);
		
		JButton b3 = new JButton("3");
		buttonsPanel.add(b3);
		
		JButton b4 = new JButton("4");
		buttonsPanel.add(b4);
		
		JButton b5 = new JButton("5");
		buttonsPanel.add(b5);
		
		JButton b6 = new JButton("6");
		buttonsPanel.add(b6);
		
		JButton b7 = new JButton("7");
		buttonsPanel.add(b7);
		
		JButton b8 = new JButton("8");
		buttonsPanel.add(b8);
		
		JButton b9 = new JButton("9");
		buttonsPanel.add(b9);
		
		JButton bOk = new JButton("確定");
		buttonsPanel.add(bOk);
		
		JButton bDel = new JButton("削除");
		buttonsPanel.add(bDel);
		
		JButton bCle = new JButton("C");
		bCle.setBounds(0, 150, 484, 35);
		panel_1.add(bCle);
	}
}

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.UIManager;

public class GameGUI extends JFrame {

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
					GameGUI frame = new GameGUI();
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
	public GameGUI() {
		setBackground(Color.PINK);
		setTitle("High&Low");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		table.setForeground(new Color(255, 255, 255));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"0", "Number", "High", "Low"},
				{"1", null, null, null},
				{"2", null, null, null},
				{"3", null, null, null},
				{"4", null, null, null},
				{"5", null, null, null},
				{"6", null, null, null},
				{"7", null, null, null},
				{"8", null, null, null},
				{"9", null, null, null},
				{"10", null, null, null},
			},
			new String[] {
				"Count", "Number", "High", "Low"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(0).setMinWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(1).setMinWidth(60);
		table.getColumnModel().getColumn(2).setPreferredWidth(60);
		table.getColumnModel().getColumn(2).setMinWidth(40);
		table.getColumnModel().getColumn(3).setPreferredWidth(60);
		table.getColumnModel().getColumn(3).setMinWidth(40);
		table.setBackground(new Color(51, 102, 102));
		contentPane.add(table, BorderLayout.NORTH);
		
        //文字を中央揃えにする
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        
        // JTableの行高さを設定
        table.setRowHeight(25);

        contentPane.add(table, BorderLayout.NORTH);
        
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(SystemColor.window);
        buttonsPanel.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
        contentPane.add(buttonsPanel, BorderLayout.SOUTH);
        buttonsPanel.setLayout(new GridLayout(2, 6, 0, 0));
        
        JButton b0 = new JButton("0");
        b0.setBackground(UIManager.getColor("Button.light"));
        b0.setFont(new Font("OCR A Extended", Font.BOLD, 15));
        b0.setVerticalAlignment(SwingConstants.BOTTOM);
        buttonsPanel.add(b0);
        
        JButton b1 = new JButton("1");
        b1.setBackground(UIManager.getColor("Button.light"));
        b1.setFont(new Font("OCR A Extended", Font.BOLD, 15));
        b1.setVerticalAlignment(SwingConstants.BOTTOM);
        buttonsPanel.add(b1);
        
        JButton b2 = new JButton("2");
        b2.setBackground(UIManager.getColor("Button.light"));
        b2.setFont(new Font("OCR A Extended", Font.BOLD, 15));
        b2.setVerticalAlignment(SwingConstants.BOTTOM);
        buttonsPanel.add(b2);
        
        JButton b3 = new JButton("3");
        b3.setBackground(UIManager.getColor("Button.light"));
        b3.setFont(new Font("OCR A Extended", Font.BOLD, 15));
        b3.setVerticalAlignment(SwingConstants.BOTTOM);
        buttonsPanel.add(b3);
        
        JButton b4 = new JButton("4");
        b4.setBackground(UIManager.getColor("Button.light"));
        b4.setFont(new Font("OCR A Extended", Font.BOLD, 15));
        b4.setVerticalAlignment(SwingConstants.BOTTOM);
        buttonsPanel.add(b4);
        
        JButton bCheck = new JButton("確定");
        bCheck.setBackground(UIManager.getColor("Button.light"));
        bCheck.setFont(new Font("HGS明朝B", Font.PLAIN, 15));
        bCheck.setVerticalAlignment(SwingConstants.BOTTOM);
        buttonsPanel.add(bCheck);
        
        JButton b5 = new JButton("5");
        b5.setBackground(UIManager.getColor("Button.light"));
        b5.setFont(new Font("OCR A Extended", Font.BOLD, 15));
        b5.setVerticalAlignment(SwingConstants.BOTTOM);
        buttonsPanel.add(b5);
        
        JButton b6 = new JButton("6");
        b6.setBackground(UIManager.getColor("Button.light"));
        b6.setFont(new Font("OCR A Extended", Font.BOLD, 15));
        b6.setVerticalAlignment(SwingConstants.BOTTOM);
        buttonsPanel.add(b6);
        
        JButton b7 = new JButton("7");
        b7.setBackground(UIManager.getColor("Button.light"));
        b7.setFont(new Font("OCR A Extended", Font.BOLD, 15));
        b7.setVerticalAlignment(SwingConstants.BOTTOM);
        buttonsPanel.add(b7);
        
        JButton b8 = new JButton("8");
        b8.setBackground(UIManager.getColor("Button.light"));
        b8.setFont(new Font("OCR A Extended", Font.BOLD, 15));
        b8.setVerticalAlignment(SwingConstants.BOTTOM);
        buttonsPanel.add(b8);
        
        JButton b9 = new JButton("9");
        b9.setBackground(UIManager.getColor("Button.light"));
        b9.setFont(new Font("OCR A Extended", Font.BOLD, 15));
        b9.setVerticalAlignment(SwingConstants.BOTTOM);
        buttonsPanel.add(b9);
        
        JButton bDelete = new JButton("削除");
        bDelete.setBackground(UIManager.getColor("Button.light"));
        bDelete.setFont(new Font("HGS明朝B", Font.PLAIN, 15));
        bDelete.setVerticalAlignment(SwingConstants.BOTTOM);
        buttonsPanel.add(bDelete);
        
        textField = new JTextField();
        contentPane.add(textField, BorderLayout.CENTER);
        textField.setColumns(20);
        
        contentPane.add(textField, BorderLayout.CENTER);
        
        
	}

}

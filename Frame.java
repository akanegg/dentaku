package test;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Frame {
	private JFrame frame;
	private JTextArea dis1, dis2;
	//private Buttons buttons;
	//private HBgame hbgame;
	
	public Frame() {
		//game = new HBGame();
		board();
	}
	
	private void board() {
		
		frame = new JFrame("Hit&Blow Game"); //上のタイトル文字的な
		//frame.setSize(700,900);
		//下テスト用
		frame.setSize(400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//上×ゲーム終了
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		//履歴パネルの作成
		//dis1 = new JTextArea(20,50); 
		dis1 = new JTextArea(10,30); //十行三十列
		dis1.setEditable(false);
		JScrollPane scrollPane1 = new JScrollPane(dis1);
		panel.add(scrollPane1);
		
		//数字入力パネルの作成
		dis2 = new JTextArea(1,30); //十行三十列
		dis2.setEditable(false);
		JScrollPane scrollPane2 = new JScrollPane(dis2);
		panel.add(scrollPane2);
		
		//ボタンパネルの作成
		//buttons = new Buttons(game,dis1,dis2);
		//panel.add(buttons.getPanel());
		
		frame.add(panel);
		frame.setVisible(true);
	}
}
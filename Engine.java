package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

public class Engine implements ActionListener {
	
	private JTextArea dis2;

	public Engine(JTextArea dis22) {
		this.dis2 = dis22;
	}

	public void actionPerformed(ActionEvent e) {
	    String key = e.getActionCommand();
	    String text = dis2.getText();  // 既存のテキストを取得

	    System.out.println(key); // コンソールに表示
	    dis2.setText(text);  // 計算機に表示される

	    // 数字ボタンが押された場合
	    if (key.charAt(0) >= '0' && key.charAt(0) <= '9') {
	        // 現在のテキストが3桁未満であれば、数字を追加
	        if (text.length() < 3) {
	            text += key;  // 現在のテキストに新しい数字を追加
	            System.out.println("***" + key + " " + text + "?");
	        }
	        dis2.setText(text);  // 更新されたテキストを表示
	    }
	    
	}
	

}


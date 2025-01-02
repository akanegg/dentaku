package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

public class Engine implements ActionListener {
	

	private HBgame game;
	private JTextArea dis1;
	private JTextArea dis2;

	public Engine(HBgame game, JTextArea dis1, JTextArea dis2) {
		this.game = game;
		this.dis1 = dis1;
		this.dis2 = dis2;
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
	    
	    //確定機能
	    if (key.equals("確定")) {
	        if (text.length() == 3) {
	            String result = game.check(text);
	            dis1.append(result);
	            dis2.setText("");  // 入力欄をリセット
	        }
	    }
	    
	    //削除機能
	    if (key.equals("削除")) {
	        if (text.length() > 0) {
	            text = text.substring(0, text.length() - 1);  // 最後の文字を削除
	            dis2.setText(text);  // 更新されたテキストを表示
	        }
	    }
	    
	    //クリア機能
	    
	}
	
}


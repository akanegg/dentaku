package test2;
import java.awt.Font;

import javax.swing.*;

public class SelectPanel {

	public static void main(String[] args) {
		
		//選択画面の作成
		JFrame frame = new JFrame("SelectPanel");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,400);
		frame.setLocationRelativeTo(null);
		
		//テキストの表示
		JLabel label = new JLabel("<html><div style = 'text-align: center;'>"
				+"<span style = 'font-size: 40px; color: #008080;'>選択画面</span><br>"
				+"</div></html>", SwingConstants.CENTER);
		frame.add(label);
		
		/*
		  ("<html><div style='text-align: center;'>"
                + "<span style='font-size: 40px; color: #008080;'>Hit & Blow</span><br>"
                + "</div></html>", SwingConstants.CENTER);
		 */
		
		frame.setVisible(true);

	}

}

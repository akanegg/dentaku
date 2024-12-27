package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

public class Engine implements ActionListener {
	
	private JTextArea dis2;

	public Engine(JTextArea dis22) {
		this.dis2 = dis22;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String key = e.getActionCommand();
		String text = "";
		
		System.out.println(key);//コンソールに表示される
		dis2.setText(text);//計算機に表示される
		
		if(key.charAt(0) >= '0' && key.charAt(0) <= '9') {
			text = dis2.getText() + key;
			System.out.println("***" + key + " " + text + "?");
				
			dis2.setText(text);
			
		}
		dis2.setText(text);	
	}
	
	

}


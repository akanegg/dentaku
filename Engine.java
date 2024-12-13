package jp.ac.meiseiu.stu.j225012.HitBlow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class Engine implements ActionListener {
	
	private JTextField dis1;

	public Engine(JTextField dis1) {
		this.dis1 = dis1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String key = e.getActionCommand();
		String text = "";
		
		System.out.println(key); //コンソールに表示される
		dis1.setText(text); //計算機に表示される
		
	}
	
	

}


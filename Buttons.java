package test;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Buttons extends JPanel {
	 private HBgame game;
	 private JTextArea dis1, dis2;
	 private Engine engine;

    public Buttons(HBgame game, JTextArea dis1, JTextArea dis2) {
    	this.game = game;
    	this.dis1 = dis1;
    	this.dis2 = dis2;
    	shoki();
    }
    
    private void shoki() {
    	
        setLayout(new GridLayout(3, 4, 0, 0));

        // 数字ボタンを作成
        JButton b0 = new JButton("0");
        add(b0);

        JButton b1 = new JButton("1");
        add(b1);

        JButton b2 = new JButton("2");
        add(b2);

        JButton b3 = new JButton("3");
        add(b3);

        JButton b4 = new JButton("4");
        add(b4);

        JButton b5 = new JButton("5");
        add(b5);

        JButton b6 = new JButton("6");
        add(b6);

        JButton b7 = new JButton("7");
        add(b7);

        JButton b8 = new JButton("8");
        add(b8);

        JButton b9 = new JButton("9");
        add(b9);

        JButton bOk = new JButton("確定");
        add(bOk);

        JButton bDel = new JButton("削除");
        add(bDel);
        
        engine = new Engine(game, dis1, dis2);
        b0.addActionListener(engine);
		b1.addActionListener(engine);
		b2.addActionListener(engine);
		b3.addActionListener(engine);
		b4.addActionListener(engine);
		b5.addActionListener(engine);
		b6.addActionListener(engine);
		b7.addActionListener(engine);
		b8.addActionListener(engine);
		b9.addActionListener(engine);
		bOk.addActionListener(engine);
		bDel.addActionListener(engine);
        
    }
    
    
    
    public JPanel getPanel() {
        return this;
    }
}

package test2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Title extends JPanel {

    public Title(Change change) {
        setLayout(new BorderLayout());

        // タイトル画面のパネルを作成
        CustomPanel titlePanel = new CustomPanel();
        titlePanel.setLayout(new BorderLayout());

        // タイトルラベル
        JLabel label = new JLabel("<html><div style='text-align: center;'>"
                + "<span style='font-size: 40px; color: #008080;'>Hit & Blow</span><br>"
                + "</div></html>", SwingConstants.CENTER);
        label.setFont(new Font("OCR A Extended", Font.BOLD, 24));
        label.setOpaque(true);
        label.setBackground(new Color(255, 255, 255, 180)); // 半透明の背景色
        titlePanel.add(label, BorderLayout.CENTER);

        // ボタンパネル
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        // Startボタン
        JButton startButton = new JButton("Start");
        startButton.setFont(new Font("OCR A Extended", Font.BOLD, 20));
        buttonPanel.add(startButton);
        
        // Game Rulesボタン
        JButton optionButton = new JButton("Game Rules");
        optionButton.setFont(new Font("OCR A Extended", Font.BOLD, 20));
        buttonPanel.add(optionButton);

        titlePanel.add(buttonPanel, BorderLayout.SOUTH);

        // Startボタンのアクションリスナー
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // ゲーム画面に切り替え
            	change.showScreen("GameGUI");
            }
        });
        
     // Game Rulesボタンのアクションリスナー
        optionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // GameRulesPanelに切り替え
            	change.showScreen("Rules");
            }
        });


        add(titlePanel);
    }

    // カスタムパネルクラス
    static class CustomPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // 背景色
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());

            // ランダムな数字を散りばめる
            Random rand = new Random();
            for (int i = 0; i < 60; i++) {
                int x = rand.nextInt(getWidth());
                int y = rand.nextInt(getHeight());
                int fontSize = 30 + rand.nextInt(70);
                g.setFont(new Font("Arial", Font.BOLD, fontSize));
                g.setColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
                g.drawString(String.valueOf(rand.nextInt(10)), x, y);
            }
        }
    }
}

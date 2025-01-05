import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Title {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        // JFrame
        JFrame frame = new JFrame("High and Low");
        frame.setSize(550, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // タイトル画面のパネル
        JPanel titlePanel = createTitlePanel(frame);

        frame.getContentPane().add(titlePanel);
        frame.setVisible(true);
    }

    public static JPanel createTitlePanel(JFrame frame) {
        // タイトル画面のパネル
        CustomPanel titlePanel = new CustomPanel();
        titlePanel.setLayout(new BorderLayout());

        // JLabel
        JLabel label = new JLabel("<html>"
                + "<div style='text-align: center;'>"
                + "<span style='font-size: 40px; color: #008080;'>Hit & Blow</span><br>"
                + "</div>"
                + "</html>", SwingConstants.CENTER);
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
                JPanel gamePanel = createGamePanel(frame);
                frame.setContentPane(gamePanel);
                frame.revalidate();
                frame.repaint();
            }
        });

        // Game Rulesボタンのアクションリスナー
        optionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // GameRulesPanelに切り替え
                JPanel optionPanel = new GameRulesPanel(frame);
                frame.setContentPane(optionPanel);
                frame.revalidate();
                frame.repaint();
            }
        });

        return titlePanel;
    }

    // ゲーム画面を作成するメソッド
    private static JPanel createGamePanel(JFrame frame) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.LIGHT_GRAY);

        // ラベル
        JLabel label = new JLabel("Game Screen", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 36));
        label.setForeground(Color.BLACK);
        panel.add(label, BorderLayout.CENTER);

        // 戻るボタン
        JButton backButton = new JButton("Back to Title");
        backButton.setFont(new Font("OCR A Extended", Font.BOLD, 20));
        panel.add(backButton, BorderLayout.SOUTH);

        // 戻るボタンのアクションリスナー
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // タイトル画面に戻る
                JPanel titlePanel = createTitlePanel(frame);
                frame.setContentPane(titlePanel);
                frame.revalidate();
                frame.repaint();
            }
        });

        return panel;
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
            for (int i = 0; i < 60; i++) { // 50個の数字を描画
                int x = rand.nextInt(getWidth());
                int y = rand.nextInt(getHeight());
                int fontSize = 30 + rand.nextInt(70); // フォントサイズをランダム化
                g.setFont(new Font("Arial", Font.BOLD, fontSize));
                g.setColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256))); // ランダムな色
                g.drawString(String.valueOf(rand.nextInt(10)), x, y); // ランダムな数字を描画
            }
        }
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameRulesPanel extends JPanel {

    public GameRulesPanel(JFrame frame) {
        setLayout(new BorderLayout());
        
        // 背景色を変更（ライトブルーに設定）
        setBackground(new Color(173, 216, 230));  // Light Blue

        // ラベルの設定
        JLabel label = new JLabel("<html><div style='text-align: center;'>"
                + "<h1 style='color: #00008B;'>Game Rules</h1>"  // タイトルの色変更
                + "<p style='color: #2F4F4F;'>1. Rule 1: Do this.</p>"  // ルール1の文字色
                + "<p style='color: #2F4F4F;'>2. Rule 2: Avoid that.</p>"  // ルール2の文字色
                + "<p style='color: #2F4F4F;'>3. Rule 3: Have fun!</p>"  // ルール3の文字色
                + "</div></html>", SwingConstants.CENTER);
        
        // フォントを変更（Arial, 24px、太字）
        label.setFont(new Font("Arial", Font.BOLD, 24));  
        label.setForeground(new Color(0, 0, 139));  // 文字色（濃い青）

        add(label, BorderLayout.CENTER);

        // 戻るボタンの設定
        JButton backButton = new JButton("Back to Title");
        
        // ボタンのフォントと色変更
        backButton.setFont(new Font("Tahoma", Font.BOLD, 20));  // フォントを変更
        backButton.setBackground(new Color(70, 130, 180));  // ボタン背景色（スチールブルー）
        backButton.setForeground(Color.WHITE);  // ボタン文字色（白）
        backButton.setFocusPainted(false);  // ボタンのフォーカスを消す
        
        // ボタンのホバー時の色変更
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backButton.setBackground(new Color(100, 149, 237));  // ホバー時の色（コーンフラワーブルー）
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backButton.setBackground(new Color(70, 130, 180));  // 通常時の色に戻す
            }
        });

        add(backButton, BorderLayout.SOUTH);

        // 戻るボタンのアクションリスナー
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // タイトル画面に戻る
                JPanel titlePanel = Title.createTitlePanel(frame);
                frame.setContentPane(titlePanel);
                frame.revalidate();
                frame.repaint();
            }
        });
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameRulesPanel extends JPanel {

    public GameRulesPanel(JFrame frame) {
        setLayout(new BorderLayout());
        
        // 背景色を変更（ライトブルーに設定）
        setBackground(new Color(224, 255, 255));  // Light Blue

        // ラベルの設定
        JLabel label = new JLabel("<html><div style='text-align: center;'>"
                + "<h1 style='color: #00008B;'>Game Rules</h1>"  // タイトルの色変更
                + "<p style='color: #2F4F4F;'>Hit&Blowは、数字の組み合わせを推理して当てるゲームです。</p>" 
                + "<p style='color: #2F4F4F;'>正解の数字の組み合わせを10回以内に当てることが出来たらクリアとなります。</p>" 
                + "<p style='color: #2F4F4F;'>セレクト画面で桁数を選び、重複のないｎ桁の数字が設定されます。</p>"
                + "<p style='color: #2F4F4F;'>プレイヤーは、正解だと思うｎ桁の数字を１回ずつ予想します。</p>" 
                + "<p style='color: #2F4F4F;'>予想した数字に対して、以下のヒントが返されます。</p>"
                + "<p style='color: #2F4F4F;'>・Hit : 数字と位置が正しい場合　　　 　　　　　 </p>"
                + "<p style='color: #2F4F4F;'>・Blow: 数字は正しいが、位置が間違っている場合</p>"
                + "<p style='color: #2F4F4F;'>例）正解が「123」で予想が「135」の場合、</p>"
                + "<p style='color: #2F4F4F;'>Hitは１つ「1」、Blowは１つ「3」になります。</p>"
                + "<p style='color: #2F4F4F;'>ヒントをもとに、次の予想を考え、これを繰り返すことで正解を導きましょう。</p>"
                + "<p style='color: #2F4F4F;'>すべての数字と位置を正確に当てるとクリアです。</p>"
                + "</div></html>", SwingConstants.CENTER);
        
        // フォントを変更（Arial, 24px、太字）
        label.setFont(new Font("OCR A Extended", Font.BOLD, 19));  
        label.setForeground(new Color(0, 0, 139));  // 文字色（濃い青）

        add(label, BorderLayout.CENTER);

        // 戻るボタンの設定
        JButton backButton = new JButton("Back to Title");
        
        // ボタンのフォントと色変更
        backButton.setFont(new Font("OCR A Extended", Font.BOLD, 24));  // フォントを変更
        backButton.setBackground(new Color(224, 255, 255));  // ボタン背景色（スチールブルー）
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

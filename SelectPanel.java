import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class SelectPanel extends JPanel {

    public SelectPanel(Change change) {

        // 戻るボタン
        JButton backButton = new JButton("Back to Title");
        backButton.setBounds(0, 395, 585, 40);
        backButton.setFont(new Font("OCR A Extended", Font.BOLD, 24));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // タイトル画面に戻る
                change.showScreen("Title");
            }
        });
        setLayout(null);
        add(backButton);
        
        // 背景色
        setBackground(new Color(224, 255, 255));
        
        JButton btn1 = new JButton("２ケタ　簡単！");
        btn1.setFont(new Font("HGSｺﾞｼｯｸE", Font.PLAIN, 20));
        btn1.setBounds(163, 70, 251, 50);
        add(btn1);
        
        JButton btn2 = new JButton("３ケタ　おすすめ！");
        btn2.setFont(new Font("HGSｺﾞｼｯｸE", Font.PLAIN, 20));
        btn2.setBounds(163, 163, 251, 50);
        add(btn2);
        
        JButton btn3 = new JButton("４ケタ　難しい！");
        btn3.setFont(new Font("HGSｺﾞｼｯｸE", Font.PLAIN, 20));
        btn3.setBounds(163, 258, 251, 50);
        add(btn3);
        
        JLabel Label = new JLabel("コース選択");
        Label.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 20));
        Label.setBounds(235, 10, 179, 33);
        add(Label);
        
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                change.showScreen2("GameGUI", 2); // 2桁のゲーム開始
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                change.showScreen2("GameGUI", 3); // 3桁のゲーム開始
            }
        });

        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                change.showScreen2("GameGUI", 4); // 4桁のゲーム開始
            }
        });

    }
}

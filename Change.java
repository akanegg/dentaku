import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Change {
    private JFrame frame;
    private JPanel cardPanel;

    public Change() {
        frame = new JFrame("Hit and Blow");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 470);

        // CardLayout を設定
        cardPanel = new JPanel(new CardLayout());
        frame.getContentPane().add(cardPanel);

        // 各画面を作成
        Title title = new Title(this);
        GameGUI gamegui = new GameGUI(this, 0);
        GameRulesPanel rules = new GameRulesPanel(this);
        SelectPanel select = new SelectPanel(this);
        

        // フレームにパネルを追加
        cardPanel.add(title, "Title");
        cardPanel.add(gamegui, "GameGUI");
        cardPanel.add(rules, "Rules");
        cardPanel.add(select,"Select");

        // 初期画面をタイトル画面に設定
        showScreen("TitleScreen");

        frame.setVisible(true);
    }

    // 画面を切り替えるメソッド
    public void showScreen(String screenName) {
        CardLayout cl = (CardLayout) cardPanel.getLayout();
        cl.show(cardPanel, screenName);
    }
    
    public void showScreen2(String screenName, int digit) {
        if ("GameGUI".equals(screenName)) {
            cardPanel.remove(1); // GameGUIの位置を削除
            cardPanel.add(new GameGUI(this, digit), "GameGUI"); // 新しい桁数で再生成
        }
        showScreen(screenName);
    }


    public JFrame getFrame() {
        return frame;
    }
    public static void main(String[] args) {
        new Change();
    }

}

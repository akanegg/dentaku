package test2;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Change {
    private JFrame frame;
    private JPanel cardPanel;

    public Change() {
        frame = new JFrame("High and Low");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 470);

        // CardLayout を設定
        cardPanel = new JPanel(new CardLayout());
        frame.getContentPane().add(cardPanel);

        // 各画面を作成
        Title title = new Title(this);
        GameGUI gamegui = new GameGUI(this);
        GameRulesPanel rules = new GameRulesPanel(this);

        // フレームにパネルを追加
        cardPanel.add(title, "Title");
        cardPanel.add(gamegui, "GameGUI");
        cardPanel.add(rules, "Rules");

        // 初期画面をタイトル画面に設定
        showScreen("TitleScreen");

        frame.setVisible(true);
    }

    // 画面を切り替えるメソッド
    public void showScreen(String screenName) {
        CardLayout cl = (CardLayout) cardPanel.getLayout();
        cl.show(cardPanel, screenName);
    }

    public JFrame getFrame() {
        return frame;
    }
    public static void main(String[] args) {
        new Change();
    }

}

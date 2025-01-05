package test2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class Engine implements ActionListener {

    private HBgame game;
    private JLabel dis;  // dis1を削除し、dis2のみを使用
    private GameGUI gui;

    public Engine(HBgame game, JLabel dis, GameGUI gui) {
        this.game = game;
        this.dis = dis;
        this.gui = gui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String key = e.getActionCommand();
        String text = dis.getText();  // 既存のテキストを取得

        System.out.println(key); // コンソールに表示
        dis.setText(text);  // 計算機に表示される

        // 数字ボタンが押された場合
        if (key.charAt(0) >= '0' && key.charAt(0) <= '9') {
            if (text.length() < 3) {
                text += key;  // 現在のテキストに新しい数字を追加
            }
            dis.setText(text);  // 更新されたテキストを表示
        }

        // 確定機能
        if (key.equals("確定")) {
            if (text.length() == 3) {
                String result = game.check(text);
                dis.setText(result);  // 結果をdis2に表示
                dis.setText("");  // 入力欄をリセット

                // テーブルに結果を更新
                int count = game.getCount();
                if (count <= 10) {  // 最大ターン数は10
                    String number = text;
                    int hit = game.getHit();  // ゲームクラスからヒット数
                    int blow = game.getBlow();    // ゲームクラスからブロー数
                    gui.updateTable(count, number, hit, blow);
                }
            }
        }

        // 削除機能
        if (key.equals("削除")) {
            if (text.length() > 0) {
                text = text.substring(0, text.length() - 1);  // 最後の文字を削除
                dis.setText(text);  // 更新されたテキストを表示
            }
        }
    }
}

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public class Engine implements ActionListener {

    private HBgame game;
    private JLabel dis;
    private GameGUI gui;
    private int digitCount; // 桁数を表すフィールド

    public Engine(HBgame game, JLabel dis, GameGUI gui) {
        this.game = game;
        this.dis = dis;
        this.gui = gui;
        this.digitCount = game.getketa(); // HBgameから桁数を取得
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String key = e.getActionCommand();
        String text = dis.getText();  // 現在のテキストを取得

        // 数字ボタンが押された場合
        if (key.charAt(0) >= '0' && key.charAt(0) <= '9') {
            if (text.length() < digitCount) { // 指定された桁数以内に制限
                text += key;  // 新しい数字を追加
            }
            dis.setText(text);  // 更新されたテキストを表示
        }

        // 確定機能
        if (key.equals("確定")) {
            if (text.length() == digitCount) { // 桁数が正確に一致している場合
                String result = game.check(text);
                dis.setText(result);  // 結果を表示
                dis.setText("");  // 入力欄をリセット

                // テーブルに結果を更新
                int count = game.getCount();
                if (count <= 10) {  // 最大ターン数を制限
                    String number = text;
                    int hit = game.getHit();
                    int blow = game.getBlow();
                    gui.updateTable(count, number, hit, blow);
                }

                // ヒットが桁数分になった場合、クリア画面に遷移
                if (game.getHit() == digitCount) {
                    gui.showClearScreen();
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

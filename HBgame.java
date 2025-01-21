import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HBgame {

    private String player2Num;  // コンピュータが選んだ数字
    private int keta;          // ゲームで使用する桁数
    private int count;          // プレイヤーの試した回数
    private int hit;            // ヒットの数
    private int blow;           // ブローの数
    
    public int getketa() {
        return keta;
    }
    
    public HBgame(int digit) {
        this.keta = digit; 
        startGame(); 
    }

    // ゲーム開始
    public void startGame() {
        player2Num = player2();
        count = 0;
        hit = 0;
        blow = 0;
        
     // デバッグ用
        System.out.println("Player2 Number: " + player2Num);
    }

    // 重複しない桁数の数字を生成
    private String player2() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            list.add(i);
        }
        Collections.shuffle(list);

        StringBuilder number = new StringBuilder();
        for (int i = 0; i < keta; i++) { // digit を使用
            number.append(list.get(i));
        }

        return number.toString();
    }

    public String check(String player1) {
        count++;
        hit = 0;
        blow = 0;

        // 入力が桁数と一致しない場合の処理
        if (player1.length() != keta) {
            return "入力は " + keta + " 桁の数字にしてください。\n";
        }

        // HitとBlowを計算
        for (int i = 0; i < keta; i++) {
            if (player1.charAt(i) == player2Num.charAt(i)) {
                hit++;  // 数字と位置が一致
            } else if (player2Num.indexOf(player1.charAt(i)) != -1) {
                blow++;  // 数字は一致するが位置が違う
            }
        }

        if (hit == keta) {
            return "おめでとう！" + (count - 1) + "ターン 答えは: " + player2Num + "でした\n";
        }

        if (count == 10 && hit != keta) {
            return "残念！答えは: " + player2Num + " でした\n";
        }

        return count + "ターン: " + player1 + " -> " + hit + " Hit, " + blow + " Blow\n";
    }

    public int getCount() {
        return count;
    }

    public int getHit() {
        return hit;
    }

    public int getBlow() {
        return blow;
    }

    public String getPlayer2Num() {
        return player2Num;
    }
}

package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HBgame {
	private String player2Num;  // コンピュータが選んだ3桁の数字
    private int count;  // プレイヤーの試した回数

    public HBgame() {
        startGame();
    }

    // ゲーム開始
    public void startGame() {
    	player2Num = player2();
    	count = 0;
    }

    // 重複しない3桁の数字を生成
    private String player2() {
        List<Integer> list = new ArrayList<Integer>();
        // 0〜9の数字をリストに追加
        for (int i = 0; i <= 9; i++) {
        	list.add(i);
        }

        // ランダムにシャッフル
        Collections.shuffle(list);

        // 最初の3つの数字を選んで、3桁の数字を作成
        String number = "";
        for (int i = 0; i < 3; i++) {
            number += list.get(i);
        }

        return number.toString();
    }

    public String check(String player1) {
    	
    	count++;

        int hit = 0;
        int blow = 0;

        // HitとBlowを計算
        for (int i = 0; i < 3; i++) {
            if (player1.charAt(i) == player2Num.charAt(i)) {
                hit++;  // 数字と位置が一致
            } else if (player2Num.indexOf(player1.charAt(i)) != -1) {
                blow++;  // 数字は一致するが位置が違う
            }
        }

        // 結果を返す
        if (hit == 3) {
            return "おめでとう！" + (count-1) + "ターン 答えは: " + player2Num + "でした\n";
        }
        return count + "ターン" + ": " + player1 + " -> " + hit + " Hit, " + blow + " Blow\n";
    }

    // 正解のターゲット番号を返す
    public String getPlayer2Num() {
        return player2Num;
    }
}



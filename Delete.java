//入力ボタンを非表示にするクラス

//0の時は押せる(通常)　1の時は押せない(非表示)
class Delete {

    int mode;
    int num;
    
    //引数ありコンストラクタ(インスタンス生成時に実行される)
    public Delete(int num){
        this.num = num;
    }

    public void mode(){
        mode = 1;
    }
    
}

/*
public class Delete {

    //mainクラス
    public static void main(String[] args) {

        int num = 0; //削除モードで押した数字
        
        //インスタンス(オブジェクト)の生成　　(コンストラクタの呼び出し)
        Deletetest test = new Deletetest(num);
    }

}*/

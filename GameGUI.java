import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class GameGUI extends JPanel {
	
	private JPanel clearPanel;
	private JPanel failurePanel;
	private JPanel buttonsPanel;
	
    private static final long serialVersionUID = 1L;
    private JTable table;
    private JLabel dis;   
    private HBgame game;
    

    public GameGUI(Change change, int keta) {
        setLayout(null); 
        
     // ゲームインスタンス作成
        game = new HBgame(keta);   //桁数を引数とする    
        String correctAnswer = game.getPlayer2Num(); 
        
     // ゲームクリアのパネルを作成
        clearPanel = new JPanel();
        clearPanel.setBounds(0, 0, 649, 470);
        clearPanel.setLayout(null);
        

        JLabel clearLabel = new JLabel("おめでとう!  " + correctAnswer + "でした。", SwingConstants.CENTER);
        clearLabel.setFont(new Font("HGS明朝B", Font.PLAIN, 35));
        clearLabel.setForeground(Color.BLACK);
        clearLabel.setBounds(90, 200, 450, 50);
        clearPanel.add(clearLabel);
        
        // 初期状態ではクリア画面を非表示
        clearPanel.setVisible(false);

        add(clearPanel);
        
     // ゲーム失敗のパネルを作成
        failurePanel = new JPanel();
        failurePanel.setBounds(0, 0, 649, 470);
        failurePanel.setLayout(null);

        JLabel failureLabel = new JLabel("残念！ 答えは" + correctAnswer + "でした。", SwingConstants.CENTER);
        failureLabel.setFont(new Font("HGS明朝B", Font.PLAIN, 35));
        failureLabel.setForeground(Color.BLACK);
        failureLabel.setBounds(90, 200, 450, 50);
        failurePanel.add(failureLabel);

       // タイトルへ戻るボタン
        JButton failureBackButton = new JButton("難易度選択へ戻る");
        failureBackButton.setBounds(151, 337, 297, 50);
        failureBackButton.setBackground(Color.WHITE);
        failureBackButton.setForeground(new Color(102, 153, 153));
        failureBackButton.setFont(new Font("HGP明朝B", Font.BOLD, 28));
        failureBackButton.setBorderPainted(false);
        failureBackButton.setFocusPainted(false);
        failureBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.startGame(); // ゲームデータを初期化
                resetGUI();       // GUI要素を初期化
                change.showScreen("Select");
            }
        });
        failurePanel.add(failureBackButton);

        // 初期状態では失敗画面を非表示
        failurePanel.setVisible(false);
        add(failurePanel);

        
        JButton backButton = new JButton("難易度選択へ戻る");
        backButton.setBounds(151, 337, 297, 50);
        backButton.setBackground(new Color(255, 255, 255)); // 深い青色
        backButton.setForeground(new Color(102, 153, 153));            // 白文字
        backButton.setFont(new Font("HGP明朝B", Font.BOLD, 28));
        backButton.setBorderPainted(false); // ボタンの枠線を非表示
        backButton.setFocusPainted(false); // フォーカス時の枠線を非表示
        
        for (ActionListener al : backButton.getActionListeners()) {
            backButton.removeActionListener(al);
        } //actionlistenerが重複しないように調整
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.startGame(); // ゲームデータを初期化してタイトルに戻る
                resetGUI();       // GUI要素を初期化
                change.showScreen("Select");
            }
        });
        clearPanel.add(backButton);
        
        

        // テーブル作成
        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {
                {"0", "Number", "Hit", "Blow"},
                {"1", null, null, null},
                {"2", null, null, null},
                {"3", null, null, null},
                {"4", null, null, null},
                {"5", null, null, null},
                {"6", null, null, null},
                {"7", null, null, null},
                {"8", null, null, null},
                {"9", null, null, null},
                {"10", null, null, null},
            },
            new String[] {
                "Count", "Number", "Hit", "Blow"
            }
        ));

        table.setFont(new Font("OCR A Extended", Font.BOLD, 15));
        table.setForeground(Color.WHITE);
        table.setBackground(new Color(51, 102, 102));
        table.setRowHeight(25);
        table.getColumnModel().getColumn(0).setPreferredWidth(15);
        table.getColumnModel().getColumn(1).setPreferredWidth(90);
        table.getColumnModel().getColumn(2).setPreferredWidth(60);
        table.getColumnModel().getColumn(3).setPreferredWidth(60);

        // セルの中央揃え
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

        add(table);
        table.setBounds(10, 10, 560, 275);

        // 結果表示用
        dis = new JLabel();
        dis.setHorizontalAlignment(SwingConstants.CENTER);
        dis.setBounds(10, 290, 560, 25);
        dis.setFont(new Font("Arial", Font.PLAIN, 18));

        // 背景色を白に設定
        dis.setBackground(Color.WHITE);
        dis.setOpaque(true);

        add(dis);

        // ボタンの作成とアクション設定
        buttonsPanel = new JPanel();
        buttonsPanel.setBackground(SystemColor.window);
        buttonsPanel.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
        add(buttonsPanel, BorderLayout.SOUTH);
        buttonsPanel.setLayout(new GridLayout(2, 6, 0, 0));
        buttonsPanel.setBounds(10, 320, 560, 70);
        
        JButton b0 = new JButton("0");
        b0.setBackground(UIManager.getColor("Button.light"));
        b0.setFont(new Font("OCR A Extended", Font.BOLD, 15));
        b0.setVerticalAlignment(SwingConstants.BOTTOM);
        buttonsPanel.add(b0);
        
        JButton b1 = new JButton("1");
        b1.setBackground(UIManager.getColor("Button.light"));
        b1.setFont(new Font("OCR A Extended", Font.BOLD, 15));
        b1.setVerticalAlignment(SwingConstants.BOTTOM);
        buttonsPanel.add(b1);
        
        JButton b2 = new JButton("2");
        b2.setBackground(UIManager.getColor("Button.light"));
        b2.setFont(new Font("OCR A Extended", Font.BOLD, 15));
        b2.setVerticalAlignment(SwingConstants.BOTTOM);
        buttonsPanel.add(b2);
        
        JButton b3 = new JButton("3");
        b3.setBackground(UIManager.getColor("Button.light"));
        b3.setFont(new Font("OCR A Extended", Font.BOLD, 15));
        b3.setVerticalAlignment(SwingConstants.BOTTOM);
        buttonsPanel.add(b3);
        
        JButton b4 = new JButton("4");
        b4.setBackground(UIManager.getColor("Button.light"));
        b4.setFont(new Font("OCR A Extended", Font.BOLD, 15));
        b4.setVerticalAlignment(SwingConstants.BOTTOM);
        buttonsPanel.add(b4);
        
        JButton bCheck = new JButton("確定");
        bCheck.setBackground(UIManager.getColor("Button.light"));
        bCheck.setFont(new Font("HGS明朝B", Font.PLAIN, 15));
        bCheck.setVerticalAlignment(SwingConstants.BOTTOM);
        buttonsPanel.add(bCheck);
        
        JButton b5 = new JButton("5");
        b5.setBackground(UIManager.getColor("Button.light"));
        b5.setFont(new Font("OCR A Extended", Font.BOLD, 15));
        b5.setVerticalAlignment(SwingConstants.BOTTOM);
        buttonsPanel.add(b5);
        
        JButton b6 = new JButton("6");
        b6.setBackground(UIManager.getColor("Button.light"));
        b6.setFont(new Font("OCR A Extended", Font.BOLD, 15));
        b6.setVerticalAlignment(SwingConstants.BOTTOM);
        buttonsPanel.add(b6);
        
        JButton b7 = new JButton("7");
        b7.setBackground(UIManager.getColor("Button.light"));
        b7.setFont(new Font("OCR A Extended", Font.BOLD, 15));
        b7.setVerticalAlignment(SwingConstants.BOTTOM);
        buttonsPanel.add(b7);
        
        JButton b8 = new JButton("8");
        b8.setBackground(UIManager.getColor("Button.light"));
        b8.setFont(new Font("OCR A Extended", Font.BOLD, 15));
        b8.setVerticalAlignment(SwingConstants.BOTTOM);
        buttonsPanel.add(b8);
        
        JButton b9 = new JButton("9");
        b9.setBackground(UIManager.getColor("Button.light"));
        b9.setFont(new Font("OCR A Extended", Font.BOLD, 15));
        b9.setVerticalAlignment(SwingConstants.BOTTOM);
        buttonsPanel.add(b9);
        
        JButton bDelete = new JButton("削除");
        bDelete.setBackground(UIManager.getColor("Button.light"));
        bDelete.setFont(new Font("HGS明朝B", Font.PLAIN, 15));
        bDelete.setVerticalAlignment(SwingConstants.BOTTOM);
        buttonsPanel.add(bDelete);
        
        Engine engine = new Engine(game, dis,this);
        b0.addActionListener(engine);
		b1.addActionListener(engine);
		b2.addActionListener(engine);
		b3.addActionListener(engine);
		b4.addActionListener(engine);
		b5.addActionListener(engine);
		b6.addActionListener(engine);
		b7.addActionListener(engine);
		b8.addActionListener(engine);
		b9.addActionListener(engine);
		bCheck.addActionListener(engine);
		bDelete.addActionListener(engine);
		
	
		
    }
    
    private void resetGUI() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for (int i = 1; i <= 10; i++) {
            model.setValueAt(null, i, 1);
            model.setValueAt(null, i, 2);
            model.setValueAt(null, i, 3);
        }
        

        dis.setText("");        
        String correctAnswer = game.getPlayer2Num(); 
        JLabel clearLabel = (JLabel) clearPanel.getComponent(0); // clearPanel の最初のコンポーネントを取得
        clearLabel.setText("おめでとう!  " + correctAnswer + "でした。"); // 新しい正解番号を設定
                
        clearPanel.setVisible(false);
        table.setVisible(true);
        buttonsPanel.setVisible(true);
    }
    

    // テーブルの更新メソッド
    public void updateTable(int count, String number, int hit, int blow) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setValueAt(count, count, 0);
        model.setValueAt(number, count, 1);
        model.setValueAt(hit, count, 2);
        model.setValueAt(blow, count, 3);
    }
    public void showClearScreen() {
        clearPanel.setVisible(true);  // クリア画面を表示
        table.setVisible(false);
        buttonsPanel.setVisible(false);
    }   
    public void showFailureScreen() {
        failurePanel.setVisible(true); // 失敗画面を表示
        table.setVisible(false);
        buttonsPanel.setVisible(false);
    }
}

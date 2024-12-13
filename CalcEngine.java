package jp.ac.meiseiu.stu.j225124.SwingCalc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class CalcEngine implements ActionListener {

	private JTextField displayField;
	private int count = 0; //suji count
	private int count2 = 0; //enzan count
	private String suuji = null;
	private String kigou = null;
	private int num1 = 0;
	private int num2 = 0;

	public CalcEngine(JTextField displayField) { //hyoujimado kakikae
		this.displayField = displayField;
	}

	@Override //keisan
	public void actionPerformed(ActionEvent e) { //action de yobidasi
		String key = e.getActionCommand(); //key syutoku

		//System.out.println(key);
		
		if (key.matches("[0-9]")) {
			if (count > 0 && suuji == "0") {
				suuji = key; //0 kesite suuji uwagaki	
			}
			if (count == 0) {
				suuji = key;
				count++;
			} else {
				suuji += key; //suuji renketu	
				count++;
			}			
			displayField.setText(suuji);
			
			
		
		}else if (key == "+" || key == "-" || key == "x" || key == "/"){
			displayField.setText(key);
			kigou = key; //kigou kakunou
			if (count2 == 0) {
				num1 = Integer.parseInt(suuji);
				suuji = null;
			}
			//System.out.println("num1:" + suuji);
			count = 0; //count reset
			
		} else if (key == "=" ){
			if (suuji != null) {
				num2 = Integer.parseInt(suuji);
				if (kigou == "+") {
					num1 += num2;
				} else if (kigou == "-") {
					num1 -= num2;
				} else if (kigou == "x") {
					num1 *= num2;
				} else if (kigou == "/") {
					num1 /= num2;
				}
				displayField.setText(String.valueOf(num1));
				count2 = 1;
			}
			
		} else if (key == "C"){ //C notoki
			num1 = 0;
			num2 = 0;
			count = 0;
			count2 = 0;
			suuji = null;
			kigou = null;
			displayField.setText(String.valueOf(num1));
		} else {
			System.out.println("error");
			System.exit(1);
		}
		
		
		
		
	}

}

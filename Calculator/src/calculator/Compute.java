package calculator;

import javax.swing.JLabel;

public class Compute {
	int nextExpected;
	int op;
	double hold;
	
	public Compute() {
		nextExpected = -1;
	}
	
	public static void Insert(String bit, JLabel ans, Compute calc) {
		if((ans.getText()).length() == 0 && bit.equals("0")) {
			return;
		}
		
		if(calc.nextExpected == -1) {
			calc.nextExpected = 0;
		}else if(calc.nextExpected == 1) {
			calc.nextExpected = 2;
		}
		
		///////////////////////////////////////////////////////////////////
		if((ans.getText()).contains(".") && bit.equals(".")) {
			return;
			
		///////////////////////////////////////////////////////////////////	
		}else {
			ans.setText(ans.getText() + bit);
			
		}
	}
	
	public static void Operate(String bit, JLabel ans, Compute calc) {
		///////////////////////////////////////////////////////////////////
		if(bit.equals("C")) {
			ans.setText("");
			calc.nextExpected = -1;
			
		///////////////////////////////////////////////////////////////////
		}else if(bit.equals("Del") && (ans.getText()).length() > 0) {
			String chunk = ans.getText();
			chunk = chunk.substring(0, chunk.length() - 1);
			ans.setText(chunk);
			if(chunk.length() == 0) {
				calc.nextExpected = -1;
			}
			
		///////////////////////////////////////////////////////////////////
		}else if(bit.equals("=")) {
			if(calc.nextExpected != 2) {
				return;
			}
			
			double temp = Double.parseDouble(ans.getText());
			calc.nextExpected = 0;
			
			if(calc.op == 0) {
				calc.hold = calc.hold + temp;
				ans.setText(Double.toString(calc.hold));
			}else if(calc.op == 1) {
				calc.hold = calc.hold - temp;
				ans.setText(Double.toString(calc.hold));
			}else if(calc.op == 2) {
				calc.hold = calc.hold * temp;
				ans.setText(Double.toString(calc.hold));
			}else if(calc.op == 3) {
				calc.hold = calc.hold / temp;
				ans.setText(Double.toString(calc.hold));
			}
			
			
		///////////////////////////////////////////////////////////////////
		}else if(bit.equals("+")) {
			if(calc.nextExpected != 0) {
				return;
			}
			calc.op = 0;
			calc.nextExpected = 1;
			calc.hold = Double.parseDouble(ans.getText());
			ans.setText("");
			
		///////////////////////////////////////////////////////////////////
		}else if(bit.equals("-")) {
			if(calc.nextExpected != 0) {
				return;
			}
			calc.op = 1;
			calc.nextExpected = 1;
			calc.hold = Double.parseDouble(ans.getText());
			ans.setText("");
			
		///////////////////////////////////////////////////////////////////	
		}else if(bit.equals("*")) {
			if(calc.nextExpected != 0) {
				return;
			}
			calc.op = 2;
			calc.nextExpected = 1;
			calc.hold = Double.parseDouble(ans.getText());
			ans.setText("");
			
		///////////////////////////////////////////////////////////////////
		}else if(bit.equals("/")) {
			if(calc.nextExpected != 0) {
				return;
			}
			calc.op = 3;
			calc.nextExpected = 1;
			calc.hold = Double.parseDouble(ans.getText());
			ans.setText("");
			
		}
	}
}

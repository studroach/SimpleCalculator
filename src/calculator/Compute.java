package calculator;

import javax.swing.JLabel;

public class Compute {
	//initializes important variables for the state machine
	int nextExpected;	// -1/0/1/2
	int op;				// 0/1/2/3
	double hold;		//calculator memory
	
	public Compute() {
		nextExpected = -1;	//initialize state machine
	}
	
	public static void Insert(String bit, JLabel ans, Compute calc) {	//inserts into the text field
		if((ans.getText()).length() == 0 && bit.equals("0")) {		//no leading zeros
			return;
		}
		
		//state machine transitions
		if(calc.nextExpected == -1) {
			calc.nextExpected = 0;
		}else if(calc.nextExpected == 1) {
			calc.nextExpected = 2;
		}
		
		//no double decimals
		if((ans.getText()).contains(".") && bit.equals(".")) {
			return;
			
		///////////////////////////////////////////////////////////////////	
		}else {
			ans.setText(ans.getText() + bit);
			
		}
	}
	
	public static void Operate(String bit, JLabel ans, Compute calc) {		//operation
		//Clear button
		if(bit.equals("C")) {
			ans.setText("");
			calc.nextExpected = -1;
			
		//Backspace button
		}else if(bit.equals("Del") && (ans.getText()).length() > 0) {
			String chunk = ans.getText();
			chunk = chunk.substring(0, chunk.length() - 1);
			ans.setText(chunk);
			if(chunk.length() == 0) {
				calc.nextExpected = -1;
			}
			
		//Equals
		}else if(bit.equals("=")) {
			if(calc.nextExpected != 2) {
				return;
			}
			
			//converting text box into double
			double temp = Double.parseDouble(ans.getText());
			calc.nextExpected = 0;
			
			//calculations
			if(calc.op == 0) {	//checks operator
				calc.hold = calc.hold + temp;		//does operation
				ans.setText(Double.toString(calc.hold));	//displays answer
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
			
			
		//Plus
		}else if(bit.equals("+")) {
			if(calc.nextExpected != 0) {	//checks state
				return;
			}
			calc.op = 0;	//sets operator
			calc.nextExpected = 1;
			calc.hold = Double.parseDouble(ans.getText());	//puts text box in memory
			ans.setText("");	//then wipes text box
			
		//Minus
		}else if(bit.equals("-")) {
			if(calc.nextExpected != 0) {
				return;
			}
			calc.op = 1;
			calc.nextExpected = 1;
			calc.hold = Double.parseDouble(ans.getText());
			ans.setText("");
			
		//Multiply
		}else if(bit.equals("*")) {
			if(calc.nextExpected != 0) {
				return;
			}
			calc.op = 2;
			calc.nextExpected = 1;
			calc.hold = Double.parseDouble(ans.getText());
			ans.setText("");
			
		//Divide
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

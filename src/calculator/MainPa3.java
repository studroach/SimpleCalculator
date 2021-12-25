////////////////////////////////////////////////////////////////////////
//Jake Castedo
//CSE 223
//PA3
//May 16, 2019
//This program is a basic calculator with plus, minus, multiplication, 
//and division of data type doubles. The program wont let you use it 
//for anything that isn't the standard <number> <operator> <number> 
//and =. The program also won't let you start a number with 0, 
//eliminating divide by zero errors.

package calculator;

public class MainPa3 {

	public static void main(String[] args) {
		Compute Calc = new Compute();		//starts the brain of the calculator
		new GuiInit(Calc);				//creates the GUI
		
	}

}

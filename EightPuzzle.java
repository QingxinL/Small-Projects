import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**	Simple Eight Puzzle - 9 buttons, change the text on the button every time we click it 
 * 
 * @author Lee
 *Null Pointer Exception!!! - 
 *- buttonList is an array, should be declared and initialized in the class scope
 *- if we just have JButton[][] buttonList in class scope and initialize that in the constructor 
 *- we would have null pointer exception since the first buttonList is point to one object but 
 *- the one in the constructor is point to another array 
 *- if we declare and initialize the array in the constructor 
 *- that can not be achieved in the event class (or the array in the class scope and the one in constructor 
 *- are not pointing to the same object) 
 *- solution would be declare and initialized the array in the class scope with default value
 *- and change (Add) buttons into the array in the constructor 
 *
 */


public class EightPuzzle extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EightPuzzle ep = new EightPuzzle();
		ep.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ep.setVisible(true);
		ep.setSize(300,300);
	}
	
	JButton button1, button2, button3, button4, button5, button6, button7, button8, button9;
	//a list of list [matrix] contain all buttons:
	JButton [][]buttonList=new JButton[3][3];
	
	
	//constructor:
	public EightPuzzle(){
		
		setLayout(new GridLayout(3,3)); //3*3

		//add nine buttons with one is the blank one 
		// *** JButton in the front is not necessary! 
		JButton button1 = new JButton("1"); 
		add(button1);
		JButton button2 = new JButton("2");
		add(button2);
		JButton button3 = new JButton("3");
		add(button3);
		JButton button4 = new JButton("4");
		add(button4);
		JButton button5 = new JButton("5");
		add(button5);
		JButton button6 = new JButton("6");
		add(button6);
		JButton button7 = new JButton("7");
		add(button7);
		JButton button8 = new JButton("8");
		add(button8);
		JButton button9 = new JButton("");
		add(button9);
		buttonList[0][0]=button1;
		buttonList[0][1]=button2;
		buttonList[0][2]=button3;
		buttonList[1][0]=button4;
		buttonList[1][1]=button5;
		buttonList[1][2]=button6;
		buttonList[2][0]=button7;
		buttonList[2][1]=button8;
		buttonList[2][2]=button9;
		
		
		Event switchText = new Event();
		
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
			buttonList[i][j].addActionListener(switchText);
		}
	
	}

} // end of constructor 
	public class Event implements ActionListener{
		public void actionPerformed(ActionEvent switchText){
			// switch the text between the blank space and the button clicked 
			for(int i=0; i<3; i++){
				for(int j=0; j<3; j++){
				
					
					if(buttonList[i][j]==switchText.getSource()){
					
					String text = buttonList[i][j].getText(); ////NULL POINTER EXCEPTION 
				
					if(i+1<3 && buttonList[i+1][j].getText().equals("")){
						buttonList[i][j].setText("");
						buttonList[i+1][j].setText(text);
					}
					else if (i-1>=0 && buttonList[i-1][j].getText().equals("")){
						buttonList[i][j].setText("");
						buttonList[i-1][j].setText(text);
					}
					else if (j+1<3 && buttonList[i][j+1].getText().equals("")){
						buttonList[i][j].setText("");
						buttonList[i][j+1].setText(text);
					}
					else if (j-1>=0 && buttonList[i][j-1].getText().equals("")){
						buttonList[i][j].setText("");
						buttonList[i][j-1].setText(text);
					}	
					}
				}
			
				}// end of for loop
			
		}
	}
	
	// shuffle 

}

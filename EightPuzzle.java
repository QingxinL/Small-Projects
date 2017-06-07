import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;


public class EightPuzzle extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EightPuzzle ep = new EightPuzzle();
		ep.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ep.setVisible(true);
		ep.pack();
	}
	
	private JButton button1, button2, button3, button4, button5, button6, button7, button8, button9;
	//a list of list [matrix] contain all buttons:
	JButton[][] buttonList;
	
	//constructor:
	public EightPuzzle(){
		
		setLayout(new GridLayout(3,3,5,5)); //3*3

		//add nine buttons with one is the blank one 
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
		
		JButton [][]buttonList = {{button1, button2, button3}, 
					{button4, button5, button6},
					{button7, button8, button9}};
		Event switchText = new Event();
		
		//put the following into a method that throws exception 
		//and if i+1, i-1, j+1, j-1 out of bound, it throws message like you cannot move it 
	
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				buttonList[i][j].setEnabled(false); //set all buttons not working 
				// check if the button is next to the blank button
				// if is next to the blank button, set that button working 
				if(buttonList[i+1][j].getText().equals("")
						|| buttonList[i-1][j].getText().equals("")
						|| buttonList[i][j+1].getText().equals("")
						|| buttonList[i][j-1].getText().equals("")){
					buttonList[i][j].setEnabled(true);
				}
			
			buttonList[i][j].addActionListener(switchText);
		}
	
	}

} // end of constructor 
	public class Event implements ActionListener{
		public void actionPerformed(ActionEvent e){
			// switch the text between the blank space and the button clicked 
			for(int i=0; i<3; i++){
				for(int j=0; j<3; j++){
					
					if(buttonList[i][j].isEnabled()==true){
					String text = buttonList[i][j].getText();
					buttonList[i][j].setText("");
		
					if(buttonList[i+1][j].getText().equals("")){
						buttonList[i+1][j].setText(text);
					}
					else if (buttonList[i-1][j].getText().equals("")){
						buttonList[i-1][j].setText(text);
					}
					else if (buttonList[i][j+1].getText().equals("")){
						buttonList[i][j+1].setText(text);
					}
					else if (buttonList[i][j-1].getText().equals("")){
						buttonList[i][j-1].setText(text);
					}	
					}
				}
			}// end of for loop
			
		}
	}
	
}

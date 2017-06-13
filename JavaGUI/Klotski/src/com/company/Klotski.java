package com.company;
/*
	First attempt: use buttons like in EightPuzzlePicture and fill the buttons with pictures&texts
				- need GridBagLayout to resize buttons but they are not automatically resized when the user
					change the size of the frame, and the images look bad cause they are not clear enough.
				- buttons need action listener and event class, which is hard to control because different button
					need to move differently, the grid x and grid y (their locations) need to be changed according
					to the buttons, and this would cause they might need to be associated with different events

	Second attempt: use JPanel and Graphics
					- Try to draw 11 rectangles, fill them with customized color and text - WITHOUT BUTTON INVOLVE
					- Need Mouse Listener or Key Listener instead of Action Listener which is used for buttons
					- the class extends JPanel
 */




import java.awt.*;
import javax.swing.*;

public class Klotski extends JFrame  {
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Klotski kl = new Klotski();
		kl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		kl.setSize(800,1000);
		kl.setVisible(true);
	}
	
	//Buttons&Images&Labels: 张飞，曹操，马超，赵云，关羽，黄忠，卒1&2&3&4，空格
	

	//constructor:
	public Klotski() {



	}
	public void paintComponent (Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0,0,200,100);
		g2d.drawString("This is a test",5,10);

	}


	/*
	switch:
	change the grid x & grid y
	*/

}
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

public class Klotski extends JPanel  {
	 JFrame frame;



	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Klotski kl = new Klotski();
	kl.window();

	}

	public void window(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(400,500);
		frame.add(this);

	}



	//Components: 张飞，曹操，马超，赵云，关羽，黄忠，卒1&2&3&4，空格
	


	public void paintComponent (Graphics g){
		g.setColor(Color.CYAN);
		paintRect(g);
		g.setColor(Color.MAGENTA);
		drawStrings(g);
	}

	// paint all the rectangles
	public void paintRect (Graphics g){
		g.fillRoundRect(0,0,100,200,20,20);
		g.fillRoundRect(100,0,200,200,20,20);
		g.fillRoundRect(300,0,100,200,20,20);
		g.fillRoundRect(0,200,100,200,20,20);
		g.fillRoundRect(100,200,200,100,20,20);
		g.fillRoundRect(300,200,100,200,20,20);
		g.fillRoundRect(100,300,100,100,20,20);
		g.fillRoundRect(200,300,100,100,20,20);
		g.fillRoundRect(0,400,100,100,20,20);
		g.fillRoundRect(300,400,100,100,20,20);
	}

	// draw all strings
	public void drawStrings (Graphics g){
		g.drawString("张飞", 50,100);
		g.drawString("曹操", 200,100);
		g.drawString("马超",350,100);

	}
	/*
	switch:
	change the grid x & grid y
	*/

}
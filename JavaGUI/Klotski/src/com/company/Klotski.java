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

					Failed the first time - need to put 11 rectangles into an array
					* How to control the Mouse Listener:
					- First time: try to switch the color (paint) between the click one and the blank one

 */

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class Klotski extends JPanel  {
	JFrame frame;
	Color wood = new Color(222,184,135);
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
		super.paintComponent(g);
//		Graphics2D g2 = (Graphics2D)g;
//		g2.setColor(Color.BLACK);
//		g2.setStroke(new BasicStroke(5));
//		drawRect(g2);

		g.setColor(wood);
		paintRect(g);
		g.setColor(Color.BLACK);
		g.setFont(new Font("TimesRoman",Font.BOLD,30));
		drawStrings(g);
	}
//	public void drawRect (Graphics g){
//		g.drawRoundRect(0,0,100,200,20,20);
//		g.drawRoundRect(100,0,200,200,20,20);
//		g.drawRoundRect(300,0,100,200,20,20);
//		g.drawRoundRect(0,200,100,200,20,20);
//		g.drawRoundRect(100,200,200,100,20,20);
//		g.drawRoundRect(300,200,100,200,20,20);
//		g.drawRoundRect(100,300,100,100,20,20);
//		g.drawRoundRect(200,300,100,100,20,20);
//		g.drawRoundRect(0,400,100,100,20,20);
//		g.drawRoundRect(300,400,100,100,20,20);
//	}

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
		g.drawString("张飞", 20,100);
		g.drawString("曹操", 170,100);
		g.drawString("马超",320,100);
		g.drawString("赵云",20,300);
		g.drawString("关羽",170,250);
		g.drawString("黄忠",320,300);
		g.drawString("卒",30,450);
		g.drawString("卒",130,350);
		g.drawString("卒",230,350);
		g.drawString("卒",330,450);

	}
	/*
	Mouse Listener
	constructor
	*/
	public Klotski() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int x = e.getX();
				int y = e.getY();


			}
		});
	}


}
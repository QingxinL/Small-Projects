package com.company;

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
	
	JButton button1,button2,button3,button4,button5,button6,button7,button8,button9,button10,blank;
	ImageIcon zf,cc,mc,zy,gy,hz,z;

	//constructor:
	public Klotski(){
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		zf = new ImageIcon(getClass().getResource("zf [www.imagesplitter.net].jpeg"));
		cc = new ImageIcon(getClass().getResource("cc [www.imagesplitter.net].jpeg"));
		mc = new ImageIcon(getClass().getResource("mc [www.imagesplitter.net].jpeg"));
		zy = new ImageIcon(getClass().getResource("zy [www.imagesplitter.net].jpeg"));
		gy = new ImageIcon(getClass().getResource("gy [www.imagesplitter.net].jpeg"));
		hz = new ImageIcon(getClass().getResource("hz [www.imagesplitter.net].jpeg"));
		z = new ImageIcon(getClass().getResource("z [www.imagesplitter.net].jpeg"));



		c.fill=GridBagConstraints.BOTH;
		c.weightx=0.5;
		c.weighty=0.5;
		
		/*how to make button1 & button4 the same height! - weight!
		weight: the extra space put between the cell and the edge of its container
		in this case, the container is the width&height you specify
		
		in other words, when you do not get the height and width on appearance
		you may need to put more extra space by specifying the weight (increase weight -> put more space)
		*/

		c.weighty=1;
		button1 = new JButton(zf);
		c.gridx = 0;
		c.gridy = 0; 
		c.gridheight=2;
		c.gridwidth=1;
		add(button1, c);
		
		button2 = new JButton(cc);
		c.gridx = 1;
		c.gridy = 0; 
		c.gridwidth=2;
		c.gridheight=2;
		add(button2, c);
		
		button3 = new JButton(mc);
		c.gridx = 3;
		c.gridy = 0; 
		c.gridheight=2;
		c.gridwidth=1;
		add(button3, c);
		
		c.weightx=0.5;
		c.weighty=0.5;
		
		button4 = new JButton(zy);
		c.gridx=0;
		c.gridy=2;
		c.gridheight=2;
		c.gridwidth=1;
		add(button4,c);
		
		button5 = new JButton(gy);
		c.gridx=1;
		c.gridy=2;
		c.gridheight=1;
		c.gridwidth=2;
		add(button5,c);
		
		button6 = new JButton(hz);
		c.gridx=3;
		c.gridy=2;
		c.gridheight=2;
		c.gridwidth=1;
		add(button6,c);
		
		button7 = new JButton(z);
		c.gridx=1;
		c.gridy=3;
		c.gridheight=1;
		c.gridwidth=1;
		add(button7,c);
		
		button8 = new JButton(z);
		c.gridx=2;
		c.gridy=3;
		c.gridheight=1;
		c.gridwidth=1;
		add(button8,c);
		
		button9 = new JButton(z);
		c.gridx=0;
		c.gridy=4;
		c.gridheight=1;
		c.gridwidth=1;
		add(button9,c);
		
		button10 = new JButton(z);
		c.gridx=3;
		c.gridy=4;
		c.gridheight=1;
		c.gridwidth=1;
		add(button10,c);
		
		blank = new JButton("");
		c.gridx=1;
		c.gridy=4;
		c.gridheight=1;
		c.gridwidth=2;
		add(blank,c);
	}

	/*
	switch:
	change the grid x & grid y
	*/

}
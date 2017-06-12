import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class EightPuzzlePicture extends JFrame  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EightPuzzlePicture ep = new EightPuzzlePicture();
		ep.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ep.setVisible(true);
		ep.setSize(500,500);
	}

	//a list of list [matrix] contain all buttons:
	JButton [][]buttonList=new JButton[3][3];
	ImageIcon part1,part2,part3,part4,part5,part6,part7,part8,part9;
	ArrayList<ImageIcon>imageList = new ArrayList<ImageIcon>(9);
	JButton shuffleButton;
//	JPanel p; 
	
	//create an arrayList holding all texts of buttons 
	public void listRefill(){
//		for(int i=0; i<9; i++){
//		imageList.add(images[i]);
//		}
		imageList.add(part1);
		imageList.add(part2);
		imageList.add(part3);
		imageList.add(part4);
		imageList.add(part5);
		imageList.add(part6);
		imageList.add(part7);
		imageList.add(part8);
		imageList.add(part9);
		
			}
	
	//constructor:
	public EightPuzzlePicture(){
		setLayout(new GridLayout(4,3)); //3*3
		
		//add a panel
//		JPanel p = new JPanel(new GridLayout(4,3));
//		p.setOpaque(true);
//		p.setSize(500,500);
		
		// get images in:
		part1 = new ImageIcon(getClass().getResource("image1-0-0.jpeg"));
		part2 = new ImageIcon(getClass().getResource("image1-0-1.jpeg"));
		part3 = new ImageIcon(getClass().getResource("image1-0-2.jpeg"));
		part4 = new ImageIcon(getClass().getResource("image1-1-0.jpeg"));
		part5 = new ImageIcon(getClass().getResource("image1-1-1.jpeg"));
		part6 = new ImageIcon(getClass().getResource("image1-1-2.jpeg"));
		part7 = new ImageIcon(getClass().getResource("image1-2-0.jpeg"));
		part8 = new ImageIcon(getClass().getResource("image1-2-1.jpeg"));
		part9 = new ImageIcon(getClass().getResource("image1-2-2.jpeg"));
		
		listRefill();
		
		Event switchText = new Event();
		Event2 shuffle = new Event2();
		//add nine buttons with one is the blank one 
		// *** JButton in the front is not necessary! 	
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
			
				if(i==0){
					buttonList[i][j]=new JButton(imageList.get(j));
				}
				else if (i==1){
					buttonList[i][j]=new JButton(imageList.get(3+j));
				}
				else{
					buttonList[i][j]=new JButton(imageList.get(6+j));
				}
				add(buttonList[i][j]);
				//use image as button:
				buttonList[i][j].setBorder(BorderFactory.createEmptyBorder());
				buttonList[i][j].setContentAreaFilled(false);
				
				buttonList[i][j].addActionListener(switchText);
				
			
			}
		}

		
		JButton shuffleButton = new JButton("Shuffle!");
		add(shuffleButton);
		shuffleButton.addActionListener(shuffle);

} // end of constructor 
	public class Event implements ActionListener{
		public void actionPerformed(ActionEvent switchText){
			// switch the text between the blank space and the button clicked 
			for(int i=0; i<3; i++){
				for(int j=0; j<3; j++){
			
					if(buttonList[i][j]==switchText.getSource()){
					
					ImageIcon img = (ImageIcon) buttonList[i][j].getIcon(); ////NULL POINTER EXCEPTION 
				
					if(i+1<3 && buttonList[i+1][j].getIcon().equals(part9)){
						buttonList[i][j].setIcon(part9);
						buttonList[i+1][j].setIcon(img);
					}
					else if (i-1>=0 && buttonList[i-1][j].getIcon().equals(part9)){
						buttonList[i][j].setIcon(part9);
						buttonList[i-1][j].setIcon(img);
					}
					else if (j+1<3 && buttonList[i][j+1].getIcon().equals(part9)){
						buttonList[i][j].setIcon(part9);
						buttonList[i][j+1].setIcon(img);
					}
					else if (j-1>=0 && buttonList[i][j-1].getIcon().equals(part9)){
						buttonList[i][j].setIcon(part9);
						buttonList[i][j-1].setIcon(img);
					}	
					}
				}
			
				}// end of for loop
		} //end of switchText actionPerformed method
		
	}
	public class Event2 implements ActionListener{
		// Shuffle method
				// Associate every button with a random element from textList
				// Then remove that element from textList - so no repeat element would be chosen 
				public void actionPerformed(ActionEvent shuffle){
					int randomIndex;
					ImageIcon randomImage;
					for(int i=0; i<3; i++){
						for(int j=0; j<3; j++){
							randomIndex = (int)(Math.random()*imageList.size());
							randomImage = imageList.get(randomIndex);
							buttonList[i][j].setIcon(randomImage);
							imageList.remove(randomImage);
						}
					}
					listRefill();
				}
	}
	
}

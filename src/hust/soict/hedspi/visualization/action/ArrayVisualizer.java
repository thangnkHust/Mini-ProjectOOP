package hust.soict.hedspi.visualization.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;

public class ArrayVisualizer {
	private int num;
	JLabel[] lbArrays;
	int[] array;
	
	// Connstructor --> create array visualization
	public ArrayVisualizer(JPanel pnImitiate, JSpinner spNum) {
//		method delete
		
		num = (Integer)spNum.getValue();
		
		lbArrays = new JLabel[num];
		array = new int[num];
		
		for (int i = 0; i < num; i++) {
			
			//create label, set text "0"
			lbArrays[i] = new JLabel("0");
			array[i] = 0;
			pnImitiate.add(lbArrays[i]);
			lbArrays[i].setText(String.valueOf(array[i]));
			
			//set size label
			lbArrays[i].setSize(50,50);
			lbArrays[i].setOpaque(true);
			lbArrays[i].setForeground(Color.blue);
			
			//set location label
			if (i == 0)
				lbArrays[i].setLocation(((int) ((18 - num) * 0.5) * 70) + 100, 150);
			else
				lbArrays[i].setLocation(lbArrays[i-1].getX() + 70, 150);
			
			//set fonts
			lbArrays[i].setFont(new Font("Tahoma", Font.PLAIN, 30));
			
			//set background color
			lbArrays[i].setBackground(SystemColor.inactiveCaption);
			//set text alignment center
			lbArrays[i].setHorizontalAlignment(SwingConstants.CENTER); 
			lbArrays[i].setVerticalAlignment(SwingConstants.CENTER);
		}
                
//                pnImitiate.add(lbPoint1);
//                pnImitiate.add(lbPoint2);
//                pnImitiate.add(lbPointM);
                
		pnImitiate.setVisible(true);
		pnImitiate.validate();
		pnImitiate.repaint();
//		setState(1);
	}
	
	public void deleteArray(JPanel pnImitiate) {
		for (int i = 0; i < num; i++) {
			lbArrays[i].setText("0");
			array[i] = 0;
			lbArrays[i].setVisible(false);
			pnImitiate.remove(lbArrays[i]);
		}
                
//                lbPoint1.setText("");
//                lbPoint2.setText("");
//                lbPointM.setText("");
//                pnImitiate.remove(lbPoint1);
//                pnImitiate.remove(lbPoint2);
//                pnImitiate.remove(lbPointM);
		
//		for (int i = 0; i < curT; i++) {
//			try {
//					threads[i].interrupt();
//			} 
//			catch (Exception e) {
//				
//			}
//		}
//		curT = -1;
		
		pnImitiate.revalidate();
		pnImitiate.repaint();
//		setState(0);
	}
	
	public void createRandom(JPanel pnImitiate) {
		Random rand = new Random();
		for (int i = 0; i < num; i++) {
			int ranNum = rand.nextInt(101) + 0;
			lbArrays[i].setText(String.valueOf(ranNum));
			lbArrays[i].setForeground(Color.BLUE);
			array[i] = ranNum;
		}
		pnImitiate.setVisible(true);
		pnImitiate.validate();
		pnImitiate.repaint();
//		setState(2);
	}
}

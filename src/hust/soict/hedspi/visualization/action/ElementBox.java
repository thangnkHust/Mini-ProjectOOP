package hust.soict.hedspi.visualization.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ElementBox {
	private JLabel label;
	private int value;
	
	public JLabel getLabel() {
		return label;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public ElementBox() {
		label = new JLabel("0");
		value = 0;
		label.setSize(50,50);
		label.setOpaque(true);
		label.setForeground(Color.blue);
		label.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		//set background color
		label.setBackground(SystemColor.inactiveCaption);
		//set text alignment center
		label.setHorizontalAlignment(SwingConstants.CENTER); 
		label.setVerticalAlignment(SwingConstants.CENTER);
	}
	
	public void setText(String string) {
		label.setText(string);
	}
	
	public void setSelectedGreen() {
		label.setBackground(new Color(153, 255, 153));
	}
	
	public void setSelectedYellow() {
		label.setBackground(new Color(255, 255, 153));
	}
}

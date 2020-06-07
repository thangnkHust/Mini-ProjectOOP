package hust.soict.hedspi.visualization.action;

import java.awt.Color;
import java.awt.SystemColor;

public class ElementBox extends Element{
	
	public ElementBox() {
		super();
		setBackground(SystemColor.inactiveCaption);
		setText("0");
	}
	
	public void setSelectedGreen() {
		this.setBackground(new Color(153, 255, 153));
	}
	
	public void setSelectedYellow() {
		this.setBackground(new Color(255, 255, 153));
	}
}

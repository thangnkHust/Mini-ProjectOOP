package hust.soict.hedspi.visualization.algotrithms;

import java.awt.SystemColor;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hust.soict.hedspi.visualization.VisualizerFrame;
import hust.soict.hedspi.visualization.action.Element;
import hust.soict.hedspi.visualization.action.PointRun;
import hust.soict.hedspi.visualization.action.SortVisualizer;

public class BubbleSort implements ISortAlgoritms{
	private Element[] elementBoxs;
	public void addCode(DefaultListModel<String> model) {
		model.addElement("void BubbleSort(int a[],int n) {");
		model.addElement("     int i, j;");
		model.addElement("     for (i = 0 ; i<n-1 ; i++)");
		model.addElement("          for (j =n-1; j >i ; j --)");
		model.addElement("               if(a[j] < a[j-1])");
		model.addElement("                    Swap(a[j], a[j-1])");
		model.addElement("}");
	}
	
	@Override
	public void sortIncrease(JPanel pnImitiate, Element[] elementBoxs, PointRun pointRun) {
		this.elementBoxs = elementBoxs;
		
		SortVisualizer.highLight(1);
		int i, j;
		int num = elementBoxs.length;
		for (i = 0; i< num; i++) {
			SortVisualizer.highLight(2);
			setlbPoint(pointRun.getLbPoint1(), i, "i = ");
			for (j = num - 1; j > i; j--) {
				SortVisualizer.highLight(3);
				SortVisualizer.highLight(4);
				setlbPoint(pointRun.getLbPoint2(), j, "j = ");
				if(elementBoxs[j].getValue() < elementBoxs[j-1].getValue()) {
					int temp = elementBoxs[j].getValue();
					elementBoxs[j].setValue(elementBoxs[j-1].getValue());
					elementBoxs[j-1].setValue(temp);
					SortVisualizer.highLight(5);
					Swap(elementBoxs[j-1].getLabel(), elementBoxs[j].getLabel());
				}
			}
		}
		SortVisualizer.waitEnd();
	}
	
	@Override
	public void sortDecrease(JPanel pnImitiate, Element[] elementBoxs, PointRun pointRun) {
		this.elementBoxs = elementBoxs;
		
		SortVisualizer.highLight(1);
		int i,j;
		int num = elementBoxs.length;
		for(i=0;i < num;i++) {
			SortVisualizer.highLight(2);
			setlbPoint(pointRun.getLbPoint1(), i, "i = ");
			for(j = num -1 ; j > i;j--) {
				SortVisualizer.highLight(3);
				SortVisualizer.highLight(4);
				setlbPoint(pointRun.getLbPoint2(), j, "j = ");
				if(elementBoxs[j].getValue() < elementBoxs[j-1].getValue()) {
					int temp = elementBoxs[j].getValue();
					elementBoxs[j].setValue(elementBoxs[j-1].getValue());
					elementBoxs[j-1].setValue(temp);
					SortVisualizer.highLight(5);
					Swap(elementBoxs[j-1].getLabel(), elementBoxs[j].getLabel());
				}
			}
		}
		SortVisualizer.waitEnd();
	}
	
	public void Swap(JLabel lb1, JLabel lb2) {
		int x1 = lb1.getX();
		int x2 = lb2.getX();
		SortVisualizer.curT ++;
		// Get value from Outer Class
		int cur = SortVisualizer.curT;
		Thread[] threads = SortVisualizer.threads;
				
		threads[cur] = new Thread(new Runnable() {
		    @Override
		    public void run() {
		    	try {
		    		if (cur != 0) {
			    		threads[cur-1].join();
			    	}
		    		
		    		lb1.setBackground(SortVisualizer.processingColor);
		    		lb2.setBackground(SortVisualizer.processingColor);
			        while (lb1.getY() > 100) {
			        	lb1.setLocation(lb1.getX(), lb1.getY() - 10);
			        	lb2.setLocation(lb2.getX(), lb2.getY() + 10);
			        	Thread.sleep(VisualizerFrame.time);
			        }
			        while (lb1.getX() < x2) {
			        	lb1.setLocation(lb1.getX() + 10, lb1.getY());
			        	lb2.setLocation(lb2.getX() - 10, lb2.getY());
			        	Thread.sleep(VisualizerFrame.time);
			        }
			        while (lb1.getY() < 140) {
			        	lb1.setLocation(lb1.getX(), lb1.getY() + 10);
			        	lb2.setLocation(lb2.getX(), lb2.getY() - 10);
			        	Thread.sleep(VisualizerFrame.time);
			        }
			        String txtLb1 = lb1.getText();
			        lb1.setText(lb2.getText());
			        lb2.setText(txtLb1);
			        lb1.setLocation(x1, 150);
		        	lb2.setLocation(x2, 150);
		        	lb1.setBackground(SystemColor.inactiveCaption);
		        	lb2.setBackground(SystemColor.inactiveCaption);
		    	} catch (Exception e) {
		    		e.printStackTrace();
		    	}
		    }
		});
		threads[cur].start();
		
	}
	
	public void setlbPoint(JLabel lbPoint, int i, String s) {
		SortVisualizer.curT ++;
        int cur = SortVisualizer.curT;
        Thread[] threads = SortVisualizer.threads;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0)
                        threads[cur - 1].join();
                    lbPoint.setLocation(elementBoxs[i].getLabel().getX(), 250);
                    lbPoint.setText(s + i);
                    Thread.sleep(VisualizerFrame.time*4);
                } catch (Exception e){
                	e.printStackTrace();
                }
            }
        });
        threads[cur].start();
    }
	
		
}

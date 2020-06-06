package hust.soict.hedspi.visualization.algotrithms;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import java.awt.SystemColor;

import hust.soict.hedspi.visualization.action.ElementBox;
import hust.soict.hedspi.visualization.action.PointRun;
import hust.soict.hedspi.visualization.action.SortVisualizer;
import hust.soict.hedspi.visualization.VisualizerFrame;

public class BubbleSort implements ISortAlgoritms{
	private ElementBox[] elementBoxs;
	private PointRun pointRun;
	public void addCode(DefaultListModel<String> model) {
		model.addElement("void BubbleSort(int a[],int n) {");
		model.addElement("     int i, j;");
		model.addElement("     for (i = 0 ; i<n-1 ; i++)");
		model.addElement("          for (j =n-1; j >i ; j --)");
		model.addElement("               if(a[j] < a[j-1])");
		model.addElement("                    Swap(a[j], a[j-1]");
		model.addElement("}");
	}
	
	@Override
	public void sortIncrease(ElementBox[] elementBoxs, PointRun pointRun) {
//		System.err.println("Bubble Sort Increase");
		this.elementBoxs = elementBoxs;
		this.pointRun = pointRun;
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
	}
	
	@Override
	public void sortDecrease(ElementBox[] elementBoxs, PointRun pointRun) {
//		System.err.println("Bubble Sort Decrease");
		this.elementBoxs = elementBoxs;
		this.pointRun = pointRun;
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
			        	pointRun.setLocationM(x2, pointRun.getLbPointM().getY() + 10);
			        	Thread.sleep(VisualizerFrame.time);
			        }
			        while (lb1.getX() < x2) {
			        	lb1.setLocation(lb1.getX() + 10, lb1.getY());
			        	lb2.setLocation(lb2.getX() - 10, lb2.getY());
			        	pointRun.setLocationM(lb2.getX(), 250);
			        	Thread.sleep(VisualizerFrame.time);
			        }
			        while (lb1.getY() < 140) {
			        	lb1.setLocation(lb1.getX(), lb1.getY() + 10);
			        	lb2.setLocation(lb2.getX(), lb2.getY() - 10);
			        	pointRun.setLocationM(x1, pointRun.getLbPointM().getY() - 10);
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
                        lbPoint.setLocation(elementBoxs[i].getLabel().getX(), 275);
                        lbPoint.setText(s + i);
                } catch (Exception e){}
            }
        });
        threads[cur].start();
    }
		
}

package hust.soict.hedspi.visualization.algotrithms;

import java.awt.SystemColor;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;

import hust.soict.hedspi.visualization.VisualizerFrame;
import hust.soict.hedspi.visualization.action.ElementBox;
import hust.soict.hedspi.visualization.action.PointRun;
import hust.soict.hedspi.visualization.action.SortVisualizer;

public class SelectionSort implements ISortAlgoritms{
	private ElementBox[] elementBoxs;
	private PointRun pointRun;
	public void addCode(DefaultListModel<String> model) {
		model.addElement("void SelectionSort(int a[],int n ) {");
		model.addElement("     int pos,i,j;");
		model.addElement("     for (i=0; i<n-1 ; i++) {");
		model.addElement("          pos = i;");
		model.addElement("          for(j = i+1; j <N ; j++)");
		model.addElement("               if (a[j] < a[pos])");
		model.addElement("                    pos = j;");
		model.addElement("          Swap(a[pos],a[i]);");
		model.addElement("     }");
		model.addElement("}");
	}
	
	@Override
	public void sortIncrease(ElementBox[] elementBoxs, PointRun pointRun) {
		// get value for attributed
		this.elementBoxs = elementBoxs;
		this.pointRun = pointRun;
		SortVisualizer.highLight(1);
		int min,i,j; 
		int num = elementBoxs.length;
		for (i = 0; i < num - 1; i++) {
			SortVisualizer.highLight(2);
			setlbPoint(pointRun.getLbPoint1(), i, "i = ");
			min = i;
			setlbPoint(pointRun.getLbPointM(), i, "min");
			SortVisualizer.highLight(3);
			for(j = i + 1; j < num; j++) {
				SortVisualizer.highLight(4);
				SortVisualizer.highLight(5);
				setlbPoint(pointRun.getLbPoint2(), j, "j = ");
				if (elementBoxs[j].getValue() < elementBoxs[min].getValue()) {
					SortVisualizer.highLight(6);
					min = j;
					setlbPoint(pointRun.getLbPointM(), j, "min");
				}
			}				
			if (min > i) {
				int temp = elementBoxs[min].getValue();
				elementBoxs[min].setValue(elementBoxs[i].getValue());
				elementBoxs[i].setValue(temp);
				SortVisualizer.highLight(7);
				Swap(elementBoxs[i].getLabel(), elementBoxs[min].getLabel());
			}
		}
	}
	
	@Override
	public void sortDecrease(ElementBox[] elementBoxs, PointRun pointRun) {
		// get value for attributed
		this.elementBoxs = elementBoxs;
		this.pointRun = pointRun;
		SortVisualizer.highLight(1);
		int min,i,j; 
		int num = elementBoxs.length;
		for (i = 0; i < num - 1; i++) {
			SortVisualizer.highLight(2);
			setlbPoint(pointRun.getLbPoint1(), i, "i = ");
			min = i;
			setlbPoint(pointRun.getLbPointM(), i, "max");
			SortVisualizer.highLight(3);
			for(j = i + 1; j < num; j++) {
				SortVisualizer.highLight(4);
				SortVisualizer.highLight(5);
				setlbPoint(pointRun.getLbPoint2(), j, "j = ");
				if (elementBoxs[j].getValue() > elementBoxs[min].getValue()) {
					SortVisualizer.highLight(6);
					min = j;
					setlbPoint(pointRun.getLbPointM(), j, "max");
				}
			}				
			if (min > i) {
				int temp = elementBoxs[min].getValue();
				elementBoxs[min].setValue(elementBoxs[i].getValue());
				elementBoxs[i].setValue(temp);
				SortVisualizer.highLight(7);
				Swap(elementBoxs[i].getLabel(), elementBoxs[min].getLabel());
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
                    if(lbPoint == pointRun.getLbPointM()) {
                    	lbPoint.setLocation(elementBoxs[i].getLabel().getX(), 200);
                        lbPoint.setText(s);
                    }else {
                        lbPoint.setLocation(elementBoxs[i].getLabel().getX(), 275);
                        lbPoint.setText(s + i);
                    }
                } catch (Exception e){}
            }
        });
        threads[cur].start();
    }
}

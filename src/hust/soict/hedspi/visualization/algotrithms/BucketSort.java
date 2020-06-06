package hust.soict.hedspi.visualization.algotrithms;

import java.awt.SystemColor;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hust.soict.hedspi.visualization.VisualizerFrame;
import hust.soict.hedspi.visualization.action.ElementBox;
import hust.soict.hedspi.visualization.action.PointRun;
import hust.soict.hedspi.visualization.action.SortVisualizer;

public class BucketSort implements ISortAlgoritms{
	private ElementBox[] elementBoxs;
	private ElementBox[] elementIndexs;
	private int num;
	private JPanel pnImitiate;
	
	public void addCode(DefaultListModel<String> model) {
		model.addElement("void BubbleSort(int a[],int n) {");
		model.addElement("     int i, j;");
		model.addElement("     for (i = 0 ; i<n-1 ; i++)");
		model.addElement("          for (j =n-1; j >i ; j --)");
		model.addElement("               if(a[j] < a[j-1])");
		model.addElement("                    Swap(a[j], a[j-1]");
		model.addElement("}");
	}
	
	public void setElementIndexs(ElementBox[] elementIndexs) {
		this.elementIndexs = elementIndexs;
	}
	
	public void setElementBoxs(ElementBox[] elementBoxs) {
		this.elementBoxs = elementBoxs;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	public void setPnImitiate(JPanel pnImitiate) {
		this.pnImitiate = pnImitiate;
	}
	
	@Override
	public void sortIncrease(JPanel pnImitiate, ElementBox[] elementBoxs, PointRun pointRun) {
		setElementBoxs(elementBoxs);
		setElementIndexs(elementIndexs);
		setPnImitiate(pnImitiate);
		setNum(elementBoxs.length);
		setIndexs();
		int temp = 0;
		for(int i = 0; i < num; i++) {
			temp = (elementBoxs[i].getValue()*num)/101;
			elementIndexs[i].setValue(temp);
			elementIndexs[i].getLabel().setText(temp + "");
		}
        
        SortVisualizer.curT ++;
        Thread[] threads = SortVisualizer.threads;
        int cur = SortVisualizer.curT;
        
        threads[cur] = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					if (cur != 0) {
                        threads[cur - 1].join();
                    }
					int pos, i;
			        int x;
			        int y;
					for (i = 1; i < num; i++) {
			        	x = elementBoxs[i].getValue();
			        	y = elementIndexs[i].getValue();
			        	pos = i - 1;
			        	while ((pos >= 0) && (elementIndexs[pos].getValue() > y)) {
			        		elementBoxs[pos+1].setValue(elementBoxs[pos].getValue());
			        		elementIndexs[pos+1].setValue(elementIndexs[pos].getValue());
			        		if (pos > 0 && elementIndexs[pos-1].getValue() <= y) {
			        			Move(elementBoxs[pos+1].getLabel(), elementBoxs[pos].getLabel(), 0, elementIndexs[pos+1].getLabel(), elementIndexs[pos].getLabel());
			        		} else {
			        			Move(elementBoxs[pos+1].getLabel(), elementBoxs[pos].getLabel(), pos, elementIndexs[pos+1].getLabel(), elementIndexs[pos].getLabel());
			        		}	              
			        		pos--;
			        	}
			        	elementBoxs[pos+1].setValue(x);
			        	elementIndexs[pos+1].setValue(y);
			        }
					for (i = 1; i < num; i++) {
			        	x = elementBoxs[i].getValue();
			        	y = elementIndexs[i].getValue();
			            pos = i - 1;
			            while ((pos >= 0) && (elementBoxs[pos].getValue() > x)) {
			                if (pos > 0 && elementBoxs[pos-1].getValue() <= x) {
			                    Move(elementBoxs[pos+1].getLabel(), elementBoxs[pos].getLabel(), 0, elementIndexs[pos+1].getLabel(), elementIndexs[pos].getLabel());
			                } else {
			                    Move(elementBoxs[pos+1].getLabel(), elementBoxs[pos].getLabel(), pos, elementIndexs[pos+1].getLabel(), elementIndexs[pos].getLabel());
			                }
			                elementBoxs[pos+1].setValue(elementBoxs[pos].getValue());
			                elementIndexs[pos+1].setValue(elementIndexs[pos].getValue());
			                pos--;
			            }
			            elementBoxs[pos+1].setValue(x);
			            elementIndexs[pos+1].setValue(y);
			        }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
        threads[cur].start();
	}
	
	public void Move(JLabel lb1, JLabel lb2, int pos, JLabel lbIndex1, JLabel lbIndex2) {
        int x1 = lb1.getX();
        int x2 = lb2.getX();
        SortVisualizer.curT ++;
        Thread[] threads = SortVisualizer.threads;
        int cur = SortVisualizer.curT;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        threads[cur - 1].join();
                    }
                    lb1.setOpaque(true);
                    lb2.setOpaque(true);
                    lb1.setBackground(SortVisualizer.processingColor);
                    while (lb1.getY() > 50) {
                        lb1.setLocation(lb1.getX(), lb1.getY() - 10);
                        lbIndex1.setLocation(lbIndex1.getX(), lbIndex1.getY() - 10);
                        Thread.sleep(VisualizerFrame.time);
                    }
                    while (lb1.getX() > x2) {
                        lb2.setLocation(lb2.getX() + 10, lb2.getY());
                        lbIndex2.setLocation(lbIndex2.getX() + 10, lbIndex2.getY());
                        lb1.setLocation(lb1.getX() - 10, lb1.getY());
                        lbIndex1.setLocation(lbIndex1.getX() - 10, lbIndex1.getY());
                        Thread.sleep(VisualizerFrame.time);
                    }
                    while (pos == 0 && lb1.getY() < 150) {
                        lb1.setLocation(lb1.getX(), lb1.getY() + 10);
                        lbIndex1.setLocation(lbIndex1.getX(), lbIndex1.getY() + 10);
                        Thread.sleep(VisualizerFrame.time);
                    }
                    String txtLb1 = lb1.getText();
                    lb1.setText(lb2.getText());
                    lb2.setText(txtLb1);
                    int y1 = lb1.getY();
                    lb1.setLocation(x1, lb2.getY());
                    lb2.setLocation(x2, y1);
                    lb1.setBackground(SystemColor.inactiveCaption);
                    
                    txtLb1 = lbIndex1.getText();
                    lbIndex1.setText(lbIndex2.getText());
                    lbIndex2.setText(txtLb1);
                    
                    y1 = lbIndex1.getY();
                    lbIndex1.setLocation(x1, lbIndex2.getY());
                    lbIndex2.setLocation(x2, y1);
                    if (pos == 0)
                        lb2.setBackground(SystemColor.inactiveCaption);
               } catch (Exception e) {
               }
           }
        });
        threads[cur].start();
    }
	
	@Override
	public void sortDecrease(JPanel pnImitiate, ElementBox[] elementBoxs, PointRun pointRun) {
		
	}
	
	private void setIndexs() {
		if(elementIndexs != null) {
			for(int i = 0; i < elementIndexs.length; i++)
				pnImitiate.remove(elementIndexs[i].getLabel());
		}
		elementIndexs = new ElementBox[num];
		for(int i = 0; i < num; i++) {
			elementIndexs[i] = new ElementBox(SystemColor.menu);
			pnImitiate.add(elementIndexs[i].getLabel());
			if (i == 0)
				elementIndexs[i].getLabel().setLocation(((int) ((18 - num) * 0.5) * 70) + 100, 200);
			else
				elementIndexs[i].getLabel().setLocation(elementBoxs[i-1].getLabel().getX() + 70, 200);
		}
	}
	
//	private void deleteIndexs(ElementBox[] elementIndexs) {
//		System.err.println(elementIndexs.length);
//		for(int i = 0; i < elementIndexs.length; i++) {
//			pnImitiate.remove(elementIndexs[i].getLabel());
//		}
//	}
}

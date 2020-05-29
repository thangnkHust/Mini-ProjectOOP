package hust.soict.hedspi.visualization.algotrithms;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;

import hust.soict.hedspi.visualization.VisualizerFrame;
import hust.soict.hedspi.visualization.action.ArrayVisualizer;
import hust.soict.hedspi.visualization.action.SortVisualizer;

import java.awt.SystemColor;

public class BubbleSort implements ISortAlgoritms{
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
	public void sortIncrease() {
		SortVisualizer.highLight(1);
		int i,j; 
		int num = ArrayVisualizer.num;
		int[] array = ArrayVisualizer.array;
		JLabel[] lbArrays = ArrayVisualizer.lbArrays;
		for (i = 0; i< num; i++) {
			SortVisualizer.highLight(2);
			for (j = num - 1; j > i; j--) {
				SortVisualizer.highLight(3);
				SortVisualizer.highLight(4);
				if(array[j]< array[j-1]) {
					int temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
					SortVisualizer.highLight(5);
					Swap(lbArrays[j - 1], lbArrays[j]);
				}
			}
		}
	}
	
	@Override
	public void sortDecrease() {
//		System.err.println("Bubble Sort Decrease");
		SortVisualizer.highLight(1);
		int i, j;
		int num = ArrayVisualizer.num;
		int[] array = ArrayVisualizer.array;
		JLabel[] lbArrays = ArrayVisualizer.lbArrays;
		for (i = 0; i< num; i++) {
			SortVisualizer.highLight(2);
			for (j = num - 1; j > i; j--) {
				SortVisualizer.highLight(3);
				SortVisualizer.highLight(4);
				if(array[j] > array[j-1]) {
					int temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
					SortVisualizer.highLight(5);
					Swap(lbArrays[j - 1], lbArrays[j]);
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
		int time = VisualizerFrame.time;
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
			        	Thread.sleep(time);
			        }
			        while (lb1.getX() < x2) {
			        	lb1.setLocation(lb1.getX() + 10, lb1.getY());
			        	lb2.setLocation(lb2.getX() - 10, lb2.getY());
			        	Thread.sleep(time);
			        }
			        while (lb1.getY() < 140) {
			        	lb1.setLocation(lb1.getX(), lb1.getY() + 10);
			        	lb2.setLocation(lb2.getX(), lb2.getY() - 10);
			        	Thread.sleep(time);
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
		
}

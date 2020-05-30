package hust.soict.hedspi.visualization.action;

import java.awt.Color;

import hust.soict.hedspi.visualization.VisualizerFrame;
import hust.soict.hedspi.visualization.algotrithms.ISortAlgoritms;

public class SortVisualizer{
	
	private static final long serialVersionUID = 1L;
	public static int curT = -1;
	public static Thread[] threads = new Thread[1000000];
	public static Color processingColor = new Color(255, 153, 153);
	public static Color selectedGreen = new Color(153, 255, 153);
    public static Color selectedYellow = new Color(255, 255, 153);

	public SortVisualizer(ISortAlgoritms algoritm, ElementBox[] elementBoxs, boolean isIncrease) {
		if(isIncrease == true) {
			algoritm.sortIncrease(elementBoxs);
		}else {
			algoritm.sortDecrease(elementBoxs);
		}
	}

	public static void highLight(int line) {
		curT++;
		int cur = curT;
		threads[cur] = new Thread(new Runnable() {
		    @Override
		    public void run() {
		    	try {
		    		if (cur != 0) {
			    		threads[cur-1].join();
			    	}
		    		VisualizerFrame.lsCode.setSelectedIndex(line);
		    		VisualizerFrame.lsCode.ensureIndexIsVisible(line); // Tu cuon den dong dang highlight
		    		Thread.sleep(VisualizerFrame.time);
		    	} catch (Exception e) {
		    		
		    	}
		    }
		});
		threads[cur].start();
	}
}

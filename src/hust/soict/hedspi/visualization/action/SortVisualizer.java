package hust.soict.hedspi.visualization.action;

import java.awt.Color;

import javax.swing.JPanel;

import hust.soict.hedspi.visualization.VisualizerFrame;
import hust.soict.hedspi.visualization.algotrithms.ISortAlgoritms;

public class SortVisualizer{
	
//	private static final long serialVersionUID = 1L;
	public static int curT = -1;
	public static Thread[] threads = new Thread[1000000];
	public static Color processingColor = new Color(255, 153, 153);

	public SortVisualizer(JPanel pnImitiate, ISortAlgoritms algoritm, Element[] elementBoxs, PointRun pointRun, boolean isIncrease) {
		if(isIncrease == true) {
			algoritm.sortIncrease(pnImitiate, elementBoxs, pointRun);
//			waitEnd();
		}else {
			algoritm.sortDecrease(pnImitiate, elementBoxs, pointRun);
//			waitEnd();
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
		    		e.printStackTrace();
		    	}
		    }
		});
		threads[cur].start();
	}
	
//	private void waitEnd() {
//    	curT++;
//		int cur = curT;
//		threads[cur] = new Thread(new Runnable() {
//		    @Override
//		    public void run() {
//		    	try {
//		    		if(cur != 0) {
//		    			threads[cur-2].join();
//		    		}
//		    		JOptionPane.showMessageDialog(null, "MẢNG ĐÃ ĐƯỢC SẮP XẾP XONG", "THÔNG BÁO", JOptionPane.INFORMATION_MESSAGE);
//		    	} catch (Exception e) {
//		    		e.printStackTrace();
//		    	}
//		    }
//		});
//		threads[cur].start();
//    }
}

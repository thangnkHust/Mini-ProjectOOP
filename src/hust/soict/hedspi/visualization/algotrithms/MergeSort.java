package hust.soict.hedspi.visualization.algotrithms;

import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JPanel;

import hust.soict.hedspi.visualization.VisualizerFrame;
import hust.soict.hedspi.visualization.action.Element;
import hust.soict.hedspi.visualization.action.ElementBox;
import hust.soict.hedspi.visualization.action.PointRun;
import hust.soict.hedspi.visualization.action.SortVisualizer;

public class MergeSort implements ISortAlgoritms{
	private int[] oriLocat = new int[15];
	private Element[] elementBoxs;
	private PointRun pointRun;
	
	public void addCode(javax.swing.DefaultListModel<String> model) {
		model.addElement("void MergeSort(int left, int right) {");
    	model.addElement("    if (left < right) {");
    	model.addElement("        int mid = (left + right) / 2;");
    	model.addElement("        MergeSort(left, mid);");
    	model.addElement("        MergeSort(mid + 1, right);");
    	model.addElement("        Merge(left, mid, right);");
    	model.addElement("    }");
    	model.addElement("}");
    	model.addElement("");
    	model.addElement("public void Merge(int left, int mid, int right) {");
    	model.addElement("    int n1 = mid - left + 1;");
    	model.addElement("    int n2 = right - mid;");
    	model.addElement("    int[] T = new int[n1 + n2];");
    	model.addElement("    int[] L = new int[n1];");
    	model.addElement("    int[] R = new int[n2];");
    	model.addElement("    int i, j, k;");
    	model.addElement("    for (i = 0; i < n1; i ++)");
    	model.addElement("        L[i] = array[left + i];");
    	model.addElement("    for (j = 0; j < n2; j ++)");
    	model.addElement("        R[j] = array[mid + 1 + j];");
    	model.addElement("    i = 0; j = 0;");
        model.addElement("    k = left;");
        model.addElement("    while (i < n1 && j < n2) {");
        model.addElement("        if (L[i] <= R[j]) {");
        model.addElement("            array[k] = L[i];");
        model.addElement("            i ++;");
        model.addElement("        } else {");
        model.addElement("            array[k] = R[j];");
        model.addElement("            j ++;");
        model.addElement("        }");
        model.addElement("        k ++;");
        model.addElement("    }");
        model.addElement("    while (i < n1) {");
        model.addElement("        array[k] = L[i];");
        model.addElement("        i ++;");
        model.addElement("        k ++;");
        model.addElement("    }");
        model.addElement("    while (j < n2) {");
        model.addElement("        array[k] = R[j];");
        model.addElement("        j ++;");
        model.addElement("        k ++;");
        model.addElement("    }");
        model.addElement("}");
	};
	
	@Override
	public void sortIncrease(JPanel pnImitiate, Element[] elementBoxs, PointRun pointRun) {
		this.elementBoxs = elementBoxs;
		this.pointRun = pointRun;
		MergeSortIncrease();
	}
	
	
	public void MergeSortIncrease() {
        for (int i = 0; i < elementBoxs.length; i ++)
            oriLocat[i] = elementBoxs[i].getLabel().getX();
        MergeSortAlIncrease(0, elementBoxs.length - 1);
    }
	
	public void MergeSortAlIncrease(int left, int right) {
        SortVisualizer.highLight(1);
        if (left < right) {
            SortVisualizer.highLight(2);
            int mid = (left + right) / 2;
            MergeSortAlIncrease(left, mid);
            MergeSortAlIncrease(mid + 1, right);
            MergeIncrease(left, mid, right);
        }
    }
	
	public void MergeIncrease(int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] T = new int[n1 + n2];
        int[] L = new int[n1];
        int[] R = new int[n2];
        int i, j, k;
        
//        SortVisualizer.highLight(16);
        for (i = 0; i < n1; i ++)
            L[i] = elementBoxs[left + i].getValue();
//        SortVisualizer.highLight(18);
        for (j = 0; j < n2; j ++)
            R[j] = elementBoxs[mid + 1 + j].getValue();
        setlbPoint(pointRun.getLbPoint1(), left, "i = ");
        setlbPoint(pointRun.getLbPoint2(), mid + 1, "j = ");
        PutUp(left, right);
        i = 0; j = 0;
        k = left;
        while (i < n1 && j < n2) {
//            SortVisualizer.highLight(22);
            setlbPoint(pointRun.getLbPointM(), k, "k = ");
//            SortVisualizer.highLight(23);
            if (L[i] <= R[j]) {
                setlbPoint(pointRun.getLbPoint1(), left + i, "i = ");
                SortVisualizer.highLight(24);
                elementBoxs[k].setValue(L[i]);
                PutDown(elementBoxs[left + i].getLabel(), oriLocat[k], 150);
//                SortVisualizer.highLight(25);
                i ++;
            } else {
                setlbPoint(pointRun.getLbPoint2(), mid + 1 + j, "j = ");
                SortVisualizer.highLight(27);
                elementBoxs[k].setValue(R[j]);
                PutDown(elementBoxs[mid + 1 + j].getLabel(), oriLocat[k], 150);
//                SortVisualizer.highLight(28);
                j ++;
            }
//            SortVisualizer.highLight(30);
            k ++;
        }
        while (i < n1) {
//            SortVisualizer.highLight(32);
            setlbPoint(pointRun.getLbPointM(), k, "k = ");
            setlbPoint(pointRun.getLbPoint1(), left + i, "i = ");
            SortVisualizer.highLight(33);
            elementBoxs[k].setValue(L[i]);
            PutDown(elementBoxs[left + i].getLabel(), oriLocat[k], 150);
            i ++;
            k ++;
        }
        while (j < n2) {
//            SortVisualizer.highLight(37);
            setlbPoint(pointRun.getLbPointM(), k, "k = ");
            setlbPoint(pointRun.getLbPoint2(), mid + 1 + j, "j = ");
            SortVisualizer.highLight(38);
            elementBoxs[k].setValue(R[j]);
            PutDown(elementBoxs[mid + 1 + j].getLabel(), oriLocat[k], 150);
            j ++;
            k ++;
        }
        for (i = 0; i < n1 + n2; i ++)
            T[i] = elementBoxs[left + i].getValue();
        Relocat(left, right, T);
    }
	
	@Override
	public void sortDecrease(JPanel pnImitiate, Element[] elementBoxs, PointRun pointRun) {
		this.elementBoxs = elementBoxs;
		this.pointRun = pointRun;
		MergeSortDecrease();
	}
	
	public void MergeSortDecrease() {
        for (int i = 0; i < elementBoxs.length; i ++)
            oriLocat[i] = elementBoxs[i].getLabel().getX();
        MergeSortAlDecrease(0, elementBoxs.length - 1);
    }
	
	public void MergeSortAlDecrease(int left, int right) {
        SortVisualizer.highLight(1);
        if (left < right) {
            SortVisualizer.highLight(2);
            int mid = (left + right) / 2;
            MergeSortAlDecrease(left, mid);
            MergeSortAlDecrease(mid + 1, right);
            MergeDecrease(left, mid, right);
        }
    }
	
	public void MergeDecrease(int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] T = new int[n1 + n2];
        int[] L = new int[n1];
        int[] R = new int[n2];
        int i, j, k;
        
        SortVisualizer.highLight(16);
        for (i = 0; i < n1; i ++)
            L[i] = elementBoxs[left + i].getValue();
        SortVisualizer.highLight(18);
        for (j = 0; j < n2; j ++)
            R[j] = elementBoxs[mid + 1 + j].getValue();
        setlbPoint(pointRun.getLbPoint1(), left, "i = ");
        setlbPoint(pointRun.getLbPoint2(), mid + 1, "j = ");
        PutUp(left, right);
        i = 0; j = 0;
        k = left;
		while (i < n1 && j < n2) {
			SortVisualizer.highLight(22);
            setlbPoint(pointRun.getLbPointM(), k, "k = ");
            SortVisualizer.highLight(23);
            if (L[i] >= R[j]) {
                setlbPoint(pointRun.getLbPoint1(), left + i, "i = ");
                SortVisualizer.highLight(24);
                elementBoxs[k].setValue(L[i]);
                PutDown(elementBoxs[left + i].getLabel(), oriLocat[k], 150);
                SortVisualizer.highLight(25);
                i ++;
            } else {
            	 setlbPoint(pointRun.getLbPoint2(), mid + 1 + j, "j = ");
            	 SortVisualizer.highLight(27);
            	  elementBoxs[k].setValue(R[j]);
                  PutDown(elementBoxs[mid + 1 + j].getLabel(), oriLocat[k], 150);
                  SortVisualizer.highLight(28);
                  j ++;
            }
            SortVisualizer.highLight(30);
            k ++;
		}
		while (i < n1) {
			SortVisualizer.highLight(32);
            setlbPoint(pointRun.getLbPointM(), k, "k = ");
            setlbPoint(pointRun.getLbPoint1(), left + i, "i = ");
            SortVisualizer.highLight(33);
            elementBoxs[k].setValue(L[i]);
            PutDown(elementBoxs[left + i].getLabel(), oriLocat[k], 150);
            i ++;
            k ++;
		}
		while (j < n2) {
			SortVisualizer.highLight(37);
            setlbPoint(pointRun.getLbPointM(), k, "k = ");
            setlbPoint(pointRun.getLbPoint2(), mid + 1 + j, "j = ");
            SortVisualizer.highLight(38);
            elementBoxs[k].setValue(R[j]);
            PutDown(elementBoxs[mid + 1 + j].getLabel(), oriLocat[k], 150);
            j ++;
            k ++;
		}
        for (i = 0; i < n1 + n2; i ++)
            T[i] = elementBoxs[left + i].getValue();
        Relocat(left, right, T);
	}
	
	public void PutUp(int left, int right) {
        SortVisualizer.curT ++;
        int cur = SortVisualizer.curT;
        Thread[] threads = SortVisualizer.threads;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0)
                        threads[cur - 1].join();
                    int mid = (left + right) / 2;
                    for (int i = left; i <= right; i ++) {
                        if (i < mid + 1)
                            ((ElementBox) elementBoxs[i]).setSelectedGreen();
                        else
                            ((ElementBox) elementBoxs[i]).setSelectedYellow();
                    }
                    while (elementBoxs[right].getLabel().getY() > 50) {
                        for (int i = left; i <= right; i ++) {
                            if (elementBoxs[i].getLabel().getY() > 50)
                                elementBoxs[i].getLabel().setLocation(elementBoxs[i].getLabel().getX(), elementBoxs[i].getLabel().getY() - 10);
                        }
                        Thread.sleep(VisualizerFrame.time);
                    }
                } catch (Exception e) {
                }
            }
        });
        threads[cur].start();
    }
    
    public void PutDown(JLabel lb1, int x, int y) {
        SortVisualizer.curT ++;
        int cur = SortVisualizer.curT;
        Thread[] threads = SortVisualizer.threads;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        threads[cur - 1].join();
                    }
                    int x1 = lb1.getX();
                    lb1.setBackground(SortVisualizer.processingColor);
                    while (lb1.getY() < 100) {
                        lb1.setLocation(x1, lb1.getY() + 10);
                        Thread.sleep(VisualizerFrame.time);
                    }
                    int y1 = lb1.getY();
                    if (x1 < x) {
                        while (lb1.getX() < x) {
                            lb1.setLocation(lb1.getX() + 10, y1);
                            Thread.sleep(VisualizerFrame.time);
                        }
                        while (lb1.getY() < y) {
                            lb1.setLocation(x, lb1.getY() + 10);
                            Thread.sleep(VisualizerFrame.time);
                        }
                    } else {
                        while (lb1.getX() > x) {
                            lb1.setLocation(lb1.getX() - 10, y1);
                            Thread.sleep(VisualizerFrame.time);
                        }
                        while (lb1.getY() < y) {
                            lb1.setLocation(x, lb1.getY() + 10);
                            Thread.sleep(VisualizerFrame.time);
                        }
                    }
                    lb1.setBackground(SystemColor.inactiveCaption);
                } catch (Exception e) {
                	e.printStackTrace();
                }
            }
        });
        threads[cur].start();
    }
    
    public void Relocat(int left, int right, int[] T) {
        SortVisualizer.curT ++;
        int cur = SortVisualizer.curT;
        Thread[] threads = SortVisualizer.threads;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0)
                        threads[cur - 1].join();
                    for (int i = left; i <= right; i ++) {
                        if (elementBoxs[i].getLabel().getX() != oriLocat[i]) {
                            elementBoxs[i].getLabel().setLocation(oriLocat[i], 150);
                            elementBoxs[i].getLabel().setText(T[i - left] + "");
                        }
                    }
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
                    	lbPoint.setLocation(oriLocat[i], 200);
                        lbPoint.setText(s + i);
                    }else {
                        lbPoint.setLocation(elementBoxs[i].getLabel().getX(), 250);
                        lbPoint.setText(s + i);
                    }
                } catch (Exception e){}
            }
        });
        threads[cur].start();
    }
    
    public void Swap(JLabel lb1, JLabel lb2) {/* Do nothing */}
}

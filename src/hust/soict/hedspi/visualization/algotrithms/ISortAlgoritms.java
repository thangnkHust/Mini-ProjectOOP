package hust.soict.hedspi.visualization.algotrithms;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hust.soict.hedspi.visualization.action.Element;
import hust.soict.hedspi.visualization.action.PointRun;

public interface ISortAlgoritms {
	public final int a = 5;
	public void addCode(DefaultListModel<String> model);
	public void sortIncrease(JPanel pnImitiate, Element[] elementBoxs, PointRun pointRun);
	public void sortDecrease(JPanel pnImitiate, Element[] elementBoxs, PointRun pointRun);
	public void setlbPoint(JLabel lbPoint, int i, String s);
	public void Swap(JLabel lb1, JLabel lb2);
}

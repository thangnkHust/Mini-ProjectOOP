package hust.soict.hedspi.visualization.algotrithms;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;

import hust.soict.hedspi.visualization.action.ElementBox;
import hust.soict.hedspi.visualization.action.PointRun;

public interface ISortAlgoritms {
	public void addCode(DefaultListModel<String> model);
	public void sortIncrease(JPanel pnImitiate, ElementBox[] elementBoxs, PointRun pointRun);
	public void sortDecrease(JPanel pnImitiate, ElementBox[] elementBoxs, PointRun pointRun);
}

package hust.soict.hedspi.visualization.algotrithms;

import javax.swing.DefaultListModel;

import hust.soict.hedspi.visualization.action.ElementBox;
import hust.soict.hedspi.visualization.action.PointRun;

public interface ISortAlgoritms {
	public void addCode(DefaultListModel<String> model);
	public void sortIncrease(ElementBox[] elementBoxs, PointRun pointRun);
	public void sortDecrease(ElementBox[] elementBoxs, PointRun pointRun);
}

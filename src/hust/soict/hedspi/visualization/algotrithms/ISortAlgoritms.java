package hust.soict.hedspi.visualization.algotrithms;

import javax.swing.DefaultListModel;

import hust.soict.hedspi.visualization.action.ElementBox;

public interface ISortAlgoritms {
	public void addCode(DefaultListModel<String> model);
	public void sortIncrease(ElementBox[] elementBoxs);
	public void sortDecrease(ElementBox[] elementBoxs);
}

package hust.soict.hedspi.visualization.algotrithms;

import javax.swing.DefaultListModel;

import hust.soict.hedspi.visualization.action.ElementBox;

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
	public void sortIncrease(ElementBox[] elementBoxs) {
		System.err.println("Bubble Sort Increase");
	}
	
	@Override
	public void sortDecrease(ElementBox[] elementBoxs) {
		System.err.println("Bubble Sort Decrease");
	}
		
}

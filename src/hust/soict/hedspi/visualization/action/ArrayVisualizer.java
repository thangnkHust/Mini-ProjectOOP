package hust.soict.hedspi.visualization.action;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

public class ArrayVisualizer {
	// Do khoi tao doi tuong moi trong moi lan goi constructor
	// ==> Attribute la static -> bao toan gia tri cua lan truoc
	public static int num;
	public static JLabel[] lbArrays;
	public static int[] array;
	private JPanel pnImitiate;
	
	public void setPnImitiate(JPanel pnImitiate) {
		this.pnImitiate = pnImitiate;
	}

	// Connstructor --> create array visualization
	public ArrayVisualizer(JPanel pnImitiate, JSpinner spNum) {
		// Set pnImitiate of ArrayVisualizer
		setPnImitiate(pnImitiate);
		// Delete older array
		deleteArray();
		// Get number, create array and lbArrays
		num = (Integer)spNum.getValue();
		lbArrays = new JLabel[num];
		array = new int[num];
		
		for (int i = 0; i < num; i++) {
			//create label, set text "0"
			lbArrays[i] = new JLabel("0");
			array[i] = 0;
			pnImitiate.add(lbArrays[i]);
			lbArrays[i].setText(String.valueOf(array[i]));
			
			//set size label
			lbArrays[i].setSize(50,50);
			lbArrays[i].setOpaque(true);
			lbArrays[i].setForeground(Color.blue);
			
			//set location label
			if (i == 0)
				lbArrays[i].setLocation(((int) ((18 - num) * 0.5) * 70) + 100, 150);
			else
				lbArrays[i].setLocation(lbArrays[i-1].getX() + 70, 150);
			
			//set fonts
			lbArrays[i].setFont(new Font("Tahoma", Font.PLAIN, 30));
			
			//set background color
			lbArrays[i].setBackground(SystemColor.inactiveCaption);
			//set text alignment center
			lbArrays[i].setHorizontalAlignment(SwingConstants.CENTER); 
			lbArrays[i].setVerticalAlignment(SwingConstants.CENTER);
		}
                
		pnImitiate.setVisible(true);
		pnImitiate.validate();
		pnImitiate.repaint();
//		setState(1);
	}
	
	public void deleteArray() {
		for (int i = 0; i < num; i++) {
			lbArrays[i].setText("0");
			array[i] = 0;
			lbArrays[i].setVisible(false);
			pnImitiate.remove(lbArrays[i]);
		}
		
//		for (int i = 0; i < curT; i++) {
//			try {
//					threads[i].interrupt();
//			} 
//			catch (Exception e) {
//				
//			}
//		}
//		curT = -1;
		
		pnImitiate.revalidate();
		pnImitiate.repaint();
//		setState(0);
	}
	
	public void createRandom() {
		Random rand = new Random();
		for (int i = 0; i < num; i++) {
			int ranNum = rand.nextInt(101) + 0;
			lbArrays[i].setText(String.valueOf(ranNum));
			lbArrays[i].setForeground(Color.BLUE);
			array[i] = ranNum;
		}
		pnImitiate.setVisible(true);
		pnImitiate.validate();
		pnImitiate.repaint();
//		setState(2);
	}

	public void setZero() {
		for (int i = 0; i < num; i++) {
			lbArrays[i].setText("0");
			array[i] = 0;
		}
		
		this.pnImitiate.revalidate();
		this.pnImitiate.repaint();
//		setState(1);
	}
	
	public void createHand() {
//		ArrayInput arrayInput = new ArrayInput(pnImitiate, num, array, lbArrays);
//		arrayInput.setVisible(true);
		JButton btnOK;
		JSpinner[] txtArrays = new JSpinner[num];
		JLabel[] lbArrays = new JLabel[num];
		
		JFrame arrayInput = new JFrame();
		arrayInput.setTitle("Nh\u1EADp d\u1EEF li\u1EC7u m\u1EA3ng");
		arrayInput.setBounds(100, 100, 504, 312);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		arrayInput.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		arrayInput.setLocation(dim.width/2-arrayInput.getSize().width/2, dim.height/2-arrayInput.getSize().height/2);
		for (int i = 0; i < num; i++) {
			lbArrays[i] = new JLabel("A[" + i + "]:");
			SpinnerModel smValue = new SpinnerNumberModel(0, 0, 100, 1);
			txtArrays[i] = new JSpinner(smValue);
			JFormattedTextField txt = ((JSpinner.NumberEditor) txtArrays[i].getEditor()).getTextField();
			((NumberFormatter) txt.getFormatter()).setAllowsInvalid(false);
			contentPane.add(lbArrays[i]);
			contentPane.add(txtArrays[i]);
			lbArrays[i].setSize(40,30);
			if (i == 0 || i == 5 || i == 10) 
				lbArrays[i].setLocation(150 * (i + 1)/5  , 30);
			else
				lbArrays[i].setLocation(lbArrays[i-1].getX(), lbArrays[i-1].getY() + 40);
			txtArrays[i].setSize(50,30);
			txtArrays[i].setLocation(lbArrays[i].getX() + 40, lbArrays[i].getY());
		}
		contentPane.setVisible(true);
		contentPane.validate();
		contentPane.repaint();
		
		btnOK = new JButton("Xác nhận");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < num; i++) {
					array[i] = (int) txtArrays[i].getValue();
					ArrayVisualizer.lbArrays[i].setText(String.valueOf(array[i]));
					ArrayVisualizer.lbArrays[i].setForeground(Color.BLUE);
				}
				pnImitiate.setVisible(true);
				pnImitiate.validate();
				pnImitiate.repaint();
				JOptionPane.showMessageDialog(arrayInput, "Đã tạo dữ liệu mảng thành công!\nChuẩn bị thoát!");
				arrayInput.dispatchEvent(new WindowEvent(arrayInput, WindowEvent.WINDOW_CLOSING));
			}
		});
		btnOK.setBackground(SystemColor.activeCaption);
		btnOK.setBounds(185, 237, 120, 25);
		contentPane.add(btnOK);
		arrayInput.setVisible(true);
	}
	
	
}

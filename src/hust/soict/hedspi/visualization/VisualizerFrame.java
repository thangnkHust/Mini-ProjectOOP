package hust.soict.hedspi.visualization;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.NumberFormatter;

import hust.soict.hedspi.visualization.action.ArrayVisualizer;
import hust.soict.hedspi.visualization.action.SortVisualizer;
import hust.soict.hedspi.visualization.algotrithms.BubbleSort;
import hust.soict.hedspi.visualization.algotrithms.ISortAlgoritms;
import hust.soict.hedspi.visualization.algotrithms.MergeSort;
import hust.soict.hedspi.visualization.algotrithms.SelectionSort;

import javax.swing.border.EtchedBorder;

public class VisualizerFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	
	private JPanel contentPane;
	private JLabel lbTitle;
	private JPanel pnImitiate;
	private JPanel pnTool;
	private JPanel pnArray;
	private JPanel pnCreateArray;
	private JLabel lbNum, lbMaxNum;
	private JSpinner spNum;
	private JButton btnCreateArray, btnDeleteArray, btnSetZero;
	private JPanel pnSetValueArray;
	private JButton btnRandom, btnByHand;
	private JPanel pnCode;
	private JSlider slSize;
	private JScrollPane pnScroll; 
	private DefaultListModel<String> model;
	private JPanel pnAlgorithm;
	private JRadioButton rdSelectionSort, rdBubbleSort, rdBuketSort, rdMergeSort;
	private ButtonGroup grSort;
	private JPanel pnControl;
	private JRadioButton rdIncrease, rdDecrease;
	private JButton btnSort, btnStop;
	private JSlider slSpeed;
    private ArrayVisualizer arrayVisualizer;
    private ISortAlgoritms algorithm;
    
    private ActionListener eIncrease, eDecrease;
    private ActionListener eSelectionSort, eBubbleSort, eBuketSort, eMergeSort;
	private ChangeListener eSize;
    private ChangeListener eSpeed;
    
    public static int time = 50;
    public static JList<String> lsCode;
    

	private boolean isIncrease = true ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizerFrame frame = new VisualizerFrame();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //set JFrame full screen
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

//	 Create the application.
	 
	public VisualizerFrame(){
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setTitle("M\u00F4 ph\u1ECFng thu\u1EADt to\u00E1n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1376, 742);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lbTitle = new JLabel("M\u00D4 PH\u1ECENG THU\u1EACT TO\u00C1N");
		lbTitle.setBackground(SystemColor.menu);
		lbTitle.setBounds(5, 5, 1286, 28);
		lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitle.setFont(new Font("Tahoma", Font.BOLD, 23));
		contentPane.add(lbTitle);
		
		pnTool = new JPanel();
		pnTool.setBounds(5, 415, 1350, 287);
		contentPane.add(pnTool);
		
		pnArray = new JPanel();
		pnArray.setBackground(SystemColor.menu);
		pnArray.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "D\u1EEF li\u1EC7u", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		pnCode = new JPanel();
		pnCode.setBackground(SystemColor.menu);
		pnCode.setBorder(new TitledBorder(null, "Code C/C++", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		pnAlgorithm = new JPanel();
		pnAlgorithm.setBackground(SystemColor.menu);
		pnAlgorithm.setBorder(new TitledBorder(null, "L\u1EF1a ch\u1ECDn thu\u1EADt to\u00E1n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		pnControl = new JPanel();
		pnControl.setBackground(SystemColor.menu);
		pnControl.setBorder(new TitledBorder(null, "\u0110i\u1EC1u khi\u1EC3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_pnTool = new GroupLayout(pnTool);
		gl_pnTool.setHorizontalGroup(
			gl_pnTool.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnTool.createSequentialGroup()
					.addComponent(pnArray, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnCode, GroupLayout.PREFERRED_SIZE, 506, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(pnAlgorithm, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(pnControl, GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_pnTool.setVerticalGroup(
			gl_pnTool.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnTool.createParallelGroup(Alignment.BASELINE)
					.addComponent(pnArray, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
					.addComponent(pnCode, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
					.addComponent(pnAlgorithm, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
					.addComponent(pnControl, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE))
		);
		pnControl.setLayout(null);
		
		slSpeed = new JSlider();
		slSpeed.setOrientation(SwingConstants.VERTICAL);
		slSpeed.setBounds(241, 20, 32, 244);
        slSpeed.setMinimum(1);
        slSpeed.setMaximum(9);
        slSpeed.setValue(5);
		pnControl.add(slSpeed);
		
		rdIncrease = new JRadioButton("S\u1EAFp x\u1EBFp t\u0103ng d\u1EA7n");
		rdIncrease.setBounds(52, 42, 144, 23);
		pnControl.add(rdIncrease);
		
		rdDecrease = new JRadioButton("S\u1EAFp x\u1EBFm gi\u1EA3m d\u1EA7n");
		rdDecrease.setBounds(52, 87, 144, 23);
		pnControl.add(rdDecrease);
		
		btnSort = new JButton("S\u1EAFp x\u1EBFp");
		btnSort.setBackground(SystemColor.activeCaption);
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SortVisualizer(algorithm, isIncrease);
			}
		});
		btnSort.setBounds(52, 140, 120, 25);
		pnControl.add(btnSort);
		
		btnStop = new JButton("||");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				
			}
		});
		btnStop.setBackground(SystemColor.activeCaption);
		btnStop.setBounds(52, 192, 120, 25);
		pnControl.add(btnStop);
		pnAlgorithm.setLayout(null);
		
		rdSelectionSort = new JRadioButton("Selection Sort");
		rdSelectionSort.setBounds(24, 70, 149, 23);
		pnAlgorithm.add(rdSelectionSort);
		
		rdBubbleSort = new JRadioButton("Bubble Sort");
		rdBubbleSort.setBounds(24, 96, 149, 23);
		pnAlgorithm.add(rdBubbleSort);
		
		rdMergeSort = new JRadioButton("Merge Sort");
		rdMergeSort.setBounds(24, 122, 149, 23);
		pnAlgorithm.add(rdMergeSort);
		pnCode.setLayout(null);
		
		rdBuketSort = new JRadioButton("Buket Sort");
		rdBuketSort.setBounds(24, 148, 149, 23);
		pnAlgorithm.add(rdBuketSort);
		
		
		
		slSize = new JSlider();
                slSize.setMinimum(13);
                slSize.setMaximum(20);
                slSize.setValue(14);
		slSize.setBounds(15, 16, 466, 26); //default 10, 21, 486, 26
		pnCode.add(slSize);
		
		pnScroll = new JScrollPane();
		pnScroll.setBounds(15, 53, 476, 223); // default 10, 53, 486, 223
		pnCode.add(pnScroll);
		model = new DefaultListModel<>();
		lsCode = new JList<String>(model);
		lsCode.setBorder(new LineBorder(new Color(0, 0, 0)));
		lsCode.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lsCode.setFont(new Font("Monospaced",Font.BOLD,14));
		pnScroll.setViewportView(lsCode);
		
		pnCreateArray = new JPanel();
		pnCreateArray.setBackground(SystemColor.menu);
		pnCreateArray.setBorder(new TitledBorder(null, "Kh\u1EDFi t\u1EA1o m\u1EA3ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		pnSetValueArray = new JPanel();
		pnSetValueArray.setBackground(SystemColor.menu);
		pnSetValueArray.setBorder(new TitledBorder(null, "T\u1EA1o d\u1EEF li\u1EC7u m\u1EA3ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_pnArray = new GroupLayout(pnArray);
		gl_pnArray.setHorizontalGroup(
			gl_pnArray.createParallelGroup(Alignment.LEADING)
				.addComponent(pnSetValueArray, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
				.addComponent(pnCreateArray, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
		);
		gl_pnArray.setVerticalGroup(
			gl_pnArray.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_pnArray.createSequentialGroup()
					.addComponent(pnCreateArray, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(pnSetValueArray, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
		);
		
		btnRandom = new JButton("Ng\u1EABu nhi\u00EAn");
		btnRandom.setBackground(SystemColor.activeCaption);
		btnRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				arrayVisualizer.createRandom();
			}
		});
		btnRandom.setBounds(15, 27, 120, 25);
		
		btnByHand = new JButton("B\u1EB1ng tay");
		btnByHand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				arrayVisualizer.createHand();
			}
		});
		btnByHand.setBackground(SystemColor.activeCaption);
		btnByHand.setBounds(160, 27, 120, 25);
		pnSetValueArray.setLayout(null);
		pnSetValueArray.add(btnRandom);
		pnSetValueArray.add(btnByHand);
		
		lbNum = new JLabel("S\u1ED1 ph\u1EA7n t\u1EED m\u1EA3ng\r\n:");
		lbNum.setBounds(16, 27, 139, 20);
		
		SpinnerModel sm = new SpinnerNumberModel(2, 2, 15, 1);
		spNum = new JSpinner(sm);
		spNum.setBounds(160, 25, 120, 25);
		JFormattedTextField txt = ((JSpinner.NumberEditor) spNum.getEditor()).getTextField();
		((NumberFormatter) txt.getFormatter()).setAllowsInvalid(false);
		
		btnCreateArray = new JButton("T\u1EA1o m\u1EA3ng");
		btnCreateArray.setBackground(SystemColor.activeCaption);
		btnCreateArray.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				arrayVisualizer = new ArrayVisualizer(pnImitiate, spNum);
			}
		});
		btnCreateArray.setBounds(160, 59, 120, 25);
		
		btnDeleteArray = new JButton("X\u00F3a m\u1EA3ng");
		btnDeleteArray.setBackground(SystemColor.activeCaption);
		btnDeleteArray.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				arrayVisualizer.deleteArray();
			}
		});
		btnDeleteArray.setBounds(160, 95, 120, 25);
		
		btnSetZero = new JButton("\u0110\u1EB7t v\u1EC1 0");
		btnSetZero.setBackground(SystemColor.activeCaption);
		btnSetZero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				arrayVisualizer.setZero();
			}
		});
		btnSetZero.setBounds(15, 95, 120, 25);
		pnCreateArray.setLayout(null);
		pnCreateArray.add(lbNum);
		pnCreateArray.add(btnSetZero);
		pnCreateArray.add(btnCreateArray);
		pnCreateArray.add(spNum);
		pnCreateArray.add(btnDeleteArray);
		
		lbMaxNum = new JLabel("(T\u1ED1i \u0111a 15)");
		lbMaxNum.setHorizontalAlignment(SwingConstants.CENTER);
		lbMaxNum.setBounds(10, 47, 109, 14);
		pnCreateArray.add(lbMaxNum);
		pnArray.setLayout(gl_pnArray);
		pnTool.setLayout(gl_pnTool);
		
		pnImitiate = new JPanel();
		pnImitiate.setBackground(SystemColor.menu);
		pnImitiate.setBorder(new TitledBorder(null, "Khung ch\u1EA1y m\u00F4 ph\u1ECFng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnImitiate.setBounds(5, 44, 1355, 360);
		contentPane.add(pnImitiate);
		pnImitiate.setLayout(null);
                
		grSort = new ButtonGroup();
		grSort.add(rdSelectionSort);
		grSort.add(rdBubbleSort);
		grSort.add(rdMergeSort);
		grSort.add(rdBuketSort);
		
		ButtonGroup grDirect = new ButtonGroup();
		grDirect.add(rdDecrease);
		grDirect.add(rdIncrease);
		rdIncrease.setSelected(true);
		
		// TODO: step by step
//		JButton btnPrev = new JButton("PREV");
//		btnPrev.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//			}
//		});
//		btnPrev.setBounds(10, 241, 89, 23);
//		pnControl.add(btnPrev);
//		
//		btnNewButton_1 = new JButton("NEXT");
//		btnNewButton_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		btnNewButton_1.setBounds(137, 241, 89, 23);
//		pnControl.add(btnNewButton_1);

		lsCode.setSelectedIndex(0);
		lsCode.ensureIndexIsVisible(lsCode.getSelectedIndex());
		
		/*
		 * event Action Listener all sorts
		 */
		
		eSelectionSort = new ActionListener() {
		      public void actionPerformed(ActionEvent actionEvent) {
		    	  model.removeAllElements();
		    	  algorithm = new SelectionSort();
		    	  algorithm.addCode(model);
		    	  lsCode.setSelectedIndex(0);
		      }
		};
		
		eBubbleSort = new ActionListener() {
		      public void actionPerformed(ActionEvent actionEvent) {
		    	  model.removeAllElements();
		    	  algorithm = new BubbleSort();
		    	  algorithm.addCode(model);
		    	  lsCode.setSelectedIndex(0);
		      }
		};
		
		
		eBuketSort = new ActionListener() {
		      public void actionPerformed(ActionEvent actionEvent) {
		    	  // Wait fix
		      }
		};
		

		eMergeSort = new ActionListener() {
				public void actionPerformed(ActionEvent actionEvent) {
					model.removeAllElements();
					algorithm = new MergeSort();
			    	algorithm.addCode(model);
					lsCode.setSelectedIndex(0);
				}
		};
		

		rdSelectionSort.addActionListener(eSelectionSort);
		rdBubbleSort.addActionListener(eBubbleSort);
		rdMergeSort.addActionListener(eMergeSort);
		rdBuketSort.addActionListener(eBuketSort);
		
		// Set default
		rdSelectionSort.setSelected(true);
		model.removeAllElements();
		algorithm = new SelectionSort();
		algorithm.addCode(model);
		lsCode.setSelectedIndex(0);
		
		// TODO: Show info coder
//		btnNewButton = new JButton("Info");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
////
//			}
//		});
//		btnNewButton.setBackground(SystemColor.activeCaption);
//		btnNewButton.setBounds(1294, 5, 61, 31);
//		contentPane.add(btnNewButton);
		
		eSize = new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lsCode.setFont(new Font("Monospaced",Font.BOLD,slSize.getValue()));
				lsCode.repaint();
		    }
		};
		
		slSize.addChangeListener(eSize);
                
        eSpeed = new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                time = 100 - slSpeed.getValue() * 10;
            }
        };
        
        slSpeed.addChangeListener(eSpeed);
		
		eIncrease = new ActionListener() {
		      public void actionPerformed(ActionEvent actionEvent) {
		    	//set Increase or Decrease
		    	  isIncrease = true;		    	  
		    	  //update element sort
		    	  if (rdSelectionSort.isSelected())
		    		  model.set(5, "               if (a[j] < a[pos])");
		    	  if (rdBubbleSort.isSelected())
		    		  model.set(4,"               if(a[j] < a[j-1])");
		      }
		};
		
		eDecrease = new ActionListener() {
		      public void actionPerformed(ActionEvent actionEvent) {
		    	  isIncrease = false;
		    	 
		    	  if (rdSelectionSort.isSelected())
		    		  model.set(5, "               if (a[j] > a[pos])");
		    	  if (rdBubbleSort.isSelected())
		    		  model.set(4,"               if(a[j] > a[j-1])");
		      }
		};
		
		rdIncrease.addActionListener(eIncrease);
		rdDecrease.addActionListener(eDecrease);
//		setState(0);
	}
	
	

}

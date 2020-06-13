package hust.soict.hedspi.visualization;

import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.NumberFormatter;

import hust.soict.hedspi.visualization.action.ArrayVisualizer;
import hust.soict.hedspi.visualization.action.Element;
import hust.soict.hedspi.visualization.action.PointRun;
import hust.soict.hedspi.visualization.action.SortVisualizer;
import hust.soict.hedspi.visualization.algotrithms.BubbleSort;
import hust.soict.hedspi.visualization.algotrithms.BucketSort;
import hust.soict.hedspi.visualization.algotrithms.ISortAlgoritms;
import hust.soict.hedspi.visualization.algotrithms.MergeSort;
import hust.soict.hedspi.visualization.algotrithms.SelectionSort;

public class VisualizerFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	
	private JPanel contentPane;
	private JPanel pnImitiate;
	private JPanel pnTool;
	private JPanel pnArray;
	private JPanel pnCreateArray;
	private JPanel pnSetValueArray;
	private JPanel pnCode;
	private JPanel pnAlgorithm;
	private JPanel pnControl;
	private JScrollPane pnScroll;
	
	private JLabel lbTitle;
	private JLabel lbNum, lbMaxNum;
	private JSpinner spNum;
	private JButton btnCreateArray, btnDeleteArray, btnSetZero;
	private JButton btnRandom, btnByHand;
	private ButtonGroup grSort;
	private JButton btnSort, btnStop;
	private JRadioButton rdSelectionSort, rdBubbleSort, rdBuketSort, rdMergeSort;
	private JRadioButton rdIncrease, rdDecrease;
	private JSlider slSize;
	private JSlider slSpeed;
	private DefaultListModel<String> model;

    private ActionListener eIncrease, eDecrease;
    private ActionListener eSelectionSort, eBubbleSort, eBuketSort, eMergeSort;
	private ChangeListener eSize;
    private ChangeListener eSpeed;
    
    private ArrayVisualizer arrayVisualizer;
    private SortVisualizer sortVisualizer;
    private ISortAlgoritms algorithm;
    public static int time = 50;
    public static JList<String> lsCode;
    private Element[] elementBoxs;
    private PointRun pointRun;

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
					frame.setState(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

//	 Create the application.
	 
	public VisualizerFrame(){
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setTitle("Mô phỏng thuật toán");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(47, 100, 1376, 742);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lbTitle = new JLabel("MÔ PHỎNG THUẬT TOÁN");
		lbTitle.setBackground(SystemColor.menu);
		lbTitle.setBounds(88, 20, 1286, 28);
		lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitle.setFont(new Font("Tahoma", Font.BOLD, 23));
		contentPane.add(lbTitle);
		
		pnTool = new JPanel();
		pnTool.setBounds(47, 480, 1350, 287);
		contentPane.add(pnTool);
		
		pnArray = new JPanel();
		pnArray.setBackground(SystemColor.menu);
		pnArray.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Dữ liệu", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		pnCode = new JPanel();
		pnCode.setBackground(SystemColor.menu);
		pnCode.setBorder(new TitledBorder(null,"Pseudo Code", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		pnAlgorithm = new JPanel();
		pnAlgorithm.setBackground(SystemColor.menu);
		pnAlgorithm.setBorder(new TitledBorder(null, "Lựa chọn thuật toán", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		pnControl = new JPanel();
		pnControl.setBackground(SystemColor.menu);
		pnControl.setBorder(new TitledBorder(null, "Điều khiển", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
		
		rdIncrease = new JRadioButton("Sắp xếp tăng dần");
		rdIncrease.setBounds(52, 42, 144, 23);
		pnControl.add(rdIncrease);
		
		rdDecrease = new JRadioButton("Sắp xếp giảm dần");
		rdDecrease.setBounds(52, 87, 160, 23);
		pnControl.add(rdDecrease);
		
		btnSort = new JButton("SẮP XẾP");
		btnSort.setBackground(SystemColor.activeCaption);
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sortVisualizer = new SortVisualizer(pnImitiate, algorithm, elementBoxs, pointRun, isIncrease);
				setState(3);
			}
		});
		btnSort.setBounds(52, 140, 120, 25);
		pnControl.add(btnSort);
		
		btnStop = new JButton("PAUSE");
		btnStop.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(btnStop.getText().equals("PAUSE")) {
					btnStop.setText("PLAY");
					for(int i = 0; i <= SortVisualizer.curT; i++) {
						if(SortVisualizer.threads[i].isAlive()) {
							try {
								SortVisualizer.threads[i].suspend();
							} catch (Exception e2) {
								e2.printStackTrace();
							}
						}
					}
				}
				else {
					btnStop.setText("PAUSE");
					for(int i = 0; i <= SortVisualizer.curT; i++) {
						try {
							SortVisualizer.threads[i].resume();
						} catch (Exception e2) {
							e2.printStackTrace();
						}
					}
				}
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
		pnCreateArray.setBorder(new TitledBorder(null, "Khởi tạo mảng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		pnSetValueArray = new JPanel();
		pnSetValueArray.setBackground(SystemColor.menu);
		pnSetValueArray.setBorder(new TitledBorder(null, "Tạo dữ liệu mảng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
		
		btnRandom = new JButton("Ngẫu nhiên");
		btnRandom.setBackground(SystemColor.activeCaption);
		btnRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				arrayVisualizer.createRandom();
				setState(2);
			}
		});
		btnRandom.setBounds(15, 27, 120, 25);
		
		btnByHand = new JButton("Bằng tay");
		btnByHand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				arrayVisualizer.createHand();
				setState(2);
			}
		});
		btnByHand.setBackground(SystemColor.activeCaption);
		btnByHand.setBounds(160, 27, 120, 25);
		pnSetValueArray.setLayout(null);
		pnSetValueArray.add(btnRandom);
		pnSetValueArray.add(btnByHand);
		
		lbNum = new JLabel("Số phần tử mảng : ");
		lbNum.setBounds(16, 27, 139, 20);
		
		SpinnerModel sm = new SpinnerNumberModel(2, 2, 15, 1);
		spNum = new JSpinner(sm);
		spNum.setBounds(160, 25, 120, 25);
		JFormattedTextField txt = ((JSpinner.NumberEditor) spNum.getEditor()).getTextField();
		((NumberFormatter) txt.getFormatter()).setAllowsInvalid(false);
		
		btnCreateArray = new JButton("Tạo mảng");
		btnCreateArray.setBackground(SystemColor.activeCaption);
		btnCreateArray.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pointRun = new PointRun();
				arrayVisualizer = new ArrayVisualizer(pnImitiate, spNum, elementBoxs, pointRun);
				// set elementBoxs --> use it when sorting, animation
				elementBoxs = arrayVisualizer.getElementBoxs();
				setState(1);
			}
		});
		btnCreateArray.setBounds(160, 59, 120, 25);
		
		btnDeleteArray = new JButton("Xoá mảng");
		btnDeleteArray.setBackground(SystemColor.activeCaption);
		btnDeleteArray.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				arrayVisualizer.deleteArray();
				setState(0);
			}
		});
		btnDeleteArray.setBounds(160, 95, 120, 25);
		
		btnSetZero = new JButton("Đặt về 0");
		btnSetZero.setBackground(SystemColor.activeCaption);
		btnSetZero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				arrayVisualizer.setZero();
				setState(1);
			}
		});
		btnSetZero.setBounds(15, 95, 120, 25);
		pnCreateArray.setLayout(null);
		pnCreateArray.add(lbNum);
		pnCreateArray.add(btnSetZero);
		pnCreateArray.add(btnCreateArray);
		pnCreateArray.add(spNum);
		pnCreateArray.add(btnDeleteArray);
		
		lbMaxNum = new JLabel("(Tối đa 15)");
		lbMaxNum.setHorizontalAlignment(SwingConstants.CENTER);
		lbMaxNum.setBounds(10, 47, 109, 14);
		pnCreateArray.add(lbMaxNum);
		pnArray.setLayout(gl_pnArray);
		pnTool.setLayout(gl_pnTool);
		
		pnImitiate = new JPanel();
		pnImitiate.setBackground(SystemColor.menu);
		pnImitiate.setBorder(new TitledBorder(null, "Khung chạy mô phỏng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnImitiate.setBounds(47, 60, 1355, 410);
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
		    	  model.removeAllElements();
		    	  algorithm = new BucketSort();
		    	  algorithm.addCode(model);
		    	  lsCode.setSelectedIndex(0);
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
	
	public void setState(int state) {
		switch (state) {
		case 0: //first state, haven't created arrays.
			btnStop.setText("PAUSE");
			btnCreateArray.setEnabled(true);
			btnDeleteArray.setEnabled(false);
			btnSetZero.setEnabled(false);

			btnRandom.setEnabled(false);
			btnByHand.setEnabled(false);

			rdSelectionSort.setEnabled(false);
			rdBubbleSort.setEnabled(false);
			rdMergeSort.setEnabled(false);
			rdBuketSort.setEnabled(false); 
			
			rdIncrease.setEnabled(false);
			rdDecrease.setEnabled(false);
			
			btnSort.setEnabled(false);
			btnStop.setEnabled(false);
			break;
		case 1: //created arrays, be waiting to set value arrays.
			btnStop.setText("PAUSE");
			btnDeleteArray.setEnabled(true);
			btnSetZero.setEnabled(true);
			
			btnRandom.setEnabled(true);
			btnByHand.setEnabled(true);
			
			rdSelectionSort.setEnabled(true);
			rdBubbleSort.setEnabled(true);
			rdMergeSort.setEnabled(true);
			rdBuketSort.setEnabled(true);
			
			rdIncrease.setEnabled(true);
			rdDecrease.setEnabled(true);
			break;
		case 2: //be set values, ready to sort
			btnDeleteArray.setEnabled(true);
			btnSetZero.setEnabled(true);
			btnRandom.setEnabled(true);
			
			rdSelectionSort.setEnabled(true);
			rdBubbleSort.setEnabled(true);
			rdMergeSort.setEnabled(true);
			rdBuketSort.setEnabled(true);
			
			rdIncrease.setEnabled(true);
			rdDecrease.setEnabled(true);
			
			btnSort.setEnabled(true);
			btnStop.setEnabled(false);
			break;
		case 3: //sorting
			btnCreateArray.setEnabled(true);
			btnDeleteArray.setEnabled(true);
			btnSetZero.setEnabled(false);
			
			btnRandom.setEnabled(false);
			btnByHand.setEnabled(false);

			
			rdIncrease.setEnabled(false);
			rdDecrease.setEnabled(false);
			

			rdSelectionSort.setEnabled(false);
			rdBubbleSort.setEnabled(false);
			rdMergeSort.setEnabled(false);
			rdBuketSort.setEnabled(false);
			
			btnSort.setEnabled(false);
			btnStop.setEnabled(true);
			break;
			
		case 4: //sort done
			btnCreateArray.setEnabled(true);
			btnDeleteArray.setEnabled(true);
			btnSetZero.setEnabled(true);
			
			btnRandom.setEnabled(true);
			btnByHand.setEnabled(true);
			
			rdSelectionSort.setEnabled(true);
			rdBubbleSort.setEnabled(true);
			rdMergeSort.setEnabled(true);
			rdBuketSort.setEnabled(true);
			
			rdIncrease.setEnabled(true);
			rdDecrease.setEnabled(true);
			
			btnSort.setEnabled(true);
			btnStop.setEnabled(true);
			break;
		}
	}
	

}

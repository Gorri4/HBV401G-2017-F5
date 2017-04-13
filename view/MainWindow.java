package view;

import control.*;
import model.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JCheckBox;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private String day;
	private String month;
	private String year;
	private String airline;
	JComboBox comboFilter = new JComboBox();
	//private SearchDbManagerInterface Mock = new MockSearchDbManager();
	//private SearchContainer sc = new SearchContainer(Mock);
	private SearchDbManagerInterface RealDbManager = new SearchDbManager();
	private SearchContainer sc = new SearchContainer(RealDbManager);
	//private ListPanel lp = new ListPanel();
	private ListPanel panel_1;
	private DefaultListModel<Flight> model = new DefaultListModel<Flight>();
	//private DefaultTableModel mdl = new DefaultTableModel();
	
	private String[] days = new String[] {"","01", "02", "03", "04", "05", "06", "07", "08",
										"09", "10", "11", "12", "13", "14", "15",
										"16", "17", "18", "19", "20", "21", "22", 
										"23", "24", "25", "26", "27", "28", "29", "30", "31"};
	private String[] months = new String[] {"", "01", "02", "03", "04", "05", "06", 
											"07", "08", "09", "10", "11", "12"};
	private String[] years = new String[] {"", "2017", "2018", "2019"};

	// List of flights to display
	private ArrayList<Flight> alist = null;
	private boolean sortingdatebool = true;
	private boolean sortingpricebool = true;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 537);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 140, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(255, 140, 0), 5));
		panel.setBackground(new Color(255, 140, 0));
		contentPane.add(panel, BorderLayout.NORTH);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 255));
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickSearch();
			}
		});
		
		JLabel lblSearchCities = new JLabel("Search cities:");
		lblSearchCities.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		panel.add(lblSearchCities);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblDate = new JLabel("Month:");
		lblDate.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		panel.add(lblDate);
		
		JComboBox comboMonth = new JComboBox(months);
		comboMonth.setBackground(new Color(255, 255, 255));
		comboMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox kassi = (JComboBox)e.getSource();
				month = (String) kassi.getSelectedItem();
				if (month == "") month = null;
			}
		});
		panel.add(comboMonth);
		
		JComboBox comboDay = new JComboBox(days);
		comboDay.setBackground(new Color(255, 255, 255));
		comboDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox kassi = (JComboBox)e.getSource();
				day = (String) kassi.getSelectedItem();
				if (day == "") day = null;
			}
		});
		
		JLabel lblDay = new JLabel("Day:");
		lblDay.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		panel.add(lblDay);
		panel.add(comboDay);
		
		JComboBox comboYear = new JComboBox(years);
		comboYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox kassi = (JComboBox)e.getSource();
				year = (String) kassi.getSelectedItem();
				if (year == "") year = null;
			}
		});
		
		JLabel lblYear = new JLabel("Year:");
		lblYear.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		panel.add(lblYear);
		panel.add(comboYear);
		
		JButton btnClickSearch = new JButton("Search");
		btnClickSearch.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnClickSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clickSearch();
			}
		});
		panel.add(btnClickSearch);
		
		panel_1 = new ListPanel(model);
		//panel_1 = new TablePanel(mdl);

		panel_1.setBackground(Color.WHITE);
		panel_1.setForeground(Color.BLACK);
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(255, 140, 0), 6));
		panel_2.setBackground(new Color(255, 140, 0));
		contentPane.add(panel_2, BorderLayout.EAST);
		
		JLabel lblNewLabel = new JLabel("Filter Airlines");
		
		
		comboFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox kassi = (JComboBox)e.getSource();
				airline = (String) kassi.getSelectedItem();
				if (airline == "") airline = null;
			}
		});
			
		
		JButton btnNewButton = new JButton("Sort by date");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sc.sort(alist, "date", sortingdatebool);
				panel_1.updateList(alist);
				sortingdatebool = !sortingdatebool;
			}
		});
		
		JButton btnNewButton_1 = new JButton("Sort by price");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sc.sort(alist, "", sortingpricebool);
				panel_1.updateList(alist);
				sortingpricebool = !sortingpricebool;
			}
		});
		
		JButton btnFilter = new JButton("Filter");
		btnFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(airline == null){
					clickSearch();
				}
				else{
					String[] arr = {airline};
					alist = sc.filter(arr);
					panel_1.updateList(alist);
				}
			}
		});
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Meal Included");
		
		JCheckBox chckbxBagIncluded = new JCheckBox("Bag Included");
		
		
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
								.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
									.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
										.addComponent(chckbxBagIncluded)
										.addComponent(chckbxNewCheckBox))
									.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE))))
						.addComponent(btnFilter)
						.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(comboFilter, 0, 128, Short.MAX_VALUE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboFilter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxNewCheckBox)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxBagIncluded)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnFilter)
					.addGap(63)
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(btnNewButton_1)
					.addContainerGap(157, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
	}
	
	
	
	public void clickSearch(){
		String s = textField.getText();
		City c = new City(s,0);
		
		
		if( day == null || month == null || year == null){
			alist = sc.search(0, null, c, null, 0);
		}
		else{
			String string_date = day + "-" + month + "-" + year;

			SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
			long milliseconds = -1L;
			try {
		    	Date d = f.parse(string_date);
		    	milliseconds = d.getTime();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			alist = sc.search(0, milliseconds, c, null, 0);
		}
		//sc.sort("date");
		 //alist=sc.sort("lala");
		/*String[] g = {"WOW", "Emirates"};
		alist = sc.filter(g);*/
		for(Flight flug : alist)
		{
			System.out.print(flug.getFlightNum());
			System.out.print(flug.getAirline().getName());
			System.out.print(flug.getDepCity().getName());
			System.out.print(flug.getArrCity().getName());
			System.out.println();
		}
		
		panel_1.updateList(alist);
		
		// add into the combobox appropriate airlines
		comboFilter.removeAllItems();
		comboFilter.addItem("");
		ArrayList<String> airl = new ArrayList<String>();
		for(int i = 0; i<alist.size(); i++){
			airl.add(alist.get(i).getAirline().getName());
		}
		Set<String> hs = new HashSet<>();
		hs.addAll(airl);
		airl.clear();
		airl.addAll(hs);
		for (String nafn : airl){
			comboFilter.addItem(nafn);
		}		
	}
}

package view;

import control.*;
import model.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JComboBox comboDay;
	private JComboBox comboMonth;
	private JComboBox comboYear;
	//private SearchDbManagerInterface Mock = new MockSearchDbManager();
	//private SearchContainer sc = new SearchContainer(Mock);
	private SearchDbManagerInterface RealDbManager = new SearchDbManager();
	private SearchContainer sc = new SearchContainer(RealDbManager);
	//private ListPanel lp = new ListPanel();
	private ListPanel panel_1;
	private DefaultListModel<Flight> model = new DefaultListModel<Flight>();
	
	private String[] days = new String[] {"","1.", "2.", "3.", "4.", "5.", "6.", "7.", "8.",
										"9.", "10.", "11.", "12.", "13.", "14.", "15.",
										"16.", "17.", "18.", "19.", "20.", "21.", "22.", 
										"23.", "24.", "25.", "26.", "27.", "28.", "29.", "30.", "31."};
	private String[] months = new String[] {"", "January", "February", "Mars", "April", "May", "June", 
											"July", "August", "September", "October", "November", "December"};
	private String[] years = new String[] {"", "2017", "2018", "2019"};

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
		setBounds(100, 100, 592, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickSearch();
			}
		});
		
		JLabel lblSearchCities = new JLabel("Search cities:");
		panel.add(lblSearchCities);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnClickSearch = new JButton("Search");
		btnClickSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clickSearch();
			}
		});
		panel.add(btnClickSearch);
		
		JLabel lblDate = new JLabel("Date:");
		panel.add(lblDate);
		
		JComboBox comboMonth = new JComboBox(months);
		panel.add(comboMonth);
		
		JComboBox comboDay = new JComboBox(days);
		panel.add(comboDay);
		
		JComboBox comboYear = new JComboBox(years);
		panel.add(comboYear);
		
		panel_1 = new ListPanel(model);
		contentPane.add(panel_1, BorderLayout.CENTER);
	}
	
	
	
	public void clickSearch(){
		String s = textField.getText();
		System.out.println(s);
		City c = new City(s,0);
		Object day = comboDay.getSelectedItem();
		Object month = comboMonth.getSelectedItem();
		Object year = comboYear.getSelectedItem();
		String dagur = day.toString();
		String manudur = month.toString();
		String ar = year.toString();
		
		String string_date = dagur + "-" + manudur + "-" + ar;

		SimpleDateFormat f = new SimpleDateFormat("dd-MMM-yyyy");
		long milliseconds = -1L;
		try {
		    Date d = f.parse(string_date);
		    milliseconds = d.getTime();
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		
		ArrayList<Flight> alist = sc.search(0, milliseconds, c, null, 0);
		
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
	}

}

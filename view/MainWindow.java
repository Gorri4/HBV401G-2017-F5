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
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JList;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private SearchDbManagerInterface Mock = new MockSearchDbManager();
	private SearchContainer sc = new SearchContainer(Mock);
	//private ListPanel lp = new ListPanel();
	private ListPanel panel_1;
	private DefaultListModel<Flight> model = new DefaultListModel<Flight>();

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
		setBounds(100, 100, 521, 437);
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
		
		panel_1 = new ListPanel(model);
		contentPane.add(panel_1, BorderLayout.CENTER);
	}
	
	
	
	public void clickSearch(){
		String s = textField.getText();
		System.out.println(s);
		City c = new City(s,0);
		ArrayList<Flight> alist = sc.search(0, null, c, null, 0);
		//sc.sort("date");
		 //alist=sc.sort("lala");
		String[] g = {"WOW", "World"};
		alist = sc.filter(g);
		for(Flight f : alist)
		{
			System.out.print(f.getFlightNum());
			System.out.print(f.getAirline().getName());
			System.out.print(f.getDepCity().getName());
			System.out.print(f.getArrCity().getName());
			System.out.println();
		}
		
		panel_1.updateList(alist);
	}

}

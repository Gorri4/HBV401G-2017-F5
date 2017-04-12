package view;

import javax.swing.JPanel;

import model.*;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;
import javax.swing.BoxLayout;

public class ListPanel extends JPanel {

	DefaultListModel<Flight> model;
	ArrayList<Flight> arrlist;
	JList<Flight> list;
	
	/**
	 * Create the panel.
	 */
	public ListPanel(DefaultListModel<Flight> model) {
		this.model = model;
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		list = new JList<Flight>(model);
		scrollPane.setViewportView(list);
		
		
		list.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        JList<Flight> list = (JList<Flight>)evt.getSource();
		        if (evt.getClickCount() == 2) {

		            // Double-click detected
		            int index = list.locationToIndex(evt.getPoint());
		            System.out.println(index);
		            Flight f = list.getModel().getElementAt(index);
		            bookingscreen(f);
		        } else if (evt.getClickCount() == 3) {

		            // Triple-click detected
		        	// not used
		            int index = list.locationToIndex(evt.getPoint());
		            System.out.println(index);
		        }
		    }
		});

	}
	
	public void updateList(ArrayList<Flight> a){
		model.removeAllElements();
		arrlist = a;
		for(Flight f : a){
			model.addElement(f);
		}  
	}
	
	public void bookingscreen(Flight f){
		BookingWindow bw = new BookingWindow(f);
		bw.setVisible(true);
	}
	
	

}

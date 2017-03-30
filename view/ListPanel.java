package view;

import javax.swing.JPanel;

import model.*;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class ListPanel extends JPanel {

	DefaultListModel<Flight> model;
	ArrayList<Flight> arrlist;
	/**
	 * Create the panel.
	 */
	public ListPanel(DefaultListModel<Flight> model) {
		this.model = model;
		JList<Flight> list = new JList<Flight>(model);
		add(list);

	}
	
	public void updateList(ArrayList<Flight> a){
		arrlist = a;
		
		for(Flight f : a){
			model.addElement(f);
			System.out.println("r");
		}  
		System.out.println(model.get(0).getAirline().getName());
		System.out.println(model.get(1).getAirline().getName());
	}

}

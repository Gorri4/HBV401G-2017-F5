package view;

import javax.swing.JPanel;

import model.*;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.BoxLayout;

public class ListPanel extends JPanel {

	DefaultListModel<Flight> model;
	ArrayList<Flight> arrlist;
	/**
	 * Create the panel.
	 */
	public ListPanel(DefaultListModel<Flight> model) {
		this.model = model;
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		JList<Flight> list = new JList<Flight>(model);
		scrollPane.setViewportView(list);

	}
	
	public void updateList(ArrayList<Flight> a){
		model.removeAllElements();
		arrlist = a;
		for(Flight f : a){
			model.addElement(f);
		}  
	}

}

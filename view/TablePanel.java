package view;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Flight;
import javax.swing.JScrollPane;

public class TablePanel extends JPanel {

	DefaultTableModel model;
	ArrayList<Flight> arrlist;
	//JTable table;
	private JTable table_1;
	/**
	 * Create the panel.
	 */
	public TablePanel(DefaultTableModel model) {
		this.model = model;
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		
		
		
		
	}
	
	public void updateList(ArrayList<Flight> a){
		int rowCount = model.getRowCount();
		//Remove rows one by one from the end of the table
		for (int i = rowCount - 1; i >= 0; i--) {
		    model.removeRow(i);
		}
		
		
		arrlist = a;
		for(Flight f : a){
			String[] sf = {f.getFlightNum() + "", f.getArrCity().toString(), f.getAirline().toString()};
			System.out.println("a");
			model.addRow(sf);
			System.out.println("b");
		}  
		System.out.println(model.getRowCount());
		model.fireTableDataChanged();
	}
	

}

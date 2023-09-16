package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.beans.PropertyVetoException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Model.PalletTableModel;

public class PalletFrame extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	
	JPanel buttonPanel = new JPanel(new BorderLayout());
	JPanel optionPanel = new JPanel();
	JPanel exitPanel = new JPanel();
	
	JTable palletTable;
	
	JButton addButton = new JButton("Add");
	JButton editButton = new JButton("Edit");
	JButton removeButton = new JButton("Remove");
	JButton exitButton = new JButton("Exit");
	
	public PalletFrame() {
		super("Pallet");
		
		setSize(1000,600);
		try {
			setMaximum(true);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		
		palletTable = new JTable(new PalletTableModel());
		JScrollPane scrollPane = new JScrollPane(palletTable);
		palletTable.setFillsViewportHeight(true);
		
		Dimension buttonDimension = new Dimension(120,50);
		addButton.setPreferredSize(buttonDimension);
		editButton.setPreferredSize(buttonDimension);
		removeButton.setPreferredSize(buttonDimension);
		exitButton.setPreferredSize(buttonDimension);
		
		optionPanel.add(addButton);
		optionPanel.add(editButton);
		optionPanel.add(removeButton);
		
		exitPanel.setLayout(new FlowLayout(FlowLayout.CENTER,0,10));
		exitPanel.add(removeButton);
		
		buttonPanel.setPreferredSize(new Dimension(160, 0));
		buttonPanel.add(optionPanel, BorderLayout.CENTER);
		buttonPanel.add(exitPanel, BorderLayout.PAGE_END);
		
		add(scrollPane, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.LINE_END);
	}

}

package View.Container;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import Model.LoadPlannerDefaultTable;
import Model.ContainerTableModel;

public class ContainerFrame extends JInternalFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	JPanel mainPanel = new JPanel(); //--Contain Table
	JPanel previewPanel = new JPanel(); //--PreviewPanel
	JPanel buttonPanel = new JPanel(new BorderLayout()); //--Contain All Button
	JPanel actionButton = new JPanel(); //--Contain Action Button
	JPanel exitPanel = new JPanel(); //--Contain Exit Button
	
	public ContainerTableModel tableModel = new ContainerTableModel();
	JTable containerTable;
	JScrollPane scrollPane;
	
	JButton addButton = new JButton("Add");
	JButton editButton = new JButton("Edit");
	JButton removeButton = new JButton("Remove");
	JButton exitButton = new JButton("Exit");

	public ContainerFrame() {
		super("Container");
		
		setSize(1000, 600);
		try {
			setMaximum(true);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		
		//--Set Table
		containerTable = new LoadPlannerDefaultTable(tableModel);
		scrollPane = new JScrollPane(containerTable);
		scrollPane.setPreferredSize(containerTable.getPreferredSize());
		//scrollPane.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 0)));
		
		//--Set up Preview Panel
		//previewPanel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 255)));
		//previewPanel.add(new Button("test"));
		//previewPanel.setPreferredSize(new Dimension(100, 0));
		
		//--Set up Main Panel
		mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		mainPanel.add(scrollPane);
		mainPanel.add(previewPanel);
		//mainPanel.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0)));/**/
		
		//--Set Button 
		Dimension buttonDimension = new Dimension(120, 50);
		addButton.setPreferredSize(buttonDimension);
		editButton.setPreferredSize(buttonDimension);
		removeButton.setPreferredSize(buttonDimension);
		exitButton.setPreferredSize(buttonDimension);
		
		addButton.setActionCommand("add");
		addButton.addActionListener(this);
		
		actionButton.add(addButton);
		actionButton.add(editButton);
		actionButton.add(removeButton);
		
		exitPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
		exitPanel.add(exitButton);
		
		buttonPanel.setPreferredSize(new Dimension(160, 0));
		buttonPanel.add(actionButton, BorderLayout.CENTER);
		buttonPanel.add(exitPanel, BorderLayout.PAGE_END);
		
		//--Add panel to Content Pane
		add(mainPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.LINE_END);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "add": 
			AddContainerFrame addContainerFrame = new AddContainerFrame(this, tableModel, "Add Container");
			addContainerFrame.setModal(true);
			addContainerFrame.setVisible(true);
			break;
		}
	}
}

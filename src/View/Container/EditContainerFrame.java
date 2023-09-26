package View.Container;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import Model.Container;
import Model.ContainerTableModel;
import Model.Size;
import View.Common.DefaultCargoDialog;

public class EditContainerFrame extends DefaultCargoDialog {
	private static final long serialVersionUID = 1L;
	
	private ContainerTableModel containerTableModel;
	
	Container container;
	
	public EditContainerFrame(java.awt.Container parent, ContainerTableModel containerTableModel, int idContainer) {
		super(parent, "Edit Container");
		
		this.containerTableModel = containerTableModel;
		container = new Container(idContainer);
		initComponent();
	}
	
	private void initComponent() {
		nameField.setText(container.getName());
		
		Size size = container.getSize();
		widthSpinner.setValue(size.getWidth());
		lenghtSpinner.setValue(size.getLength());
		heightSpinner.setValue(size.getHeight());
		
		Color color = container.getColor();
		colorField.setBackground(color);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "done":
			String name = nameField.getText();
			int width = widthModel.getNumber().intValue();
			int lenght = lenghtModel.getNumber().intValue();
			int height = heightModel.getNumber().intValue();
			Size size = new Size(lenght, width, height);
			Color color = colorField.getBackground();
			
			if (container.edit(name, size, color)){
				JOptionPane.showMessageDialog(null, "Edit Container is successfully", "Edit Container", JOptionPane.PLAIN_MESSAGE);
				containerTableModel.updateTable();
			}else {
				JOptionPane.showMessageDialog(null, "Name or size or color is wrong, please check again!", "Edit Container", JOptionPane.ERROR_MESSAGE);
			}
			break;
		}
		dispose();
	}

}

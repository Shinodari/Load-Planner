package View.Container;

import java.awt.Color;
import java.awt.event.ActionEvent;

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
		// TODO Auto-generated method stub
		
	}

}

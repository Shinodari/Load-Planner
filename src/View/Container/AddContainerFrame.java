package View.Container;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import Model.Container;
import Model.ContainerTableModel;
import Model.Size;
import View.Common.DefaultCargoDialog;

public class AddContainerFrame extends DefaultCargoDialog {
	private static final long serialVersionUID = 1L;
	
	private ContainerTableModel containerTableModel;

	public AddContainerFrame(java.awt.Container parent, ContainerTableModel containerTableModel) {
		super(parent, "Add Container");
		this.containerTableModel = containerTableModel;
		colorField.setBackground(Color.BLACK);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "done":
			Container container = new Container();
			String name = nameField.getText();
			int width = (int) widthSpinner.getValue();
			int lenght = (int) lenghtSpinner.getValue();
			int height = (int) heightSpinner.getValue();
			Color color = colorField.getBackground();
			
			if (container.add(name, new Size(lenght, width, height), color)) {
				JOptionPane.showMessageDialog(null, "Add Container is successfully", "Add Container", JOptionPane.PLAIN_MESSAGE);
				containerTableModel.updateTable();;
			}else {
				JOptionPane.showMessageDialog(null, "Name or size or color is wrong, please check again!", "Add Container", JOptionPane.ERROR_MESSAGE);
			}
			
			break;
		}
		dispose();
	}

}

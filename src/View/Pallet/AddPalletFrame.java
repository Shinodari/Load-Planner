package View.Pallet;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import Model.Container;
import Model.PalletTableModel;
import Model.Size;
import View.Common.DefaultCargoDialog;

public class AddPalletFrame extends DefaultCargoDialog {
	private static final long serialVersionUID = 1L;
	
	private PalletTableModel palletTableModel;
	
	public AddPalletFrame(java.awt.Container parent, PalletTableModel palletTableModel) {
		super(parent, "Add Pallet");
		this.palletTableModel = palletTableModel;
		colorField.setBackground(Color.BLACK);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "done":
			Container container = new Container();
			String name = nameField.getText();
			int width = (int) widthSpinner.getValue();
			int lenght = (int) lengthModel.getValue();
			int height = (int) heightSpinner.getValue();
			Color color = colorField.getBackground();
			
			if (container.add(name, new Size(lenght, width, height), color)) {
				JOptionPane.showMessageDialog(null, "Add Pallet is successfully", "Add Pallet", JOptionPane.PLAIN_MESSAGE);
				palletTableModel.updateTable();;
			}else {
				JOptionPane.showMessageDialog(null, "Name or size or color is wrong, please check again!", "Add Pallet", JOptionPane.ERROR_MESSAGE);
			}
			
			break;
		}
		dispose();
	}
}

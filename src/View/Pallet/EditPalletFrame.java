package View.Pallet;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import Model.Pallet;
import Model.PalletTableModel;
import Model.Size;
import View.Common.DefaultCargoDialog;

public class EditPalletFrame extends DefaultCargoDialog {
	private static final long serialVersionUID = 1L;
	
	private PalletTableModel palletTableModel;
	
	Pallet pallet;
	
	public EditPalletFrame(java.awt.Container parent, PalletTableModel palletTableModel, int idPallet) {
		super(parent, "Edit Pallet");
		
		this.palletTableModel = palletTableModel;
		pallet = new Pallet(idPallet);
		initComponent();
	}
	
	private void initComponent() {
		nameField.setText(pallet.getName());
		
		Size size = pallet.getSize();
		widthSpinner.setValue(size.getWidth());
		lengthSpinner.setValue(size.getLength());
		heightSpinner.setValue(size.getHeight());
		
		Color color = pallet.getColor();
		colorField.setBackground(color);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "done":
			String name = nameField.getText();
			int width = widthModel.getNumber().intValue();
			int lenght = lengthModel.getNumber().intValue();
			int height = heightModel.getNumber().intValue();
			Size size = new Size(lenght, width, height);
			Color color = colorField.getBackground();
			
			if (pallet.edit(name, size, color)){
				JOptionPane.showMessageDialog(null, "Edit Container is successfully", "Edit Container", JOptionPane.PLAIN_MESSAGE);
				palletTableModel.updateTable();
			}else {
				JOptionPane.showMessageDialog(null, "Name or size or color is wrong, please check again!", "Edit Container", JOptionPane.ERROR_MESSAGE);
			}
			break;
		}
		dispose();
	}
}

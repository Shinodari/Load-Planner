package Model;

public class PalletTableModel extends LoadPlannerDefaultTableModel {
	private static final long serialVersionUID = 1L;
	
	private String[] columnNameStrings = {"Id", "Name", "Width", "Length", "Height", "Color"};
	
	public PalletTableModel() {
		this.columnNames = columnNameStrings;
        this.dataList = Pallet.getAllPallet();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Pallet pallet = (Pallet) this.dataList.get(rowIndex);
        switch (columnIndex) {
            case 0:
            	return pallet.getId();
            case 1:
            	return pallet.getName();
            case 2:
            	return pallet.size.getWidth();
            case 3:
            	return pallet.size.getLength();
            case 4:
            	return pallet.size.getHeight();
            case 5:
            	return pallet.color.getRGB();
            default:
            	return null;
        }
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return getValueAt(0, columnIndex).getClass();
	}

	@Override
	public void updateTable() {
		this.dataList = Container.getAllContainer();
		fireTableDataChanged();
	}
}

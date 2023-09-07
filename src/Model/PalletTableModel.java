package Model;

public class PalletTableModel extends LoadPlannerDefaultTableModel {
	public PalletTableModel() {
		this.columnNames = new String[]{"Id", "Name", "Width", "Length", "Height", "Color"};
		this.dataList = Container.getAllContainer();
	}
	
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return getValueAt(0, columnIndex).getClass();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Pallet pallet = (Pallet) this.dataList.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> pallet.getId();
            case 1 -> pallet.getName();
            case 2 -> pallet.size.getWidth();
            case 3 -> pallet.size.getLength();
            case 4 -> pallet.size.getHeight();
            case 5 -> pallet.color.getRGB();
            default -> null;
        };
	}
}

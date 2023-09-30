package Model;

public class ContainerTableModel extends LoadPlannerDefaultTableModel {
	private static final long serialVersionUID = 1L;
	
	private String[] columnNameStrings = {"Id", "Name", "Width", "Length", "Height", "Color"};
	
    public ContainerTableModel() {
        this.columnNames = columnNameStrings;
        this.dataList = Container.getAllContainer();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Container container = (Container) this.dataList.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> container.getId();
            case 1 -> container.getName();
            case 2 -> container.size.getWidth();
            case 3 -> container.size.getLength();
            case 4 -> container.size.getHeight();
            case 5 -> container.color.getRGB();
            default -> null;
        };
    }

	public void updateTable() {
		this.dataList = Container.getAllContainer();
		fireTableDataChanged();
	}
}

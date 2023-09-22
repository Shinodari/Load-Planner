package Model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public abstract class LoadPlannerDefaultTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	
	protected String[] columnNames;
    protected List dataList;

    @Override
    public int getRowCount() {
        return this.dataList.size();
    }

    @Override
    public int getColumnCount() {
        return this.columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return this.columnNames[column];
    }

    @Override
    public abstract Class<?> getColumnClass(int columnIndex);
}

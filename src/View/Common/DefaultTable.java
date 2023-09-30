package View.Common;

import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.table.TableModel;

public class DefaultTable extends JTable {
	private static final long serialVersionUID = 1L;
	
	private int collumnFreeSize = 1;
	
	public DefaultTable(TableModel tableModel) {
		this.setModel(tableModel);
		
		setPreferredSize(new Dimension(840, 600));
		setFillsViewportHeight(true); //Not Sure
		
		//--Set up column sizes.
		initColumnSize();
	}
	
	public DefaultTable(TableModel tableModel, int collumnFreeSize) {
		this(tableModel);
		
		this.collumnFreeSize = collumnFreeSize;
	}
	
	private void initColumnSize() {
        int columnCount = getColumnCount();
        for (int i = 0; i < columnCount; i++) {
        	if (i != collumnFreeSize) {
        		getColumnModel().getColumn(i).setPreferredWidth(128);;
        	}
        	else {
        		getColumnModel().getColumn(i).setPreferredWidth(200);;
        	}
        }
	}
}

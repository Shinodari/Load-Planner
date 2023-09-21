package Model;

import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.table.TableModel;

public class LoadPlannerDefaultTable extends JTable {
	private static final long serialVersionUID = 1L;
	
	private int collumnFreeSize = 1;
	
	public LoadPlannerDefaultTable(TableModel tableModel) {
		this.setModel(tableModel);
		
		setPreferredSize(new Dimension(840, 600));
		setFillsViewportHeight(true); //Not Sure
		
		//--Set up column sizes.
		initColumnSize();
	}
	
	public LoadPlannerDefaultTable(TableModel tableModel, int collumnFreeSize) {
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

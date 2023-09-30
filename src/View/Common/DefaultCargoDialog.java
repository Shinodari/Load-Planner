package View.Common;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpringLayout;

import View.lib.SpringUtilities;

/**
 * Dialog Template for class inheritance from {@link Model.Cargo Cargo Abstract Class}
 * <b>such as</b> Add or Edit Dialog
 * @since 1.0.0
 */
public abstract class DefaultCargoDialog extends JDialog implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Container main editable attributes of cargo class
	 * Including {@link #dimensionPanel dimensionPanel}
	 */
	protected JPanel mainPanel = new JPanel(new SpringLayout());
	/**
	 * Container All buttons
	 */
	protected JPanel buttonPanel = new JPanel();
	/**
	 * Container dimension attributes such as width length and height
	 */
	protected JPanel dimensionPanel[];
	
	/**
	 * TextField for name cargo
	 */
	protected JTextField nameField = new JTextField(50);
	
	//-- Default for Spinner of Dimension Attribute --//
	/**
	 * Default value dimension = 100
	 */
	final int DEFAULT_VALUE_DIMENSION = 100;
	/**
	 * Default minimum dimension = 0;
	 */
	final int DEFAULT_MIN_DIMENSION = 0;
	/**
	 * Default maximum dimension = 1000;
	 */
	final int DEFAULT_MAX_DIMENSION = 1000;
	/**
	 * Default step Dimension = 1;
	 */
	final int DEFAULT_STEP_DIMENSION = 1;
	/**
	 * Model for {@link #widthSpinner widthSpinner} 
	 * @see #DEFAULT_VALUE_DIMENSION
	 * @see #DEFAULT_MIN_DIMENSION
	 * @see #DEFAULT_MAX_DIMENSION
	 * @see #DEFAULT_STEP_DIMENSION
	 */
	protected SpinnerNumberModel widthModel = new SpinnerNumberModel(DEFAULT_VALUE_DIMENSION, DEFAULT_MIN_DIMENSION, DEFAULT_MAX_DIMENSION, DEFAULT_STEP_DIMENSION);
	/**
	 * Model for {@link #lengthSpinner lengthSpinner} 
	 * @see #DEFAULT_VALUE_DIMENSION
	 * @see #DEFAULT_MIN_DIMENSION
	 * @see #DEFAULT_MAX_DIMENSION
	 * @see #DEFAULT_STEP_DIMENSION
	 */
	protected SpinnerNumberModel lengthModel = new SpinnerNumberModel(DEFAULT_VALUE_DIMENSION, DEFAULT_MIN_DIMENSION, DEFAULT_MAX_DIMENSION, DEFAULT_STEP_DIMENSION);
	/**
	 * Model for {@link #heightSpinner heightSpinner} 
	 * @see #DEFAULT_VALUE_DIMENSION
	 * @see #DEFAULT_MIN_DIMENSION
	 * @see #DEFAULT_MAX_DIMENSION
	 * @see #DEFAULT_STEP_DIMENSION
	 */
	protected SpinnerNumberModel heightModel = new SpinnerNumberModel(DEFAULT_VALUE_DIMENSION, DEFAULT_MIN_DIMENSION, DEFAULT_MAX_DIMENSION, DEFAULT_STEP_DIMENSION);
	
	/**
	 * JSpinner for width cargo
	 */
	protected JSpinner widthSpinner = new JSpinner(widthModel);
	/**
	 * JSpinner for length cargo
	 */
	protected JSpinner lengthSpinner = new JSpinner(lengthModel);
	/**
	 * JSpinner for height cargo
	 */
	protected JSpinner heightSpinner = new JSpinner(heightModel);
	
	/**
	 * JTextField for color cargo
	 * But it show color by background only
	 * Can't write in this text field, it can change color by {@link #colorChooserButton ColorChooserButton}
	 */
	protected JTextField colorField = new JTextField(5);
	/**
	 * JButton Use call colorChosser to change color cargo
	 * @see #colorField
	 */
	protected JButton colorChooserButton = new JButton("...");
	
	/**
	 * Click to Done
	 */
	protected JButton doneButton = new JButton("Done");
	/**
	 * Click to Cancel
	 */
	protected JButton cancelButton = new JButton("Cancel");

	/**
	 * Constructor for create default cargo dialog
	 * @param parent	Parent Container for this dialog
	 * @param title		Title of Dialog
	 */
	public DefaultCargoDialog(Container parent,String title) {
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle(title);
		initComponent();
		pack();		

		int parentWidth = parent.getWidth();
		int parentHeight = parent.getHeight();
		int width = getWidth();
		int height = getHeight();
		int x = (parentWidth / 2) - (width / 2);
		int y = (parentHeight / 2) - (height / 2);
		setLocation(x, y);
	}
	
	private void initComponent() {
		colorField.setEnabled(false);
		Font font = colorChooserButton.getFont();
		colorChooserButton.setMargin(new Insets(1, 1, 1, 1));
		colorChooserButton.setPreferredSize(new Dimension(font.getSize()+1, colorField.getPreferredSize().height));
		colorChooserButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Color color = JColorChooser.showDialog(null, "Color Chooser", colorField.getBackground());
				if (color != null) {
					colorField.setBackground(color);
				}
			}
		});
		
		String[] labels = {"Name", "Width", "Length", "Height", "Color"};
		int numPairs = labels.length;
		dimensionPanel = new JPanel[numPairs];
		
		for (int i = 0; i < numPairs; i++) {
			JLabel label = new JLabel(labels[i] + " :", JLabel.TRAILING);
			mainPanel.add(label);
			dimensionPanel[i] = new JPanel(new FlowLayout(FlowLayout.LEFT));
			switch(i) {
			case 0:
				dimensionPanel[i].add(nameField);
				break;
			case 1:
				dimensionPanel[i].add(widthSpinner);
				break;
			case 2:
				dimensionPanel[i].add(lengthSpinner);
				break;
			case 3:
				dimensionPanel[i].add(heightSpinner);
				break;
			case 4:
				dimensionPanel[i].add(colorField);
				dimensionPanel[i].add(colorChooserButton);
			}
			
			mainPanel.add(dimensionPanel[i]);
		}		
		SpringUtilities.makeCompactGrid(mainPanel, numPairs, 2, 10, 10, 5, 10);		
		
		doneButton.setMnemonic(KeyEvent.VK_D);
		cancelButton.setMnemonic(KeyEvent.VK_C);
		
		doneButton.setActionCommand("done");
		cancelButton.setActionCommand("cancel");
		
		doneButton.addActionListener(this);
		cancelButton.addActionListener(this);
		
		Dimension buttonDimension = new Dimension(120, 50);
		doneButton.setPreferredSize(buttonDimension);
		cancelButton.setPreferredSize(buttonDimension);
		
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		buttonPanel.setPreferredSize(new Dimension(140, 0));
		buttonPanel.add(doneButton);
		buttonPanel.add(cancelButton);
		
		getContentPane().add(mainPanel, BorderLayout.CENTER);
		getContentPane().add(buttonPanel, BorderLayout.LINE_END);
	}
}

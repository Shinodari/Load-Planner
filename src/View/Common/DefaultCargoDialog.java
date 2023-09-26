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

public abstract class DefaultCargoDialog extends JDialog implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	public boolean isSucces = false;
	
	protected JPanel mainPanel = new JPanel(new SpringLayout());
	protected JPanel buttonPanel = new JPanel();
	protected JPanel dimensionPanel[];
	
	protected JTextField nameField = new JTextField(50);
	
	final int DEFINE_VALUE_DIMENSION = 100;
	final int DEFINE_MIN_DIMENSION = 0;
	final int DEFINE_MAX_DIMENSION = 1000;
	final int DEFINE_STEP_DIMENSION = 1;
	protected SpinnerNumberModel widthModel = new SpinnerNumberModel(DEFINE_VALUE_DIMENSION, DEFINE_MIN_DIMENSION, DEFINE_MAX_DIMENSION, DEFINE_STEP_DIMENSION);
	protected SpinnerNumberModel lenghtModel = new SpinnerNumberModel(DEFINE_VALUE_DIMENSION, DEFINE_MIN_DIMENSION, DEFINE_MAX_DIMENSION, DEFINE_STEP_DIMENSION);
	protected SpinnerNumberModel heightModel = new SpinnerNumberModel(DEFINE_VALUE_DIMENSION, DEFINE_MIN_DIMENSION, DEFINE_MAX_DIMENSION, DEFINE_STEP_DIMENSION);
	protected JSpinner widthSpinner = new JSpinner(widthModel);
	protected JSpinner lenghtSpinner = new JSpinner(lenghtModel);
	protected JSpinner heightSpinner = new JSpinner(heightModel);
	
	protected JTextField colorField = new JTextField(5);
	protected JButton colorChooserButton = new JButton("...");
	
	protected JButton doneButton = new JButton("Done");
	protected JButton cancelButton = new JButton("Cancel");

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
				dimensionPanel[i].add(lenghtSpinner);
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

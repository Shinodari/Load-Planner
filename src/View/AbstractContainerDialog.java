package View;

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

public abstract class AbstractContainerDialog extends JDialog implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	public boolean isSucces = false;
	
	protected JPanel mainPanel = new JPanel(new SpringLayout());
	protected JPanel buttonPanel = new JPanel();
	
	protected JTextField nameField = new JTextField(50);
	
	private SpinnerNumberModel spinnerNumberModel = new SpinnerNumberModel(100, 0, 1000, 1);
	protected JSpinner widthSpinner = new JSpinner(spinnerNumberModel);
	protected JSpinner lenghtSpinner = new JSpinner(spinnerNumberModel);
	protected JSpinner heightSpinner = new JSpinner(spinnerNumberModel);
	
	protected JTextField colorField = new JTextField(5);
	protected JButton colorChooserButton = new JButton("...");
	
	protected JButton doneButton = new JButton("Done");
	protected JButton cancelButton = new JButton("Cancel");

	public AbstractContainerDialog(Container parent,String title) {
		
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
		
		for (int i = 0; i < numPairs; i++) {
			JLabel label = new JLabel(labels[i] + " :", JLabel.TRAILING);
			mainPanel.add(label);
			JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
			switch(i) {
			case 0:
				inputPanel.add(nameField);
				break;
			case 1:
				inputPanel.add(widthSpinner);
				break;
			case 2:
				inputPanel.add(lenghtSpinner);
				break;
			case 3:
				inputPanel.add(heightSpinner);
				break;
			case 4:
				inputPanel.add(colorField);
				inputPanel.add(colorChooserButton);
			}
			
			mainPanel.add(inputPanel);
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

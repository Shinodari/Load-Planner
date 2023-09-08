package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;

import javax.swing.Box;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	JDesktopPane desktop;
	
	public MainFrame() {
		super("Load Planner");

		//Setup MainMenuBar
		JMenuBar mainMenuBar = new JMenuBar();
		
		JMenu mainMenu = new JMenu("Main");
		
		JMenuItem containerMenuItem = new JMenuItem("Container");
		containerMenuItem.setMaximumSize(new Dimension(200, 100));
		containerMenuItem.setActionCommand(containerMenuItem.getName());
		containerMenuItem.addActionListener(this);
		
		JMenuItem palletMenuItem = new JMenuItem("Pallet");
		palletMenuItem.setMaximumSize(new Dimension(500, 100));
		palletMenuItem.setActionCommand(palletMenuItem.getName());
		palletMenuItem.addActionListener(this);
		
		JMenuItem shipmentMenuItem = new JMenuItem("Shipment");
		
		mainMenu.add(containerMenuItem);
		mainMenu.add(palletMenuItem);
		mainMenu.add(shipmentMenuItem);
		
		mainMenuBar.add(mainMenu);
		
		desktop = new JDesktopPane();
		setContentPane(desktop);
		setJMenuBar(mainMenuBar);
	}
	
	

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				MainFrame mainframe = new MainFrame();
				mainframe.setMinimumSize(new Dimension(1200, 750));
				mainframe.setExtendedState(Frame.MAXIMIZED_BOTH);
				mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				mainframe.setVisible(true);
			}
			
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "Container":
			/* -- This process in IssueNo: #2 (Assign: Shinodari) --
			ContainerFrame containerFrame = new ContainerFrame();
			containerFrame.setVisible(true);
			desktop.add(containerFrame);
			try {
				containerFrame.setSelected(true);
			} catch (PropertyVetoException e1) {
				e1.printStackTrace();
			}*/
			break;
		case "Pallet":
			//ToDO for IssueNo: #3 (Assign: Hibino02)
			break;
		}
	}

}

package View;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	JDesktopPane desktop;
	
	public MainFrame() {
		super("Load Planner");

		//Setup MainMenuBar
		JMenuBar mainMenuBar = new JMenuBar();
		JMenu containerMenu = new JMenu("Container");
		containerMenu.setActionCommand(containerMenu.getName());
		containerMenu.addActionListener(this);
		containerMenu.setMnemonic(KeyEvent.VK_C);
		mainMenuBar.add(containerMenu);
		
		desktop = new JDesktopPane();
		setContentPane(desktop);
		setJMenuBar(mainMenuBar);
	}
	
	

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				MainFrame mainframe = new MainFrame();
				mainframe.setMinimumSize(new Dimension(1200, 1000));
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
			
			break;
		}
	}

}

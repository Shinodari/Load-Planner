package View;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JButton containerButton;
    private JPanel mainPanel;
    private JToolBar mainToolBar;

    public MainFrame(){
        super("Load Planner");

        JDesktopPane desktopPane = new JDesktopPane();
        ContainerFrame containerFrame = new ContainerFrame();
        containerFrame.setVisible(true);
        desktopPane.add(containerFrame);
        try {
            containerFrame.setSelected(true);
        }catch (Exception e){

        }

        setContentPane(desktopPane);
        desktopPane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);

        //add(mainPanel);
        //getContentPane().add(mainPanel, BorderLayout.NORTH);
        //getContentPane().add(desktopPane, BorderLayout.SOUTH);
        //internalPanel.add(desktopPane);

        //this.add(desktopPane, BorderLayout.CENTER);
        this.setMinimumSize(new Dimension(1600, 1000));
    }

    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e){
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(()->{
            MainFrame mainFrame = new MainFrame();
            //mainFrame.pack();
            mainFrame.setVisible(true);
            mainFrame.setExtendedState(MainFrame.MAXIMIZED_BOTH);
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}

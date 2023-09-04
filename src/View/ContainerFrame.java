package View;

import javax.swing.*;
import java.awt.*;

public class ContainerFrame extends JInternalFrame {

    private JPanel panel1;
    private JLabel testLabel;

    public ContainerFrame(){
        super("Doc");
        setLocation(0,0);

        add(panel1);
        setSize(800,600);
    }
}

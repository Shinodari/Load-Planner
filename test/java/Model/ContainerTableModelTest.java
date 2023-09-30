package Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTableModelTest {

    @Test
    void Call() {
        ContainerTableModel containerTableModel = new ContainerTableModel();
    }

    @Test
    void getValueAt() {
        ContainerTableModel containerTableModel = new ContainerTableModel();
        assertEquals(2, containerTableModel.getValueAt(1, 0));
    }
}
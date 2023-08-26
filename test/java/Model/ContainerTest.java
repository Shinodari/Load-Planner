package Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    @Test
    @DisplayName("Get All Container")
    void getAllContainer() {
        ArrayList<Container> containers = Container.getAllContainer();
        assert containers != null;
        assertNotEquals(0, containers.size());
    }

    @Test
    @DisplayName("Add Container")
    void add() {
        ArrayList<Container> containersBefore = Container.getAllContainer();
        assert containersBefore != null;
        int b = containersBefore.size();

        Container container = new Container();
        boolean test = container.add("test",new Size(10, 20, 30));
        assertTrue(test);

        ArrayList<Container> containersAfter = Container.getAllContainer();
        int a = containersAfter.size();

        assertEquals(a, b+1);
        assertNotEquals(0, container.id);
        assertNotEquals(0, container.name);
        Size size = container.size;
        assertNotEquals(0,size.getLength());
    }
}
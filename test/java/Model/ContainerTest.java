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

    @Test
    @DisplayName("Edit Container")
    void edit() {
        ArrayList<Container> containers = Container.getAllContainer();
        assert containers != null;
        int count = containers.size();
        Container container = new Container(count - 1);
        int id = container.getId();
        String name = container.getName();
        Size size = container.getSize();
        double length = size.getLength();
        double width = size.getWidth();
        double height = size.getHeight();

        assertNotEquals(0, container.id);
        assertNotNull(container.name);
        assertNotEquals(0,size.getLength());
        assertNotEquals(0,size.getWidth());
        assertNotEquals(0,size.getHeight());

        name += id;
        ++length;
        ++width;
        ++height;

        container.edit(name, new Size(length, width, height));
        assertEquals(id, container.id);
        assertEquals(name, container.name);
        assertEquals(length, container.size.getLength());
        assertEquals(width, container.size.getWidth());
        assertEquals(height, container.size.getHeight());

        Container containerT = new Container(id);
        assertEquals(id, containerT.id);
        assertEquals(name, containerT.name);
        assertEquals(length, containerT.size.getLength());
        assertEquals(width, containerT.size.getWidth());
        assertEquals(height, containerT.size.getHeight());
    }

    @Test
    @DisplayName("Remove Container")
    void remove() {
        ArrayList<Container> containers = Container.getAllContainer();
        int count = containers.size();
        Container container = new Container(containers.get(count - 1).getId());

        Size size = container.getSize();
        assertNotEquals(0, container.id);
        assertNotNull(container.name);
        assertNotEquals(0,size.getLength());
        assertNotEquals(0,size.getWidth());
        assertNotEquals(0,size.getHeight());

        boolean result = container.remove();
        assertTrue(result);
        assertEquals(count - 1, Container.getAllContainer().size());
    }
}
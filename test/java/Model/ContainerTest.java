package Model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    @Test
    void getAllContainer() {
        ArrayList<Container> containers = Container.getAllContainer();
        assert containers != null;
        assertEquals(2, containers.size());
    }
}
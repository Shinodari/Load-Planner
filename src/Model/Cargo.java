package Model;
import java.awt.Color;

public abstract class Cargo {
    protected int id;
    protected String name;
    protected Size size;
    protected Color color;


    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public Size getSize(){
        return size;
    }
    public Color getColor(){
        return color;
    }

    public abstract boolean add(String name, Size size, Color color);
    public abstract boolean edit(String name, Size size, Color color);
    public abstract boolean remove();
}
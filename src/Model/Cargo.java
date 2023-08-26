package Model;

abstract class Cargo {
    protected int id;
    protected String name;
    protected Size size;

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public Size getSize(){
        return size;
    }

    public abstract boolean add(String name, Size size);
    public abstract boolean edit(String name, Size size);
    public abstract boolean remove();
}
package Model;

public class Size {
    private double length;
    private double width;
    private double height;

    public Size(double s){
        this.length = s;
        this.width = s;
        this.height = s;
    }
    public Size(double length,double width,double height){
        this.length = length;
        this.width = width;
        this.height = height;
    }
    public double getLength(){
        return length;
    }
    public double getWidth(){
        return width;
    }
    public double getHeight(){
        return height;
    }
}

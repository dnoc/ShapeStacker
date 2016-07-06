public abstract class Shape {
    protected double area;

    public abstract String stackString();

    public boolean fitsOn(Shape s) {
        return s.area >= area;
    }

    public double getArea() {
        return area;
    }
}

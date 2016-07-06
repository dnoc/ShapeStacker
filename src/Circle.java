public class Circle extends Shape {

    public Circle(double dia) {
        area = dia*Math.PI;
    }

    @Override
    public String stackString() {
        return "C[";
    }
}

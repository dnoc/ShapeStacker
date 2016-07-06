public class Rectangle extends Shape{

    public Rectangle(double s1, double s2) {
        area = s1*s2;
    }

    @Override
    public String stackString() {
        return "R[";
    }
}

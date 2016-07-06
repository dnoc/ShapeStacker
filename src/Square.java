public class Square extends Shape {

    public Square(double s) {
        area = s * s;
    }

    @Override
    public String stackString() {
        return "S[";
    }
}

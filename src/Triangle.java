public class Triangle extends Shape {

    public Triangle(double s1, double s2, double s3) {
        //Heron's formula
        double sp = (s1+s2+s3)/2;
        area = Math.sqrt(sp*(sp - s1)*(sp - s2)*(sp - s3));
    }

    @Override
    public String stackString() {
        return "T[";
    }
}

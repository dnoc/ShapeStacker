import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ShapeStacker {
    public static String stack(List<Shape> shapes) {
        //Insertion sort because it's simple and a small set
        Shape temp;
        for (int i = 1; i < shapes.size(); i++) {
            for(int j = i ; j > 0 ; j--){
                Shape s1 = shapes.get(j-1);
                Shape s2 = shapes.get(j);
                if(s1.fitsOn(s2)){
                    temp = shapes.remove(j-1);
                    shapes.add(j, temp);
                }
            }
        }
        //set to string output
        String output = "";
        String end = "";
        for (int i = 0; i < shapes.size(); i++) {
            Shape s = shapes.get(i);
            output = output + s.stackString();
            end = end + "]";
        }
        output = output + end;
        return output;
    }

    public static Shape processInput(Scanner sc, String input) {
        //Prompt for lengths, catch anything that's not a double, repeat if so
        while (true) {
            switch (input) {
                case "circle":
                    try {
                        System.out.print("Enter Diameter:");
                        double diameter = sc.nextDouble();
                        sc.nextLine();
                        Circle c = new Circle(diameter);
                        System.out.println("Circle Area: " + c.getArea());
                        return c;
                    } catch (Exception e) {
                        System.out.println("Error, invalid input. Try again.");
                        break;
                    }
                case "rectangle":
                    try {
                        System.out.print("Enter Side 1 Length:");
                        double side1 = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("Enter Side 2 Length:");
                        double side2 = sc.nextDouble();
                        sc.nextLine();
                        Rectangle r = new Rectangle(side1,side2);
                        System.out.println("Rectangle Area: " + r.getArea());
                        return r;
                    } catch (Exception e) {
                        System.out.println("Error, invalid input. Try again.");
                        break;
                    }
                case "square":
                    try {
                        System.out.print("Enter Side Length:");
                        double side = sc.nextDouble();
                        sc.nextLine();
                        Square sq = new Square(side);
                        System.out.println("Square Area: " + sq.getArea());
                        return sq;
                    } catch (Exception e) {
                        System.out.println("Error, invalid input. Try again.");
                        break;
                    }
                case "triangle":
                    try {
                        System.out.print("Enter Side 1 Length:");
                        double side1 = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("Enter Side 2 Length:");
                        double side2 = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("Enter Side 3 Length:");
                        double side3 = sc.nextDouble();
                        sc.nextLine();
                        Triangle t = new Triangle(side1,side2,side3);
                        System.out.println("Triangle Area: " + t.getArea());
                        return t;
                    } catch (Exception e) {
                        System.out.println("Error, invalid input. Try again.");
                        break;
                    }
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        List<Shape> shapes = new ArrayList<>();

        //process input and check for Stack or errors
        boolean flag = true;
        while (flag) {
            System.out.println("Enter a shape (Circle, Rectangle, Square, or Triangle), or \"Stack!\" to sort them:");
            String line = sc.nextLine().trim().toLowerCase();
            switch (line) {
                case "circle":
                case "rectangle":
                case "square":
                case "triangle":
                    shapes.add(processInput(sc, line));
                    break;
                case "stack!":
                case "stack":
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid entry, try again.");
            }
        }
        //output
        System.out.println("Stacked:" + stack(shapes));
    }
}

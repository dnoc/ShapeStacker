import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ShapeStackerTest extends ShapeStacker {

    @Test
    public void testSuggestedTests() throws Exception {
        List<Shape> s = new ArrayList<>();
        s.add(new Square(4));
        s.add(new Circle(4));
        s.add(new Triangle(4,10,10));
        assertEquals("Expected \"T[S[C[]]]\"", "T[S[C[]]]", stack(s));
        List<Shape> s2 = new ArrayList<>();
        s2.add(new Square(4));
        s2.add(new Circle(6));
        s2.add(new Rectangle(2,4));
        assertEquals("Expected \"C[S[R[]]]\"", "C[S[R[]]]", stack(s2));
        List<Shape> s3 = new ArrayList<>();
        s3.add(new Triangle(4,10,10));
        s3.add(new Circle(20));
        assertEquals("Expected \"C[T[]]\"", "C[T[]]", stack(s3));
    }

    @Test
    public void testRegularInput() throws Exception {
        List<Shape> s = new ArrayList<>();
        s.add(new Triangle(10,5,10));
        assertEquals("Expected \"T[]\"", "T[]", stack(s));
        s.add(new Square(4));
        assertEquals("Expected \"T[S[]]\"", "T[S[]]", stack(s));
        s.add(new Circle(2));
        assertEquals("Expected \"T[S[C[]]]\"", "T[S[C[]]]", stack(s));
        s.add(new Rectangle(1,1));
        assertEquals("Expected \"T[S[C[R[]]]]\"", "T[S[C[R[]]]]", stack(s));
    }

    @Test
    public void testBackwardsInput() throws Exception {
        List<Shape> s = new ArrayList<>();
        s.add(new Rectangle(1,1));
        assertEquals("Expected \"R[]\"", "R[]", stack(s));
        s.add(new Circle(2));
        assertEquals("Expected \"C[R[]]\"", "C[R[]]", stack(s));
        s.add(new Square(4));
        assertEquals("Expected \"S[C[R[]]]\"", "S[C[R[]]]", stack(s));
        s.add(new Triangle(5,10,10));
        assertEquals("Expected \"T[S[C[R[]]]]\"", "T[S[C[R[]]]]", stack(s));
    }

    @Test
    public void testCircles() throws Exception {
        List<Shape> s = new ArrayList<>();
        s.add(new Circle(2));
        s.add(new Circle(4));
        s.add(new Circle(5));
        s.add(new Circle(7));
        assertEquals("Expected \"C[C[C[C[]]]]\"", "C[C[C[C[]]]]", stack(s));
    }

    @Test
    public void testSquares() throws Exception {
        List<Shape> s = new ArrayList<>();
        s.add(new Square(2));
        s.add(new Square(4));
        s.add(new Square(5));
        s.add(new Square(7));
        assertEquals("Expected \"S[S[S[S[]]]]\"", "S[S[S[S[]]]]", stack(s));
    }

    @Test
    public void testRectangles() throws Exception {
        List<Shape> s = new ArrayList<>();
        s.add(new Rectangle(2,3));
        s.add(new Rectangle(7,2));
        s.add(new Rectangle(5,5));
        s.add(new Rectangle(10,10));
        assertEquals("Expected \"R[R[R[R[]]]]\"", "R[R[R[R[]]]]", stack(s));
    }

    @Test
    public void testTriangles() throws Exception {
        List<Shape> s = new ArrayList<>();
        s.add(new Triangle(2,3,4));
        s.add(new Triangle(1,1,1));
        s.add(new Triangle(5,5,5));
        s.add(new Triangle(8,5,4));
        assertEquals("Expected \"T[T[T[T[]]]]\"", "T[T[T[T[]]]]", stack(s));
    }

    @Test
    public void testEmpty() throws Exception {
        List<Shape> s = new ArrayList<>();
        assertEquals("Expected empty String", "", stack(s));
    }

    @Test
    public void testLargeInput() throws Exception {
        List<Shape> s = new ArrayList<>();
        s.add(new Triangle(1000,1000,1200));
        assertEquals("Expected \"T[]\"", "T[]", stack(s));
        s.add(new Square(4000));
        assertEquals("Expected \"S[T[]]\"", "S[T[]]", stack(s));
        s.add(new Circle(3000));
        assertEquals("Expected \"S[T[C[]]]\"", "S[T[C[]]]", stack(s));
        s.add(new Rectangle(1000,1000));
        assertEquals("Expected \"S[R[T[C[]]]]\"", "S[R[T[C[]]]]", stack(s));
    }

    @Test
    public void testZero() throws Exception {
        List<Shape> s = new ArrayList<>();
        s.add(new Square(0));
        assertEquals("Expected \"S[]\"", "S[]", stack(s));
        s.add(new Circle(0));
        assertEquals("Expected \"C[S[]]\"", "C[S[]]", stack(s));
        s.add(new Rectangle(0,0));
        assertEquals("Expected \"R[S[C[]]]\"", "R[S[C[]]]", stack(s));
        s.add(new Triangle(0,0,0));
        assertEquals("Expected \"T[C[S[R[]]]]\"", "T[C[S[R[]]]]", stack(s));
    }

}

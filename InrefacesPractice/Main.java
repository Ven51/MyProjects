package ch17.task;

public class Main {

    public static void main(String[] args) {
        Circle circle1 = new Circle(3);
        Rectangle rectangle1 = new Rectangle(4, 5);
        Line line1 = new Line(8);

        System.out.println(circle1.getArea());
        System.out.println(rectangle1.getArea());
        System.out.println(line1.getLength());
    }
}

package designs.creational.factory;

import designs.creational.factory.objects.Shape;

public class Client {
    public static void main(String[] args) {
        Shape circle = new ShapeFactory().getShape("Circle");
        circle.draw();
        System.out.println(circle.calculateArea(10, 0, 0));
        Shape square = new ShapeFactory().getShape("Square");
        square.draw();
        System.out.println(square.calculateArea(0, 10, 10));
        Shape rectangle = new ShapeFactory().getShape("Rectangle");
        rectangle.draw();
        System.out.println(rectangle.calculateArea(0, 5, 20));
    }
}

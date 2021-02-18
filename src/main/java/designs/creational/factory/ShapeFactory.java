package designs.creational.factory;

import designs.creational.factory.objects.Circle;
import designs.creational.factory.objects.Rectangle;
import designs.creational.factory.objects.Shape;
import designs.creational.factory.objects.Square;

public class ShapeFactory {
    public Shape getShape(String type) {
        switch (type) {
            case "Circle":
                return new Circle();
            case "Square":
                return new Square();
            case "Rectangle":
                return new Rectangle();
            default:
                return null;
        }
    }
}

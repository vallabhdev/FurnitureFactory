package designs.creational.factory.objects;

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("this is a circle shape");
    }

    @Override
    public int calculateArea(int radius, int lenght, int breadth) {
        return (22 / 7) * radius * radius;
    }
}

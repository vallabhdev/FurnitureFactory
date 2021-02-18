package designs.creational.factory.objects;

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("this is a circle shape");
    }

    @Override
    public int calculateArea(int radius, int lenght, int breadth) {
        return 2 * (22 / 7) * radius;
    }
}

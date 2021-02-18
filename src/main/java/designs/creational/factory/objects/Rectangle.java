package designs.creational.factory.objects;

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("this is a rectangle shape");
    }

    @Override
    public int calculateArea(int radius, int lenght, int breadth) {
        return lenght * breadth;
    }
}

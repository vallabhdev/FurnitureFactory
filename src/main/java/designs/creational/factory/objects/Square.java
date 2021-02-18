package designs.creational.factory.objects;

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("this is a square shape");
    }

    @Override
    public int calculateArea(int radius, int length, int breadth) {
        return length * breadth;
    }
}

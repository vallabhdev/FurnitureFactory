package designs.structural.facade.objects;

public class Iphone implements Mobile {
    @Override
    public void getModelNo() {
        System.out.println("iphone x");
    }

    @Override
    public void getPrice() {
        System.out.println("60K");
    }
}

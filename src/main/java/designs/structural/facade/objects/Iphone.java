package designs.structural.facade.objects;

public class Iphone implements Mobile {
    @Override
    public void modelNo() {
        System.out.println("iphone x");
    }

    @Override
    public void price() {
        System.out.println("60K");
    }
}

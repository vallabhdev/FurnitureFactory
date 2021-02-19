package designs.structural.facade.objects;

public class Samsung implements Mobile {
    @Override
    public void getModelNo() {
        System.out.println("samsung m31");
    }

    @Override
    public void getPrice() {
        System.out.println("16K");
    }
}

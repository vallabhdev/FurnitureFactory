package designs.structural.facade.objects;

public class Nokia implements Mobile {
    @Override
    public void getModelNo() {
        System.out.println("Nokia lumia");
    }

    @Override
    public void getPrice() {
        System.out.println("26K");
    }
}

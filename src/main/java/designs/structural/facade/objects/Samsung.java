package designs.structural.facade.objects;

public class Samsung implements Mobile {
    @Override
    public void modelNo() {
        System.out.println("samsung m31");
    }

    @Override
    public void price() {
        System.out.println("16K");
    }
}

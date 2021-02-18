package designs.structural.facade;

import designs.structural.facade.objects.Iphone;
import designs.structural.facade.objects.Samsung;

//A Facade Pattern says that just "just provide a unified and simplified interface to a set of interfaces
// in a subsystem, therefore it hides the complexities of the subsystem from the client".
//In other words, Facade Pattern describes a higher-level interface that makes the sub-system easier to use.
//Practically, every Abstract Factory is a type of Facade.
public class Shopkeeper {
    private Iphone iphone;
    private Samsung samsung;

    public Shopkeeper() {
        this.iphone = new Iphone();
        this.samsung = new Samsung();
    }

    public void saleIphone() {
        iphone.modelNo();
        iphone.price();
    }

    public void saleSamsung() {
        samsung.modelNo();
        samsung.price();
    }

}

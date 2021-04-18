package practice.general;

import designs.structural.facade.objects.Mobile;

public abstract class Parent {
    public abstract Mobile getMobile();

    public static int getPrice() {
        return 1;
    }
}

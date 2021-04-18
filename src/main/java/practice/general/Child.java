package practice.general;

import designs.structural.facade.objects.Iphone;
import designs.structural.facade.objects.Mobile;

public class Child extends Parent {
    @Override
    public Mobile getMobile() {
        return new Iphone();
    }

    /*public static int getPrice() {
      *  return 11;
    }*/
    static boolean f = false;
    public static void main(String[] args) {
        any(f);
        System.out.println(f);
    }

    static boolean any(boolean f) {
        f = true;
        return f;
    }

    public static void main1(String[] args) {
        Parent child = new Child();

        //hello
        int i = 0;//after
        /* start */
        /* start
        u* between
        * last*/
        System.out.println();
        System.out.println(child.getMobile() + " - " + child.getPrice());
    }
}

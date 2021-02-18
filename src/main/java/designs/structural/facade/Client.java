package designs.structural.facade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Client {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String choice = reader.readLine();
        Shopkeeper shopkeeper = new Shopkeeper();
        if (choice.equalsIgnoreCase("Iphone")) {
            shopkeeper.saleIphone();
        } else if (choice.equalsIgnoreCase("samsung")) {
            shopkeeper.saleSamsung();
        } else {
            System.out.println("Sorry : " + choice + " is out of stock");
        }
    }
}

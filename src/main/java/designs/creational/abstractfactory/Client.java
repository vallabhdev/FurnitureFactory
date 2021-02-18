package designs.creational.abstractfactory;

import designs.creational.abstractfactory.factories.AbstractFactory;
import designs.creational.abstractfactory.factories.FactoryCreator;
import designs.creational.abstractfactory.object.Bank;
import designs.creational.abstractfactory.object.Loan;

public class Client {
    public static void main(String[] args) {
        AbstractFactory bank = FactoryCreator.getFactory("Bank");
        Bank hdfc = bank.getBank("HDFC");
        System.out.println(hdfc.getBankName());
        AbstractFactory loan = FactoryCreator.getFactory("Loan");
        Loan car = loan.getLoan("Car");
        car.calculateLoanPayment(975000, 7);
    }
}

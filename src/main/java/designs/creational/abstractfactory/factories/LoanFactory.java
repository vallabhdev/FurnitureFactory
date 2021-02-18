package designs.creational.abstractfactory.factories;

import designs.creational.abstractfactory.object.Bank;
import designs.creational.abstractfactory.object.CarLoan;
import designs.creational.abstractfactory.object.HomeLoan;
import designs.creational.abstractfactory.object.Loan;

public class LoanFactory extends AbstractFactory {
    @Override
    public Bank getBank(String bank) {
        return null;
    }

    @Override
    public Loan getLoan(String type) {
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("Car")) {
            return new CarLoan();
        }
        if (type.equalsIgnoreCase("Home")) {
            return new HomeLoan();
        }
        return null;
    }
}

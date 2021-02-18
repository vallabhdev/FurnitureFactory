package designs.creational.abstractfactory.factories;

import designs.creational.abstractfactory.object.*;

public class BankFactory extends AbstractFactory {
    @Override
    public Bank getBank(String type) {
        switch (type) {
            case "HDFC":
                return new HDFC();
            case "ICICI":
                return new ICICI();
            case "SBI":
                return new SBI();
            default:
                return null;
        }
    }

    @Override
    public Loan getLoan(String loanType) {
        return null;
    }
}

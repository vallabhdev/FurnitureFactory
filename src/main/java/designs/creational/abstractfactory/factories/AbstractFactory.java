package designs.creational.abstractfactory.factories;

import designs.creational.abstractfactory.object.Bank;
import designs.creational.abstractfactory.object.Loan;

public abstract class AbstractFactory {
    public abstract Bank getBank(String bank);

    public abstract Loan getLoan(String loanType);
}

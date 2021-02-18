package designs.creational.abstractfactory.object;

public abstract class Loan {
    protected double rate;

    abstract double getInterestRate();

    public void calculateLoanPayment(double principle, int years) {
        double EMI;
        int n;
        n = years * 12;//no. of months
        rate = getInterestRate() / 1200;
        double pow = Math.pow((1 + rate), n);
        EMI = ((rate * pow) / (pow - 1)) * principle;
        System.out.println("your monthly EMI is " + EMI + " for the amount"
                + principle + " you have borrowed");
        // A = P (1 + (r/n))pow(n*t)
    }
}

package ro.ase.cts.g1098.recap.models;

public class CurrentAccount extends BankAccount{

    public static double MAX_CREDIT;

    public CurrentAccount(String iban) {
        super(iban);
    }

    @Override
    public double GetBalance() {
        return 0;
    }
}

package ro.ase.cts.assesment.modules;

import ro.ase.cts.assesment.enums.AccountType;

public class Account {
    private double	loan_value,rate;
    private int	daysActive;
    private AccountType account_Type;

    public double getLoan_value() {
        return loan_value;
    }

    public AccountType getAccount_Type() {
        return account_Type;
    }

    public int getDaysActive() {
        return daysActive;
    }

    public double loan() {
        return loan_value;
    }

    public void printLoan() {
        System.out.println("The loan value is " + this.loan_value);
    }

    public double getRate() {
        return this.rate;
    }

    public void printRate() {
        System.out.println("The rate is "+rate);
    }

    //must have method - the lead has requested it in all classes
    public double getMonthlyRate() {
        return loan_value*rate;
    }

    public void setValue(double value) throws IllegalArgumentException {
        if(value<0) {
            throw new IllegalArgumentException();
        }
        loan_value = value;
    }

    @Override
    public String toString() {
        return "Loan: "+this.loan_value+"; rate: "+this.rate+"; days active:"+daysActive+"; Type: "+account_Type+";";
    }


    public void print() {
        System.out.println("This is an account");
    }

    public Account(double value, double rate, AccountType account_Type) throws IllegalArgumentException {
        if(value<0) {
            throw new IllegalArgumentException();
        }

        this.loan_value = value;
        this.rate = rate;
        this.account_Type = account_Type;
    }


}

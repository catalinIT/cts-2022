package ro.ase.cts.assesment.modules;

import ro.ase.cts.assesment.enums.AccountType;

public class Account {
    private double	loan_value,rate;
    private int	daysActive;
    private AccountType account_Type;

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

    public static  double computeLocalFee(double loan_value, double rate, int daysActive) {
        return .0125	*	(	//	1.25%	broker's	fee
                loan_value*Math.pow(rate,(daysActive/365)) - loan_value);
    }
    public static double calculateTotalFee(Account[] 	accounts)
    {
        double totalFee=0.0;
        Account	account;
        for	(int	i=0;i<accounts.length;i++)	{
            account=accounts[i];
            if(account.account_Type==AccountType.PREMIUM||account.account_Type==AccountType.SUPER_PREMIUM)
                totalFee+= computeLocalFee(account.loan_value, account.rate, account.daysActive);	//	interest-principal
        }
        return	totalFee;
    }

    public Account(double value, double rate, AccountType account_Type) throws Exception {
        if(value<0)
            throw new Exception();
        else
        {
            loan_value = value;
        }
        this.rate = rate;
        this.account_Type = account_Type;
    }


}

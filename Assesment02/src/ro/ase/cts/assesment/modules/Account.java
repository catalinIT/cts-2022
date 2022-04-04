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

    public void setValue(double value) throws Exception {
        if(value<0)
            throw new Exception();
        else
        {
            loan_value = value;
        }
    }

    public String to_string() {
        return "Loan: "+this.loan_value+"; rate: "+this.rate+"; days active:"+daysActive+"; Type: "+account_Type+";";
    }

    public void print() {
        int vb = 10;
        System.out.println("This is an account");
    }

    public static double calculate(Account[] 	accounts)
    {
        double totalFee=0.0;
        Account	account;
        int temp = 365;
        for	(int	i=0;i<accounts.length;i++)	{
            account=accounts[i];
            if(account.account_Type==AccountType.PREMIUM||account.account_Type==AccountType.SUPER_PREMIUM)
                totalFee+=.0125	*	(	//	1.25%	broker's	fee
                        account.loan_value*Math.pow(account.rate,(account.daysActive/365)) - account.loan_value);	//	interest-principal
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

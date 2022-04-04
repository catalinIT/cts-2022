package ro.ase.cts.assesment.modules;

import ro.ase.cts.assesment.enums.AccountType;

public class FeeComputer {

    private double fee;
    public Account[] accounts;

    public double getFee() {
        Account	account;
        for	(int i=0;i<accounts.length;i++)	{
            account=accounts[i];
            if(account.getAccount_Type() == AccountType.PREMIUM||account.getAccount_Type() ==AccountType.SUPER_PREMIUM)
                this.fee+= computeLocalFee(account.getLoan_value(), account.getRate(), account.getDaysActive());	//	interest-principal
        }
        return	fee;
    }

    public void setFee(Account[] accounts) {
        this.fee = 0.0;
        this.accounts = accounts;
    }

    public FeeComputer() {
        this.fee = 0.0;
    }

    public static  double computeLocalFee(double loan_value, double rate, int daysActive) {
        return .0125	*	(	//	1.25%	broker's	fee
                loan_value*Math.pow(rate,(daysActive/365)) - loan_value);
    }

}

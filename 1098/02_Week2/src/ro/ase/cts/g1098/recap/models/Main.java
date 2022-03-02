package ro.ase.cts.g1098.recap.models;

import java.util.ArrayList;
import java.util.List;
import ro.ase.cts.g1098.recap.exceptions.*;

public class Main {

    public static void main(String[] args) {
        Banker bank = new Banker("SGD");
        BankAccount debitAccount = bank.openAccount(AccountType.SAVINGS);
        BankAccount creditAccount = bank.openAccount(AccountType.CURRENT);

        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(creditAccount);
        accounts.add(debitAccount);
        accounts.add(bank.openAccount(AccountType.SAVINGS));

        try {
            debitAccount.deposit(1000);
            debitAccount.withdraw(100);
            debitAccount.transfer(creditAccount, 100);
            System.out.println(debitAccount.balance);
        } catch (IllegalTransferException e) {

        } catch (InsufficientFundsException e) {

        }
    }
}

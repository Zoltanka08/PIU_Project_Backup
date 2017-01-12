package MockDatabase.Models;

/**
 * Created by Zoltan on 1/11/2017.
 */

public class BankAccount {

    private String Iban;
    private String Amount;

    public BankAccount(String iban, String amount) {
        Iban = iban;
        Amount = amount;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getIban() {
        return Iban;
    }

    public void setIban(String iban) {
        Iban = iban;
    }
}

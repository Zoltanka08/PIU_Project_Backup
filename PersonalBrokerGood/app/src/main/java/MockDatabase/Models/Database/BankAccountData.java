package MockDatabase.Models.Database;

import MockDatabase.Models.BankAccount;

/**
 * Created by Zoltan on 1/11/2017.
 */

public class BankAccountData {

    public static BankAccount MyBankAccount;

    public static BankAccount GetMyAccount(){
        if(MyBankAccount == null)
        {
            MyBankAccount = new BankAccount("ROBTRL12312AS124XCS", "5900.9");
        }

        return MyBankAccount;
    }
}

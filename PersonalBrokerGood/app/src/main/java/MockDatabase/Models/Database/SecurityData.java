package MockDatabase.Models.Database;

import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

import MockDatabase.Models.Security;

/**
 * Created by Zoltan on 1/10/2017.
 */

public class SecurityData {
    public static List<Security> portfolioSecurities;
    public static List<Security> boughtSecurities = new ArrayList<>();

    public static void SetupPortfolio(){

        portfolioSecurities = new ArrayList<>();
        portfolioSecurities.addAll(boughtSecurities);
        portfolioSecurities.add(new Security("1", "VTI", "9,345.76", "19:13", "image", "Shares", "+3.05", "+0.22%","58", "25.4", "26.9", true));
        portfolioSecurities.add(new Security("2", "VFIFX", "3,345.76", "19:14", "image", "Funds", "-2.17", "-0.08%","148", "11.4", "16.15", false));
    }

    public static Security GetSecurityById(String id){
        portfolioSecurities.addAll(boughtSecurities);
        for(Security security : portfolioSecurities){
            if(security.getSecurityId().equals(id))
                return security;
        }

        return null;
    }

    public static boolean updateAmountOfSecurity(String id, int amount){
        Security security = GetSecurityById(id);

        if(security != null) {
            String currentAmountString = security.getAmount();
            int currentAmount = Integer.parseInt(currentAmountString);
            int total = currentAmount - amount;
            String totalStr = Integer.toString(total);
            security.setAmount(totalStr);

            return true;
        }

        return false;
    }

    public static void insertSecurity(Security security)
    {
        boughtSecurities.add(security);
    }

    public static void deleteElement(String id){
        Security security = GetSecurityById(id);
        if(boughtSecurities.contains(security)) {
            boughtSecurities.remove(security);
        } else {
            portfolioSecurities.remove(security);
        }
    }

    public static void decreaseAmount(String id, int amount){
        Security security = GetSecurityById(id);
        int currentAmount = Integer.parseInt(security.getAmount());
        String total = Integer.toString(currentAmount - amount);
        security.setAmount(total);
    }
}

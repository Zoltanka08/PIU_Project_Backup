package MockDatabase.Models.Database;

import java.util.ArrayList;
import java.util.List;

import MockDatabase.Models.Security;

/**
 * Created by Zoltan on 1/13/2017.
 */

public class IndexData {

    public static List<Security> indecies = new ArrayList<>();

    public static void setupIndices(){
        indecies.add(new Security("1", "EURO STOXX", "11,345.76", "12:13", "image", "Europe", "+1.05", "+0.29%","31241", "25.4", "26.9", true));
        indecies.add(new Security("2", "S&P Global", "113,345.76", "12:11", "image", "Global", "+2.22", "+0.54%","421241", "25.4", "26.9", true));
        indecies.add(new Security("3", "S&P Asia", "11,345.76", "11:18", "image", "Asia", "+0.35", "+0.19%","51241", "25.4", "26.9", true));
        indecies.add(new Security("4", "ATX", "4,345.76", "16:12", "image", "Austria", "-0.17", "-0.21%","1241", "25.4", "26.9", false));
        indecies.add(new Security("5", "BG40", "345.76", "20:34", "image", "Bulgaria", "-2.12", "-1.01%","241", "25.4", "26.9", false));
        indecies.add(new Security("6", "AEX", "1,345.76", "22:18", "image", "Netherlands", "+2.75", "+2.89%","9241", "25.4", "26.9", true));
    }

    public static List<Security> securitiesOfIndex = new ArrayList<>();

    public static void setupSecuritiesOfIndex(){
        securitiesOfIndex.add(new Security("1", "VTI", "9,345.76", "19:13", "image", "Gold", "+3.05", "+0.22%","1000", "25.4", "26.9", true));
        securitiesOfIndex.add(new Security("2", "VFIFX", "3,345.76", "19:14", "image", "Silver", "-2.17", "-0.08%","148", "11.4", "16.15", false));
        securitiesOfIndex.add(new Security("3", "PSE", "1,345.76", "19:13", "image", "Shares", "+1.05", "+0.29%","31241", "25.4", "26.9", true));
        securitiesOfIndex.add(new Security("4", "WIG", "2,345.76", "19:11", "image", "Commodities", "+2.22", "+0.54%","421241", "25.4", "26.9", true));
        securitiesOfIndex.add(new Security("5", "BET", "145.76", "19:18", "image", "Futures", "+0.35", "+0.19%","51241", "25.4", "26.9", true));
        securitiesOfIndex.add(new Security("6", "SBI", "945.76", "19:12", "image", "Turbos", "-0.17", "-0.21%","1241", "25.4", "26.9", false));
        securitiesOfIndex.add(new Security("7", "FT30", "345.76", "19:34", "image", "Assets", "-2.12", "-1.01%","241", "25.4", "26.9", false));
    }

    public static Security getIndexById(String id){
        for(Security security : indecies){
            if(security.getSecurityId().equals(id))
                return security;
        }
        return null;
    }
}

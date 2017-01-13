package MockDatabase.Models;

/**
 * Created by Zoltan on 1/13/2017.
 */

public class Currency {
    private int id;
    private String name;
    private String euroValue;
    private String rate;
    private boolean isAsc;

    public Currency(int id, String name, String euroValue, String rate, boolean isAsc) {
        this.name = name;
        this.euroValue = euroValue;
        this.rate = rate;
        this.isAsc = isAsc;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEuroValue() {
        return euroValue;
    }

    public void setEuroValue(String euroValue) {
        this.euroValue = euroValue;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public boolean getIsAsc() {
        return isAsc;
    }

    public void setIsAsc(boolean isAsc) {
        this.isAsc = isAsc;
    }
}

package MockDatabase.Models;

/**
 * Created by Zoltan on 1/10/2017.
 */

public class Security {
    private String securityId;
    private String name;
    private String price;
    private String date;
    private String imagePath;
    private String type;
    private String rate;
    private String percentage;
    private String amount;
    private String bid;
    private String ask;
    private boolean isAscending;

    public Security(String securityId, String name, String price, String date, String imagePath, String type,
                    String rate, String percentage, String amount, String bid, String ask, boolean isAscending) {
        this.securityId = securityId;
        this.name = name;
        this.price = price;
        this.date = date;
        this.imagePath = imagePath;
        this.type = type;
        this.rate = rate;
        this.percentage = percentage;
        this.amount = amount;
        this.bid = bid;
        this.ask = ask;
        this.isAscending = isAscending;
    }

    public String getSecurityId() {
        return securityId;
    }

    public void setSecurityId(String securityId) {
        this.securityId = securityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public boolean getAscending() {
        return isAscending;
    }
    public void setAscending(boolean ascending) {
        isAscending = ascending;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }
}

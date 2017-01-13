package MockDatabase.Models;

/**
 * Created by Zoltan on 1/10/2017.
 */

public class News {

    private String id;
    private String title;
    private String imagePath;
    private String description;
    private String date;
    private String mainTitle;

    public News() {
    }

    public News(String id, String title, String imagePath, String description, String date, String mainTitle) {
        this.id = id;
        this.title = title;
        this.imagePath = imagePath;
        this.description = description;
        this.date = date;
        this.mainTitle = mainTitle;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMainTitle() {
        return mainTitle;
    }
    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle;
    }
}

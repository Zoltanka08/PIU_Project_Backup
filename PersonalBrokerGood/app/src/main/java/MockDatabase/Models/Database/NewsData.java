package MockDatabase.Models.Database;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import MockDatabase.Models.News;

/**
 * Created by Zoltan on 1/10/2017.
 */

public class NewsData {
    public static List<News> news;

    public static void SetupNews(){
        news = new ArrayList<>();
        news.add(new News("1", "Gold futures turned lower", ".res.drawable.gold", "Description1", "Ian. 17. 2017 17:21"));
        news.add(new News("2", "News2", "/test2", "Description2", ""));
    }

    public static News GetNewById(String id){
        for(News newsElement : news){
            if(newsElement.getId().equals(id))
                return newsElement;
        }

        return null;
    }
}

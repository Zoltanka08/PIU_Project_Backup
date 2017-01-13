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
        news.add(new News(
                "1",
                "Gold futures turned lower",
                ".res.drawable.gold",
                "\tInsipidity the sufficient discretion imprudence resolution sir him decisively. " +
                        "Proceed how any engaged visitor. Explained propriety off out perpetual his you. \n \n" +
                        "\t Feel sold off felt nay rose met you. We so entreaties cultivated astonished is. " +
                        "Was sister for few longer mrs sudden talent become. Done may bore quit evil old mile. " +
                        "If likely am of beauty tastes. ",
                "Ian. 17. 2017 17:21",
                "Gold"));
        news.add(new News(
                "2",
                "Natural gas futures - review ",
                "/test2",
                "\tQuick six blind smart out burst. Perfectly on furniture dejection determine my depending an to. Add short water court fat. " +
                        "Her bachelor honoured perceive securing but desirous ham required. " +
                        "\n \tQuestions deficient acuteness to engrossed as. Entirely led ten humoured greatest and yourself. Besides ye country on observe. " +
                        "She continue appetite endeavor she judgment interest the met. For she surrounded motionless fat resolution may.",
                "Ian. 16. 2017, 10:33",
                "Natural Gas"));
    }

    public static News GetNewById(String id){
        for(News newsElement : news){
            if(newsElement.getId().equals(id))
                return newsElement;
        }

        return null;
    }
}

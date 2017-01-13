package com.pluralsight.zoltan.personalbrokergood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import MockDatabase.Models.Database.NewsData;
import MockDatabase.Models.News;

public class NewsDetailsActivity extends AppCompatActivity {

    private static final String NEWS_ID = "NewsId";
    private static final String FRAGMENT_ID = "FragmentName";
    private static final String NEWS_DETAILS = "NewsDetails";

    private News news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(NewsDetailsActivity.this, BrokerActivity.class);
                myIntent.putExtra(FRAGMENT_ID, NEWS_DETAILS);
                startActivity(myIntent);
            }
        });

        String newsId = getIntent().getStringExtra(NEWS_ID);
        this.news = NewsData.GetNewById(newsId);

        TextView title = (TextView) findViewById(R.id.news_details_title);
        TextView date = (TextView) findViewById(R.id.news_details_date);
        TextView description = (TextView) findViewById(R.id.news_details_description);
        TextView mainTitle = (TextView) findViewById(R.id.news_details_main_title);
        ImageView image = (ImageView) findViewById(R.id.news_details_image);

        title.setText(this.news.getTitle());
        date.setText(this.news.getDate());
        description.setText(this.news.getDescription());
        mainTitle.setText(this.news.getMainTitle());

        setupImage(this.news.getId(), image);
    }

    private void setupImage(String id, ImageView imageView){
        int position = Integer.parseInt(id);
        switch(position){
            case 0:

                break;
            case 1:
                imageView.setImageResource(R.drawable.gold);
                break;
            case 2:
                imageView.setImageResource(R.drawable.gas_flare);
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            default:
                break;
        }
    }
}

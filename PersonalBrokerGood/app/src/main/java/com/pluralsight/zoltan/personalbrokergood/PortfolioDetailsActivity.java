package com.pluralsight.zoltan.personalbrokergood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import MockDatabase.Models.Database.SecurityData;
import MockDatabase.Models.Security;

public class PortfolioDetailsActivity extends AppCompatActivity {

    private static final String SECURITY_ID = "SecurityId";

    private static final String OPERATION = "Operation";
    private static final String SELL_OPERATION = "Sell";
    private static final String BUY_OPERATION = "Buy";

    private static final String FRAGMENT_ID = "FragmentName";
    private static final String SECURITY_LIST = "SecurityList";

    private Security security;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portfolio_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        String securityId = getIntent().getStringExtra(SECURITY_ID);
        final String operation = getIntent().getStringExtra(OPERATION);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operation.equals(SELL_OPERATION)) {
                    Intent myIntent = new Intent(PortfolioDetailsActivity.this, BrokerActivity.class);
                    startActivity(myIntent);
                }
                else
                {
                    Intent myIntent = new Intent(PortfolioDetailsActivity.this, BrokerActivity.class);
                    myIntent.putExtra(FRAGMENT_ID, SECURITY_LIST);
                    startActivity(myIntent);
                }
            }
        });

        this.security = SecurityData.GetSecurityById(securityId);

        TextView percentage = (TextView) findViewById(R.id.security_percentage);
        percentage.setText(this.security.getPercentage());

        TextView rate = (TextView) findViewById(R.id.security_rate);
        rate.setText(this.security.getRate());

        TextView bid = (TextView) findViewById(R.id.security_bid);
        bid.setText(this.security.getBid());

        TextView ask = (TextView) findViewById(R.id.security_ask);
        ask.setText(this.security.getAsk());

        TextView name = (TextView) findViewById(R.id.security_name);
        name.setText(this.security.getName());

        Button button = (Button) findViewById(R.id.buy_sell_button);
        if(operation.equals(SELL_OPERATION))
            button.setText("SELL");
        else
            button.setText("BUY");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operation.equals(SELL_OPERATION)){

                }
                else{

                }
            }
        });
    }
}

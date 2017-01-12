package com.pluralsight.zoltan.personalbrokergood;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import MockDatabase.Models.Database.SecurityData;
import MockDatabase.Models.Security;

public class SecurityDetailsActivity extends AppCompatActivity {

    private static final String SECURITY_ID = "SecurityId";

    private Security security;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String securityId = getIntent().getStringExtra(SECURITY_ID);

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
    }

}

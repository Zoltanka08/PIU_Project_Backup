package com.pluralsight.zoltan.personalbrokergood;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import MockDatabase.Models.Database.BankAccountData;
import MockDatabase.Models.Database.IndexData;
import MockDatabase.Models.Database.SecurityData;
import MockDatabase.Models.Security;

public class BuyActivity extends AppCompatActivity {

    private static final String SECURITY_ID = "SecurityId";

    private Security security;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(BuyActivity.this, SecuritiesOfIndexActivity.class);
                startActivity(myIntent);
            }
        });

        String securityId = getIntent().getStringExtra(SECURITY_ID);
        this.security = IndexData.getSecurityById(securityId);

        TextView title = (TextView) findViewById(R.id.buy_title);
        TextView type = (TextView) findViewById(R.id.buy_type_text);
        TextView price = (TextView) findViewById(R.id.buy_price_text);

        title.setText(this.security.getName());
        type.setText(this.security.getType());
        price.setText(this.security.getAsk());

        Button button = (Button) findViewById(R.id.buy_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView amountText = (TextView) findViewById(R.id.buy_amount_text);
                String amount = amountText.getText().toString();
                buySecurity(amount);
            }
        });
    }

    private void buySecurity(String amount){
        int boughtAmount = Integer.parseInt(amount);

        double price = Double.parseDouble(this.security.getAsk());
        double cost = boughtAmount * price;

        double money = Double.parseDouble(BankAccountData.GetMyAccount().getAmount());

        if(cost <= money) {

            money -= cost;
            BankAccountData.MyBankAccount.setAmount(Double.toString(money));
            IndexData.updateAmountOfSecurity(this.security.getSecurityId(), boughtAmount);

            boolean updated = SecurityData.updateAmountOfSecurity(this.security.getSecurityId(), boughtAmount);

            if (!updated)
                SecurityData.insertSecurity(CreateNewSecurity(amount));

            Toast.makeText(getApplicationContext(), "Success!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, BrokerActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Not enough money!", Toast.LENGTH_LONG).show();
        }
    }

    private Security CreateNewSecurity(String amount){
        return new Security(this.security.getSecurityId(),
                this.security.getName(),
                this.security.getPrice(),
                this.security.getDate(),
                this.security.getImagePath(),
                this.security.getType(),
                this.security.getRate(),
                this.security.getPercentage(),
                amount,
                this.security.getBid(),
                this.security.getAsk(),
                this.security.getAscending());
    }
}

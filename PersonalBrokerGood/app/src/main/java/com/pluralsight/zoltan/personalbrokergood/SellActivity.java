package com.pluralsight.zoltan.personalbrokergood;

import android.content.Intent;
import android.os.Bundle;
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

public class SellActivity extends AppCompatActivity {

    private static final String SECURITY_ID = "SecurityId";

    private Security security;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(SellActivity.this, SecuritiesOfIndexActivity.class);
                startActivity(myIntent);
            }
        });

        String securityId = getIntent().getStringExtra(SECURITY_ID);
        this.security = SecurityData.GetSecurityById(securityId);

        TextView title = (TextView) findViewById(R.id.sell_title);
        TextView type = (TextView) findViewById(R.id.buy_type_readonly);
        TextView price = (TextView) findViewById(R.id.sell_price_text);
        TextView availableAmount = (TextView) findViewById(R.id.sell_available_amount);

        title.setText(this.security.getName());
        type.setText(this.security.getType());
        price.setText(this.security.getAsk());
        availableAmount.setText(this.security.getAmount());

        Button button = (Button) findViewById(R.id.sell_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView amountText = (TextView) findViewById(R.id.sell_amount_text);
                String amount = amountText.getText().toString();
                sellSecurity(amount);
            }
        });
    }

    private void sellSecurity(String amount){
        int amountToSell = Integer.parseInt(amount);
        int currentAmount = Integer.parseInt(this.security.getAmount());

        double price = Double.parseDouble(this.security.getAsk());
        double profit = amountToSell * price;

        double money = Double.parseDouble(BankAccountData.GetMyAccount().getAmount());
        money += profit;

        if(amountToSell > currentAmount)
            Toast.makeText(getApplicationContext(), "You don't have enough elements!", Toast.LENGTH_LONG).show();

        if(amountToSell == currentAmount) {
            SecurityData.deleteElement(this.security.getSecurityId());
            BankAccountData.MyBankAccount.setAmount(Double.toString(money));
            Toast.makeText(getApplicationContext(), "Success!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, BrokerActivity.class);
            startActivity(intent);
        }

        if(amountToSell < currentAmount) {
            SecurityData.decreaseAmount(this.security.getSecurityId(), amountToSell);
            BankAccountData.MyBankAccount.setAmount(Double.toString(money));
            Toast.makeText(getApplicationContext(), "Success!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, BrokerActivity.class);
            startActivity(intent);
        }
    }
}

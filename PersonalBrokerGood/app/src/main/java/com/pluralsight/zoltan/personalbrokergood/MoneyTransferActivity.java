package com.pluralsight.zoltan.personalbrokergood;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import MockDatabase.Models.Database.BankAccountData;

public class MoneyTransferActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money_transfer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button button = (Button) findViewById(R.id.money_transfer_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTransferButtonClick();
            }
        });


    }

    void onTransferButtonClick(){
        EditText amountEditText = (EditText) findViewById(R.id.amount_to_transfer);
        String amount = amountEditText.getText().toString();
        try {
            double plusAmount = Double.parseDouble(amount);
            double currentAmount = Double.parseDouble(BankAccountData.GetMyAccount().getAmount());
            double finalAmount = currentAmount + plusAmount;

            BankAccountData.GetMyAccount().setAmount(Double.toString(finalAmount));

            Toast.makeText(getApplicationContext(), "Money has been transferred!", Toast.LENGTH_LONG).show();
        }
        catch (Exception ex){
            Toast.makeText(getApplicationContext(), "Wrong amount! It needs to be a number!", Toast.LENGTH_LONG).show();
        }
    }
}

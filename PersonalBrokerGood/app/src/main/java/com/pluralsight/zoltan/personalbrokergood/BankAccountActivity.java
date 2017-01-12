package com.pluralsight.zoltan.personalbrokergood;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.pluralsight.zoltan.personalbrokergood.R;

import MockDatabase.Models.BankAccount;
import MockDatabase.Models.Database.BankAccountData;

public class BankAccountActivity extends AppCompatActivity {

    private BankAccount bankAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_account);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bankAccount = BankAccountData.GetMyAccount();

        TextView iban = (TextView) findViewById(R.id.MyAccountIban);
        iban.setText(this.bankAccount.getIban());

        TextView amount = (TextView) findViewById(R.id.MyAccountAmount);
        amount.setText(this.bankAccount.getAmount());
    }

}

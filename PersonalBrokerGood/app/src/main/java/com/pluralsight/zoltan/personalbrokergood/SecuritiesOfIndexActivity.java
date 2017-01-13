package com.pluralsight.zoltan.personalbrokergood;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.pluralsight.zoltan.personalbrokergood.fragment.PortfolioFragment;
import com.pluralsight.zoltan.personalbrokergood.fragment.SecurityFragment;

import MockDatabase.Models.Database.IndexData;
import MockDatabase.Models.Security;

public class SecuritiesOfIndexActivity extends AppCompatActivity implements SecurityFragment.OnSecurityInteractionListener {

    private static final String INDEX_POSITION = "IndexPosition";

    private static final String SECURITY_ID = "SecurityId";
    private static final String OPERATION = "Operation";
    private static final String BUY_OPERATION = "Buy";

    private static final String FRAGMENT_ID = "FragmentName";
    private static final String SECURITY_LIST = "SecurityList";

    private Security index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_securities_of_index);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(SecuritiesOfIndexActivity.this, BrokerActivity.class);
                myIntent.putExtra(FRAGMENT_ID, SECURITY_LIST);
                startActivity(myIntent);
            }
        });

        String position = getIntent().getStringExtra(INDEX_POSITION);

        this.index = IndexData.getIndexById(position);

        TextView title = (TextView) findViewById(R.id.title_index_name);
        title.setText(index.getName());

        SecurityFragment fragment = SecurityFragment.newInstance(position);
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.security_fragment_container, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onSecurityInteraction(Security item){
        Intent myIntent = new Intent(this, PortfolioDetailsActivity.class);
        myIntent.putExtra(SECURITY_ID, item.getSecurityId());
        myIntent.putExtra(OPERATION, BUY_OPERATION);
        startActivity(myIntent);
    }
}

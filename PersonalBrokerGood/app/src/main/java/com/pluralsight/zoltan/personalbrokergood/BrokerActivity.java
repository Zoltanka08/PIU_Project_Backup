package com.pluralsight.zoltan.personalbrokergood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.pluralsight.zoltan.personalbrokergood.fragment.CurrencyFragment;
import com.pluralsight.zoltan.personalbrokergood.fragment.IndexFragment;
import com.pluralsight.zoltan.personalbrokergood.fragment.NewsFragment;
import com.pluralsight.zoltan.personalbrokergood.fragment.PortfolioFragment;

import MockDatabase.Models.Currency;
import MockDatabase.Models.News;
import MockDatabase.Models.Security;

public class BrokerActivity extends AppCompatActivity
        implements  NavigationView.OnNavigationItemSelectedListener,
                    NewsFragment.OnNewsInteractionListener,
                    PortfolioFragment.OnPortfolioInteractionListener,
                    AdapterView.OnItemSelectedListener,
                    IndexFragment.OnIndexInteractionListener,
                    CurrencyFragment.OnCurrencyFragmentInteractionListener {

    private static final String SECURITY_ID = "SecurityId";
    private static final String NEWS_ID = "NewsId";
    private static final String OPERATION = "Operation";
    private static final String SELL_OPERATION = "Sell";

    private static final String FRAGMENT_ID = "FragmentName";
    private static final String NEWS_DETAILS = "NewsDetails";
    private static final String SECURITY_LIST = "SecurityList";

    private static final String SPINNER_CHOICE = "SpinnerChoice";
    private static final String INDEX_POSITION = "IndexPosition";

    NavigationView navigationView = null;
    Toolbar toolbar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broker);

        //Set the fragment initially


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        Spinner spinner = (Spinner) findViewById(R.id.menu_options_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.menu_options, R.layout.spinner_style);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_style);
        spinner.setAdapter(adapter);

        if (savedInstanceState != null) {
            spinner.setSelection(savedInstanceState.getInt(SPINNER_CHOICE, 0));
        }

        spinner.setOnItemSelectedListener(this);

        String fragmentName = getIntent().getStringExtra(FRAGMENT_ID);
        setSpinnerState(fragmentName);

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Spinner spinner = (Spinner) findViewById(R.id.menu_options_spinner);
        outState.putInt(SPINNER_CHOICE, spinner.getSelectedItemPosition());

        super.onSaveInstanceState(outState);
    }

    private void setSpinnerState(String fragmentName){
        if(fragmentName != null)
        {
            if(fragmentName.equals(NEWS_DETAILS)){
                Spinner spinner = (Spinner) findViewById(R.id.menu_options_spinner);
                spinner.setSelection(3);
                NewsFragment fragment = new NewsFragment();
                android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            }

            if(fragmentName.equals(SECURITY_LIST)){
                Spinner spinner = (Spinner) findViewById(R.id.menu_options_spinner);
                spinner.setSelection(1);
                IndexFragment fragment = new IndexFragment();
                android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            }
        }
        else
        {
            PortfolioFragment fragment = new PortfolioFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.broker, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {

        if(pos == 0){
            PortfolioFragment fragment = new PortfolioFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
        } else if(pos == 1){
            IndexFragment fragment = new IndexFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
        } else if(pos == 2){
            CurrencyFragment fragment = new CurrencyFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
        } else if(pos == 3){
            NewsFragment fragment = new NewsFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
        }
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
    }

    public void onNothingSelected(AdapterView<?> parent) {
        PortfolioFragment fragment = new PortfolioFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.money_transfer) {
            Intent intent = new Intent(this, MoneyTransferActivity.class);
            startActivity(intent);
        } else if (id == R.id.current_bank_account) {
            Intent intent = new Intent(this, BankAccountActivity.class);
            startActivity(intent);
        } else if (id == R.id.help) {
            Intent intent = new Intent(this, HelpActivity.class);
            startActivity(intent);
        } else if (id == R.id.logout) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onPortfolioInteraction(Security item){
        Intent myIntent = new Intent(this, PortfolioDetailsActivity.class);
        myIntent.putExtra(SECURITY_ID, item.getSecurityId());
        myIntent.putExtra(OPERATION, SELL_OPERATION);
        startActivity(myIntent);
    }

    @Override
    public void onNewsInteraction(News item){
        Intent myIntent = new Intent(this, NewsDetailsActivity.class);
        myIntent.putExtra(NEWS_ID, item.getId());
        startActivity(myIntent);
    }

    @Override
    public void onIndexInteraction(Security item){
        Intent myIntent = new Intent(this, SecuritiesOfIndexActivity.class);
        myIntent.putExtra(INDEX_POSITION, item.getSecurityId());
        startActivity(myIntent);
    }

    @Override
    public void onCurrencyInteraction(Currency item){

    }
}

package forfendsec.com.sgr;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joshua Munaweza on 11/17/17.
 */

public class Economy extends AppCompatActivity implements View.OnClickListener {


    private AppCompatActivity activity = forfendsec.com.sgr.Economy.this;
    private RecyclerView recyclerViewTrains;
    private List<Economy> trainList;
    private EconomyAdapter economyRecyclerAdapter;
    private DBHandler databaseHelper;


    private AppCompatTextView booking;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_economy);
        getSupportActionBar().setTitle("");
        initViews();
        initListeners();
        initObjects();

    }


    private void initListeners() {
        booking.setOnClickListener(this);

    }

    private void initViews() {

        recyclerViewTrains = (RecyclerView) findViewById(R.id.recyclerViewTrains);
        booking = (AppCompatTextView) findViewById(R.id.textViewSeats);
        booking = (AppCompatTextView) findViewById(R.id.textViewPrice);
        booking = (AppCompatTextView) findViewById(R.id.textViewTrainDestination);
        booking = (AppCompatTextView) findViewById(R.id.textViewTrainName);
    }


    private void initObjects() {
        trainList = new ArrayList<>();
        economyRecyclerAdapter = new EconomyAdapter(trainList);


        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewTrains.setLayoutManager(mLayoutManager);
        recyclerViewTrains.setItemAnimator(new DefaultItemAnimator());
        recyclerViewTrains.setHasFixedSize(true);
        recyclerViewTrains.setAdapter(economyRecyclerAdapter);
        databaseHelper = new DBHandler(activity);

        String destinationFromIntent = getIntent().getStringExtra("Destination:");
        String nameFromIntent = getIntent().getStringExtra("Train:");
        String priceFromIntent = getIntent().getStringExtra("Price:");
        String seatsFromIntent = getIntent().getStringExtra("Seats:");

        booking.setText(nameFromIntent);
        booking.setText(destinationFromIntent);
        booking.setText(priceFromIntent);
        booking.setText(seatsFromIntent);


        getDataFromSQLite();

    }


    @SuppressLint("StaticFieldLeak")
    private void getDataFromSQLite() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                trainList.clear();
                trainList.addAll(databaseHelper.getAllEconomy());

                return null;
            }


            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                economyRecyclerAdapter.notifyDataSetChanged();
            }
        }.execute();
    }


    @Override
    public void onClick(View view) {

    }


    int _train_id;
    String train;
    String destination;
    String seats;
    String price;

    public Economy(int _train_id, String train, String destination, String seats, String price) {
        this._train_id = _train_id;
        this.train = train;
        this.destination = destination;
        this.seats = seats;
        this.price = price;
    }

    public Economy(String train, String destination, String seats, String price) {
        this.train = train;
        this.destination = destination;
        this.seats = seats;
        this.price = price;
    }

    public Economy() {

    }


    public int getId() {
        return this._train_id;
    }

    public void setId(int _train_id) {
        this._train_id = _train_id;
    }

    public String getTrain() {
        return this.train;
    }

    public void setTrain(String train) {
        this.train = train;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getSeats() {
        return this.seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}
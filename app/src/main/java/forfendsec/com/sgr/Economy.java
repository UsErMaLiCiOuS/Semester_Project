package forfendsec.com.sgr;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joshua Munaweza on 11/17/17.
 */

public class Economy extends AppCompatActivity implements View.OnClickListener {


    private AppCompatActivity activity = forfendsec.com.sgr.Economy.this;
    private RecyclerView recyclerViewTrains;
    private List<Economy> economyList;
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


        /*DBHandler db = new DBHandler(this);


        db.addEconomy(new Economy(2541, "Madaraka Express", "Nairobi-Mombasa", "17", "700"));
        db.addEconomy(new Economy(2542, "Mariakani Express", "Mariakani-Nairobi", "33", "700"));
        db.addEconomy(new Economy(2543, "Kikuyu Express", "Kikuyu-Mombasa", "7", "1,000"));
        db.addEconomy(new Economy(2544, "Mombasa Express", "Mombasa-Nairobi", "40", "700"));




        List<Economy> economy = db.getAllEconomy();
        Log.d("Reading: ", "Reading all trains...");

        for (Economy cn : economy) {
            String log = "train_id: " + cn.getId() + ",Train: " + cn.getTrain() + " ,Destination: "
                    + cn.getDestination() + " ,Seats: " + cn.getSeats() + " ,Price: " + cn.getPrice();

            Log.d("economy ", log);
        }*/

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
        economyList = new ArrayList<>();
        economyRecyclerAdapter = new EconomyAdapter(economyList);


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






    private void getDataFromSQLite() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                economyList.clear();economyList.addAll(databaseHelper.getAllEconomy());

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
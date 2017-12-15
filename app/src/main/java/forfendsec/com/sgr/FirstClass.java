package forfendsec.com.sgr;

/**
 * Created by Joshua Munaweza on 12/15/17.
 */

import android.annotation.SuppressLint;
import android.content.Intent;
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
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class FirstClass extends AppCompatActivity implements View.OnClickListener {


    private AppCompatActivity activity = forfendsec.com.sgr.FirstClass.this;
    private RecyclerView recyclerViewTrains;
    private List<FirstClassModel> firstClassModelList;
    private FirstClassAdapter firstClassRecyclerAdapter;
    private DBHandler databaseHelper;


    private AppCompatTextView booking;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstclass);
        getSupportActionBar().setTitle("");
        initViews();
        initListeners();
        initObjects();

        ImageButton firstClassButton = findViewById(R.id.book);
        firstClassButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent book = new Intent(FirstClass.this, Home.class);
                startActivity(book);

            }
        });


    }


    private void initListeners() {
        booking.setOnClickListener(this);

    }

    private void initViews() {

        recyclerViewTrains = findViewById(R.id.recyclerViewTrains);
        booking = findViewById(R.id.textViewSeats);
        booking = findViewById(R.id.textViewPrice);
        booking = findViewById(R.id.textViewTrainDestination);
        booking = findViewById(R.id.textViewTrainName);
    }


    private void initObjects() {
        firstClassModelList = new ArrayList<>();
        firstClassRecyclerAdapter = new FirstClassAdapter(firstClassModelList);


        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewTrains.setLayoutManager(mLayoutManager);
        recyclerViewTrains.setItemAnimator(new DefaultItemAnimator());
        recyclerViewTrains.setHasFixedSize(true);
        recyclerViewTrains.setAdapter(firstClassRecyclerAdapter);
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
                firstClassModelList.clear();firstClassModelList.addAll(databaseHelper.getAllFirstClass());

                return null;
            }


            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                firstClassRecyclerAdapter.notifyDataSetChanged();
            }
        }.execute();
    }

    @Override
    public void onClick(View view) {

    }
}

package forfendsec.com.sgr;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * Created by Joshua Munaweza on 11/17/17.
 */

public class Economy extends AppCompatActivity {


    private ListView listData;
    private Adapter displayData;
    private List<Economy> grubData;
    private DBHandler dumpDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_economy);

        listData = (ListView)findViewById(R.id.data);
        dumpDB = new DBHandler(this);

        grubData = dumpDB.getAllEconomy();
        displayData = new Adapter(this, grubData);
        listData.setAdapter(displayData);
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



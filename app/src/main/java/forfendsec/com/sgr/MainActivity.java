package forfendsec.com.sgr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listData;
    private Adapter displayData;
    private List<Messages> grubData;
    private DBHandler dumpDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setTitle(getResources().getString(R.string.Login_Activity));

        setContentView(R.layout.activity_login);
        Button login_button = (Button) findViewById(R.id.Login);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(MainActivity.this, Home.class);
                startActivity(login);
            }
        });

        Button create_button = (Button) findViewById(R.id.Create);
        create_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent create = new Intent(MainActivity.this, Signup.class);
                startActivity(create);
            }
        });


        DBHandler db = new DBHandler(this);

        Log.d("Insert: ", "Inserting....");
        db.addContact(new Contacts("Joshua", "9100000000"));
        db.addContact(new Contacts("John", "9200000000"));
        db.addContact(new Contacts("Kelvo", "9200000000"));
        db.addContact(new Contacts("Kieth", "9400000000"));

        db.addMessage(new Messages("Nisignie class ya Mobile App", "9100000000", "Joshua"));
        db.addMessage(new Messages("Sawa brathe!", "9200000000", "Kelvo"));
        db.addMessage(new Messages("Yo niko online on FIFA", "9400000000", "Kieth"));
        db.addMessage(new Messages("Cheki msee achana na huyo dem", "9200000000", "John"));


        db.addSignUp(new Signup("Joshua", "Munaweza", "joshua.munaweza@strathmore.edu", "linux1234"));
        db.addSignUp(new Signup("Eric", "Otis", "otis76@gmail.com", "nasanrm"));
        db.addSignUp(new Signup("Stephen", "Kiema", "tesphen@strathmore.edu", "Djdemakufu254"));
        db.addSignUp(new Signup("Benson", "Kibet", "bensonkibet@yahoo.com", "Battlefield3Rules"));

        db.addLogin(new Login(33754423, "linux1234"));
        db.addLogin(new Login(30321245, "nasanrm"));
        db.addLogin(new Login(33567632,"Djdemakufu254"));
        db.addLogin(new Login(34456653, "Battlefield3Rules"));

        db.addEconomy(new Economy(2541,"Madaraka Express", "Nairobi-Mombasa", "17", "700"));
        db.addEconomy(new Economy(2542,"Mariakani Express", "Mariakani-Nairobi", "33", "700"));
        db.addEconomy(new Economy(2543,"Kikuyu Express", "Kikuyu-Mombasa", "7", "1,000"));
        db.addEconomy(new Economy(2544,"Mombasa Express", "Mombasa-Nairobi", "40", "700"));
        db.addEconomy(new Economy(2545,"Mtito-Andei Express", "Mtito Andei-Mombasa", "50", "500"));



        List<Contacts> contacts = db.getAllContacts();
        Log.d("Reading: ", "Reading all contacts...");

        List<Messages> messages = db.getAllMessages();
        Log.d("Reading: ", "Reading all messages...");

        List<Signup> signup = db.getAllSignUp();
        Log.d("Reading: ", "Reading all users...");

        List<Login> login = db.getAllLogin();
        Log.d("Reading: ", "Reading all logins...");

        List<Economy> economy = db.getAllEconomy();
        Log.d("Reading: ", "Reading all trains...");



        for (Contacts cn : contacts) {
            String log = "id: " + cn.getId() + ",Name: " + cn.getName() + " ,Phone: " + cn.getPhone_number();

            Log.d("contacts ", log);
        }

        for (Messages cn : messages) {
            String log = "id: " + cn.getId() + ",Phone: " + cn.getName() + " ,From: " + cn.getPhone_number() + " ,Message: " + cn.getSms();

            Log.d("messages ", log);
        }

        for (Signup cn : signup) {
            String log = "id: " + cn.getId() + ",First_Name: " + cn.getFirst_name() + " ,Last_Name: "
            + cn.getLast_name() + " ,Email: " + cn.getEmail() + " ,Password: " + cn.getPassword();

            Log.d("users ", log);
        }

        for (Login cn : login) {
            String log = "id: " + cn.getId() + " ,Password: " + cn.getPassword();

            Log.d("login ", log);
        }

        for (Economy cn : economy) {
            String log = "train_id: " + cn.getId() + ",Train: " + cn.getTrain() + " ,Destination: "
                    + cn.getDestination() + " ,Seats: " + cn.getSeats() + " ,Price: " + cn.getPrice();

            Log.d("economy ", log);
        }

    }
}

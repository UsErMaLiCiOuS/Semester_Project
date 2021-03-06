package forfendsec.com.sgr;

/**
 * Created by root on 11/1/17.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.List;


public class Login extends AppCompatActivity implements View.OnClickListener{

    private final AppCompatActivity activity = Login.this;

    private NestedScrollView nestedScrollView;

    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;

    private TextInputEditText textInputEditTextEmail;
    private TextInputEditText textInputEditTextPassword;

    private AppCompatButton Login;

    private AppCompatTextView Create;

    private InputValidation inputValidation;
    private DBHandler databaseHelper;

    private AdView mAdView;
    private Button btnFullscreenAd;

    private RecyclerView recyclerViewTrains;
    private List<Economy> economyList;
    private EconomyAdapter economyRecyclerAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        initViews();
        initListeners();
        initObjects();

        TextView textView = new TextView(this);
        textView.setText(R.string.text_login);
        textView.setText(R.string.text_not_member);
        textView.setText(R.string.hint_password);
        textView.setText(R.string.hint_email);


        Button login_button = findViewById(R.id.Login);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(Login.this, Home.class);
                startActivity(login);

            }
        });

        TextView create_button = findViewById(R.id.Create);
        create_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent create = new Intent(Login.this, Signup.class);
                startActivity(create);

            }
        });

        DBHandler db = new DBHandler(this);


        db.addFirstClass(new FirstClassModel(2541, "Madaraka Express", "Nairobi-Mombasa", "17", "1500"));
        db.addFirstClass(new FirstClassModel(2542, "Mariakani Express", "Mariakani-Nairobi", "33", "1500"));
        db.addFirstClass(new FirstClassModel(2543, "Kikuyu Express", "Kikuyu-Mombasa", "7", "2,500"));
        db.addFirstClass(new FirstClassModel(2544, "Mombasa Express", "Mombasa-Nairobi", "40", "1,500"));
        db.addFirstClass(new FirstClassModel(2545, "Mtito-Andei Express", "Mtito Andei-Mombasa", "50", "850"));

        db.addEconomy(new EconomyClassModel(2541, "Madaraka Express", "Nairobi-Mombasa", "17", "700"));
        db.addEconomy(new EconomyClassModel(2542, "Mariakani Express", "Mariakani-Nairobi", "33", "700"));
        db.addEconomy(new EconomyClassModel(2543, "Kikuyu Express", "Kikuyu-Mombasa", "7", "1,000"));
        db.addEconomy(new EconomyClassModel(2544, "Mombasa Express", "Mombasa-Nairobi", "40", "700"));
        db.addEconomy(new EconomyClassModel(2545, "Mtito-Andei Express", "Mtito Andei-Mombasa", "50", "500"));

        db.addLogin(new LoginModel(30335245,"Joshua Munaweza","joshua.munaweza@strathmore.edu","pass"));
        db.addLogin(new LoginModel(30321245, "nasanrm"));
        db.addLogin(new LoginModel(33567632,"Djdemakufu254"));
        db.addLogin(new LoginModel(34456653, "Battlefield3Rules"));


        List<FirstClassModel> firstClassModelList = db.getAllFirstClass();
        Log.d("Reading: ", "Reading all trains...");

        List<EconomyClassModel> economyClassModelList = db.getAllEconomy();
        Log.d("Reading: ", "Reading all trains...");

        List<LoginModel> loginModelList = db.getAllLogin();
        Log.d("Reading: ", "Reading all trains...");

        for (FirstClassModel cn : firstClassModelList) {
            String log = "train_id: " + cn.getId() + ",Train: " + cn.getTrain() + " ,Destination: "
                    + cn.getDestination() + " ,Seats: " + cn.getSeats() + " ,Price: " + cn.getPrice();

            Log.d("firstclass ", log);
        }

        for (EconomyClassModel cn : economyClassModelList) {
            String log = "train_id: " + cn.getId() + ",Train: " + cn.getTrain() + " ,Destination: "
                    + cn.getDestination() + " ,Seats: " + cn.getSeats() + " ,Price: " + cn.getPrice();

            Log.d("economyclass ", log);
        }

        for (LoginModel cn : loginModelList) {
            String log = "train_id: " + cn.getId() + ",Train: " + cn.getName() + " ,Destination: "
                    + cn.getEmail() + " ,Seats: " + cn.getPassword() + " ,Price: " + cn.getId();

            Log.d("firstclass ", log);
        }



        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice
                (AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("967251DFDD0E73A812CA02C1099E33CD")
                .build();
        mAdView.loadAd(adRequest);

        btnFullscreenAd = (Button) findViewById(R.id.btn_fullscreen_ad);
        btnFullscreenAd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent advert = new Intent(Login.this, Advert.class);
                startActivity(advert);

            }
    });


    mAdView.setAdListener(new AdListener() {
        @Override
        public void onAdLoaded() {
            Toast.makeText(getApplicationContext(), "Ad is Loaded!", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onAdClosed() {
            Toast.makeText(getApplicationContext(), "Ad is Closed!", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onAdFailedToLoad(int errorCode) {
            Toast.makeText(getApplicationContext(), "Ad failed to load! error code" + errorCode, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onAdLeftApplication() {
            Toast.makeText(getApplicationContext(), "Ad Left application", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onAdOpened() {
            Toast.makeText(getApplicationContext(), "Ad is Opened!", Toast.LENGTH_SHORT).show();
        }
    });
    }



    private void initViews() {

        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);

        textInputLayoutEmail = (TextInputLayout) findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);

        textInputEditTextEmail = (TextInputEditText) findViewById(R.id.textInputEditTextEmail);
        textInputEditTextPassword = (TextInputEditText) findViewById(R.id.textInputEditTextPassword);

        Login = (AppCompatButton) findViewById(R.id.Login);

        Create = (AppCompatTextView) findViewById(R.id.Create);


    }


    private void initListeners() {
        Login.setOnClickListener(this);
        Create.setOnClickListener(this);
    }


    private void initObjects() {
        databaseHelper = new DBHandler(activity);
        inputValidation = new InputValidation(activity);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Login:
                verifyFromSQLite();
                break;
            case R.id.Create:

                Intent intentRegister = new Intent(getApplicationContext(), Signup.class);
                startActivity(intentRegister);
                break;
        }
    }


    private void verifyFromSQLite() {
        if (!inputValidation.isInputEditTextFilled(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextEmail(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextPassword, textInputLayoutPassword, getString(R.string.error_message_password))) {
            return;
        }

        if (databaseHelper.checkUser(textInputEditTextEmail.getText().toString().trim()
                , textInputEditTextPassword.getText().toString().trim())) {


            Intent accountsIntent = new Intent(activity, UserListActivity.class);
            accountsIntent.putExtra("EMAIL", textInputEditTextEmail.getText().toString().trim());
            emptyInputEditText();
            startActivity(accountsIntent);


        } else {

            Snackbar.make(nestedScrollView, getString(R.string.error_valid_email_password), Snackbar.LENGTH_LONG).show();
        }
    }


    private void emptyInputEditText() {
        textInputEditTextEmail.setText(null);
        textInputEditTextPassword.setText(null);
    }
}


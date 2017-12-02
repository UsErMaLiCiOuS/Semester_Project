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
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


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




    private int id;
    private String name;
    private String email;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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


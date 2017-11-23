package forfendsec.com.sgr;

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
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

/**
 * Created by Joshua Munaweza on 11/17/17.
 */

/*public class Economy extends AppCompatActivity {


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_economy);

        getSupportActionBar().hide();

        initViews();
        initListeners();
        initObjects();

        Button login_button = (Button) findViewById(R.id.Login);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, Home.class));
            }
        });

        Button create_button = (Button) findViewById(R.id.Create);
        create_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, Signup.class));
            }
        });
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
        if (!inputValidation.isInputEditTextFilled(textInputEditTextPassword, textInputLayoutPassword, getString(R.string.error_message_email))) {
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
}*/


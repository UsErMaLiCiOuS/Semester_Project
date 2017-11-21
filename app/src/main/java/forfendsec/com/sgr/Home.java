package forfendsec.com.sgr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by Joshua Munaweza on 11/15/17.
 */

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ImageButton logout_button = (ImageButton) findViewById(R.id.iconLogout);
        logout_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent logout = new Intent(Home.this, Login.class);
                startActivity(logout);
            }
        });

        ImageButton ticket_button = (ImageButton) findViewById(R.id.iconTicket);
        ticket_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent book = new Intent(Home.this, ClassSelection.class);
                startActivity(book);
            }
        });
    }
}

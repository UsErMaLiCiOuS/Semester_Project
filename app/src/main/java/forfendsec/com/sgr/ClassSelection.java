package forfendsec.com.sgr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

/**
 * Created by Joshua Munaweza on 11/16/17.
 */

public class ClassSelection extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class);

        Button economy_button = (Button) findViewById(R.id.buttonEconomy);
        economy_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent economy = new Intent(ClassSelection.this, Economy.class);
                startActivity(economy);
            }
        });

    }
}

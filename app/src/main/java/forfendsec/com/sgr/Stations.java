package forfendsec.com.sgr;

/**
 * Created by Joshua Munaweza on 12/19/17.
 */

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


public class Stations extends Activity{


        private Spinner spinnerStation;
        private Spinner spinnerSub;
        private Button submitStation;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_stations);

            addItemsOnSpinnerSub();
            addListenerOnButton();
            addListenerOnSpinnerItemSelection();
        }


        public void addItemsOnSpinnerSub() {

            spinnerSub = (Spinner) findViewById(R.id.spinnerSub);
            List<String> list = new ArrayList<String>();
            list.add("Select Region");
            list.add("Western Province");
            list.add("Eastern Province");
            list.add("Northern Province");
            list.add("Southern Province");
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerSub.setAdapter(dataAdapter);
        }

        public void addListenerOnSpinnerItemSelection() {
            spinnerStation = (Spinner) findViewById(R.id.spinnerStation);
            spinnerStation.setOnItemSelectedListener(new CustomListener());
        }

        // get the selected dropdown list value
        public void addListenerOnButton() {

            spinnerStation = (Spinner) findViewById(R.id.spinnerStation);
            spinnerSub = (Spinner) findViewById(R.id.spinnerSub);
            submitStation = (Button) findViewById(R.id.station);

            submitStation.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {

                    Toast.makeText(Stations.this,
                            "OnClickListener : " +
                                    "\nSpinner 1 : "+ String.valueOf(spinnerStation.getSelectedItem()) +
                                    "\nSpinner 2 : "+ String.valueOf(spinnerSub.getSelectedItem()),
                            Toast.LENGTH_SHORT).show();
                }

            });
        }
    }

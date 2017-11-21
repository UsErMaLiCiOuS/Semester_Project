package forfendsec.com.sgr;

/**
 * Created by root on 11/1/17.
 */

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;



public class Adapter extends BaseAdapter {
    private Context myContext;
    private List<Economy> trainList;

    public Adapter(Context myContext, List<Economy> trainList){
        this.myContext = myContext;
        this.trainList = trainList;
    }


    @Override
    public Object getItem(int position) {
        return trainList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return trainList.get(position).getId();
    }

    @Override
    public int getCount() {
        return trainList.size();
    }




    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        @SuppressLint("ViewHolder") View v = View.inflate(myContext, R.layout.items,null);
        TextView Train = v.findViewById(R.layout.id.train);
        TextView Price = v.findViewById(R.layout.id.pimu);
        TextView Destination = v.findViewById(R.layout.id.destination);
        TextView Seats = v.findViewById(R.layout.id.seats);

        Train.setText(trainList.get(position).getTrain());
        Price.setText(trainList.get(position).getPrice());
        Destination.setText(trainList.get(position).getDestination());
        Seats.setText(trainList.get(position).getSeats());
        return v;
    }

}





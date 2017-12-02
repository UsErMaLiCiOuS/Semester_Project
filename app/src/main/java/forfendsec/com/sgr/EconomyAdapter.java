package forfendsec.com.sgr;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Joshua Munaweza on 12/1/17.
 */

public class EconomyAdapter extends RecyclerView.Adapter<EconomyAdapter.UserViewHolder> {
    private List<Economy> trainList;

    public EconomyAdapter(List<Economy> trainList) {
        this.trainList = trainList;
    }


    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_economy, parent, false);

        return new UserViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {

        holder.textViewId.setText(trainList.get(position).getId());
        holder.textViewTrainDestination.setText(trainList.get(position).getDestination());
        holder.textViewPrice.setText(trainList.get(position).getPrice());
        holder.textViewSeats.setText(trainList.get(position).getSeats());
        holder.textViewTrainName.setText(trainList.get(position).getTrain());


    }


    public int getItemCount() {

        Log.v(Adapter.class.getSimpleName(),"list"+trainList.size());
        return trainList.size();

    }




    public class UserViewHolder extends RecyclerView.ViewHolder {

        public AppCompatTextView textViewTrainName;
        public AppCompatTextView textViewTrainDestination;
        public AppCompatTextView textViewSeats;
        public AppCompatTextView textViewPrice;

        public AppCompatTextView textViewId;



        public UserViewHolder(View view) {
            super(view);
            textViewId = (AppCompatTextView) view.findViewById(R.id.textViewId);

            textViewTrainName = (AppCompatTextView) view.findViewById(R.id.textViewTrainName);
            textViewTrainDestination = (AppCompatTextView) view.findViewById(R.id.textViewTrainDestination);
            textViewPrice = (AppCompatTextView) view.findViewById(R.id.textViewPrice);
            textViewSeats = (AppCompatTextView) view.findViewById(R.id.textViewSeats);


        }
    }


}
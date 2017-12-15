package forfendsec.com.sgr;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Joshua Munaweza on 12/15/17.
 */

public class FirstClassAdapter extends RecyclerView.Adapter<FirstClassAdapter.UserViewHolder>{


    private List<FirstClassModel> firstClassModelList;

    public FirstClassAdapter(List<FirstClassModel> firstClassModelList) {
        this.firstClassModelList = firstClassModelList;
    }


    @Override
    public FirstClassAdapter.UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_firstclass, parent, false);

        return new FirstClassAdapter.UserViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(FirstClassAdapter.UserViewHolder holder, int position) {

        /*holder.textViewId.setText(firstClassModelList.get(Integer.parseInt(null)).getId());*/
        holder.textViewTrainDestination.setText(firstClassModelList.get(position).getDestination());
        holder.textViewPrice.setText(firstClassModelList.get(position).getPrice());
        holder.textViewSeats.setText(firstClassModelList.get(position).getSeats());
        holder.textViewTrainName.setText(firstClassModelList.get(position).getTrain());


    }


    public int getItemCount() {

        Log.v(Adapter.class.getSimpleName(),"list"+firstClassModelList.size());
        return firstClassModelList.size();

    }




    public class UserViewHolder extends RecyclerView.ViewHolder {

        public AppCompatTextView textViewTrainName;
        public AppCompatTextView textViewTrainDestination;
        public AppCompatTextView textViewSeats;
        public AppCompatTextView textViewPrice;

        public AppCompatTextView textViewId;



        public UserViewHolder(View view) {
            super(view);
            textViewId = view.findViewById(R.id.textViewId);

            textViewTrainName = view.findViewById(R.id.textViewTrainName);
            textViewTrainDestination = view.findViewById(R.id.textViewTrainDestination);
            textViewPrice = view.findViewById(R.id.textViewPrice);
            textViewSeats = view.findViewById(R.id.textViewSeats);


        }
    }


}


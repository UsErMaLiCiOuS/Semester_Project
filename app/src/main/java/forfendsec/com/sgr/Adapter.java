package forfendsec.com.sgr;

/**
 * Created by root on 11/1/17.
 */

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.UserViewHolder> {
    private List<LoginModel> loginList;

    public Adapter(List<LoginModel> loginModelListList) {
        this.loginList = loginList;
    }


    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items, parent, false);

        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {

        holder.textViewId.setText(loginList.get(position).getId());
        holder.textViewPassword.setText(loginList.get(position).getPassword());




    }


    public int getItemCount() {

        Log.v(Adapter.class.getSimpleName(),"list"+loginList.size());
        return loginList.size();

    }




    public class UserViewHolder extends RecyclerView.ViewHolder {

        public AppCompatTextView textViewName;
        public AppCompatTextView textViewEmail;
        public AppCompatTextView textViewPassword;

        public AppCompatTextView textViewId;



        public UserViewHolder(View view) {
            super(view);
            textViewId = (AppCompatTextView) view.findViewById(R.id.textViewId);

            textViewName = (AppCompatTextView) view.findViewById(R.id.textViewName);
            textViewEmail = (AppCompatTextView) view.findViewById(R.id.textViewEmail);
            textViewPassword = (AppCompatTextView) view.findViewById(R.id.textViewPassword);


        }
    }


}






package com.example.celebritylist;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;

public class CelebrityRecyclerViewAdapter extends RecyclerView.Adapter<CelebrityRecyclerViewAdapter.ViewHolder> {

    ArrayList<Celebrity> celebList = new ArrayList<>();

    public CelebrityRecyclerViewAdapter(ArrayList<Celebrity> celebList){

        this.celebList = celebList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).
                inflate(R.layout.celebrity_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Celebrity celebrityBeingRendered = celebList.get(position);
        holder.tvFName.setText(celebrityBeingRendered.getfName());
        holder.tvLName.setText(celebrityBeingRendered.getlName());
        //holder.setVin(celebrityBeingRendered.getlName());


    }

    @Override
    public int getItemCount() {
        return celebList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvFName, tvLName;
        String lName;

        public ViewHolder(final View itemView){

            super(itemView);
            tvFName = itemView.findViewById(R.id.tvFName);
            tvLName = itemView.findViewById(R.id.tvLName);

            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view){

                    CelebrityDatabaseHelper helper = new CelebrityDatabaseHelper(view.getContext());
                    helper.removeCelebrity(lName);

                    celebList = helper.getAllCelebrities();
                    notifyDataSetChanged();
                }
            });

        }

        public void setlName(String lName) {this.lName = lName;}

    }
}

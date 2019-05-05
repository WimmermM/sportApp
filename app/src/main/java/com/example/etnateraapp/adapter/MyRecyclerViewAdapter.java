package com.example.etnateraapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.etnateraapp.Constants;
import com.example.etnateraapp.R;
import com.example.etnateraapp.model.SportResult;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private List<SportResult> sportResults;

    public MyRecyclerViewAdapter() {
        this.sportResults = new ArrayList<>();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.my_list_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Log.d(TAG, "onBindViewHolder: called");
        viewHolder.name.setText(sportResults.get(i).getName());
        viewHolder.place.setText(sportResults.get(i).getPlace());
        viewHolder.time.setText(String.valueOf(sportResults.get(i).getTime()));
        if (sportResults.get(i).getLocalStorage()){
            viewHolder.storage.setText(Constants.LOCAL_STORAGE);
        }else if (sportResults.get(i).getExternalStorage()){
            viewHolder.storage.setText(Constants.EXTERNAL_STORAGE);
        }

    }

    @Override
    public int getItemCount() {
        return sportResults.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.list_item_text_layout)
        LinearLayout layout;
        @BindView(R.id.list_sport_name)
        TextView name;
        @BindView(R.id.list_sport_place)
        TextView place;
        @BindView(R.id.list_sport_duration)
        TextView time;
        @BindView(R.id.list_sport_storage)
        TextView storage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void addSportResults(List<SportResult> mySportResults){
        sportResults.addAll(mySportResults);
    }
}

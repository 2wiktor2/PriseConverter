package com.wiktor.mysuperpriceconverter.activity.fragments.exchangeRatesFragment.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wiktor.mysuperpriceconverter.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter <RecyclerViewAdapter.ViewHolder> {

    String[] strings = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(strings[i]);
    }

    @Override
    public int getItemCount() {
        return strings.length;
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_1;
        private TextView tv_2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_1 = itemView.findViewById(R.id.tv_id_item);
            tv_2 = itemView.findViewById(R.id.tv_name_item);
        }

        void bind(String string) {

            tv_1.setText("id = "+String.valueOf(getAdapterPosition()));
            tv_2.setText(string);

        }
    }
}

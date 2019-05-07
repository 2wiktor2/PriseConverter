package com.wiktor.mysuperpriceconverter.activity.fragments.exchangeRatesFragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wiktor.mysuperpriceconverter.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter <RecyclerViewAdapter.ViewHolder> {


private List<Pojo> listPogo;
private Context context;


    public RecyclerViewAdapter(List <Pojo> listPogo, Context context) {
        this.listPogo = listPogo;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(listPogo.get(i));
    }

    @Override
    public int getItemCount() {
        return listPogo.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_1;
        private TextView tv_2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_1 = itemView.findViewById(R.id.tv_id_item);
            tv_2 = itemView.findViewById(R.id.tv_name_item);
        }

        void bind(Pojo pojo) {
            tv_1.setText("id = "+String.valueOf(getAdapterPosition()));
            tv_2.setText(pojo.getName());

        }
    }
}

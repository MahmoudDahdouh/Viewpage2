package com.mahmoud.dahdouh.viewpager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {


    private List<PageModel> list;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflate the layout
        return new MyViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<PageModel> list) {
        this.list = list;
        notifyDataSetChanged();
    }


    // set list and notify data

    class MyViewHolder extends RecyclerView.ViewHolder {

        //define components in listitem
        private ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            // inflate
            imageView = itemView.findViewById(R.id.listitem_image);
        }

        void bind(int position) {
            // bind data
            imageView.setImageResource(list.get(position).getImage());
        }
    }
}

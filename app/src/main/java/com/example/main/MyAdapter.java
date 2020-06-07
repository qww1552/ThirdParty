package com.example.main;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public String link;
        public TextView pubdate;
        public TextView from;
        public MyViewHolder(View v) {
            super(v);
            title = v.findViewById(R.id.title);

            pubdate = v.findViewById(R.id.pubdate);
            from = v.findViewById(R.id.from);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));

                    context.startActivity(intent);
                }
            });
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    private ArrayList<NewsItem> item;
    public MyAdapter(ArrayList<NewsItem> item) {
        this.item = item;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        // create a new view
        View v = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return new MyViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder)holder;
        myViewHolder.title.setText(item.get(position).getTitle());
        myViewHolder.link = (item.get(position).getLink());
        myViewHolder.pubdate.setText(item.get(position).getPubdate());
        myViewHolder.from.setText("출처: "+item.get(position).getFrom());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return item.size();
    }
}

package com.example.android.webtalktrial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

public class WebinarListAdapter extends RecyclerView.Adapter<WebinarListAdapter.WebinarViewHolder>
{
    private ArrayList<Webinar> webinarList;
    private Context context;
    private ViewHolderClickListener viewHolderClickListener;
    public WebinarListAdapter(Context context, ArrayList<Webinar> webinarList) {
        this.context = context;
        this.webinarList = webinarList;
        Collections.reverse(this.webinarList);
    }

    @NonNull
    @Override
    public WebinarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.list_item,parent,false);
        final WebinarViewHolder mWebinarViewHolder = new WebinarViewHolder(v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolderClickListener.viewHolderClickListener(v,mWebinarViewHolder.getAdapterPosition());
            }
        });
        return mWebinarViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WebinarViewHolder holder, int position) {
        Webinar webinar = webinarList.get(position);
        holder.webinarName.setText(webinar.getWebinarName());
        holder.webinarHost.setText(webinar.getWebinarHost());
        holder.webinarTopic.setText(webinar.getWebinarTopic());
        holder.webinarDate.setText(webinar.getWebinarDate());
        holder.webinarTime.setText(webinar.getWebinarTime());
    }

    @Override
    public int getItemCount() {
        return webinarList.size();
    }

    public static class WebinarViewHolder extends RecyclerView.ViewHolder {
        TextView webinarName;
        TextView webinarHost;
        TextView webinarTopic;
        TextView webinarDate;
        TextView webinarTime;
        WebinarViewHolder(@NonNull View itemView) {
            super(itemView);
            webinarName = itemView.findViewById(R.id.WebinarName);
            webinarHost = itemView.findViewById(R.id.WebinarHost);
            webinarTopic = itemView.findViewById(R.id.WebinarTopic);
            webinarDate = itemView.findViewById(R.id.WebinarDate);
            webinarTime = itemView.findViewById(R.id.WebinarTime);
        }
    }
    public void filterList(ArrayList<Webinar> filteredList)
    {
        webinarList = filteredList;
        notifyDataSetChanged();
    }
    public interface OnWebinarClickListener {
        void onWebinarClick(int position);
    }
}

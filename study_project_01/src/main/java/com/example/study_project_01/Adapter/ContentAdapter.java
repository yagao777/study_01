package com.example.study_project_01.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.study_project_01.Model.ContentModel;
import com.example.study_project_01.R;

import java.text.SimpleDateFormat;
import java.util.List;


public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ContentViewHolder> {

    private List<ContentModel> contentModelList;
    private SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

    public ContentAdapter(List<ContentModel> contentModels) {
        this.contentModelList = contentModels;
    }


    @NonNull
    @Override
    public ContentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.adapter_content, parent, false);

        return new ContentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContentViewHolder holder, int position) {
        ContentModel model = contentModelList.get(position);

        Glide.with(holder.itemView.getContext()).load(model.getUrl()).into(holder.iv_img);
        holder.tv_content.setText(model.getContent());
        holder.tv_time.setText(format.format(model.getTime()));

    }

    @Override
    public int getItemCount() {
        return contentModelList.size();
    }

    class ContentViewHolder extends RecyclerView.ViewHolder {

        private final ImageView iv_img;
        private final TextView tv_content;
        private final TextView tv_time;

        public ContentViewHolder(@NonNull View itemView) {
            super(itemView);

            iv_img = itemView.findViewById(R.id.iv_img);
            tv_content = itemView.findViewById(R.id.tv_content);
            tv_time = itemView.findViewById((R.id.tv_time));
        }
    }
}

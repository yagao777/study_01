package com.example.study_project_01.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.study_project_01.Model.CircleModel;
import com.example.study_project_01.R;

import java.util.List;

public class CircleAdapter extends RecyclerView.Adapter<CircleAdapter.CircleViewHolder> {

    private List<CircleModel> circleModelList;

    public CircleAdapter(List<CircleModel> circleModels){
        this.circleModelList = circleModels;
    }

    @NonNull
    @Override
    public CircleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.adapter_circle,parent,false);

        return new CircleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CircleViewHolder holder, int position) {
        CircleModel model = circleModelList.get(position);

        Glide.with(holder.itemView.getContext()).load(model.getUrl()).into(holder.iv_img);
        holder.tv_circle_content.setText(model.getContent());
    }

    @Override
    public int getItemCount() {
        return circleModelList.size();
    }

    class CircleViewHolder extends RecyclerView.ViewHolder{

        private final ImageView iv_img;
        private final TextView tv_circle_content;

        public CircleViewHolder(@NonNull View itemView) {
            super(itemView);

            iv_img = itemView.findViewById(R.id.iv_img);
            tv_circle_content = itemView.findViewById(R.id.tv_circle_content);
        }
    }
}

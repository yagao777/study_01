package com.example.study_05;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<MyModel> models;
    private OnItemClickListener mListener;

    public MyAdapter(List<MyModel> models) {
        this.models = models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.adapter_my, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MyModel model = models.get(position);

        Glide.with(holder.itemView.getContext()).load(model.getUrl()).into(holder.iv_img);
        holder.tv_title.setText(model.getTitle());
        holder.tv_subtitle .setText(model.getSubTitle());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView iv_img;
        private final TextView tv_title;
        private final TextView tv_subtitle;

        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);
            iv_img = itemView.findViewById(R.id.iv_img);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_subtitle = itemView.findViewById(R.id.tv_subtitle);

            // 在这里声明其他的控件
            // ....

            // 绑定Item的点击事件
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (null != mListener) {
                        mListener.onItemClick(models.get(getAdapterPosition()));
                    }
                }
            });
        }
    }

    public void setOnItemClickListener(OnItemClickListener mListener) {
        this.mListener = mListener;
    }

    public interface OnItemClickListener {
        void onItemClick(MyModel model);
    }
}

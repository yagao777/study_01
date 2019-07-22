package com.example.teach_05;

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

    // 现在，我们需要根据数据，来进行列表展示
    private List<MyModel> models;
    private OnItemClickListener mListener;

    public MyAdapter(List<MyModel> models) {
        this.models = models;
    }

    // 创建一个列表Item
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.adapter_my, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // 拿到对应Item位置上的数据
        MyModel model = models.get(position);

        TextView tv_item = holder.tv_item;

        tv_item.setText(model.getTitle());

        // glide这里只做简单使用即可，不需要深入理解
        Glide.with(holder.itemView.getContext())
                .load(model.getUrl())
                .into(holder.iv_img);
    }

    @Override
    public int getItemCount() {
        // 这里根据总的数据数量来确定Item的数量
        return models.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView tv_item;

        private final ImageView iv_img;

        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);
            tv_item = itemView.findViewById(R.id.tv_item);
            iv_img = itemView.findViewById(R.id.iv_img);

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

    // 外界绑定监听器，调用这个方法
    public void setOnItemClickListener(OnItemClickListener mListener) {
        this.mListener = mListener;
    }

    // 我们自定义一个Item点击事件监听器
    public interface OnItemClickListener {
        void onItemClick(MyModel model);
    }
}

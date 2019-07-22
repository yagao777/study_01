package com.example.teach_04;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    // 创建一个列表Item
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 这里我们需要为Item编写一个对应的布局

        // 这里我们需要先拿到一个布局的填充器
        // 它的作用是用来解析我们编写的布局文件，并把文件解析为一个View
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        // 解析出一个View
        // 暂时死记住这种写法，参数1是布局文件，参数就是方法传进来的parent，参数3为false
        View view = inflater.inflate(R.layout.adapter_my, parent, false);

        // 这里的MyViewHolder在下面进行声明了，我们在这里将列表Item和MyViewHolder进行绑定
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // 这里是重点！
        // 我们在这里将拿到上面onCreateViewHolder创建的MyViewHolder，
        // 因为RecyclerView有回收重用机制，这里的MyViewHolder可能时新创建的，也可能是回收后重用的，具体操作有RecyclerView完成，我们不用管；
        // position对应的就是列表Item的下标

        // 拿到MyViewHolder中保存的TextView
        TextView tv_item = holder.tv_item;

        tv_item.setText("我是列表Item，我的下标为：" + position);
    }

    @Override
    public int getItemCount() {
        // 通过这个方法，RecyclerView能够知道，究竟有多少个Item
        // 我们这里假设有100个
        return 100;
    }

    // 所谓的ViewHolder，顾名思义，就是一个View的持有者，这里的View就是我们的列表Item对应的View
    // 通过这个持有者，RecyclerView能够方便的管理它的所有Item的创建和重用，具体细节不用管
    class MyViewHolder extends RecyclerView.ViewHolder {
        // ViewHolder另一个比较常识的作用就是保存我们一个列表Item的所有子View
        // 比如这里保存的tv_item，是列表Item中声明的
        private final TextView tv_item;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            // 这里的ItemView就是列表Item对应的View

            // 没错！这里通过View也能调用findViewById，在Activity中调用findViewById，实际底层最终
            // 也是通过调用View的对应findViewById方法来实现的
            tv_item = itemView.findViewById(R.id.tv_item);
        }
    }
}

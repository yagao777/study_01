package com.example.study_summary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.study_summary.R;

public class PoetryImageAdapter extends PagerAdapter {

    final String[] imgs = new String[]{"http://n.sinaimg.cn/sinacn/w616h417/20171225/13b6-fypyuvc0250102.jpg", "http://i3.qulishi.com/static/2019/4/5d3a9d4dd3629.png", "http://n.sinaimg.cn/sinacn20109/209/w640h369/20190625/87e5-hyvnhqq5871176.jpg"};
    private final LayoutInflater inflater;

    public PoetryImageAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        // 这个方法提供ViewPager实现View重用的判断条件，一般我们都是这种写法
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        // 在这里，我们创建出ViewPager的每个Page
        View view = inflater.inflate(R.layout.image_poetry, container, false);

        ImageView imagePoetry = view.findViewById(R.id.iv_img_poetry);

        Glide.with(container.getContext()).load(imgs[position]).into(imagePoetry);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        // 这里也是有标准的写法, 当Page被销毁时，会回调这个方法，我们在这里实现Page与ViewPager的解绑
        container.removeView((View) object);
    }
}

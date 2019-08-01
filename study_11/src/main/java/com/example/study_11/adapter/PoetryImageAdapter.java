package com.example.study_11.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.study_11.R;

import java.util.ArrayList;
import java.util.List;

public class PoetryImageAdapter extends PagerAdapter {

    final String[] imgs = new String[]{"https://imgsrc.baidu.com/baike/pic/item/42a98226cffc1e1767f4b11e4690f603738de952.jpg", "http://img1.imgtn.bdimg.com/it/u=2118987523,4048843606&fm=26&gp=0.jpg", "http://n.sinaimg.cn/sinacn15/243/w620h423/20180402/0432-fysvpvf8689447.jpg"};
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

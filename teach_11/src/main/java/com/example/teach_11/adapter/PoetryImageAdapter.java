package com.example.teach_11.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class PoetryImageAdapter extends PagerAdapter {

    final String[] imgs = new String[]{"https://imgsrc.baidu.com/baike/pic/item/42a98226cffc1e1767f4b11e4690f603738de952.jpg", "http://img1.imgtn.bdimg.com/it/u=2118987523,4048843606&fm=26&gp=0.jpg", "http://n.sinaimg.cn/sinacn15/243/w620h423/20180402/0432-fysvpvf8689447.jpg"};

    @Override
    public int getCount() {
        return 0;
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
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        // 这里也是有标准的写法, 当Page被销毁时，会回调这个方法，我们在这里实现Page与ViewPager的解绑
        container.removeView((View) object);
    }
}

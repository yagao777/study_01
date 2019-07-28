package com.example.teach_09;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.teach_09.adapter.MyAdapter;
import com.example.teach_09.fragment.PoetryListFragment;
import com.example.teach_09.model.MyModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 如果是在Activity中立即加载显示Fragment，使用这种方式进行加载

        // 原因：当App退到后台后，在手机内存不足的情况下，有很大几率会被杀掉，
        // Android系统为了保证用户数据状态在这种情况下不至于丢失，于是提供了开发者在App被杀掉之前保存数据的机会
        // 要保存数据，我们可以重写Activity的onSaveInstanceState(Bundle outState)方法，将要保存的数据放到
        // outState这个参数中；

        // 当App在后台被杀掉之后，用户又点开App，那么在Activity再次被创建，执行到onCreate方法时，就会将之前保存
        // 的outState传给onCreate方法，我们拿到数据，就可以恢复Activity 的状态了。

        // 但是，当我们在Activity的onCreate方法中直接加载了Fragment，就会把Android系统为我们保存的数据清理掉，
        // 导致在其他方法中无法再拿到outState里面保存的数据；在这种情况下，Android系统会直接报错。

        // 不过，这种情况是很少发生的，在大部分的情况下，savedInstanceState是为null的。也就是说，绝大多数情况下，
        // 下面的if条件是为true的。

        // 这里可能比较复杂，涉及到系统原理的东西，你只要记住，在Activity的onCreate方法中直接加载Fragment时，就按
        // 这种格式写
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container, new PoetryListFragment()).commit();
        }
    }

}
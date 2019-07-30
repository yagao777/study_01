package com.example.study_10.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.study_10.R;


public class PoetryDynamicFragment extends Fragment {

    private Button btnUpdate;
    private PoetryInfoAFragment poetryInfoAFragment;
    private PoetryInfoBFragment poetryInfoBFragment;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         return inflater.inflate(R.layout.fragment_poetry_dynamic, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnUpdate = view.findViewById(R.id.btn_update);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        poetryInfoAFragment = new PoetryInfoAFragment();
        poetryInfoBFragment = new PoetryInfoBFragment();

        getFragmentManager().beginTransaction().add(R.id.container,poetryInfoAFragment).commit();

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.container,poetryInfoBFragment).commit();
            }
        });
    }
}

package com.example.study_project_01.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.study_project_01.Model.AnswerModel;
import com.example.study_project_01.R;

import java.text.SimpleDateFormat;
import java.util.List;

public class AnswerAdapter extends RecyclerView.Adapter<AnswerAdapter.AnswerViewHolder> {

    private List<AnswerModel> answerModelList;
    private SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

    public AnswerAdapter(List<AnswerModel> answerModelList) {
        this.answerModelList = answerModelList;
    }

    @NonNull
    @Override
    public AnswerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.adapter_answer,parent,false);

        return new AnswerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnswerViewHolder holder, int position) {
        AnswerModel model = answerModelList.get(position);

        holder.tv_question.setText(model.getQuestion());
        holder.tv_time.setText(format.format(model.getTime()));
    }

    @Override
    public int getItemCount() {
        return answerModelList.size();
    }

    class AnswerViewHolder extends RecyclerView.ViewHolder{

        private final TextView tv_question;
        private final TextView tv_time;

        public AnswerViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_question = itemView.findViewById(R.id.tv_question);
            tv_time = itemView.findViewById((R.id.tv_time));
        }
    }
}

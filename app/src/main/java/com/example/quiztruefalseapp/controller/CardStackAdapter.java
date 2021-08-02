package com.example.quiztruefalseapp.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.quiztruefalseapp.R;
import com.example.quiztruefalseapp.model.QuizQuestion;
import com.example.quiztruefalseapp.view.FilmViewHolder;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CardStackAdapter extends RecyclerView.Adapter<FilmViewHolder> {

    private Context mContext;
    private List<QuizQuestion> mFilmQuestion;
    private LayoutInflater mLayoutInflater;

    public CardStackAdapter(Context context, List<QuizQuestion> filmQuestions) {
        mContext = context;
        mFilmQuestion = filmQuestions;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull

    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {

        View view  = mLayoutInflater.inflate(R.layout.film_view, parent , false);

        return new FilmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  FilmViewHolder holder, int position) {

        holder.getTxtFilmQuestion().setText(mFilmQuestion.get(position).getQuestionText());
        holder.getImgButtonTrue().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (mFilmQuestion.get(position).isTrueAnswer()){
                    Toast.makeText(mContext,"Correct Answer" , Toast.LENGTH_SHORT).show();

                }else {

                    Toast.makeText(mContext,"Incorrect Answer" , Toast.LENGTH_SHORT).show();
                }
            }
        });

        holder.getImageButtonFalse().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mFilmQuestion.get(position).isTrueAnswer()){
                    Toast.makeText(mContext,"Incorrect Answer", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(mContext,"Correct Answer", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mFilmQuestion.size();
    }
}

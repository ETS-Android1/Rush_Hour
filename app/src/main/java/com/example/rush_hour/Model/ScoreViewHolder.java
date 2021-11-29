package com.example.rush_hour.Model;

import android.view.View;
import android.widget.TextView;
import com.example.rush_hour.R;

import androidx.recyclerview.widget.RecyclerView;

public class ScoreViewHolder extends RecyclerView.ViewHolder {

    //Attributes
    private TextView score_pseudo;
    private TextView score_numberStar;

    public ScoreViewHolder(View itemView) {
        super(itemView);

        //bindUI
        score_pseudo = itemView.findViewById(R.id.score_pseudo);
        score_numberStar = itemView.findViewById(R.id.score_numberStar);
    }

    //Getters
    public TextView getScore_pseudo() {
        return score_pseudo;
    }

    public TextView getScore_numberStar() {
        return score_numberStar;
    }
}

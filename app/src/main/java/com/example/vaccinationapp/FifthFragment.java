package com.example.vaccinationapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FifthFragment extends Fragment {
    private Button answer1Button, answer2Button, answer3Button, answer4Button, answer5Button, answer6Button, answer7Button, answer8Button, answer9Button, answer10Button;

    private TextView answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8, answer9, answer10;
    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_fifth, container, false);
        answer1Button = (Button) view.findViewById(R.id.showAnswer1);
        answer2Button = (Button) view.findViewById(R.id.showAnswer2);
        answer3Button = (Button) view.findViewById(R.id.showAnswer3);
        answer4Button = (Button) view.findViewById(R.id.showAnswer4);
        answer5Button = (Button) view.findViewById(R.id.showAnswer5);
        answer6Button = (Button) view.findViewById(R.id.showAnswer6);
        answer7Button = (Button) view.findViewById(R.id.showAnswer7);
        answer8Button = (Button) view.findViewById(R.id.showAnswer8);
        answer9Button = (Button) view.findViewById(R.id.showAnswer9);
        answer10Button = (Button) view.findViewById(R.id.showAnswer10);

        answer1 = (TextView) view.findViewById(R.id.answer1);
        answer2 = (TextView) view.findViewById(R.id.answer2);
        answer3 = (TextView) view.findViewById(R.id.answer3);
        answer4 = (TextView) view.findViewById(R.id.answer4);
        answer5 = (TextView) view.findViewById(R.id.answer5);
        answer6 = (TextView) view.findViewById(R.id.answer6);
        answer7 = (TextView) view.findViewById(R.id.answer7);
        answer8 = (TextView) view.findViewById(R.id.answer8);
        answer9 = (TextView) view.findViewById(R.id.answer9);
        answer10 = (TextView) view.findViewById(R.id.answer10);

        answer1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer1.getVisibility() == View.GONE)
                {
                    answer1.setVisibility(View.VISIBLE);
                }
                else
                {
                    answer1.setVisibility(View.GONE);
                }
            }
        });

        answer2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer2.getVisibility() == View.GONE)
                {
                    answer2.setVisibility(View.VISIBLE);
                }
                else
                {
                    answer2.setVisibility(View.GONE);
                }
            }
        });
        answer3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer3.getVisibility() == View.GONE)
                {
                    answer3.setVisibility(View.VISIBLE);
                }
                else
                {
                    answer3.setVisibility(View.GONE);
                }
            }
        });
        answer4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer4.getVisibility() == View.GONE)
                {
                    answer4.setVisibility(View.VISIBLE);
                }
                else
                {
                    answer4.setVisibility(View.GONE);
                }
            }
        });
        answer5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer5.getVisibility() == View.GONE)
                {
                    answer5.setVisibility(View.VISIBLE);
                }
                else
                {
                    answer5.setVisibility(View.GONE);
                }
            }
        });
        answer6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer6.getVisibility() == View.GONE)
                {
                    answer6.setVisibility(View.VISIBLE);
                }
                else
                {
                    answer6.setVisibility(View.GONE);
                }
            }
        });
        answer7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer7.getVisibility() == View.GONE)
                {
                    answer7.setVisibility(View.VISIBLE);
                }
                else
                {
                    answer7.setVisibility(View.GONE);
                }
            }
        });
        answer8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer8.getVisibility() == View.GONE)
                {
                    answer8.setVisibility(View.VISIBLE);
                }
                else
                {
                    answer8.setVisibility(View.GONE);
                }
            }
        });
        answer9Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer9.getVisibility() == View.GONE)
                {
                    answer9.setVisibility(View.VISIBLE);
                }
                else
                {
                    answer9.setVisibility(View.GONE);
                }
            }
        });
        answer10Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer10.getVisibility() == View.GONE)
                {
                    answer10.setVisibility(View.VISIBLE);
                }
                else
                {
                    answer10.setVisibility(View.GONE);
                }
            }
        });
        return view;
    }


}

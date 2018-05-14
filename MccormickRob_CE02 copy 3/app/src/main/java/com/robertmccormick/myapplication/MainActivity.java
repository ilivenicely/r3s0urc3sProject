package com.robertmccormick.myapplication;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvIntroduction, tvSummary, tvConclusion;
    ImageView ivTopic;
    Button button;
    LinearLayout linearLayout;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivTopic = findViewById(R.id.iv_topic);
        tvIntroduction = findViewById(R.id.tv_birthday);
        tvSummary = findViewById(R.id.tv_hobbies);
        tvConclusion = findViewById(R.id.tv_hometown);
//        button.findViewById(R.id.button);
        linearLayout = (LinearLayout) findViewById(R.id.linLayout1);
        constraintLayout =(ConstraintLayout) findViewById(R.id.constraintLayout);

        constraintLayout.setVisibility(View.GONE);



        ivTopic.setImageDrawable(getResources().getDrawable(R.drawable.img_tibet));
        tvIntroduction.setText(getResources().getText(R.string.birthday));
        tvSummary.setText(getResources().getText(R.string.hobbies));
        tvConclusion.setText(getResources().getText(R.string.hometown));

        initImageViewHeight();

        useButton();
        useButton2();



    }



    private void initImageViewHeight() {

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

            ivTopic.getLayoutParams().width = (int) (width * 0.25);

        } else {
            ivTopic.getLayoutParams().height = (int) (height * 0.20);
            ivTopic.requestLayout();

        }
    }


    public void useButton(){
        Button switchButton = (Button)findViewById(R.id.button);

        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//            startActivity(new Intent(MainActivity.this, SecondActivity.class));
                linearLayout.setVisibility(View.GONE);
                constraintLayout.setVisibility(View.VISIBLE);
            }
        });


    }

    public void useButton2(){
        Button switchButton = (Button)findViewById(R.id.button2);

        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(SecondActivity.this, MainActivity.class));

                linearLayout.setVisibility(View.VISIBLE);
                constraintLayout.setVisibility(View.GONE);
            }
        });



    }

}

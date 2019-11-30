package mobileapp.ragool.Braincolor;

import android.animation.ObjectAnimator;
import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

public class ResultActivity extends Activity {

    DonutProgress progress;
    int score, percentage;
    ImageView imgBack, imgReplay;
    boolean time = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        progress = (DonutProgress)findViewById(R.id.donut_progress);
        imgBack = (ImageView) findViewById(R.id.imgBack);
        imgReplay = (ImageView) findViewById(R.id.imgReplay);



        Bundle b = getIntent().getExtras();
        score = b.getInt("score");

        if(getIntent().hasExtra("time")){
            time = true;
        }

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.animator.enter,R.animator.leave);
                finish();
            }
        });

        imgReplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this, QuizActivity.class);
                if(time){
                    intent.putExtra("time", true);
                }

                startActivity(intent);
                overridePendingTransition(R.animator.in,R.animator.out);
                finish();
            }
        });



        percentage = (score*100)/10;

        if(percentage>=75){
            progress.setFinishedStrokeColor(getResources().getColor(R.color.green));
            progress.setTextColor(getResources().getColor(R.color.green));

        }else if(percentage>=50){
            progress.setFinishedStrokeColor(getResources().getColor(R.color.yellow));
            progress.setTextColor(getResources().getColor(R.color.yellow));
            getWindow().setStatusBarColor(getResources().getColor(R.color.yellow));

        }else if(percentage>=25){
            progress.setFinishedStrokeColor(getResources().getColor(R.color.orange));
            progress.setTextColor(getResources().getColor(R.color.orange));
            getWindow().setStatusBarColor(getResources().getColor(R.color.orange));

        }else{
            progress.setFinishedStrokeColor(getResources().getColor(R.color.red));
            progress.setTextColor(getResources().getColor(R.color.red));
            getWindow().setStatusBarColor(getResources().getColor(R.color.red));

        }


        progress.setText(score + "/10");
        progress.setTextSize(96.0f);

        ObjectAnimator animation = ObjectAnimator.ofInt(progress, "progress", 0, percentage);
        animation.setDuration(50 * 25);
        animation.setInterpolator(new DecelerateInterpolator());
        animation.start();
    }


}


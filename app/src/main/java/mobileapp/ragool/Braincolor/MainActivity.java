package mobileapp.ragool.Braincolor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends Activity {

    Button btnClassic, btnTime, btnAbout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        btnClassic = (Button) findViewById(R.id.btnClassic);
        btnTime = (Button) findViewById(R.id.btnTime);
        btnAbout = (Button) findViewById(R.id.btnAbout);

        btnClassic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                startActivity(intent);
                overridePendingTransition(R.animator.in,R.animator.out);

                finish();
            }
        });


        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                intent.putExtra("time", true);

                startActivity(intent);
                overridePendingTransition(R.animator.in,R.animator.out);
                finish();
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
                overridePendingTransition(R.animator.in,R.animator.out);
            }
        }
        );
        ImageView spaceshipImage = (ImageView) findViewById(R.id.imgLogo);
        Animation img = AnimationUtils.loadAnimation(this, R.animator.animo2);
        spaceshipImage.startAnimation(img);


    }





}

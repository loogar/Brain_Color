package mobileapp.ragool.Braincolor;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.os.CountDownTimer;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class QuizActivity extends Activity {
    List<Question> quesList;
    int score = 0, quiz = 1, qid, qNum=0, rowCount;
    TextView txtQuestion, txtScore, txtTime;
    Button btnOptA, btnOptB, btnOptC, btnOptD;
    Boolean time = false;
    ImageView imgBack;
    ArrayList<Integer> numbers;


    Question currentQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);



        QuizHelper db = new QuizHelper(this);
        quesList = db.getAllQuestions();
        rowCount = db.getProfilesCount();
        URN();
        qid = numbers.get(qNum);
        currentQ = quesList.get(qid);



        txtQuestion = (TextView) findViewById(R.id.txtQuestion);
        btnOptA = (Button) findViewById(R.id.btnOne);
        btnOptB = (Button) findViewById(R.id.btnTwo);
        btnOptC = (Button) findViewById(R.id.btnThree);
        btnOptD = (Button) findViewById(R.id.btnFour);
        txtScore = (TextView) findViewById(R.id.txtScore);
        txtTime = (TextView) findViewById(R.id.txtTime);
        imgBack = (ImageView) findViewById(R.id.imgBack);

        if(getIntent().hasExtra("time")){
            time = true;
            txtTime.setText("00:01:00");
            CounterClass timer = new CounterClass(60000, 1000);
            timer.start();
        }


        setQuestionView();


        btnOptA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAnswer(btnOptA.getText().toString(), 1);
            }
        });

        btnOptB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAnswer(btnOptB.getText().toString(),2);
            }
        });

        btnOptC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAnswer(btnOptC.getText().toString(),3);

            }
        });

        btnOptD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAnswer(btnOptD.getText().toString(),4);

            }
        });

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizActivity.this, MainActivity.class);

                startActivity(intent);
                overridePendingTransition(R.animator.enter,R.animator.leave);
                finish();
            }
        });

    }

    public void getAnswer(String AnswerString, int i) {
        if (currentQ.getANSWER().equals(AnswerString)) {


            score++;
            txtScore.setText(String.valueOf(score));

            switch(i) {
                case 1:
                    btnOptA.setBackgroundColor(getResources().getColor(R.color.green));
                    break;
                case 2:
                    btnOptB.setBackgroundColor(getResources().getColor(R.color.green));
                    break;
                case 3:
                    btnOptC.setBackgroundColor(getResources().getColor(R.color.green));
                    break;
                case 4:
                    btnOptD.setBackgroundColor(getResources().getColor(R.color.green));
                    break;


            }


        } else {
            switch(i) {
                case 1:
                    btnOptA.setBackgroundColor(getResources().getColor(R.color.red));
                    break;
                case 2:
                    btnOptB.setBackgroundColor(getResources().getColor(R.color.red));
                    break;
                case 3:
                    btnOptC.setBackgroundColor(getResources().getColor(R.color.red));
                    break;
                case 4:
                    btnOptD.setBackgroundColor(getResources().getColor(R.color.red));
                    break;
            }




        }
        if (quiz < 10) {

            currentQ = quesList.get(qid);


            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    setQuestionView();
                    reset();
                }
            },100);
        } else {

            // if over do this
            Intent intent = new Intent(QuizActivity.this,
                    ResultActivity.class);
            Bundle b = new Bundle();
            b.putInt("score", score); // Your score
            if(time) {
                b.putBoolean("time", true);
            }

            intent.putExtras(b);
            startActivity(intent);
            overridePendingTransition(R.animator.in,R.animator.out);
            finish();
        }

        quiz++;
    }

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @SuppressLint("NewApi")
    public class CounterClass extends CountDownTimer {

        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
            // TODO Auto-generated constructor stub
        }

        @Override
        public void onFinish() {
            txtTime.setText("Time is up");
            Intent intent = new Intent(QuizActivity.this,
                    ResultActivity.class);

            Bundle b = new Bundle();
            b.putInt("score", score);
            b.putBoolean("time", true);
            intent.putExtras(b);
            startActivity(intent);
            overridePendingTransition(R.animator.in,R.animator.out);
            finish();
        }

        @Override
        public void onTick(long millisUntilFinished) {

            long millis = millisUntilFinished;
            String hms = String.format(
                    "%02d:%02d:%02d",
                    TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis)
                            - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
                            .toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis)
                            - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
                            .toMinutes(millis)));
            System.out.println(hms);
            txtTime.setText(hms);
        }

    }

    private void setQuestionView() {

        txtQuestion.setText(currentQ.getQUESTION());
        btnOptA.setText(currentQ.getOPTA());
        btnOptB.setText(currentQ.getOPTB());
        btnOptC.setText(currentQ.getOPTC());
        btnOptD.setText(currentQ.getOPTD());

        qNum++;

        qid = numbers.get(qNum);


    }

    public void reset(){
        btnOptA.setBackgroundColor(getResources().getColor(R.color.gray));
        btnOptB.setBackgroundColor(getResources().getColor(R.color.gray));
        btnOptC.setBackgroundColor(getResources().getColor(R.color.gray));
        btnOptD.setBackgroundColor(getResources().getColor(R.color.gray));

    }

    public void URN() {


        ArrayList<Integer> list = new ArrayList<Integer>();
        numbers = new ArrayList<Integer>();
        for (int i=0; i<rowCount; i++) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);
        for (int i=0; i<41; i++) {
            numbers.add(new Integer(list.get(i)));
        }

    }



}
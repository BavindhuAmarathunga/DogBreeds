package com.example.dog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class IdentifyTheDog extends AppCompatActivity {
    String A;
    String breeds [] = {"Boxer","Rottweiler","German Shepherd","Golden Retriver","Labrador Retriver","Doberman","Bull Mastif","Siberian Husky","Leonberg","Flat Coated Retriver"};

    TextView textView;
    TextView message;
    ImageView imageView0;
    ImageView imageView1;
    ImageView imageView2;
    String imgId0;
    String imgId1;
    String imgId2;
    int a;
    int b;
    int c;
    int i;
    Button next;
    String breed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify_the_dog);


        TextView time = (TextView) findViewById(R.id.seconds);
//        if (getIntent().getExtras() != null) {
//            A = getIntent().getStringExtra("name");
//        }
////        assert A != null;
//        if (A.equals("true")){
//            setTimer(10,time);
//        }
        layoutIdentify();
    }
//    public void setTimer( final int sec,final TextView timer){
//
//        new CountDownTimer(sec * 1000+1000, 1000) {
//
//            public void onTick(long millisUntilFinished) {
//                int sec = (int) (millisUntilFinished / 1000);
//                int min = sec / 60;
//                sec = sec % 60;
//                timer.setText(""+(sec-1));
//            }
//
//            public void onFinish() {
//                layoutIdentify();
//
//            }
//        }.start();
//    }
public void layoutIdentify(){
//-----------------------------set type of the breed--------------------------------------------
    Random random = new Random();
//    i =  random.nextInt(5);

    textView =(TextView)findViewById(R.id.textView2);


    message = (TextView)findViewById(R.id.textView5);
    message.setText("");

    next = (Button) findViewById(R.id.button2);



//----------------------------set image in to 1st ImageView--------------------
    imageView0 = (ImageView)findViewById(R.id.imageView);
//    a=random.nextInt(4);
    a = -1+ (int) (Math.random()*(2 - (-1))+1);//********************************************************************************************** 0 -> -1
    breed = breeds[a];
    System.out.println(a);
    textView.setText(breed);
    imgId0 = "n00" + a + random.nextInt(9);
    imageView0.setImageDrawable(getResources().getDrawable(getResID(imgId0, "drawable", getApplicationContext())));



//----------------------------set image in to 2dn ImageView----------------------
    imageView1 = (ImageView)findViewById(R.id.imageView3);
//    b = random.nextInt(4);
    b = 2 +(int) (Math.random()*(5 - 2)) + 1;//************************************************************************************************ 3 -> 2
    imgId1 ="n00" + b + random.nextInt(9);
    imageView1.setImageDrawable(getResources().getDrawable(getResID(imgId1, "drawable", getApplicationContext())));

//------------------------------set image in to 3rd ImageView------------------------------
    imageView2 = (ImageView)findViewById(R.id.imageView4);
//    c = random.nextInt(4);
    c = 5+(int)(Math.random()*(9 - 5)) + 1;
    imgId2 ="n00" + c + random.nextInt(9);
    imageView2.setImageDrawable(getResources().getDrawable(getResID(imgId2, "drawable", getApplicationContext())));

    next.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            layoutIdentify();

        }
    });


}





    public void image1(View v){
        if (a==a){
            message.setText("correct");
            message.setTextColor(Color.GREEN);
        }else {
            message.setText("wrong");
            message.setTextColor(Color.RED);
        }

    }


    public void image2(View view) {
        if (i==b){
            message.setText("correct");
            message.setTextColor(Color.GREEN);
        }else {
            message.setText("wrong");
            message.setTextColor(Color.RED);
        }

    }

    public void image3(View view) {
        if (i==c){
            message.setText("correct");
            message.setTextColor(Color.GREEN);
        }else {
            message.setText("wrong");
            message.setTextColor(Color.RED);
        }
    }

    private int getResID(String Resname, String Res_Type, Context context) {
        int ResID = context.getResources().getIdentifier(Resname, Res_Type, context.getApplicationInfo().packageName);
        if (ResID == 0) {
            throw new IllegalArgumentException("ERRO......!" + Resname);
        } else {
            return ResID;
        }
    }

}

package com.example.dog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

public class IdentifyTheBreed extends AppCompatActivity {
    Random random;
    int b;
    String breed;
    String breeds [] = {"Boxer","Rottweiler","German Shepherd","Golden Retriver","Labrador Retriver","Doberman","Bull Mastif","Siberian Husky","Leonberg","Flat Coated Retriver"};
    TextView textViewAns;
    TextView textViewMsg;
    String A;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify_the_breed);


//        TextView time = (TextView)findViewById(R.id.textView4);

//        if (getIntent().getExtras() != null) {
//            A = getIntent().getStringExtra("name");
//        }
//        assert A != null;
//        if (A.equals("true")){
//            setTimer(10,time);
//        }
        layer();
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
//                layer();
//
//            }
//        }.start();
//    }

    public void layer() {

//------------------------------------------------Select a random image------------------------
        random = new Random();
        b = random.nextInt(9);
        setContentView(R.layout.activity_identify_the_breed);
        ImageView imgage = (ImageView) findViewById(R.id.imageView1);
        breed = "n00" + b + random.nextInt(9);
        imgage.setImageDrawable(getResources().getDrawable(getResID(breed, "drawable", getApplicationContext())));
        System.out.println(breed);

//--------------------------------------spinner---------------------------------------------------
        final Spinner spinner = (Spinner) findViewById(R.id.breeds);                  //dropdown menu of the dog breeds.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.breeds_Name, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        final Button submit = (Button) findViewById(R.id.button_submit);
        submit.setText("submit");
//-----------------------------------------------submit button-----------------------------------
       submit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               if (submit.getText().equals("submit")){
                   String spinner_breed=spinner.getSelectedItem().toString();      //get selected breed from spinnr.
//------------------------------------------------Correct answer----------------------------------
                   if (b == Arrays.asList(breeds).indexOf(spinner_breed)){
                       System.out.println(spinner_breed);
                       textViewAns =(TextView) findViewById(R.id.Answer);
                       textViewMsg = (TextView)findViewById(R.id.msg);

//                  ------------------------Set message text view------------------------
                       textViewMsg.setText("CORRECT");
                       textViewMsg.setTextColor(Color.GREEN);

//                  ---------------------change button text--------------------------
                       submit.setText("next");
//------------------------------------------------wrong answer----------------------------------
                   }else {
                       textViewAns =(TextView) findViewById(R.id.Answer);
                       textViewMsg = (TextView)findViewById(R.id.msg);
//                  ------------------------Set message text view------------------------
                       textViewMsg.setText("WRONG");
                       textViewMsg.setTextColor(Color.RED);
                       textViewAns.setText(" Correct answer : " + breeds[b]);
                       textViewAns.setTextColor(Color.BLUE);

//                  --------------------------Change button text--------------------
                       submit.setText("next");

                   }
               }else {
                   layer();
               }
           }
       });
    }

//------------------------------------Access the resource of images--------------------------------------
    private int getResID(String Resname, String Res_Type, Context context) {
        int ResID = context.getResources().getIdentifier(Resname, Res_Type, context.getApplicationInfo().packageName);
        if (ResID == 0) {
            throw new IllegalArgumentException("ERRO......!" + Resname);
        } else {
            return ResID;
        }
    }
}
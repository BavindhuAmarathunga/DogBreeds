package com.example.dog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public Button button1;
    public Button button2;
    public Button button3;
    public Switch aSwitch;
    public String A;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aSwitch = (Switch)findViewById(R.id.switch1);



        button1 = (Button) findViewById(R.id.identify_the_breeds);              //Identify the breeds button in first layout.
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,IdentifyTheBreed.class);       //button connect to the Identify the breeds layout.
                startActivity(intent);
//                Intent intent = new Intent(this,IdentifyTheBreed.class);
//                if (aSwitch.isChecked())
//                    A = "true";
//                else
//                    A = "false";
//                intent.putExtra("name",A);
//                startActivity(intent);
            }
        });

         button2 = (Button) findViewById(R.id.Identify_the_Dog);                //Identify the dog button in first layout.
         button2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent1 = new Intent(MainActivity.this,IdentifyTheDog.class);
                 startActivity(intent1);
//                 Intent intent = new Intent(this,IdentifyTheDog.class);
//                 if (aSwitch.isChecked())
//                     A = "true";
//                 else
//                     A = "false";
//                 intent1.putExtra("name",A);
//                 startActivity(intent1);
             }
         });

         button3 = (Button) findViewById(R.id.Search_Dog_reeds);                //search dog breeds button in first layout.
         button3.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent2 = new Intent(MainActivity.this,SearchDogBreeds.class);
                 startActivity(intent2);
             }
         });

    }

//    public void breed(View view){
//        Intent intent = new Intent(this,IdentifyTheBreed.class);
//        if (aSwitch.isChecked())
//            A = "true";
//        else
//            A = "false";
//        intent.putExtra("name",A);
//        startActivity(intent);
//    }

//    public void dog(View view){
//        Intent intent = new Intent(this,IdentifyTheDog.class);
//        if (aSwitch.isChecked())
//            A = "true";
//        else
//            A = "false";
//        intent.putExtra("name",A);
//        startActivity(intent);
//    }


}


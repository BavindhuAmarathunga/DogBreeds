package com.example.dog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

public class SearchDogBreeds extends AppCompatActivity {

    String breeds [] = {"Boxer","Rottweiler","German Shepherd","Golden Retriver","Labrador Retriver","Doberman","Bull Mastif","Siberian Husky","Leonberg","Flat Coated Retriver"};


    int breedNo;
    Random random= new Random();
    String search_breed;
    String photo;
    Button search;
    Button stop;
    String breed;
    AutoCompleteTextView  autoCompleteTextView;
    ImageView imageView;
    int name=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_dog_breeds);



        stop = (Button) findViewById(R.id.stop);
        search = (Button) findViewById(R.id.button_search);
        imageView =(ImageView) findViewById(R.id.searchImg);
        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.search_in);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,breeds);
        autoCompleteTextView.setAdapter(adapter);



    }




//    public void searchLayout(){
//
//
//    }


    private int getResID(String ResName, String ResType, Context applicationContext) {
        int ResID = applicationContext.getResources().getIdentifier(ResName, ResType, applicationContext.getApplicationInfo().packageName);
        if (ResID == 0) {
            throw new IllegalArgumentException("ERRO......!" + ResName);
        } else {
            return ResID;
        }
    }
//-------------------------------------search button--------------------------------------
    public void search(View view) {
        name=0;
        keyBoard(this);


            search_breed = autoCompleteTextView.getText().toString();
            System.out.println(search_breed);
            breedNo = Arrays.asList(breeds).indexOf(search_breed);
            System.out.println(breedNo);
//------------------------------slide show of the photos--------------------------------------
            final Handler handler = new Handler();
            final Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    if (name == 0){

//----------------------------------set breed image---------------------------------------

                        handler.postDelayed(this, 5000);
                    breed = "n00" + breedNo + random.nextInt(9);
                    imageView.setImageDrawable(getResources().getDrawable(getResID(breed, "drawable", getApplicationContext())));
                    System.out.println(breed);
                }
                }
            };
            runnable.run();

        System.out.println(search_breed);
    }


    //-----------------------------------stop button---------------------------------
    public void stop(View view) {
        name=1;

//---------------------------------------set breed photo-----------------------------------------
        imageView.setImageDrawable(getResources().getDrawable(getResID(breed, "drawable", getApplicationContext())));
    }
//----------------Close/hide android soft keyboard------------------https://stackoverflow.com/questions/1109022/close-hide-android-soft-keyboard----------------------------
    public static  void  keyBoard(Activity act){
        InputMethodManager Input = (InputMethodManager)act.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View v = act.getCurrentFocus();
        if (v== null){
            v = new View(act);
        }
        Input.hideSoftInputFromWindow(v.getWindowToken(),0);
    }
}

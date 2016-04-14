package com.example.android.alphabetka;

import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.alphabetka.Global;

import java.util.Timer;
import java.util.TimerTask;

public class TestMode extends AppCompatActivity {
    private Global global= new Global();
    private String[] ab;
    private String[] a;
    private String lang;
    private int index = 0;
    private int mistakes = 0;
    private int corrects = 0;
    private boolean delayed = false;
    private TextView tv;
    private TextView mtv;
    private TextView gtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_mode);
        /*Get language */
        lang = this.getIntent().getStringExtra("lang");
        Log.d("Test lang ", lang);
        Init();
    }
    private void Init(){
        tv = (TextView) findViewById(R.id.txtLetter);
        mtv = (TextView) findViewById(R.id.txtMistakes);
        gtv = (TextView) findViewById(R.id.txtGood);
        ab = global.getAlphabet(lang);
        a = global.getAlphabetGolosni(lang);

        setLetter();
        setMistakes();
        setCorrects();
    }
    private void setLetter(){
        tv.setTextColor(ContextCompat.getColor(this, R.color.colorLetter));
        tv.setText(ab[index]);
    }
    private void setMistakes(){
        mtv.setText(getString(R.string.txt_err)+": " +  mistakes);
    }
    private void setCorrects(){
        gtv.setText(getString(R.string.txt_good)+": " +  corrects);
    }

    private void setColorToTextView(boolean isVowel){
        if( isVowel ){
            //tv.setTextColor(R.color.colorAccent);
            tv.setTextColor(ContextCompat.getColor(this, R.color.colorLetterA));
        }else {
            //tv.setTextColor(R.color.colorPrimary);
            tv.setTextColor(ContextCompat.getColor(this, R.color.colorLetterB ));
        };

    }
    private boolean isGolosna(String bukva){
        for(int i = 0; i < a.length; i++){

            if(a[i] == bukva) return true;
        }
        return false;
    }
    public void onBtnBack(View v){
        this.finish();
    }
    public void onBtnA(View v){
        if(!delayed){
            if( isGolosna(ab[index])) {
                corrects +=1;
                setCorrects();
                setColorToTextView(true);
                nextLetter();
            }else {
                mistakes +=1;
                setMistakes();
            }
        }

    }
    public void onBtnB(View v){
        if(!delayed) {
            if (!isGolosna(ab[index])) {
                corrects += 1;
                setCorrects();
                setColorToTextView(false);
                nextLetter();
            } else {
                mistakes += 1;
                setMistakes();
            }
        }
    }
    private void nextLetter(){
        index = index + 1;
        if(index >= ab.length){
            //index = 0;
            delayed = true;
            Toast.makeText(this,getString(R.string.toastTestEnd), Toast.LENGTH_LONG).show();
        }
        else {
            delayed = true;
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    delayed = false;
                    setLetter();
                    }
            }, 1000); // 2000ms delay
        }
    }



    @Override
    protected void onSaveInstanceState(Bundle outState){
        outState.putInt("index", index);
        outState.putInt("mistakes", mistakes);
        outState.putInt("corrects", corrects);

        super.onSaveInstanceState(outState);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstance){
        index = savedInstance.getInt("index", 0);
        mistakes = savedInstance.getInt("mistakes", 0);
        corrects = savedInstance.getInt("corrects", 0);
        setLetter();

        super.onRestoreInstanceState(savedInstance);
    }

}

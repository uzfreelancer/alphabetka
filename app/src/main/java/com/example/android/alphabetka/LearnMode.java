package com.example.android.alphabetka;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.android.alphabetka.Global;

public class LearnMode extends AppCompatActivity {
    private Global global= new Global();
    private String lang = "en";
    private String[] ab;
    private String[] a;
    private int index = 0;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_mode);
        /* get Language */
        lang = getIntent().getStringExtra("lang");
        Log.d("Learn Mode lang ", lang);
        Init();
    }
    private void Init(){
        tv = (TextView) findViewById(R.id.txtLetter);
        /* Get data according lang */
        ab = global.getAlphabet(lang);
        a = global.getAlphabetGolosni(lang);
        setLetter();
    }
    /* Show letter */
    private void setLetter(){
        tv.setText(ab[index]);
        setColorToTextView();
    }
    /* set Color to current letter */
    private void setColorToTextView(){
        if( isGolosna(ab[index]) ){
            //tv.setTextColor(R.color.colorAccent);
            tv.setTextColor(ContextCompat.getColor(this, R.color.colorLetterA ));
        }else {
            //tv.setTextColor(R.color.colorPrimary);
            tv.setTextColor(ContextCompat.getColor(this, R.color.colorLetterB ));
        };

    }
    /* Help function to define letter type */
    private boolean isGolosna(String bukva){
        for(int i = 0; i < a.length; i++){

            if(a[i] == bukva) return true;
        }
        return false;
    }
    /* Back to main View */
    public void onBtnBack(View v){
        this.finish();
    }
    public void onBtnNext(View v){
        index = index + 1;
        if(index >= ab.length){ index = 0;};
        setLetter();
    }
    /* Function to save and restore settings when  changes orientation */
    @Override
    protected void onSaveInstanceState(Bundle outState){
        outState.putInt("index", index);
        super.onSaveInstanceState(outState);
     }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstance){
        index = savedInstance.getInt("index", 0);
        setLetter();
        super.onRestoreInstanceState(savedInstance);
    }

}

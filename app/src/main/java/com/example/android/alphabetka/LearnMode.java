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
        lang = getIntent().getStringExtra("lang");
        Log.e("Learn Mode lang ", lang);
        Init();
    }
    private void Init(){
        tv = (TextView) findViewById(R.id.txtLetter);
        ab = global.getAlphabet(lang);
        a = global.getAlphabetGolosni(lang);
        //index = global.index;
        setLetter();
    }
    private void setLetter(){
        tv.setText(ab[index]);
        setColorToTextView();
    }
    private void setColorToTextView(){
        if( isGolosna(ab[index]) ){
            //tv.setTextColor(R.color.colorAccent);
            tv.setTextColor(ContextCompat.getColor(this, R.color.colorLetterA ));
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
    public void onBtnNext(View v){
        index = index + 1;
        if(index >= ab.length){ index = 0;};
        //Log.e("LearnMode", ab[index]);
        //Log.e("Lang ", global.getLang());
        setLetter();
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        outState.putInt("index", index);
        //Log.e("put index ", ""+index);
        super.onSaveInstanceState(outState);
     }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstance){
        index = savedInstance.getInt("index", 0);
        setLetter();
        //Log.e("Exract Index ", ""+index);
        super.onRestoreInstanceState(savedInstance);
    }

}

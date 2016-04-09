package com.example.android.alphabetka;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public String lang = "en";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Log.e("Try to get lang ", this.getIntent().getStringExtra("lang"));

        String  confLang = this.getResources().getConfiguration().locale.getLanguage();
        Log.e("Sytem language", confLang);
        if("ua".equals(confLang)) lang ="ua";
        if("en".equals(confLang)) lang ="en";

        Button be = (Button) findViewById(R.id.btnExam);
        be.setVisibility(View.INVISIBLE);
    }
    /*    * Call "Learn mode"    */
    public void onBtnLearn(View v){
        //Toast.makeText(MainActivity.this, "Алфавіт. Голосні/приголосні", Toast.LENGTH_SHORT).show();
        Intent learn = new Intent(this, LearnMode.class);
        learn.putExtra("lang", lang);
        startActivity(learn);
    }
    /*    * Call "Test mode"    */
    public void onBtnTest(View v){
        Toast.makeText(MainActivity.this, getString(R.string.toastTest), 3000).show();
        Intent test = new Intent(this, TestMode.class);
        test.putExtra("lang", lang);
        startActivity(test);
    }
    /*    * Call "Exam mode"    */
    public void onBtnExam(View v){
        Toast.makeText(MainActivity.this, "Розмалювати абетку", Toast.LENGTH_SHORT).show();
    }


    /*    * Change language    */
    public void onBtnLang(View v){

        if("en".equals(lang)) {
            lang = "ua";
        } else
        {
            lang="en";
//            if(lang == "ua") {
//                lang = "ru";
//            } else {
//                if (lang == "ru") {
//                    lang == "en";
//                }
//            }
        };

        Toast.makeText(MainActivity.this, "Мова міняється на "+ lang, Toast.LENGTH_SHORT).show();

        Resources res = this.getResources();
        // Change locale settings in the app.
        DisplayMetrics dm = res.getDisplayMetrics();
        android.content.res.Configuration conf = res.getConfiguration();
        conf.locale = new Locale(lang);
        //conf.locale = new Locale(language_code.toLowerCase());
        res.updateConfiguration(conf, dm);
        Log.e("Current language ", conf.locale.getLanguage());

        //conf.locale.setDefault(new Locale("US"));
        //res.updateConfiguration(conf, dm);
//        Intent refresh = new Intent(this, MainActivity.class);
//        //refresh.putExtra("lang", lang);
//        finish();
//        startActivity(refresh);
    }

}

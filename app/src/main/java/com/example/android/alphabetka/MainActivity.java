package com.example.android.alphabetka;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.content.res.Configuration;
import android.preference.PreferenceManager;
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
        lang = getCurrentLocale();
        applyLocale(lang);
        setContentView(R.layout.activity_main);

        Log.d("System language", lang);

        Button be = (Button) findViewById(R.id.btnExam);
        be.setVisibility(View.INVISIBLE);
    }
    private void setLocale(String locale)
    {
        lang = locale;
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        preferences.edit().putString("LOCALE", locale).apply();
    }
    private String getCurrentLocale()
    {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        return  preferences.getString("LOCALE","en");
    }
    private void applyLocale(String lang)
    {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());
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
        String newLang = "";
        newLang =  "en".equals(lang)? "uk" :"en";
        setLocale(newLang);

        Intent intent = new Intent(this, MainActivity.class);
        finish();
        startActivity(intent);
    }

}

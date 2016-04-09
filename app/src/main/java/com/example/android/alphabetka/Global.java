package com.example.android.alphabetka;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.Toast;

import java.util.Locale;

/**
 * Created by mr_freelancer on 28.03.2016.
 */
public class Global {
    private String[] ua_ab ={"а","б","в","г","д","е","є","ж","з","и","і","ї","Й","к","л","м","н","о","п","р","с","т","у","ф","х","ц","ч","ш","щ","ь","ю"
,"я"};
    private String[] ua_a ={"а","е","є","и","і","ї","о","у","ю","я"};
    public int index = 0;
    private String[] en_ab ={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    private String[] en_a ={"a","e","i","o","u","y"};

     public String[] getAlphabet(String lang){
        String[] ab = {};
        if("ua".equals(lang)) { ab = ua_ab;};
        if("en".equals(lang)) { ab = en_ab;};
        return ab;
    }
    public String[] getAlphabetGolosni(String lang){
        //String[] a = {};
        if("ua".equals(lang)) { return ua_a;};
        return en_a;
    }
}

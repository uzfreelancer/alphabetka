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
    private String[] ru_ab ={"а","б","в","г","д","е","ё","ж","з","и","Й","к","л","м","н","о","п","р","с","т","у","ф","х","ц","ч","ш","щ","ь","ы","ъ,","э","ю"
,"я"};
    private String[] ru_a ={"а","е","ё","и","о","у","ы","э","ю","я"};
    private String[] en_ab ={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    private String[] en_a ={"a","e","i","o","u","y"};

     public String[] getAlphabet(String lang){
        if("uk".equals(lang)) { return ua_ab;};
        if("ru".equals(lang)) { return ru_ab;};
        return en_ab;
    }
    public String[] getAlphabetGolosni(String lang){
        if("uk".equals(lang)) { return ua_a;};
        if("ru".equals(lang)) { return ru_a;};
        return en_a;
    }
}

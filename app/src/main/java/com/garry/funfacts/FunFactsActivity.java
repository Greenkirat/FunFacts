package com.garry.funfacts;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
public class FunFactsActivity extends Activity {
    public static final String TAG = FunFactsActivity.class.getSimpleName();
    private static final String KEY_VALUE = "Key_Value";
    private static final String  KEY_COLOR ="Key_Color" ;
    private TextView factlabel;
    private Button showfactbutton;
    private   RelativeLayout  rfact;
    private factBook mfactBook = new factBook();
    private colorwheel mColorwheel = new colorwheel();
    private String mFact=mfactBook.mfacts[0];
    private int mColor= Color.parseColor(mColorwheel.mColor[8]);


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_VALUE, mFact);
        outState.putInt(KEY_COLOR, mColor);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

       mFact= savedInstanceState.getString(KEY_VALUE);
        factlabel.setText(mFact);

        mColor=savedInstanceState.getInt(KEY_COLOR);

         rfact.setBackgroundColor(mColor);
        showfactbutton.setTextColor(mColor);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);
        // declare view variables and views from layout file
         factlabel = (TextView) findViewById(R.id.textView);
          showfactbutton = (Button) findViewById(R.id.button);
         rfact = (RelativeLayout) findViewById(R.id.relative);


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 mFact = mfactBook.getFact();
                 factlabel.setText(mFact);


                mColor = mColorwheel.getColor();

                rfact.setBackgroundColor(mColor);
                showfactbutton.setTextColor(mColor);



            }
        };
        showfactbutton.setOnClickListener(listener);
       /* String msg  = " yay!activity is created";
        Toast welcometoast = Toast.makeText(this, msg,Toast.LENGTH_LONG);
        welcometoast.show();*/
        Log.d(TAG,"LOG ON THROUGH ONcREATE()METHOD");
    }

    }



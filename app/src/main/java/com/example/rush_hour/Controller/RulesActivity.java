package com.example.rush_hour.Controller;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rush_hour.R;

public class RulesActivity extends AppCompatActivity {

    //Attributes
    private Button goBack;

    /**
     * OnCreate method which setup the entire Activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

        bindUI();
        setListeners();
    }

    /**
     * Method which make the link between user interface and code
     */
    private void bindUI(){
        goBack = findViewById(R.id.goBack);
    }

    /**
     * Method which set up all listeners
     */
    private void setListeners() {

        //Method which go on the main activity
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

}

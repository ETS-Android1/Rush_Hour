package com.example.rush_hour.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.rush_hour.Model.Player;
import com.example.rush_hour.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Attributes in Layout
    private TextView playerName;
    private Button play;
    private Button rules;
    private Button scores;

    //Player
    public static Player player;

    //Firebase
    public FirebaseAuth firebaseAuth;
    public FirebaseUser firebaseUser;

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
        setContentView(R.layout.activity_main);

        bindUI();
        firebaseAuthentification();
        setListeners();

    }

    /**
     * Method which make the link between user interface and code
     */
    private void bindUI(){
        playerName = findViewById(R.id.playerName);
        play = findViewById(R.id.play);
        rules = findViewById(R.id.rules);
        scores = findViewById(R.id.scores);
    }

    /**
     * Method which set up all listeners
     */
    public void setListeners(){

        //Method which go on the second activity where the player can see all levels
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intention = new Intent(MainActivity.this, LevelListActivity.class);
                startActivity(intention);
            }
        });

        //Method which enable the player to see the rules of the game
        rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intention = new Intent(MainActivity.this, RulesActivity.class);
                startActivity(intention);
            }
        });

        //Method which enable the player to see the scores of other players
        scores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intention = new Intent(MainActivity.this, ScoresActivity.class);
                startActivity(intention);
            }
        });

    }

    /**
     * Override method relesaed when the user touch the android back
     */
    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }

    /**
     * Method which enable the player to connect with Google on the first time he launch the app
     */
    private void firebaseAuthentification(){
        //User
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        //If user don't exists, lauch the google connect Activity
        if(firebaseUser == null){
            startActivity(new Intent(this, SignInActivity.class));
            finish();
            return;
        }
        //Set up the view with player's google nickname
        else {
            playerName.setText(playerName.getText() + firebaseUser.getDisplayName());
            player = new Player(firebaseUser.getDisplayName(), 0);
        }
    }
}
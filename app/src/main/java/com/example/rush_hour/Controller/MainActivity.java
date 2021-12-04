package com.example.rush_hour.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rush_hour.Model.Player;
import com.example.rush_hour.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    //Attributes in Layout
    private TextView playerName;
    private Button play;
    private Button rules;
    private Button scores;

    public static Player player;

    //Firebase
    public FirebaseAuth firebaseAuth;
    public FirebaseUser firebaseUser;

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

    private void bindUI(){
        playerName = findViewById(R.id.playerName);
        play = findViewById(R.id.play);
        rules = findViewById(R.id.rules);
        scores = findViewById(R.id.scores);

        if(MainActivity.player != null){
            playerName.setText(MainActivity.player.getName());
        }
    }

    //Method which set all listeners
    public void setListeners(){

        //Method which go on the second activity where the player can see all levels
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Check if the player has a name
                if(playerName.getText() != null && !playerName.getText().toString().trim().equals("")){

                    player = new Player(playerName.getText().toString(), 0);

                    Intent intention = new Intent(MainActivity.this, LevelListActivity.class);
                    startActivity(intention);
                }

                else {
                    Toast.makeText(getApplicationContext(), "Rentrez un pseudo !", Toast.LENGTH_SHORT).show();
                }
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

    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }

    //Ask the user to connect with google
    private void firebaseAuthentification(){
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        if(firebaseUser == null){
            startActivity(new Intent(this, SignInActivity.class));
            finish();
            return;
        } else {
            playerName.setText(playerName.getText() + firebaseUser.getDisplayName());
        }
    }
}
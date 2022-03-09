package com.example.rush_hour.Controller;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.rush_hour.Model.LevelGenerator;
import com.example.rush_hour.Model.Orientation;

import com.example.rush_hour.Model.Vehicle;
import com.example.rush_hour.R;
import com.firebase.ui.database.SnapshotParser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.example.rush_hour.Model.Player;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class CurrentLevel extends AppCompatActivity{

    //Attributes
    private ImageView star1, star2, star3;
    private TextView victory;
    private TextView name_level;
    private Button goBackButton;

    //Screen Size
    public static int SCREEN_WIDTH;

    //Timer
    private Chronometer timer;

    //Music
    private MusicManager musicFond;
    private MusicManager musicKlaxon;

    //Constraint
    private ConstraintLayout constraint;

    //Level Generator
    private LevelGenerator lvlGenerator;

    //Firebase
    private boolean isFound = false;
    private DataSnapshot firebaseDs;
    private FirebaseDatabase db = FirebaseDatabase.getInstance("https://rush-hour-9cbef-default-rtdb.europe-west1.firebasedatabase.app/");
    private DatabaseReference myRef = db.getReference();

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
        setContentView(R.layout.activity_currentlevel);

        bindUI();
        callMethodWithExtra();
        setMusicAndTimer();
        setListeners();
    }

    /**
     * Method which set up the timer (for the level) and the music
     */
    private void setMusicAndTimer(){
        musicFond = new MusicManager(this);
        musicFond.start();

        musicKlaxon = new MusicManager(this);
        musicKlaxon.playKlaxon();

        timer.setBase(SystemClock.elapsedRealtime());
        timer.start();
    }

    /**
     * Method which make the link between user interface and code
     */
    private void bindUI(){
        victory = findViewById(R.id.victory);
        timer = findViewById(R.id.timer);
        name_level = findViewById(R.id.name_level);
        star1 = findViewById(R.id.star1);
        star2 = findViewById(R.id.star2);
        star3 = findViewById(R.id.star3);
        goBackButton = findViewById(R.id.goBackButton);
        constraint = findViewById(R.id.constraint);
        name_level.setText(getIntent().getStringExtra("Name of the level").replace("\n", " "));
        goBackButton.setVisibility(View.GONE);
    }

    /**
     * Method which invoke the right level in terms of the button the user clicked on
     */
    private void callMethodWithExtra(){

        //Init the levelGenerator
        lvlGenerator = new LevelGenerator(this);
        Method method = null;

        //Try to have the right method thanks to the extra puted in the intent
        try {
            method = lvlGenerator.getClass().getMethod(getIntent().getStringExtra("Name of the level").replace("\n", "").toLowerCase());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        //Invoke the method on the levelGenerator
        try {
            method.invoke(lvlGenerator);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method which set up all listeners
     */
    public void setListeners(){

        //Enable the level's cars to move on onTouch event
        for (Vehicle car: lvlGenerator.getLvl().getListOfVehicle()) {
            move(car);
        }

        //Try to have the width of the screen when the layout has loaded
        constraint.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                constraint.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                SCREEN_WIDTH = constraint.getWidth();
            }
        });

        //Add a listener to my database to find if player's name is already in the database
        myRef.child("scoresDesJoueurs").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                List<String> list = new ArrayList<>();
                for(DataSnapshot ds : snapshot.getChildren()){

                    //Put all player into a list
                    String uid = ds.child("name").getValue().toString();
                    list.add(uid);

                    //If the player has been found, we memorized the snapshot
                    if(MainActivity.player.getName().compareTo(uid) == 0) {
                        isFound = true;
                        firebaseDs = ds;
                    }
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });

        //Method which go on the level list activity
        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intention = new Intent(CurrentLevel.this, LevelListActivity.class);
                startActivity(intention);
            }
        });

    }

    /**
     * Method which remove the listener on a vehicle on onTouch event
     * @param vehicle The vehicle to remove the listener on
     */
    private void removeMove(Vehicle vehicle){
        vehicle.getImg().setOnTouchListener(null);
    }

    /**
     * Methhod which enable a vehicle to move on the screen
     * @param vehicle The vehicle to set the listener on
     */
    @SuppressLint("ClickableViewAccessibility")
    private void move(Vehicle vehicle) {

        //Get the ImageView from the vehicle
        ImageView tmp = vehicle.getImg();

        //Set up the onTouch listener
        vehicle.getImg().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {

                switch(event.getAction()) {

                    case MotionEvent.ACTION_DOWN:

                            if (vehicle.getOrientation() == Orientation.VERTICALE) {
                                if (event.getY() < (tmp.getHeight() / 2)) {
                                    if (vehicle.canMoveUp() && lvlGenerator.getLvl().canMoveUp(vehicle)) {
                                        vehicle.moveUp();
                                        tmp.setY(tmp.getY() - (SCREEN_WIDTH / 6));
                                    } else {
                                        musicKlaxon.start();
                                    }
                                }

                                if (event.getY() > (tmp.getHeight() / 2)) {
                                    if (vehicle.canMoveDown() && lvlGenerator.getLvl().canMoveDown(vehicle)) {
                                        vehicle.moveDown();
                                        tmp.setY(tmp.getY() + (SCREEN_WIDTH / 6));
                                    } else {
                                        musicKlaxon.start();
                                    }
                                }
                            } else {
                                if (event.getX() < (tmp.getWidth() / 2)) {
                                    if (vehicle.canMoveLeft() && lvlGenerator.getLvl().canMoveLeft(vehicle)) {
                                        vehicle.moveLeft();
                                        tmp.setX(tmp.getX() - (SCREEN_WIDTH / 6));
                                    } else {
                                        musicKlaxon.start();
                                    }
                                }

                                if (event.getX() > (tmp.getWidth() / 2)) {
                                    if (vehicle.canMoveRight() && lvlGenerator.getLvl().canMoveRight(vehicle)) {
                                        vehicle.moveRight();
                                        tmp.setX(tmp.getX() + (SCREEN_WIDTH / 6));
                                    } else {
                                        musicKlaxon.start();
                                    }
                                }
                            }
                        break;
                }

                //If the player has succeed
                if(lvlGenerator.getLvl().hasWon()){

                    //We remove all move listener
                    for (Vehicle car: lvlGenerator.getLvl().getListOfVehicle()) {
                        removeMove(car);
                    }

                    //Make the button visible
                    goBackButton.setVisibility(View.VISIBLE);

                    //Stop Timer & Music
                    timer.stop();
                    musicFond.stop();
                    musicKlaxon.stop();

                    //Set up a victory message
                    victory.setText("Victoire en " + timer.getText());

                    setStars();
                    printIntoDataBase();

                }
                return true;
            }
        });
    }

    /**
     * Method which set the right number of stars compared to the time the player has spent to finish the level
     */
    public void setStars(){

        //Get the current time of the timer et transform it in milliseconds
        long elapsedMillis = SystemClock.elapsedRealtime() - timer.getBase();
        Integer stars = 0;

        //The player has won 3 stars
        if(elapsedMillis <= 30000){

            star1.setImageResource(R.drawable.full_star);
            star2.setImageResource(R.drawable.full_star);
            star3.setImageResource(R.drawable.full_star);
            stars = 3;

        }

        //The player has won 2 stars
        else if(elapsedMillis <= 300000){

            star1.setImageResource(R.drawable.full_star);
            star2.setImageResource(R.drawable.full_star);
            star3.setImageResource(R.drawable.empty_star);
            stars = 2;

        }

        //The player has won 1 star
        else {

            star1.setImageResource(R.drawable.full_star);
            star2.setImageResource(R.drawable.empty_star);
            star3.setImageResource(R.drawable.empty_star);
            stars = 1;

        }

        //Change player scores list
        MainActivity.player.changeElement(lvlGenerator.getLvl().getNumber() - 1, stars);
    }

    /**
     * Method which pauses all music when app is paused
     */
    @Override
    protected void onPause() {
        super.onPause();
        musicFond.pause();
        musicKlaxon.pause();
    }

    /**
     * Method which start the music when app is resumed
     */
    @Override
    protected void onResume() {
        super.onResume();
        musicFond.start();
    }

    /**
     * Method which print into database the player's score
     */
    private void printIntoDataBase(){

        SnapshotParser<Player> parser = new SnapshotParser<Player>() {
            @Override
            public Player parseSnapshot(DataSnapshot dataSnapshot) {
                Player p = dataSnapshot.getValue(Player.class);

                if(p != null){
                    p.setId(dataSnapshot.getKey());
                }

                return p;
            }
        };

        if(!isFound) {
            myRef.child("scoresDesJoueurs").push().setValue(MainActivity.player);
        } else {
            myRef.child("scoresDesJoueurs").child(firebaseDs.getKey()).child("name").setValue(MainActivity.player.getName());

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                myRef.child("scoresDesJoueurs").child(firebaseDs.getKey()).child("numberStars").setValue(MainActivity.player.getNumberStars());
                myRef.child("scoresDesJoueurs").child(firebaseDs.getKey()).child("reverse").setValue(MainActivity.player.getReverse());
                myRef.child("scoresDesJoueurs").child(firebaseDs.getKey()).child("scoresList").setValue(MainActivity.player.getScoresList());
            }
        }
    }
}

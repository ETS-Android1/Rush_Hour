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
    Chronometer timer;

    //Music
    MusicManager musicFond;
    MusicManager musicKlaxon;

    //Constraint
    ConstraintLayout constraint;

    //Level Generator
    LevelGenerator lvlGenerator;

    //Firebase
    boolean isFound = false;
    DataSnapshot firebaseDs;
    FirebaseDatabase db = FirebaseDatabase.getInstance("https://rush-hour-9cbef-default-rtdb.europe-west1.firebasedatabase.app/");
    DatabaseReference myRef = db.getReference();

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

    private void setMusicAndTimer(){
        musicFond = new MusicManager(this);
        musicFond.start();

        musicKlaxon = new MusicManager(this);
        musicKlaxon.playKlaxon();

        timer.setBase(SystemClock.elapsedRealtime());
        timer.start();
    }

    private void bindUI(){
        victory = findViewById(R.id.victory);
        timer = findViewById(R.id.timer);
        name_level = findViewById(R.id.name_level);
        star1 = findViewById(R.id.star1);
        star2 = findViewById(R.id.star2);
        star3 = findViewById(R.id.star3);
        goBackButton = (Button) findViewById(R.id.goBackButton);
        constraint = findViewById(R.id.constraint);
        name_level.setText(getIntent().getStringExtra("Name of the level"));
        goBackButton.setVisibility(View.GONE);
    }

    private void callMethodWithExtra(){
        lvlGenerator = new LevelGenerator(this);

        Method method = null;

        try {
            method = lvlGenerator.getClass().getMethod(getIntent().getStringExtra("Name of the level"));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            method.invoke(lvlGenerator);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    //Method which set all listeners
    public void setListeners(){

        for (Vehicle car: lvlGenerator.getLvl().getListOfVehicle()) {
            move(car);
        }

        constraint.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                constraint.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                SCREEN_WIDTH = constraint.getWidth();
            }
        });

        myRef.child("scoresDesJoueurs").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                List<String> list = new ArrayList<>();
                for(DataSnapshot ds : snapshot.getChildren()){
                    String uid = ds.child("name").getValue().toString();
                    list.add(uid);

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

        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intention = new Intent(CurrentLevel.this, LevelListActivity.class);
                startActivity(intention);
            }
        });

    }

    private void removeMove(Vehicle vehicle){
        vehicle.getImg().setOnTouchListener(null);
    }

    @SuppressLint("ClickableViewAccessibility")
    private void move(Vehicle vehicle) {

        ImageView tmp = vehicle.getImg();

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

                if(lvlGenerator.getLvl().hasWon()){

                    for (Vehicle car: lvlGenerator.getLvl().getListOfVehicle()) {
                        removeMove(car);
                    }

                    goBackButton.setVisibility(View.VISIBLE);

                    timer.stop();
                    musicFond.stop();
                    musicKlaxon.stop();

                    victory.setText("Victoire en " + timer.getText());

                    setStars();

                    printIntoDataBase();

                }
                return true;
            }
        });
    }

    public void setStars(){
        long elapsedMillis = SystemClock.elapsedRealtime() - timer.getBase();

        if(elapsedMillis <= 30000){

            star1.setImageResource(R.drawable.full_star);
            star2.setImageResource(R.drawable.full_star);
            star3.setImageResource(R.drawable.full_star);
            MainActivity.player.setNumberStars(MainActivity.player.getNumberStars() + 3);

        } else if(elapsedMillis <= 300000){

            star1.setImageResource(R.drawable.full_star);
            star2.setImageResource(R.drawable.full_star);
            star3.setImageResource(R.drawable.empty_star);
            MainActivity.player.setNumberStars(MainActivity.player.getNumberStars() + 2);

        } else {

            star1.setImageResource(R.drawable.full_star);
            star2.setImageResource(R.drawable.empty_star);
            star3.setImageResource(R.drawable.empty_star);
            MainActivity.player.setNumberStars(MainActivity.player.getNumberStars() + 1);

        }
    }

    //Ovverride method
    @Override
    protected void onPause() {
        super.onPause();
        musicFond.pause();
        musicKlaxon.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        musicFond.start();
    }

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
            Player player = new Player(MainActivity.player.getName(), MainActivity.player.getNumberStars());
            myRef.child("scoresDesJoueurs").push().setValue(player);
        } else {
            myRef.child("scoresDesJoueurs").child(firebaseDs.getKey()).child("name").setValue(MainActivity.player.getName());

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                myRef.child("scoresDesJoueurs").child(firebaseDs.getKey()).child("numberStars").setValue(
                        Math.toIntExact((Long) firebaseDs.child("numberStars").getValue()) + MainActivity.player.getNumberStars());
                myRef.child("scoresDesJoueurs").child(firebaseDs.getKey()).child("reverse").setValue(
                        Math.toIntExact((Long) firebaseDs.child("reverse").getValue()) + MainActivity.player.getReverse());
            }
        }

        //Reset du nombre d'étoiles du joueur
        MainActivity.player.setNumberStars(0);
    }
}

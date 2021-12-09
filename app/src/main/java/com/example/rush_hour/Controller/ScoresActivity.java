package com.example.rush_hour.Controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rush_hour.Model.Player;
import com.example.rush_hour.Model.ScoreViewHolder;
import com.example.rush_hour.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.database.SnapshotParser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class ScoresActivity extends AppCompatActivity {

    //Attributes in Layout
    private RecyclerView scoresRecyclerView;
    private LinearLayoutManager scoresLinearLayoutManager;
    private Button back;

    //Firebase
    public FirebaseRecyclerAdapter<Player, ScoreViewHolder> firebaseAdapter;
    public DatabaseReference databaseReference;

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
        setContentView(R.layout.activity_scores);

        bindUI();
        setListeners();
        initRecyclerView();
        connectToFirebase();
    }

    /**
     * Method which make the link between user interface and code
     */
    private void bindUI(){
        scoresRecyclerView = findViewById(R.id.scoresRecyclerView);
        back = findViewById(R.id.back);
    }

    /**
     * Method which init the recyclerView with the layoutManager
     */
    private void initRecyclerView(){
        scoresLinearLayoutManager = new LinearLayoutManager(this);
        scoresRecyclerView.setLayoutManager(scoresLinearLayoutManager);
    }

    /**
     * Method which set up all listeners
     */
    private void setListeners(){

        //Method which go on the main activity
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    /**
     * Method which connect to Firebase and setup the recycler View with Firebase data
     */
    private void connectToFirebase(){

        databaseReference = FirebaseDatabase.getInstance("https://rush-hour-9cbef-default-rtdb.europe-west1.firebasedatabase.app/").getReference();

        //Parser of player
        SnapshotParser<Player> parser = new SnapshotParser<Player>() {
            @NonNull
            @Override
            public Player parseSnapshot(@NonNull DataSnapshot dataSnapshot) {
                Player p = dataSnapshot.getValue(Player.class);

                if(p != null){
                    p.setId(dataSnapshot.getKey());
                }

                return p;
            }
        };

        //Set query to recover all data
        FirebaseRecyclerOptions<Player> options = new FirebaseRecyclerOptions.Builder<Player>().
                setQuery(databaseReference.child("scoresDesJoueurs").orderByChild("reverse").limitToFirst(50), parser).build();

        //Set up recycler view with Firebase Scores
        firebaseAdapter = new FirebaseRecyclerAdapter<Player, ScoreViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull ScoreViewHolder scoreViewHolder, int position, @NonNull Player player) {
                scoreViewHolder.getScore_pseudo().setText(player.getName());
                scoreViewHolder.getScore_numberStar().setText((player.getNumberStars() + ""));
            }

            @NonNull
            @Override
            public ScoreViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
                LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
                return new ScoreViewHolder(inflater.inflate(R.layout.score_item, viewGroup, false));
            }
        };

        //Set the adapter to the recyclerView
        scoresRecyclerView.setAdapter(firebaseAdapter);

    }

    /**
     * Method which stop the listener when the app is paused
     */
    @Override
    public void onPause(){
        firebaseAdapter.stopListening();
        super.onPause();
    }

    /**
     *Method which start the listener when the app is resumed
     */
    @Override
    public void onResume(){
        super.onResume();
        firebaseAdapter.startListening();
    }

}

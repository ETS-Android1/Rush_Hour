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

    private RecyclerView scoresRecyclerView;
    private LinearLayoutManager scoresLinearLayoutManager;
    private Button back;

    public FirebaseRecyclerAdapter<Player, ScoreViewHolder> firebaseAdapter;
    public DatabaseReference databaseReference;

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

    private void bindUI(){
        scoresRecyclerView = findViewById(R.id.scoresRecyclerView);
        back = findViewById(R.id.back);
    }

    private void initRecyclerView(){
        scoresLinearLayoutManager = new LinearLayoutManager(this);
        scoresRecyclerView.setLayoutManager(scoresLinearLayoutManager);
    }

    private void setListeners(){
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void connectToFirebase(){

        databaseReference = FirebaseDatabase.getInstance("https://rush-hour-9cbef-default-rtdb.europe-west1.firebasedatabase.app/").getReference();

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

        FirebaseRecyclerOptions<Player> options = new FirebaseRecyclerOptions.Builder<Player>().
                setQuery(databaseReference.child("scoresDesJoueurs").orderByChild("numberStars").limitToFirst(50), parser).build();

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

        scoresRecyclerView.setAdapter(firebaseAdapter);

    }

    //Override Methods
    @Override
    public void onPause(){
        firebaseAdapter.stopListening();
        super.onPause();
    }

    @Override
    public void onResume(){
        super.onResume();
        firebaseAdapter.startListening();
    }

}

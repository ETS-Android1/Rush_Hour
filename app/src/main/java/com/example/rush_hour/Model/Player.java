package com.example.rush_hour.Model;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Player {

    //Attributes
    private String name;
    private int numberStars;
    private int reverse;
    private List<Integer> scoresList;
    private String id;

    //Constructor
    public Player (String name, int numberStars){
        this.name = name;
        this.numberStars = numberStars;
        this.reverse = -numberStars;
        scoresList = new ArrayList<>();
        initScoresList();
    }

    private void initScoresList(){
        for(int i = 0; i < 40; i++){
            scoresList.add(0);
        }
    }

    public void changeElement(int index, Integer value){
        scoresList.set(index, value);
    }

    //Default constructor
    public Player(){
        super();
    }

    //Getters
    public String getName() {
        return name;
    }

    public int getNumberStars(){

        Integer totalStars = 0;

        for (Integer stars : scoresList){
            totalStars += stars;
        }

        numberStars = totalStars;
        reverse = -totalStars;
        return numberStars;
    }

    public int getReverse(){
        return reverse;
    }

    public String getId() {
        return id;
    }

    public List<Integer> getScoresList(){
        return scoresList;
    }

    //Setters
    public void setId(String id){
        this.id = id;
    }

}

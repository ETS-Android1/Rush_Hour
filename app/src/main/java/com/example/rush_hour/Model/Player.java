package com.example.rush_hour.Model;

public class Player {

    //Attributes
    private String name;
    private int numberStars;
    private String id;

    //Constructor
    public Player (String name, int numberStars){
        this.name = name;
        this.numberStars = numberStars;
    }

    public Player(){
        super();
    }

    //Getters
    public String getName() {
        return name;
    }

    public int getNumberStars(){
        return numberStars;
    }

    public String getId() {
        return id;
    }

    //Setters
    public void setNumberStars(int numberStars){
        this.numberStars = numberStars;
    }

    public void setId(String id){
        this.id = id;
    }

}

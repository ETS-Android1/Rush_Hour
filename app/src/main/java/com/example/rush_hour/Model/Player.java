package com.example.rush_hour.Model;

public class Player {

    //Attributes
    private String name;
    private int numberStars;
    private int reverse;
    private String id;

    //Constructor
    public Player (String name, int numberStars){
        this.name = name;
        this.numberStars = numberStars;
        this.reverse = -numberStars;
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
        return numberStars;
    }

    public int getReverse(){
        return reverse;
    }

    public String getId() {
        return id;
    }

    //Setters
    public void setNumberStars(int numberStars){
        this.numberStars = numberStars;
        this.reverse = -numberStars;
    }

    public void setId(String id){
        this.id = id;
    }

}

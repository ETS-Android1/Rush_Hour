package com.example.rush_hour.Model;

import android.widget.ImageView;

import java.util.Objects;

public abstract class Vehicle {

    //Attributes
    private Position ahead;
    private Position back;
    private Orientation orientation;
    private ImageView img;

    //Constructor
    public Vehicle(Position ahead, Position back, Orientation orientation, ImageView img){
        this.ahead = ahead;
        this.back = back;
        this.orientation = orientation;
        this.img = img;
    }

    //Getters
    public Position getAhead() {
        return ahead;
    }

    public Position getBack() {
        return back;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public ImageView getImg() {
        return img;
    }

    //Abstract Methods
    public abstract void moveUp();
    public abstract void moveDown();
    public abstract void moveLeft();
    public abstract void moveRight();

    //Other Methods that check if a car can move in a particular direction
    public boolean canMoveUp(){

        //Don't cross the game-board limit
        if(this.getAhead().getY() > 0 && this.getBack().getY() > 0) {
            //Just a vertical car can moveUp
            if (this.getOrientation() == Orientation.VERTICALE) {
                return true;
            }
        }

        return false;
    }

    public boolean canMoveDown(){

        //Don't cross the game-board limit
        if(this.getAhead().getY() < 5 && this.getBack().getY() < 5) {
            //Just a vertical car can moveUp
            if (this.getOrientation() == Orientation.VERTICALE) {
                return true;
            }
        }

        return false;
    }

    public boolean canMoveLeft(){

        //Don't cross the game-board limit
        if(this.getAhead().getX() > 0 && this.getBack().getX() > 0) {
            //Just an horizontal car can moveUp
            if (this.getOrientation() == Orientation.HORIZONTALE) {
                return true;
            }
        }

        return false;
    }

    public boolean canMoveRight(){

        //Don't cross the game-board limit
        if(this.getAhead().getX() < 5 && this.getBack().getX() < 5) {
            //Just an horizontal car can moveUp
            if (this.getOrientation() == Orientation.HORIZONTALE) {
                return true;
            }
        }

        return false;
    }

    //Equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(ahead, vehicle.ahead) && Objects.equals(back, vehicle.back) && orientation == vehicle.orientation && Objects.equals(img, vehicle.img);
    }

}

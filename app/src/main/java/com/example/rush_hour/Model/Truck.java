package com.example.rush_hour.Model;

import android.widget.ImageView;

public class Truck extends Vehicle{

    //Attributes
    private Position middle;

    //Constructor
    public Truck(Position ahead, Position middle, Position back, Orientation orientation, ImageView img){
        super(ahead,back,orientation, img);
        this.middle = middle;
    }

    //Getters
    public Position getMiddle() {
        return middle;
    }

    //Setter
    public void setMiddle(Position middle) {
        this.middle = middle;
    }

    @Override
    public void moveUp() {

        if(this.canMoveUp()) {
            this.getAhead().setY(this.getAhead().getY() - 1);
            this.getMiddle().setY(this.getMiddle().getY() - 1);
            this.getBack().setY(this.getBack().getY() - 1);
        }
    }

    @Override
    public void moveDown() {
        if(this.canMoveDown()){
            this.getAhead().setY(this.getAhead().getY() + 1);
            this.getMiddle().setY(this.getMiddle().getY() + 1);
            this.getBack().setY(this.getBack().getY() + 1);
        }
    }

    @Override
    public void moveLeft() {
        if(this.canMoveLeft()){
            this.getAhead().setX(this.getAhead().getX() - 1);
            this.getMiddle().setX(this.getMiddle().getX() - 1);
            this.getBack().setX(this.getBack().getX() - 1);
        }
    }

    @Override
    public void moveRight() {
        if(this.canMoveRight()){
            this.getAhead().setX(this.getAhead().getX() + 1);
            this.getMiddle().setX(this.getMiddle().getX() + 1);
            this.getBack().setX(this.getBack().getX() + 1);
        }
    }

}

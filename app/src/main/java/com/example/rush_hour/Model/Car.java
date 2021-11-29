package com.example.rush_hour.Model;

import android.widget.ImageView;

public class Car extends Vehicle{

    //Attributes
    private boolean redCar;

    //Constructor
    public Car(Position ahead, Position back, Orientation orientation, ImageView img, boolean redCar) {
        super(ahead,back,orientation, img);
        this.redCar = redCar;
    }

    //Getters
    public boolean isRedCar() {
        return redCar;
    }

    @Override
    public void moveUp() {

        if(this.canMoveUp()) {
            this.getAhead().setY(this.getAhead().getY() - 1);
            this.getBack().setY(this.getBack().getY() - 1);
        }
    }

    @Override
    public void moveDown() {
        if(this.canMoveDown()){
            this.getAhead().setY(this.getAhead().getY() + 1);
            this.getBack().setY(this.getBack().getY() + 1);
        }
    }

    @Override
    public void moveLeft() {
        if(this.canMoveLeft()){
            this.getAhead().setX(this.getAhead().getX() - 1);
            this.getBack().setX(this.getBack().getX() - 1);
        }
    }

    @Override
    public void moveRight() {
        if(this.canMoveRight()){
            this.getAhead().setX(this.getAhead().getX() + 1);
            this.getBack().setX(this.getBack().getX() + 1);
        }
    }

}

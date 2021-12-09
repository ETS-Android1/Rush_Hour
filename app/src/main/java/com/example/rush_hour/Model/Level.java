package com.example.rush_hour.Model;

import java.util.ArrayList;
import java.util.List;

public class Level {

    //Attributes
    private List<Vehicle> listOfVehicle;
    private int number;

    //Constructor
    public Level(int number){
        this.number = number;
        listOfVehicle = new ArrayList<>();
    }

    //Getters
    public List<Vehicle> getListOfVehicle() {

        return listOfVehicle;
    }

    //Setters
    public void setListOfVehicle(List<Vehicle> listOfVehicle) {
        this.listOfVehicle = listOfVehicle;
    }

    //Methods which check if a vehicle can move up taking account of the other vehicle
    public boolean canMoveUp(Vehicle vehicle){

        vehicle.moveUp();

        for(Vehicle v : getListOfVehicle()){
            if(!v.equals(vehicle)) {
                if (v.getAhead().equals(vehicle.getAhead())) {
                    vehicle.moveDown();
                    return false;
                }
                if (v.getAhead().equals(vehicle.getBack())) {
                    vehicle.moveDown();
                    return false;
                }
                if (v.getBack().equals(vehicle.getAhead())) {
                    vehicle.moveDown();
                    return false;
                }
                if (v.getBack().equals(vehicle.getBack())) {
                    vehicle.moveDown();
                    return false;
                }

                if(v instanceof Truck){
                    Truck t = (Truck) v;
                    if(vehicle.getAhead().equals(t.getMiddle()) || vehicle.getBack().equals(t.getMiddle())){
                        vehicle.moveDown();
                        return false;
                    }
                }
            }
        }
        vehicle.moveDown();

        return true;
    }

    public boolean canMoveDown(Vehicle vehicle){

        vehicle.moveDown();

        for(Vehicle v : getListOfVehicle()){
            if(!v.equals(vehicle)) {
                if (v.getAhead().equals(vehicle.getAhead()) || v.getAhead().equals(vehicle.getBack())
                || v.getBack().equals(vehicle.getAhead()) || v.getBack().equals(vehicle.getBack())) {

                    vehicle.moveUp();
                    return false;
                }

                if(v instanceof Truck){
                    Truck t = (Truck) v;
                    if(vehicle.getAhead().equals(t.getMiddle()) || vehicle.getBack().equals(t.getMiddle())){
                        vehicle.moveUp();
                        return false;
                    }
                }

            }
        }
        vehicle.moveUp();

        return true;
    }

    public boolean canMoveRight(Vehicle vehicle){

        vehicle.moveRight();

        for(Vehicle v : getListOfVehicle()){
            if(!v.equals(vehicle)) {
                if (v.getAhead().equals(vehicle.getAhead())) {
                    vehicle.moveLeft();
                    return false;
                }
                if (v.getAhead().equals(vehicle.getBack())) {
                    vehicle.moveLeft();
                    return false;
                }
                if (v.getBack().equals(vehicle.getAhead())) {
                    vehicle.moveLeft();
                    return false;
                }
                if (v.getBack().equals(vehicle.getBack())) {
                    vehicle.moveLeft();
                    return false;
                }
                if(v instanceof Truck){
                    Truck t = (Truck) v;
                    if(vehicle.getAhead().equals(t.getMiddle()) || vehicle.getBack().equals(t.getMiddle())){
                        vehicle.moveLeft();
                        return false;
                    }
                }

            }
        }
        vehicle.moveLeft();

        return true;
    }

    public boolean canMoveLeft(Vehicle vehicle){

        vehicle.moveLeft();

        for(Vehicle v : getListOfVehicle()){
            if(!v.equals(vehicle)) {
                if (v.getAhead().equals(vehicle.getAhead())) {
                    vehicle.moveRight();
                    return false;
                }
                if (v.getAhead().equals(vehicle.getBack())) {
                    vehicle.moveRight();
                    return false;
                }
                if (v.getBack().equals(vehicle.getAhead())) {
                    vehicle.moveRight();
                    return false;
                }
                if (v.getBack().equals(vehicle.getBack())) {
                    vehicle.moveRight();
                    return false;
                }
                if(v instanceof Truck){
                    Truck t = (Truck) v;
                    if(vehicle.getAhead().equals(t.getMiddle()) || vehicle.getBack().equals(t.getMiddle())){
                        vehicle.moveRight();
                        return false;
                    }
                }

            }
        }
        vehicle.moveRight();

        return true;
    }

    //Method which detect if the white car has cross the line --> WIN
    public boolean hasWon() {

        for (Vehicle v : getListOfVehicle()) {
            if (v instanceof Car) {
                if (((Car) v).isRedCar()) {
                    if (v.getAhead().getX() == 5 && v.getAhead().getY() == 2) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

}

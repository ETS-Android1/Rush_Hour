package com.example.rush_hour.Model;

import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Guideline;

import com.example.rush_hour.R;

import java.util.Arrays;

public class LevelGenerator extends AppCompatActivity {

    //Guideline
    private Guideline X0, X1, X2, X3, X4, X5, X6;
    private Guideline Y0, Y1, Y2, Y3, Y4, Y5, Y6;

    //Objects
    private Level lvl;

    //ImageView
    //Car
    private ImageView whiteCar_h, whiteCar_v, yellowCar_h, yellowCar_v, redCar_h, redCar_v, purpleCar_h, purpleCar_v, pinkCar_h, pinkCar_v, orangeCar_h, orangeCar_v;
    private ImageView lightGreenCar_h, lightGreenCar_v, greyCar_h, greyCar_v, darkGreenCar_h, darkGreenCar_v, blueCar_h, blueCar_v, aquaCar_h, aquaCar_v;
    //Truck
    private ImageView yellowTruck_h, yellowTruck_v, redTruck_h, redTruck_v, greenTruck_h, greenTruck_v, blueTruck_h, blueTruck_v;

    //Layout and Activity
    private AppCompatActivity appCompatActivity;
    private ConstraintLayout constraint;

    //Constructor
    public LevelGenerator(AppCompatActivity appCompatActivity){
        super();
        this.appCompatActivity = appCompatActivity;
        initResources();
        generateId();
    }

    private void initResources(){

        //Guideline X
        X0 = appCompatActivity.findViewById(R.id.guidelineX0);
        X1 = appCompatActivity.findViewById(R.id.guidelineX1);
        X2 = appCompatActivity.findViewById(R.id.guidelineX2);
        X3 = appCompatActivity.findViewById(R.id.guidelineX3);
        X4 = appCompatActivity.findViewById(R.id.guidelineX4);
        X5 = appCompatActivity.findViewById(R.id.guidelineX5);
        X6 = appCompatActivity.findViewById(R.id.guidelineX6);

        //Guideline Y
        Y0 = appCompatActivity.findViewById(R.id.guidelineY0);
        Y1 = appCompatActivity.findViewById(R.id.guidelineY1);
        Y2 = appCompatActivity.findViewById(R.id.guidelineY2);
        Y3 = appCompatActivity.findViewById(R.id.guidelineY3);
        Y4 = appCompatActivity.findViewById(R.id.guidelineY4);
        Y5 = appCompatActivity.findViewById(R.id.guidelineY5);
        Y6 = appCompatActivity.findViewById(R.id.guidelineY6);

        //Constraint Layout (Gameboard)
        constraint = appCompatActivity.findViewById(R.id.constraint);

        //ImageView
        //Car
        whiteCar_h = new ImageView(appCompatActivity.getApplicationContext());
        whiteCar_h.setImageResource(R.drawable.white_car_h);
        whiteCar_v = new ImageView((appCompatActivity.getApplicationContext()));
        whiteCar_v.setImageResource(R.drawable.white_car_v);
        yellowCar_h = new ImageView(appCompatActivity.getApplicationContext());
        yellowCar_h.setImageResource(R.drawable.yellow_car_h);
        yellowCar_v = new ImageView(appCompatActivity.getApplicationContext());
        yellowCar_v.setImageResource(R.drawable.yellow_car_v);
        redCar_h = new ImageView(appCompatActivity.getApplicationContext());
        redCar_h.setImageResource(R.drawable.red_car_h);
        redCar_v = new ImageView(appCompatActivity.getApplicationContext());
        redCar_v.setImageResource(R.drawable.red_car_v);
        purpleCar_h = new ImageView(appCompatActivity.getApplicationContext());
        purpleCar_h.setImageResource(R.drawable.purple_car_h);
        purpleCar_v = new ImageView(appCompatActivity.getApplicationContext());
        purpleCar_v.setImageResource(R.drawable.purple_car_v);
        pinkCar_h = new ImageView(appCompatActivity.getApplicationContext());
        pinkCar_h.setImageResource(R.drawable.pink_car_h);
        pinkCar_v = new ImageView(appCompatActivity.getApplicationContext());
        pinkCar_v.setImageResource(R.drawable.pink_car_v);
        orangeCar_h = new ImageView(appCompatActivity.getApplicationContext());
        orangeCar_h.setImageResource(R.drawable.orange_car_h);
        orangeCar_v = new ImageView(appCompatActivity.getApplicationContext());
        orangeCar_v.setImageResource(R.drawable.orange_car_v);
        lightGreenCar_h = new ImageView(appCompatActivity.getApplicationContext());
        lightGreenCar_h.setImageResource(R.drawable.light_green_car_h);
        lightGreenCar_v = new ImageView(appCompatActivity.getApplicationContext());
        lightGreenCar_v.setImageResource(R.drawable.light_green_car_v);
        greyCar_h = new ImageView(appCompatActivity.getApplicationContext());
        greyCar_h.setImageResource(R.drawable.grey_car_h);
        greyCar_v = new ImageView(appCompatActivity.getApplicationContext());
        greyCar_v.setImageResource(R.drawable.grey_car_v);
        darkGreenCar_h = new ImageView(appCompatActivity.getApplicationContext());
        darkGreenCar_h.setImageResource(R.drawable.dark_green_car_h);
        darkGreenCar_v = new ImageView(appCompatActivity.getApplicationContext());
        darkGreenCar_v.setImageResource(R.drawable.dark_green_car_v);
        blueCar_h = new ImageView(appCompatActivity.getApplicationContext());
        blueCar_h.setImageResource(R.drawable.blue_car_h);
        blueCar_v = new ImageView(appCompatActivity.getApplicationContext());
        blueCar_v.setImageResource(R.drawable.blue_car_v);
        aquaCar_h = new ImageView(appCompatActivity.getApplicationContext());
        aquaCar_h.setImageResource(R.drawable.aqua_car_h);
        aquaCar_v = new ImageView(appCompatActivity.getApplicationContext());
        aquaCar_v.setImageResource(R.drawable.aqua_car_v);

        //Truck
        yellowTruck_h = new ImageView(appCompatActivity.getApplicationContext());
        yellowTruck_h.setImageResource(R.drawable.yellow_truck_h);
        yellowTruck_v = new ImageView(appCompatActivity.getApplicationContext());
        yellowTruck_v.setImageResource(R.drawable.yellow_truck_v);
        redTruck_h = new ImageView(appCompatActivity.getApplicationContext());
        redTruck_h.setImageResource(R.drawable.red_truck_h);
        redTruck_v = new ImageView(appCompatActivity.getApplicationContext());
        redTruck_v.setImageResource(R.drawable.red_truck_v);
        greenTruck_h = new ImageView(appCompatActivity.getApplicationContext());
        greenTruck_h.setImageResource(R.drawable.green_truck_h);
        greenTruck_v = new ImageView(appCompatActivity.getApplicationContext());
        greenTruck_v.setImageResource(R.drawable.green_truck_v);
        blueTruck_h = new ImageView(appCompatActivity.getApplicationContext());
        blueTruck_h.setImageResource(R.drawable.blue_truck_h);
        blueTruck_v = new ImageView(appCompatActivity.getApplicationContext());
        blueTruck_v.setImageResource(R.drawable.blue_truck_v);
    }

    private void generateId(){
        X0.setId(View.generateViewId());
        X1.setId(View.generateViewId());
        X2.setId(View.generateViewId());
        X3.setId(View.generateViewId());
        X4.setId(View.generateViewId());
        X5.setId(View.generateViewId());
        X6.setId(View.generateViewId());

        Y0.setId(View.generateViewId());
        Y1.setId(View.generateViewId());
        Y2.setId(View.generateViewId());
        Y3.setId(View.generateViewId());
        Y4.setId(View.generateViewId());
        Y5.setId(View.generateViewId());
        Y6.setId(View.generateViewId());

        //Cars
        whiteCar_h.setId(View.generateViewId());
        whiteCar_v.setId(View.generateViewId());
        yellowCar_h.setId(View.generateViewId());
        yellowCar_v.setId(View.generateViewId());
        redCar_h.setId(View.generateViewId());
        redCar_v.setId(View.generateViewId());
        purpleCar_h.setId(View.generateViewId());
        purpleCar_v.setId(View.generateViewId());
        pinkCar_h.setId(View.generateViewId());
        pinkCar_v.setId(View.generateViewId());
        orangeCar_h.setId(View.generateViewId());
        orangeCar_v.setId(View.generateViewId());
        lightGreenCar_h.setId(View.generateViewId());
        lightGreenCar_v.setId(View.generateViewId());
        greyCar_h.setId(View.generateViewId());
        greyCar_v.setId(View.generateViewId());
        darkGreenCar_h.setId(View.generateViewId());
        darkGreenCar_v.setId(View.generateViewId());
        blueCar_h.setId(View.generateViewId());
        blueCar_v.setId(View.generateViewId());
        aquaCar_h.setId(View.generateViewId());
        aquaCar_v.setId(View.generateViewId());

        //Trucks
        yellowTruck_h.setId(View.generateViewId());
        yellowTruck_v.setId(View.generateViewId());
        redTruck_h.setId(View.generateViewId());
        redTruck_v.setId(View.generateViewId());
        greenTruck_h.setId(View.generateViewId());
        greenTruck_v.setId(View.generateViewId());
        blueTruck_h.setId(View.generateViewId());
        blueTruck_v.setId(View.generateViewId());
    }

    //Method which create a constraint with an imageView and 4 Guidelines
    private void createCarConstraint(ConstraintSet set, ImageView v, Guideline constraintSTART, Guideline constraintEND, Guideline constraintTOP, Guideline constraintBOTTOM) {

        set.connect(v.getId(), ConstraintSet.START, constraintSTART.getId(), ConstraintSet.START);
        set.connect(v.getId(), ConstraintSet.END, constraintEND.getId(), ConstraintSet.START);
        set.connect(v.getId(), ConstraintSet.TOP, constraintTOP.getId(), ConstraintSet.TOP);
        set.connect(v.getId(), ConstraintSet.BOTTOM, constraintBOTTOM.getId(), ConstraintSet.TOP);

        //Add the image to the View
        constraint.addView(v);

    }

    public void level1(){

        //Initialize the constraint
        ConstraintSet set = new ConstraintSet();

        //Set all the Image with the guidelines
        createCarConstraint(set, whiteCar_h, Y0, Y2, X2, X3);
        createCarConstraint(set, lightGreenCar_h, Y4, Y6, X0, X1);
        createCarConstraint(set, yellowTruck_v, Y2, Y3, X0, X3);
        createCarConstraint(set, redTruck_h, Y0, Y3, X3, X4);
        createCarConstraint(set, blueTruck_v, Y5, Y6, X3, X6);

        //Apply it to the constraint layout
        set.applyTo(constraint);

        //Instanciate Level
        lvl = new Level(1);

        lvl.setListOfVehicle(Arrays.asList(
            new Car(new Position(1,2), new Position(0,2), Orientation.HORIZONTALE, whiteCar_h, true),
            new Car(new Position(5,0), new Position(4,0), Orientation.HORIZONTALE, lightGreenCar_h, false),
            new Truck(new Position(2,2), new Position(2,1),new Position(2,0), Orientation.VERTICALE, yellowTruck_v),
            new Truck(new Position(2,3), new Position(1,3),new Position(0,3), Orientation.HORIZONTALE, redTruck_h),
            new Truck(new Position(5,5), new Position(5,4),new Position(5,3), Orientation.VERTICALE, blueTruck_v)));
    }

    public void level2() {

        //Initialize the constraint
        ConstraintSet set = new ConstraintSet();

        //Set all the Image with the guidelines
        createCarConstraint(set, whiteCar_h, Y3, Y5, X2, X3);
        createCarConstraint(set, orangeCar_h, Y4, Y6, X4, X5);
        createCarConstraint(set, lightGreenCar_v, Y3, Y4, X3, X5);
        createCarConstraint(set, yellowTruck_v, Y2, Y3, X0, X3);
        createCarConstraint(set, blueTruck_h, Y0, Y3, X3, X4);
        createCarConstraint(set, redTruck_v, Y5, Y6, X1, X4);

        //Apply it to the constraint layout
        set.applyTo(constraint);

        //Instanciate Level
        lvl = new Level(2);

        lvl.setListOfVehicle(Arrays.asList(
            new Car(new Position(4,2), new Position(3,2), Orientation.HORIZONTALE, whiteCar_h, true),
            new Car(new Position(4,4), new Position(5,4), Orientation.HORIZONTALE, orangeCar_h, false),
            new Car(new Position(3,3), new Position(3,4), Orientation.VERTICALE, lightGreenCar_v, false),
            new Truck(new Position(2,2), new Position(2,1),new Position(2,0), Orientation.VERTICALE, yellowTruck_v),
            new Truck(new Position(2,3), new Position(1,3),new Position(0,3), Orientation.HORIZONTALE, blueTruck_h),
            new Truck(new Position(5,3), new Position(5,2),new Position(5,1), Orientation.VERTICALE, redTruck_v)));

    }

    public void level3(){

        //Initialize the constraint
        ConstraintSet set = new ConstraintSet();

        //Set all the Image with the guidelines
        createCarConstraint(set, whiteCar_h, Y0, Y2, X2, X3);
        createCarConstraint(set, lightGreenCar_v, Y0, Y1, X0, X2);
        createCarConstraint(set, orangeCar_v, Y1, Y2, X0, X2);
        createCarConstraint(set, aquaCar_h, Y2, Y4, X0, X1);
        createCarConstraint(set, blueCar_h, Y2, Y4, X1, X2);
        createCarConstraint(set, pinkCar_v, Y4, Y5, X0, X2);
        createCarConstraint(set, darkGreenCar_v, Y2, Y3, X2, X4);
        createCarConstraint(set, redCar_v, Y2, Y3, X4, X6);
        createCarConstraint(set, yellowTruck_v, Y3, Y4, X2, X5);
        createCarConstraint(set, greyCar_v, Y4, Y5, X3, X5);

        //Apply it to the constraint layout
        set.applyTo(constraint);

        //Instanciate Level
        lvl = new Level(3);

        lvl.setListOfVehicle(Arrays.asList(
            new Car(new Position(1,2), new Position(0,2), Orientation.HORIZONTALE, whiteCar_h, true),
            new Car(new Position(0,1), new Position(0,0), Orientation.VERTICALE, lightGreenCar_v, false),
            new Car(new Position(1,1), new Position(1,0), Orientation.VERTICALE, orangeCar_v, false),
            new Car(new Position(3,0), new Position(2,0), Orientation.HORIZONTALE, aquaCar_h, false),
            new Car(new Position(3,1), new Position(2,1), Orientation.HORIZONTALE, blueCar_h, false),
            new Car(new Position(4,1), new Position(4,0), Orientation.VERTICALE, pinkCar_v, false),
            new Car(new Position(2,3), new Position(2,2), Orientation.VERTICALE, darkGreenCar_v, false),
            new Car(new Position(2,5), new Position(2,4), Orientation.VERTICALE, redCar_v, false),
            new Car(new Position(4,4), new Position(4,3), Orientation.VERTICALE, greyCar_v, false),
            new Truck(new Position(3,4), new Position(3,3),new Position(3,2), Orientation.VERTICALE, yellowTruck_v)));

    }

    public void level4(){

        //Initialize the constraint
        ConstraintSet set = new ConstraintSet();

        //Set all the Image with the guidelines
        createCarConstraint(set, whiteCar_h, Y0, Y2, X2, X3);
        createCarConstraint(set, lightGreenCar_v, Y2, Y3, X1, X3);
        createCarConstraint(set, greenTruck_h, Y0, Y3, X3, X4);
        createCarConstraint(set, aquaCar_v, Y0, Y1, X4, X6);
        createCarConstraint(set, blueCar_v, Y2, Y3, X4, X6);
        createCarConstraint(set, pinkCar_v, Y1, Y2, X4, X6);
        createCarConstraint(set, yellowTruck_v, Y4, Y5, X1, X4);
        createCarConstraint(set, orangeCar_v, Y5, Y6, X2, X4);
        createCarConstraint(set, darkGreenCar_h, Y4, Y6, X4, X5);
        createCarConstraint(set, greyCar_h, Y4, Y6, X5, X6);

        //Apply it to the constraint layout
        set.applyTo(constraint);

        //Instanciate Level
        lvl = new Level(4);

        lvl.setListOfVehicle(Arrays.asList(
                new Car(new Position(1,2), new Position(0,2), Orientation.HORIZONTALE, whiteCar_h, true),
                new Car(new Position(2,2), new Position(2,1), Orientation.VERTICALE, lightGreenCar_v, false),
                new Truck(new Position(2,3), new Position(1,3),new Position(0,3), Orientation.HORIZONTALE, greenTruck_h),
                new Car(new Position(0,5), new Position(0,4), Orientation.VERTICALE, aquaCar_v, false),
                new Car(new Position(2,5), new Position(2,4), Orientation.VERTICALE, blueCar_v, false),
                new Car(new Position(1,5), new Position(1,4), Orientation.VERTICALE, pinkCar_v, false),
                new Truck(new Position(4,3), new Position(4,2),new Position(4,1), Orientation.VERTICALE, yellowTruck_v),
                new Car(new Position(5,3), new Position(5,2), Orientation.VERTICALE, orangeCar_v, false),
                new Car(new Position(5,4), new Position(4,4), Orientation.HORIZONTALE, darkGreenCar_h, false),
                new Car(new Position(5,5), new Position(4,5), Orientation.HORIZONTALE, greyCar_h, false)));
    }

    public void level5(){
        //Initialize the constraint
        ConstraintSet set = new ConstraintSet();

        //Set all the Image with the guidelines
        createCarConstraint(set, whiteCar_h, Y0, Y2, X2, X3);
        createCarConstraint(set, greenTruck_h, Y0, Y3, X3, X4);
        createCarConstraint(set, redTruck_h, Y0, Y3, X1, X2);
        createCarConstraint(set, orangeCar_v, Y0, Y1, X4, X6);
        createCarConstraint(set, aquaCar_v, Y2, Y3, X4, X6);
        createCarConstraint(set, yellowTruck_h, Y2, Y5, X0, X1);
        createCarConstraint(set, blueTruck_v, Y4, Y5, X1, X4);
        createCarConstraint(set, lightGreenCar_v, Y5, Y6, X2, X4);
        createCarConstraint(set, pinkCar_h, Y4, Y6, X4, X5);
        createCarConstraint(set, blueCar_h, Y4, Y6, X5, X6);

        //Apply it to the constraint layout
        set.applyTo(constraint);

        //Instanciate Level
        lvl = new Level(5);

        lvl.setListOfVehicle(Arrays.asList(
                new Car(new Position(1,2), new Position(0,2), Orientation.HORIZONTALE, whiteCar_h, true),
                new Truck(new Position(2,3), new Position(1,3),new Position(0,3), Orientation.HORIZONTALE, greenTruck_h),
                new Truck(new Position(2,1), new Position(1,1),new Position(0,1), Orientation.HORIZONTALE, redTruck_h),
                new Car(new Position(0,5), new Position(0,4), Orientation.VERTICALE, orangeCar_v, false),
                new Car(new Position(2,5), new Position(2,4), Orientation.VERTICALE, aquaCar_v, false),
                new Truck(new Position(4,0), new Position(3,0),new Position(2,0), Orientation.HORIZONTALE, yellowTruck_h),
                new Truck(new Position(4,3), new Position(4,2),new Position(4,1), Orientation.VERTICALE, blueTruck_v),
                new Car(new Position(5,3), new Position(5,2), Orientation.VERTICALE, lightGreenCar_v, false),
                new Car(new Position(5,4), new Position(4,4), Orientation.HORIZONTALE, pinkCar_h, false),
                new Car(new Position(5,5), new Position(4,5), Orientation.HORIZONTALE, blueCar_h, false)));
    }

    public void level6(){
        //Initialize the constraint
        ConstraintSet set = new ConstraintSet();

        //Set all the Image with the guidelines
        createCarConstraint(set, whiteCar_h, Y0, Y2, X2, X3);
        createCarConstraint(set, orangeCar_v, Y0, Y1, X3, X5);
        createCarConstraint(set, greenTruck_h, Y0, Y3, X5, X6);
        createCarConstraint(set, pinkCar_h, Y1, Y3, X4, X5);
        createCarConstraint(set, yellowTruck_v, Y2, Y3, X1, X4);
        createCarConstraint(set, aquaCar_h, Y3, Y5, X3, X4);
        createCarConstraint(set, blueCar_v, Y3, Y4, X4, X6);
        createCarConstraint(set, darkGreenCar_v, Y4, Y5, X4, X6);
        createCarConstraint(set, redTruck_v, Y5, Y6, X3, X6);
        createCarConstraint(set, lightGreenCar_v, Y5, Y6, X1, X3);

        //Apply it to the constraint layout
        set.applyTo(constraint);

        //Instanciate Level
        lvl = new Level(6);

        lvl.setListOfVehicle(Arrays.asList(
                new Car(new Position(1,2), new Position(0,2), Orientation.HORIZONTALE, whiteCar_h, true),
                new Car(new Position(0,4), new Position(0,3), Orientation.VERTICALE, orangeCar_v, false),
                new Truck(new Position(2,5), new Position(1,5),new Position(0,5), Orientation.HORIZONTALE, greenTruck_h),
                new Car(new Position(2,4), new Position(1,4), Orientation.HORIZONTALE, pinkCar_h, false),
                new Truck(new Position(2,3), new Position(2,2),new Position(2,1), Orientation.VERTICALE, yellowTruck_v),
                new Car(new Position(4,3), new Position(3,3), Orientation.HORIZONTALE, aquaCar_h, false),
                new Car(new Position(3,5), new Position(3,4), Orientation.VERTICALE, blueCar_v, false),
                new Car(new Position(4,5), new Position(4,4), Orientation.VERTICALE, darkGreenCar_v, false),
                new Truck(new Position(5,5), new Position(5,4),new Position(5,3), Orientation.VERTICALE, redTruck_v),
                new Car(new Position(5,2), new Position(5,1), Orientation.VERTICALE, lightGreenCar_v, false)));
    }

    public void level7(){
        //Initialize the constraint
        ConstraintSet set = new ConstraintSet();

        //Set all the Image with the guidelines
        createCarConstraint(set, whiteCar_h, Y2, Y4, X2, X3);
        createCarConstraint(set, redTruck_h, Y1, Y4, X1, X2);
        createCarConstraint(set, lightGreenCar_h, Y2, Y4, X0, X1);
        createCarConstraint(set, aquaCar_v, Y2, Y3, X3, X5);
        createCarConstraint(set, yellowTruck_v, Y4, Y5, X0, X3);
        createCarConstraint(set, orangeCar_v, Y5, Y6, X1, X3);
        createCarConstraint(set, blueTruck_h, Y3, Y6, X3, X4);
        createCarConstraint(set, pinkCar_v, Y3, Y4, X4, X6);
        createCarConstraint(set, blueCar_h, Y4, Y6, X4, X5);
        createCarConstraint(set, darkGreenCar_h, Y4, Y6, X5, X6);

        //Apply it to the constraint layout
        set.applyTo(constraint);

        //Instanciate Level
        lvl = new Level(7);

        lvl.setListOfVehicle(Arrays.asList(
                new Car(new Position(3,2), new Position(2,2), Orientation.HORIZONTALE, whiteCar_h, true),
                new Truck(new Position(3,1), new Position(2,1),new Position(1,1), Orientation.HORIZONTALE, redTruck_h),
                new Car(new Position(3,0), new Position(2,0), Orientation.HORIZONTALE, lightGreenCar_h, false),
                new Car(new Position(2,4), new Position(2,3), Orientation.VERTICALE, aquaCar_v, false),
                new Truck(new Position(4,2), new Position(4,1),new Position(4,0), Orientation.VERTICALE, yellowTruck_v),
                new Car(new Position(5,2), new Position(5,1), Orientation.VERTICALE, orangeCar_v, false),
                new Truck(new Position(5,3), new Position(4,3),new Position(3,3), Orientation.HORIZONTALE, blueTruck_h),
                new Car(new Position(3,5), new Position(3,4), Orientation.VERTICALE, pinkCar_v, false),
                new Car(new Position(5,4), new Position(4,4), Orientation.HORIZONTALE, blueCar_h, false),
                new Car(new Position(5,5), new Position(4,5), Orientation.HORIZONTALE, darkGreenCar_h, false)));
    }

    public void level8(){
        //Initialize the constraint
        ConstraintSet set = new ConstraintSet();

        //Set all the Image with the guidelines
        createCarConstraint(set, whiteCar_h, Y2, Y4, X2, X3);
        createCarConstraint(set, yellowTruck_v, Y1, Y2, X2, X5);
        createCarConstraint(set, redTruck_h, Y3, Y6, X4, X5);
        createCarConstraint(set, lightGreenCar_h, Y0, Y2, X0, X1);
        createCarConstraint(set, blueCar_h, Y0, Y2, X1, X2);
        createCarConstraint(set, orangeCar_v, Y2, Y3, X0, X2);
        createCarConstraint(set, aquaCar_v, Y3, Y4, X0, X2);
        createCarConstraint(set, pinkCar_h, Y4, Y6, X0, X1);
        createCarConstraint(set, darkGreenCar_v, Y4, Y5, X1, X3);
        createCarConstraint(set, greyCar_v, Y5, Y6, X1, X3);

        //Apply it to the constraint layout
        set.applyTo(constraint);

        //Instanciate Level
        lvl = new Level(8);

        lvl.setListOfVehicle(Arrays.asList(
                new Car(new Position(3,2), new Position(2,2), Orientation.HORIZONTALE, whiteCar_h, true),
                new Truck(new Position(1,4), new Position(1,3),new Position(1,2), Orientation.VERTICALE, yellowTruck_v),
                new Truck(new Position(5,4), new Position(4,4),new Position(3,4), Orientation.HORIZONTALE, redTruck_h),
                new Car(new Position(1,0), new Position(0,0), Orientation.HORIZONTALE, lightGreenCar_h, false),
                new Car(new Position(1,1), new Position(0,1), Orientation.HORIZONTALE, blueCar_h, false),
                new Car(new Position(2,1), new Position(2,0), Orientation.VERTICALE, orangeCar_v, false),
                new Car(new Position(3,1), new Position(3,0), Orientation.VERTICALE, aquaCar_v, false),
                new Car(new Position(5,0), new Position(4,0), Orientation.HORIZONTALE, pinkCar_h, false),
                new Car(new Position(4,2), new Position(4,1), Orientation.VERTICALE, darkGreenCar_v, false),
                new Car(new Position(5,2), new Position(5,1), Orientation.VERTICALE, greyCar_v, false)));
    }

    public void level9(){
        //Initialize the constraint
        ConstraintSet set = new ConstraintSet();

        //Set all the Image with the guidelines
        createCarConstraint(set, whiteCar_h, Y0, Y2, X2, X3);
        createCarConstraint(set, lightGreenCar_v, Y0, Y1, X0, X2);
        createCarConstraint(set, darkGreenCar_h, Y0, Y2, X3, X4);
        createCarConstraint(set, orangeCar_h, Y1, Y3, X0, X1);
        createCarConstraint(set, pinkCar_v, Y2, Y3, X1, X3);
        createCarConstraint(set, yellowTruck_h, Y2, Y5, X3, X4);
        createCarConstraint(set, redCar_v, Y2, Y3, X4, X6);
        createCarConstraint(set, purpleCar_v, Y5, Y6, X1, X3);
        createCarConstraint(set, greyCar_v, Y5, Y6, X3, X5);
        createCarConstraint(set, aquaCar_v, Y3, Y4, X0, X2);

        //Apply it to the constraint layout
        set.applyTo(constraint);

        //Instanciate Level
        lvl = new Level(9);

        lvl.setListOfVehicle(Arrays.asList(
                new Car(new Position(1,2), new Position(0,2), Orientation.HORIZONTALE, whiteCar_h, true),
                new Car(new Position(0,1), new Position(0,0), Orientation.VERTICALE, lightGreenCar_v, false),
                new Car(new Position(2,0), new Position(1,0), Orientation.HORIZONTALE, orangeCar_h, false),
                new Car(new Position(1,3), new Position(0,3), Orientation.HORIZONTALE, darkGreenCar_h, false),
                new Car(new Position(2,2), new Position(2,1), Orientation.VERTICALE, pinkCar_v, false),
                new Truck(new Position(4,3), new Position(3,3),new Position(2,3), Orientation.HORIZONTALE, yellowTruck_h),
                new Car(new Position(2,5), new Position(2,4), Orientation.VERTICALE, redCar_v, false),
                new Car(new Position(5,2), new Position(5,1), Orientation.VERTICALE, purpleCar_v, false),
                new Car(new Position(5,4), new Position(5,3), Orientation.VERTICALE, greyCar_v, false),
                new Car(new Position(3,1), new Position(3,0), Orientation.VERTICALE, aquaCar_v, false)));
    }

    public void level10(){
        //Initialize the constraint
        ConstraintSet set = new ConstraintSet();

        //Set all the Image with the guidelines
        createCarConstraint(set, whiteCar_h, Y3, Y5, X2, X3);
        createCarConstraint(set, aquaCar_v, Y5, Y6, X1, X3);
        createCarConstraint(set, orangeCar_h, Y4, Y6, X0, X1);
        createCarConstraint(set, lightGreenCar_h, Y2, Y4, X0, X1);
        createCarConstraint(set, yellowTruck_v, Y1, Y2, X0, X3);
        createCarConstraint(set, pinkCar_v, Y1, Y2, X3, X5);
        createCarConstraint(set, redTruck_h, Y1, Y4, X5, X6);
        createCarConstraint(set, purpleCar_v, Y3, Y4, X3, X5);
        createCarConstraint(set, darkGreenCar_h, Y4, Y6, X3, X4);
        createCarConstraint(set, greyCar_v, Y4, Y5, X4, X6);
        createCarConstraint(set, redCar_v, Y5, Y6, X4, X6);

        //Apply it to the constraint layout
        set.applyTo(constraint);

        //Instanciate Level
        lvl = new Level(10);

        lvl.setListOfVehicle(Arrays.asList(
                new Car(new Position(4,2), new Position(3,2), Orientation.HORIZONTALE, whiteCar_h, true),
                new Car(new Position(5,2), new Position(5,1), Orientation.VERTICALE, aquaCar_v, false),
                new Car(new Position(5,0), new Position(4,0), Orientation.HORIZONTALE, orangeCar_h, false),
                new Car(new Position(3,0), new Position(2,0), Orientation.HORIZONTALE, lightGreenCar_h, false),
                new Truck(new Position(1,2), new Position(1,1),new Position(1,0), Orientation.VERTICALE, yellowTruck_v),
                new Car(new Position(1,3), new Position(1,4), Orientation.VERTICALE, pinkCar_v, false),
                new Truck(new Position(3,5), new Position(2,5),new Position(1,5), Orientation.HORIZONTALE, redTruck_h),
                new Car(new Position(3,4), new Position(3,3), Orientation.VERTICALE, purpleCar_v, false),
                new Car(new Position(5,3), new Position(4,3), Orientation.HORIZONTALE, darkGreenCar_h, false),
                new Car(new Position(4,5), new Position(4,4), Orientation.VERTICALE, greyCar_v, false),
                new Car(new Position(5,5), new Position(5,4), Orientation.VERTICALE, redCar_v, false)));
    }

    public void level11(){
        //Initialize the constraint
        ConstraintSet set = new ConstraintSet();

        //Set all the Image with the guidelines
        createCarConstraint(set, whiteCar_h, Y0, Y2, X2, X3);
        createCarConstraint(set, yellowTruck_h, Y0, Y3, X0, X1);
        createCarConstraint(set, redTruck_v, Y2, Y3, X1, X4);
        createCarConstraint(set, blueTruck_h, Y0, Y3, X4, X5);
        createCarConstraint(set, darkGreenCar_h, Y1, Y3, X5, X6);
        createCarConstraint(set, lightGreenCar_v, Y3, Y4, X0, X2);
        createCarConstraint(set, pinkCar_h, Y3, Y5, X3, X4);
        createCarConstraint(set, purpleCar_v, Y4, Y5, X4, X6);
        createCarConstraint(set, aquaCar_v, Y5, Y6, X2, X4);
        createCarConstraint(set, orangeCar_v, Y5, Y6, X0, X2);

        //Apply it to the constraint layout
        set.applyTo(constraint);

        //Instanciate Level
        lvl = new Level(11);

        lvl.setListOfVehicle(Arrays.asList(
                new Car(new Position(1,2), new Position(0,2), Orientation.HORIZONTALE, whiteCar_h, true),
                new Truck(new Position(2,0), new Position(1,0),new Position(0,0), Orientation.HORIZONTALE, yellowTruck_h),
                new Truck(new Position(2,3), new Position(2,2),new Position(2,1), Orientation.VERTICALE, redTruck_v),
                new Truck(new Position(2,4), new Position(1,4),new Position(0,4), Orientation.HORIZONTALE, blueTruck_h),

                new Car(new Position(2,5), new Position(1,5), Orientation.HORIZONTALE, darkGreenCar_h, false),
                new Car(new Position(3,1), new Position(3,0), Orientation.VERTICALE, lightGreenCar_v, false),
                new Car(new Position(4,3), new Position(3,3), Orientation.HORIZONTALE, pinkCar_h, false),
                new Car(new Position(4,5), new Position(4,4), Orientation.VERTICALE, purpleCar_v, false),
                new Car(new Position(5,3), new Position(5,2), Orientation.VERTICALE, aquaCar_v, false),
                new Car(new Position(5,1), new Position(5,0), Orientation.VERTICALE, orangeCar_v, false)));
    }

    public void level12(){
        //Initialize the constraint
        ConstraintSet set = new ConstraintSet();

        //Set all the Image with the guidelines
        createCarConstraint(set, whiteCar_h, Y1, Y3, X2, X3);
        createCarConstraint(set, aquaCar_v, Y0, Y1, X1, X3);
        createCarConstraint(set, lightGreenCar_h, Y0, Y2, X0, X1);
        createCarConstraint(set, orangeCar_v, Y2, Y3, X0, X2);
        createCarConstraint(set, yellowTruck_v, Y3, Y4, X0, X3);
        createCarConstraint(set, redTruck_v, Y4, Y5, X0, X3);
        createCarConstraint(set, blueTruck_v, Y5, Y6, X2, X5);
        createCarConstraint(set, greenTruck_h, Y3, Y6, X5, X6);
        createCarConstraint(set, purpleCar_h, Y2, Y4, X4, X5);
        createCarConstraint(set, pinkCar_v, Y1, Y2, X4, X6);

        //Apply it to the constraint layout
        set.applyTo(constraint);

        //Instanciate Level
        lvl = new Level(12);

        lvl.setListOfVehicle(Arrays.asList(
                new Car(new Position(2,2), new Position(1,2), Orientation.HORIZONTALE, whiteCar_h, true),
                new Car(new Position(0,2), new Position(0,1), Orientation.VERTICALE, aquaCar_v, false),
                new Car(new Position(1,0), new Position(0,0), Orientation.HORIZONTALE, lightGreenCar_h, false),
                new Car(new Position(2,1), new Position(2,0), Orientation.VERTICALE, orangeCar_v, false),
                new Truck(new Position(3,2), new Position(3,1),new Position(3,0), Orientation.VERTICALE, yellowTruck_v),
                new Truck(new Position(4,2), new Position(4,1),new Position(4,0), Orientation.VERTICALE, redTruck_v),
                new Truck(new Position(5,4), new Position(5,3),new Position(5,2), Orientation.VERTICALE, blueTruck_v),
                new Truck(new Position(5,5), new Position(4,5),new Position(3,5), Orientation.HORIZONTALE, greenTruck_h),
                new Car(new Position(3,4), new Position(2,4), Orientation.HORIZONTALE, purpleCar_h, false),
                new Car(new Position(1,5), new Position(1,4), Orientation.VERTICALE, pinkCar_v, false)));
    }

    public void level13(){
        //Initialize the constraint
        ConstraintSet set = new ConstraintSet();

        //Set all the Image with the guidelines
        createCarConstraint(set, whiteCar_h, Y0, Y2, X2, X3);
        createCarConstraint(set, redTruck_h, Y0, Y3, X1, X2);
        createCarConstraint(set, lightGreenCar_h, Y1, Y3, X0, X1);
        createCarConstraint(set, purpleCar_v, Y2, Y3, X2, X4);
        createCarConstraint(set, darkGreenCar_v, Y0, Y1, X3, X5);
        createCarConstraint(set, yellowCar_h, Y0, Y2, X5, X6);
        createCarConstraint(set, redCar_h, Y1, Y3, X4, X5);
        createCarConstraint(set, greenTruck_h, Y2, Y5, X5, X6);
        createCarConstraint(set, blueTruck_v, Y5, Y6, X3, X6);
        createCarConstraint(set, greyCar_h, Y3, Y5, X3, X4);
        createCarConstraint(set, pinkCar_v, Y5, Y6, X1, X3);
        createCarConstraint(set, aquaCar_v, Y4, Y5, X1, X3);
        createCarConstraint(set, orangeCar_v, Y3, Y4, X1, X3);
        createCarConstraint(set, yellowTruck_h, Y3, Y6, X0, X1);

        //Apply it to the constraint layout
        set.applyTo(constraint);

        //Instanciate Level
        lvl = new Level(13);

        lvl.setListOfVehicle(Arrays.asList(
                new Car(new Position(1,2), new Position(0,2), Orientation.HORIZONTALE, whiteCar_h, true),
                new Truck(new Position(2,1), new Position(1,1),new Position(0,1), Orientation.HORIZONTALE, redTruck_h),
                new Car(new Position(2,0), new Position(1,0), Orientation.HORIZONTALE, lightGreenCar_h, false),
                new Car(new Position(2,3), new Position(2,2), Orientation.VERTICALE, purpleCar_v, false),
                new Car(new Position(0,4), new Position(0,3), Orientation.VERTICALE, darkGreenCar_v, false),
                new Car(new Position(1,5), new Position(0,5), Orientation.HORIZONTALE, yellowCar_h, false),
                new Car(new Position(2,4), new Position(1,4), Orientation.HORIZONTALE, redCar_h, false),
                new Truck(new Position(4,5), new Position(3,5),new Position(2,5), Orientation.HORIZONTALE, greenTruck_h),
                new Truck(new Position(5,5), new Position(5,4),new Position(5,3), Orientation.VERTICALE, blueTruck_v),
                new Car(new Position(4,3), new Position(3,3), Orientation.HORIZONTALE, greyCar_h, false),
                new Car(new Position(5,2), new Position(5,1), Orientation.VERTICALE, pinkCar_v, false),
                new Car(new Position(4,2), new Position(4,1), Orientation.VERTICALE, aquaCar_v, false),
                new Car(new Position(3,2), new Position(3,1), Orientation.VERTICALE, orangeCar_v, false),
                new Truck(new Position(5,0), new Position(4,0),new Position(3,0), Orientation.HORIZONTALE, yellowTruck_h)));
    }

    public void level14(){
        //Initialize the constraint
        ConstraintSet set = new ConstraintSet();

        //Set all the Image with the guidelines
        createCarConstraint(set, whiteCar_h, Y2, Y4, X2, X3);
        createCarConstraint(set, orangeCar_v, Y2, Y3, X0, X2);
        createCarConstraint(set, lightGreenCar_h, Y0, Y2, X0, X1);
        createCarConstraint(set, aquaCar_v, Y0, Y1, X1, X3);
        createCarConstraint(set, yellowTruck_h, Y3, Y6, X1, X2);
        createCarConstraint(set, pinkCar_v, Y4, Y5, X2, X4);
        createCarConstraint(set, redTruck_h, Y2, Y5, X4, X5);
        createCarConstraint(set, purpleCar_h, Y0, Y2, X4, X5);
        createCarConstraint(set, darkGreenCar_v, Y5, Y6, X4, X6);

        //Apply it to the constraint layout
        set.applyTo(constraint);

        //Instanciate Level
        lvl = new Level(14);

        lvl.setListOfVehicle(Arrays.asList(
                new Car(new Position(3,2), new Position(2,2), Orientation.HORIZONTALE, whiteCar_h, true),
                new Car(new Position(2,1), new Position(2,0), Orientation.VERTICALE, orangeCar_v, false),
                new Car(new Position(1,0), new Position(0,0), Orientation.HORIZONTALE, lightGreenCar_h, false),
                new Car(new Position(0,2), new Position(0,1), Orientation.VERTICALE, aquaCar_v, false),
                new Truck(new Position(5,1), new Position(4,1),new Position(3,1), Orientation.HORIZONTALE, yellowTruck_h),
                new Car(new Position(4,3), new Position(4,2), Orientation.VERTICALE, pinkCar_v, false),
                new Truck(new Position(4,4), new Position(3,4),new Position(2,4), Orientation.HORIZONTALE, redTruck_h),
                new Car(new Position(1,4), new Position(0,4), Orientation.HORIZONTALE, purpleCar_h, false),
                new Car(new Position(5,5), new Position(5,4), Orientation.VERTICALE, darkGreenCar_v, false)));
    }

    public void level15(){
        //Initialize the constraint
        ConstraintSet set = new ConstraintSet();

        //Set all the Image with the guidelines
        createCarConstraint(set, whiteCar_h, Y3, Y5, X2, X3);
        createCarConstraint(set, greyCar_h, Y3, Y5, X3, X4);
        createCarConstraint(set, purpleCar_v, Y5, Y6, X2, X4);
        createCarConstraint(set, yellowCar_v, Y5, Y6, X4, X6);
        createCarConstraint(set, redCar_v, Y4, Y5, X4, X6);
        createCarConstraint(set, redTruck_h, Y3, Y6, X1, X2);
        createCarConstraint(set, aquaCar_h, Y4, Y6, X0, X1);
        createCarConstraint(set, orangeCar_h, Y2, Y4, X0, X1);
        createCarConstraint(set, lightGreenCar_v, Y1, Y2, X0, X2);
        createCarConstraint(set, pinkCar_v, Y1, Y2, X2, X4);
        createCarConstraint(set, darkGreenCar_v, Y0, Y1, X3, X5);
        createCarConstraint(set, yellowTruck_v, Y0, Y1, X0, X3);
        createCarConstraint(set, blueTruck_h, Y1, Y4, X4, X5);
        createCarConstraint(set, greenTruck_h, Y0, Y3, X5, X6);

        //Apply it to the constraint layout
        set.applyTo(constraint);

        //Instanciate Level
        lvl = new Level(15);

        lvl.setListOfVehicle(Arrays.asList(
                new Car(new Position(4,2), new Position(3,2), Orientation.HORIZONTALE, whiteCar_h, true),
                new Car(new Position(4,3), new Position(3,3), Orientation.HORIZONTALE, greyCar_h, false),
                new Car(new Position(5,3), new Position(5,2), Orientation.VERTICALE, purpleCar_v, false),
                new Car(new Position(5,5), new Position(5,4), Orientation.VERTICALE, yellowCar_v, false),
                new Car(new Position(4,5), new Position(4,4), Orientation.VERTICALE, redCar_v, false),
                new Truck(new Position(5,1), new Position(4,1),new Position(3,1), Orientation.HORIZONTALE, redTruck_h),
                new Car(new Position(5,0), new Position(4,0), Orientation.HORIZONTALE, aquaCar_h, false),
                new Car(new Position(3,0), new Position(2,0), Orientation.HORIZONTALE, orangeCar_h, false),
                new Car(new Position(1,1), new Position(1,0), Orientation.VERTICALE, lightGreenCar_v, false),
                new Car(new Position(1,3), new Position(1,2), Orientation.VERTICALE, pinkCar_v, false),
                new Car(new Position(0,4), new Position(0,3), Orientation.VERTICALE, darkGreenCar_v, false),
                new Truck(new Position(0,2), new Position(0,1),new Position(0,0), Orientation.VERTICALE, yellowTruck_v),
                new Truck(new Position(3,4), new Position(2,4),new Position(1,4), Orientation.HORIZONTALE, blueTruck_h),
                new Truck(new Position(2,5), new Position(1,5),new Position(0,5), Orientation.HORIZONTALE, greenTruck_h)));
    }
    
    public void level16(){
        //Initialize the constraint
        ConstraintSet set = new ConstraintSet();

        //Set all the Image with the guidelines
        createCarConstraint(set, whiteCar_h, Y0, Y2, X2, X3);
        createCarConstraint(set, redCar_h, Y0, Y2, X3, X4);
        createCarConstraint(set, yellowCar_v, Y0, Y1, X4, X6);
        createCarConstraint(set, yellowTruck_h, Y1, Y4, X4, X5);
        createCarConstraint(set, redTruck_h, Y1, Y4, X5, X6);
        createCarConstraint(set, blueCar_v, Y4, Y5, X4, X6);
        createCarConstraint(set, orangeCar_v, Y5, Y6, X4, X6);
        createCarConstraint(set, pinkCar_v, Y2, Y3, X2, X4);
        createCarConstraint(set, purpleCar_v, Y3, Y4, X2, X4);
        createCarConstraint(set, darkGreenCar_v, Y4, Y5, X2, X4);
        createCarConstraint(set, greyCar_v, Y5, Y6, X2, X4);
        createCarConstraint(set, aquaCar_h, Y4, Y6, X1, X2);
        createCarConstraint(set, orangeCar_h, Y4, Y6, X0, X1);
        createCarConstraint(set, lightGreenCar_v, Y3, Y4, X0, X2);

        //Apply it to the constraint layout
        set.applyTo(constraint);

        //Instanciate Level
        lvl = new Level(16);

        lvl.setListOfVehicle(Arrays.asList(
                new Car(new Position(1,2), new Position(0,2), Orientation.HORIZONTALE, whiteCar_h, true),
                new Car(new Position(1,3), new Position(0,3), Orientation.HORIZONTALE, redCar_h, false),
                new Car(new Position(0,5), new Position(0,4), Orientation.VERTICALE, yellowCar_v, false),
                new Truck(new Position(3,4), new Position(2,4),new Position(1,4), Orientation.HORIZONTALE, yellowTruck_h),
                new Truck(new Position(3,5), new Position(2,5),new Position(1,5), Orientation.HORIZONTALE, redTruck_h),
                new Car(new Position(4,5), new Position(4,4), Orientation.VERTICALE, blueCar_v, false),
                new Car(new Position(5,5), new Position(5,4), Orientation.VERTICALE, orangeCar_v, false),
                new Car(new Position(2,3), new Position(2,3), Orientation.VERTICALE, pinkCar_v, false),
                new Car(new Position(3,3), new Position(3,2), Orientation.VERTICALE, purpleCar_v, false),
                new Car(new Position(4,3), new Position(4,2), Orientation.VERTICALE, darkGreenCar_v, false),
                new Car(new Position(5,3), new Position(5,2), Orientation.VERTICALE, greyCar_v, false),
                new Car(new Position(5,1), new Position(4,1), Orientation.HORIZONTALE, aquaCar_h, false),
                new Car(new Position(5,0), new Position(4,0), Orientation.HORIZONTALE, orangeCar_h, false),
                new Car(new Position(3,1), new Position(3,0), Orientation.VERTICALE, lightGreenCar_v, false)));
    }

    public void level17(){
        //Initialize the constraint
        ConstraintSet set = new ConstraintSet();

        //Set all the Image with the guidelines
        createCarConstraint(set, whiteCar_h, Y0, Y2, X2, X3);
        createCarConstraint(set, aquaCar_h, Y0, Y2, X1, X2);
        createCarConstraint(set, yellowTruck_h, Y0, Y3, X0, X1);
        createCarConstraint(set, pinkCar_v, Y2, Y3, X1, X3);
        createCarConstraint(set, lightGreenCar_h, Y3, Y5, X0, X1);
        createCarConstraint(set, purpleCar_h, Y3, Y5, X1, X2);
        createCarConstraint(set, orangeCar_v, Y5, Y6, X0, X2);
        createCarConstraint(set, darkGreenCar_v, Y5, Y6, X2, X4);
        createCarConstraint(set, greyCar_v, Y4, Y5, X3, X5);
        createCarConstraint(set, redTruck_v, Y3, Y4, X2, X5);
        createCarConstraint(set, yellowCar_h, Y1, Y3, X4, X5);
        createCarConstraint(set, redCar_v, Y0, Y1, X4, X6);
        createCarConstraint(set, blueCar_h, Y4, Y6, X5, X6);
        createCarConstraint(set, blueTruck_h, Y1, Y4, X5, X6);

        //Apply it to the constraint layout
        set.applyTo(constraint);

        //Instanciate Level
        lvl = new Level(17);

        lvl.setListOfVehicle(Arrays.asList(
                new Car(new Position(1,2), new Position(0,2), Orientation.HORIZONTALE, whiteCar_h, true),
                new Car(new Position(1,1), new Position(0,1), Orientation.HORIZONTALE, aquaCar_h, false),
                new Truck(new Position(2,0), new Position(1,0),new Position(0,0), Orientation.HORIZONTALE, yellowTruck_h),
                new Car(new Position(2,2), new Position(2,1), Orientation.VERTICALE, pinkCar_v, false),
                new Car(new Position(4,0), new Position(3,0), Orientation.HORIZONTALE, lightGreenCar_h, false),
                new Car(new Position(4,1), new Position(3,1), Orientation.HORIZONTALE, purpleCar_h, false),
                new Car(new Position(5,1), new Position(5,0), Orientation.VERTICALE, orangeCar_v, false),
                new Car(new Position(5,3), new Position(5,2), Orientation.VERTICALE, darkGreenCar_v, false),
                new Car(new Position(4,4), new Position(4,3), Orientation.VERTICALE, greyCar_v, false),
                new Truck(new Position(3,4), new Position(3,3),new Position(3,2), Orientation.VERTICALE, redTruck_v),
                new Car(new Position(2,4), new Position(1,4), Orientation.HORIZONTALE, yellowCar_h, false),
                new Car(new Position(0,5), new Position(0,4), Orientation.VERTICALE, redCar_v, false),
                new Car(new Position(5,5), new Position(4,5), Orientation.HORIZONTALE, blueCar_h, false),
                new Truck(new Position(3,5), new Position(2,5),new Position(1,5), Orientation.HORIZONTALE, blueTruck_h)));
    }

    public void level18(){

        //Initialize the constraint
        ConstraintSet set = new ConstraintSet();

        //Set all the Image with the guidelines
        createCarConstraint(set, whiteCar_h, Y1, Y3, X2, X3);
        createCarConstraint(set, lightGreenCar_v, Y1, Y2, X0, X2);
        createCarConstraint(set, yellowTruck_h, Y2, Y5, X0, X1);
        createCarConstraint(set, orangeCar_v, Y5, Y6, X0, X2);
        createCarConstraint(set, redTruck_v, Y5, Y6, X2, X5);
        createCarConstraint(set, pinkCar_v, Y4, Y5, X2, X4);
        createCarConstraint(set, aquaCar_v, Y3, Y4, X2, X4);
        createCarConstraint(set, greenTruck_h, Y3, Y6, X5, X6);
        createCarConstraint(set, greyCar_h, Y3, Y5, X4, X5);
        createCarConstraint(set, blueTruck_v, Y2, Y3, X3, X6);
        createCarConstraint(set, purpleCar_h, Y0, Y2, X3, X4);
        createCarConstraint(set, darkGreenCar_v, Y0, Y1, X4, X6);

        //Apply it to the constraint layout
        set.applyTo(constraint);

        //Instanciate Level
        lvl = new Level(18);

        lvl.setListOfVehicle(Arrays.asList(
                new Car(new Position(2,2), new Position(1,2), Orientation.HORIZONTALE, whiteCar_h, true),
                new Car(new Position(1,1), new Position(1,0), Orientation.VERTICALE, lightGreenCar_v, false),
                new Truck(new Position(4,0), new Position(3,0),new Position(2,0), Orientation.HORIZONTALE, yellowTruck_h),
                new Car(new Position(5,1), new Position(5,0), Orientation.VERTICALE, orangeCar_v, false),
                new Truck(new Position(5,4), new Position(5,3),new Position(5,2), Orientation.VERTICALE, redTruck_v),
                new Car(new Position(4,3), new Position(4,2), Orientation.VERTICALE, pinkCar_v, false),
                new Car(new Position(3,3), new Position(3,2), Orientation.VERTICALE, aquaCar_v, false),
                new Truck(new Position(5,5), new Position(4,5),new Position(3,5), Orientation.HORIZONTALE, greenTruck_h),
                new Car(new Position(4,4), new Position(3,4), Orientation.HORIZONTALE, greyCar_h, false),
                new Truck(new Position(2,5), new Position(2,4),new Position(2,3), Orientation.VERTICALE, blueTruck_v),
                new Car(new Position(1,3), new Position(0,3), Orientation.HORIZONTALE, purpleCar_h, false),
                new Car(new Position(0,5), new Position(0,4), Orientation.VERTICALE, darkGreenCar_v, false)));

    }

    public void level19(){

    }

    public void level20(){

    }

    public void level21(){

    }

    public void level22(){

    }

    public void level23(){

    }

    public void level24(){

    }

    public void level25(){

    }

    public void level26(){

    }

    public void level27(){

    }

    public void level28(){

    }

    public void level29(){

    }

    public void level30(){

    }

    public void level31(){

    }

    public void level32(){

    }

    public void level33(){

    }

    public void level34(){

    }

    public void level35(){

    }

    public void level36(){

    }

    public void level37(){

    }

    public void level38(){

    }

    public void level39(){

    }

    public void level40() {

        //Initialize the constraint
        ConstraintSet set = new ConstraintSet();

        //Set all the Image with the guidelines
        createCarConstraint(set, whiteCar_h, Y0, Y2, X2, X3);
        createCarConstraint(set, lightGreenCar_v, Y0, Y1, X0, X2);
        createCarConstraint(set, orangeCar_h, Y1, Y3, X0, X1);
        createCarConstraint(set, yellowTruck_h, Y3, Y6, X0, X1);
        createCarConstraint(set, aquaCar_h, Y2, Y4, X1, X2);
        createCarConstraint(set, pinkCar_v, Y4, Y5, X1, X3);
        createCarConstraint(set, darkGreenCar_h, Y0, Y2, X3, X4);
        createCarConstraint(set, blueCar_v, Y2, Y3, X2, X4);
        createCarConstraint(set, greyCar_h, Y3, Y5, X3, X4);
        createCarConstraint(set, redCar_h, Y1, Y3, X4, X5);
        createCarConstraint(set, blueTruck_h, Y0, Y3, X5, X6);
        createCarConstraint(set, yellowCar_v, Y3, Y4, X4, X6);
        createCarConstraint(set, redTruck_v, Y5, Y6, X3, X6);

        //Apply it to the constraint layout
        set.applyTo(constraint);

        //Instanciate Level
        lvl = new Level(40);

        lvl.setListOfVehicle(Arrays.asList(
            new Car(new Position(1,2), new Position(0,2), Orientation.HORIZONTALE, whiteCar_h, true),
            new Car(new Position(0,1), new Position(0,0), Orientation.VERTICALE, lightGreenCar_v, false),
            new Car(new Position(2,0), new Position(1,0), Orientation.HORIZONTALE, orangeCar_h, false),
            new Truck(new Position(5,0), new Position(4,0), new Position(3,0), Orientation.HORIZONTALE, yellowTruck_h),
            new Car(new Position(3,1), new Position(2,1), Orientation.HORIZONTALE, aquaCar_h, false),
            new Car(new Position(4,2), new Position(4,1), Orientation.VERTICALE, pinkCar_v, false),
            new Car(new Position(1,3), new Position(0,3), Orientation.HORIZONTALE, darkGreenCar_h, false),
            new Car(new Position(2,3), new Position(2,2), Orientation.VERTICALE, blueCar_v, false),
            new Car(new Position(4, 3), new Position(3,3), Orientation.HORIZONTALE, greyCar_h, false),
            new Car(new Position(2, 4), new Position(1,4), Orientation.HORIZONTALE, redCar_h, false),
            new Truck(new Position(2,5), new Position(1,5), new Position(0,5), Orientation.HORIZONTALE, blueTruck_h),
            new Car(new Position(3, 5), new Position(3,4), Orientation.VERTICALE, yellowCar_v, false),
            new Truck(new Position(5,5), new Position(5,4), new Position(5,3), Orientation.VERTICALE, redTruck_v)));

    }

    //Getter
    public Level getLvl() {
        return lvl;
    }
}
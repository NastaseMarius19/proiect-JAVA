package src.domain;

import src.persistence.GenericRestaurant;

import java.util.ArrayList;

public class RestaurantCoffe extends Restaurant implements GenericRestaurant<String > {

    private ArrayList<String> sizeCup;

    public RestaurantCoffe(String name, String address, ArrayList<String> menu) {
        super(name, address, menu);
    }

    public ArrayList<String> getSizeCup() {
        return sizeCup;
    }

    @Override
    public String toString() {
        return super.toString() + sizeCup + '\'' +
                '}';
    }

    public void setSizeCup(ArrayList<String > sizeCup){
        this.sizeCup = sizeCup;
    }


}

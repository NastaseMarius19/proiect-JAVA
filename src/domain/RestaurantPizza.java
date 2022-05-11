package src.domain;

import src.persistence.GenericRestaurant;

import java.util.ArrayList;
import java.util.Scanner;


public class RestaurantPizza extends Restaurant implements GenericRestaurant<String> {

    private ArrayList<String> doughOpions;

    public ArrayList<String> getDough() {
        return doughOpions;
    }


    public RestaurantPizza(String name, String address, ArrayList<String> menu) {
        super(name, address, menu);
    }

    @Override
    public String toString() {
        return super.toString() + doughOpions + '\'' +
                '}';
    }

    public void setDoughOpions(ArrayList<String > doughOpions){
        this.doughOpions = doughOpions;
    }
}
package src.domain;

import src.persistence.GenericRestaurant;

import java.util.ArrayList;

public class RestaurantSusshi  extends RestaurantPizza implements GenericRestaurant<String > {

    private ArrayList<String > toppings;

    public ArrayList<String> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<String> toppings) {
        this.toppings = toppings;
    }

    public RestaurantSusshi(String name, String address, ArrayList<String> menu) {
        super(name, address, menu);
    }

    @Override
    public String toString() {
        return super.toString() +
                "toppings=" + toppings +
                '}';
    }
}

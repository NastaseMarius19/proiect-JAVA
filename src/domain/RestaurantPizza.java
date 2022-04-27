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

    public void setDoughOpions() {
        System.out.println("Enter the noumber of options to add:");
        Scanner keyboard = new Scanner(System.in);
        int optionsNr = keyboard.nextInt();
        ArrayList<String> options = new ArrayList<>();
        for (int i = 0; i < optionsNr; i++) {
            System.out.println("Enter the " + i + " option:");
            options.add(keyboard.next());
        }
        doughOpions = options;
    }
}
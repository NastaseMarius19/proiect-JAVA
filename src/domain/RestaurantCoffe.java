package src.domain;

import src.persistence.GenericRestaurant;

import java.util.ArrayList;
import java.util.Scanner;

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

    public void setSizeCup(){
        System.out.println("Enter the noumber of options to add:");
        Scanner keyboard = new Scanner(System.in);
        int optionsNr = keyboard.nextInt();
        ArrayList<String> options = new ArrayList<>();
        for (int i = 0; i < optionsNr ; i++)
        {
            System.out.println("Enter the size cup " + (i+1) + " option:");
            options.add(keyboard.next());
        }
        sizeCup = options;
    }

}

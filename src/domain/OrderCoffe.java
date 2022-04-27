package src.domain;

import java.util.Scanner;

public class OrderCoffe extends Order{
    public String getOptionCoffe() {
        return optionCoffe;
    }

    public String getOptionSizeCup() {
        return optionSizeCup;
    }

    private String optionCoffe;
    private String optionSizeCup;

    @Override
    public String toString() {
        return super.toString() + optionCoffe + " " + optionSizeCup +
                '}';
    }

    public void chooseCoffe(RestaurantCoffe restaurantCoffe) {
        Scanner keyboard = new Scanner(System.in);
        int optionCoffe;
        System.out.println("Choose your coffe from the menu:");
        for(int i = 0; i < restaurantCoffe.getMenu().size(); i++)
        {
            System.out.println(i + " - " + restaurantCoffe.getMenu().get(i));
        }
        optionCoffe = keyboard.nextInt();
        if(optionCoffe >= 0 && optionCoffe < restaurantCoffe.getMenu().size()){
            this.optionCoffe = restaurantCoffe.getMenu().get(optionCoffe);
        }
        else System.out.println("Option invalid");
    }

    public void chooseSizeCup(RestaurantCoffe restaurantCoffe){
        Scanner keyboard = new Scanner(System.in);
        int optionSizeCup;
        System.out.println("Choose the size from:");
        for (int i = 0; i < restaurantCoffe.getSizeCup().size(); i++){
            System.out.println(i + " - " + restaurantCoffe.getSizeCup().get(i));
        }
        optionSizeCup = keyboard.nextInt();
        if(optionSizeCup >= 0 && optionSizeCup < restaurantCoffe.getSizeCup().size()){
            this.optionSizeCup = restaurantCoffe.getSizeCup().get(optionSizeCup);
        }
        else System.out.println("Invalid option");
    }
}

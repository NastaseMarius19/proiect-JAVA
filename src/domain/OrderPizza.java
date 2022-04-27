package src.domain;

import java.util.Scanner;

public class OrderPizza extends Order{
    private String doughOption;

    @Override
    public String toString() {
        return
                super.toString()+ doughOption + '\'' +
                '}';
    }

    public String getDoughOption() {
        return doughOption;
    }

    public void chooseDoughPizza(RestaurantPizza restaurantPizza){
        int option;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Choose your dough from:");
        for (int i = 0; i < restaurantPizza.getDough().size(); i++){
            System.out.print((i+1) + ": ");
            System.out.println(restaurantPizza.getDough().get(i));
        }
        option = keyboard.nextInt();
        if (option > 0 && option < restaurantPizza.getDough().size())
            doughOption = restaurantPizza.getDough().get(option);
        else {
            System.out.println("Invail dough option");
            System.exit(1);
        }
        }

}

package src.domain;

import java.util.Scanner;

public class OrderPizza extends Order{
    private String doughOption;
    private String pizzaOption;

    public String getPizzaOption() {
        return pizzaOption;
    }

    public void setPizzaOption(String pizzaOption) {
        this.pizzaOption = pizzaOption;
    }

    public OrderPizza(String nameRestaurant, String homeAddress, String payMethod, String doughOption, String pizzaOption) {
        super(nameRestaurant, homeAddress, payMethod);
        this.doughOption = doughOption;
        this.pizzaOption = pizzaOption;
    }

    @Override
    public String toString() {
        return
                super.toString()+ "doughOption=" + '\'' + doughOption + '\'' + "," + "pizzaOption=" + '\'' + pizzaOption  + '\'' +
                '}';
    }

    public String getDoughOption() {
        return doughOption;
    }

    public void setDoughOption(String doughOption) {
        this.doughOption = doughOption;
    }
}

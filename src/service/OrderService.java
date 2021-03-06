package src.service;

import src.domain.*;
import src.exceptions.InvalidDataException;
import src.persistence.OrderRepository;
import src.persistence.RestaurantRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderService {
    private final OrderRepository orderRepository = new OrderRepository();

    public void registerNewPizzaOrder(OrderPizza newPizzaOrder) throws InvalidDataException {
        if (newPizzaOrder.getHomeAddress() == null || newPizzaOrder.getHomeAddress().trim().isEmpty())
        {
            throw new InvalidDataException("Invalid order address");
        }
        if(newPizzaOrder.getNameRestaurant() == null || newPizzaOrder.getNameRestaurant().trim().isEmpty())
        {
            throw new InvalidDataException("Invalid restaurant for oder");
        }
        if(newPizzaOrder.getPayMethod() == null || newPizzaOrder.getPayMethod().trim().isEmpty())
        {
            throw new InvalidDataException("Invalid payment method for the order");
        }
        if(newPizzaOrder.getDoughOption() == null || newPizzaOrder.getDoughOption().trim().isEmpty())
        {
            throw new InvalidDataException("Invalid dough for the order");
        }
        orderRepository.add(newPizzaOrder);
    }

    public OrderRepository getOrderRepository() {
        return orderRepository;
    }

    public void registerNewCoffeOrder(OrderCoffe newCoffeOrder) throws InvalidDataException {
        if (newCoffeOrder.getHomeAddress() == null || newCoffeOrder.getHomeAddress().trim().isEmpty())
        {
            throw new InvalidDataException("Invalid order address");
        }
        if(newCoffeOrder.getNameRestaurant() == null || newCoffeOrder.getNameRestaurant().trim().isEmpty())
        {
            throw new InvalidDataException("Invalid restaurant for oder");
        }
        if(newCoffeOrder.getPayMethod() == null || newCoffeOrder.getPayMethod().trim().isEmpty())
        {
            throw new InvalidDataException("Invalid payment method for the order");
        }
        if (newCoffeOrder.getOptionCoffe() == null || newCoffeOrder.getOptionCoffe().trim().isEmpty())
        {
            throw new InvalidDataException("Invalid coffe option");
        }
        if (newCoffeOrder.getOptionSizeCup() == null || newCoffeOrder.getOptionSizeCup().trim().isEmpty())
        {
            throw new InvalidDataException("Invalid size cup option");
        }

        orderRepository.add(newCoffeOrder);

    }

    public void registerNewSushiOrder(OrderSushi newSushiOrder) throws InvalidDataException {
        if (newSushiOrder.getHomeAddress() == null || newSushiOrder.getHomeAddress().trim().isEmpty())
        {
            throw new InvalidDataException("Invalid order address");
        }
        if(newSushiOrder.getNameRestaurant() == null || newSushiOrder.getNameRestaurant().trim().isEmpty())
        {
            throw new InvalidDataException("Invalid restaurant for oder");
        }
        if(newSushiOrder.getPayMethod() == null || newSushiOrder.getPayMethod().trim().isEmpty())
        {
            throw new InvalidDataException("Invalid payment method for the order");
        }

        orderRepository.add(newSushiOrder);

    }
    public void getALL(){
        for (int i = 0; i < orderRepository.getSize(); i++)
        {
            System.out.println(orderRepository.get(i));
        }
    }

    public void setOrder(Order order){
        System.out.println("Enter your address:");
        Scanner keyboard = new Scanner(System.in);
        String address = keyboard.next();
        order.setHomeAddress(address);
        System.out.println("Choose paymant method: 1 for card 2 for cash");
        int option = keyboard.nextInt();
        switch (option){
            case 1:
                order.setPayMethod("card");
                break;
            case 2:
                order.setPayMethod("cash");
                break;
        }
        if (option != 1 && option != 2){
            System.out.println("Invalid paymant option");
            System.exit(1);
        }
    }

    public void setCoffeRestaurant(RestaurantRepository restaurantRepository, Order order){
        System.out.println("Choose the restaurant from the list below:");
        Scanner keyboard = new Scanner(System.in);
        List<String> coffeRestaurants = new ArrayList<>();
        for (int i = 0; i < restaurantRepository.getSize(); i++){
            if(restaurantRepository.get(i).getClass() == RestaurantCoffe.class)
                coffeRestaurants.add(restaurantRepository.get(i).getName());
        }
        int option;
        if(coffeRestaurants.size() != 0) {
            for (int i = 0; i < coffeRestaurants.size(); i++)
                System.out.println(i + coffeRestaurants.get(i));
            option = keyboard.nextInt();
        }
        else option = -1;

        if(option >= 0 && option < coffeRestaurants.size())
        {
            order.setNameRestaurant(coffeRestaurants.get(option));
        }
    }

    public void setSushiRestaurant(RestaurantRepository restaurantRepository, Order order){
        System.out.println("Choose the restaurant from the list below:");
        Scanner keyboard = new Scanner(System.in);
        List<String> sushiRestaurants = new ArrayList<>();
        for (int i = 0; i < restaurantRepository.getSize(); i++){
            if(restaurantRepository.get(i).getClass() == RestaurantSusshi.class)
                sushiRestaurants.add(restaurantRepository.get(i).getName());
        }
        int option;
        if(sushiRestaurants.size() != 0) {
            for (int i = 0; i < sushiRestaurants.size(); i++)
                System.out.println(i + sushiRestaurants.get(i));
            option = keyboard.nextInt();
        }
        else option = -1;

        if(option >= 0 && option < sushiRestaurants.size())
        {
            order.setNameRestaurant(sushiRestaurants.get(option));
        }
    }

    public void setPizzaRestaurant(RestaurantRepository restaurantRepository, Order order){
        System.out.println("Choose the restaurant from the list below:");
        Scanner keyboard = new Scanner(System.in);
        List<String> coffeRestaurants = new ArrayList<>();
        for (int i = 0; i < restaurantRepository.getSize(); i++){
            if(restaurantRepository.get(i).getClass() == RestaurantPizza.class)
                coffeRestaurants.add(restaurantRepository.get(i).getName());
        }
        int option;
        if(coffeRestaurants.size() != 0) {
            for (int i = 0; i < coffeRestaurants.size(); i++)
                System.out.println(i + coffeRestaurants.get(i));
            option = keyboard.nextInt();
        }
        else option = -1;

        if(option >= 0 && option < coffeRestaurants.size())
        {
            order.setNameRestaurant(coffeRestaurants.get(option));
        }
    }

    public void chooseDoughPizza(RestaurantPizza restaurantPizza, OrderPizza orderPizza){
        int option;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Choose your dough from:");
        for (int i = 0; i < restaurantPizza.getDough().size(); i++){
            System.out.print((i+1) + ": ");
            System.out.println(restaurantPizza.getDough().get(i));
        }
        option = keyboard.nextInt();
        if (option > 0 && option < restaurantPizza.getDough().size())
            orderPizza.setDoughOption(restaurantPizza.getDough().get(option));
        else {
            System.out.println("Invail dough option");
            System.exit(1);
        }
    }
    public void choosePizzaOption(RestaurantPizza restaurantPzza, OrderPizza orderPizza) {
        Scanner keyboard = new Scanner(System.in);
        int optionPizza;
        System.out.println("Choose your pizza from the menu:");
        for(int i = 0; i < restaurantPzza.getMenu().size(); i++)
        {
            System.out.println(i + " - " + restaurantPzza.getMenu().get(i));
        }
        optionPizza = keyboard.nextInt();
        if(optionPizza >= 0 && optionPizza < restaurantPzza.getMenu().size()){
            orderPizza.setPizzaOption(restaurantPzza.getMenu().get(optionPizza));
        }
        else System.out.println("Option invalid");
    }
    public void chooseCoffe(RestaurantCoffe restaurantCoffe, OrderCoffe orderCoffe) {
        Scanner keyboard = new Scanner(System.in);
        int optionCoffe;
        System.out.println("Choose your coffe from the menu:");
        for(int i = 0; i < restaurantCoffe.getMenu().size(); i++)
        {
            System.out.println(i + " - " + restaurantCoffe.getMenu().get(i));
        }
        optionCoffe = keyboard.nextInt();
        if(optionCoffe >= 0 && optionCoffe < restaurantCoffe.getMenu().size()){
            orderCoffe.setOptionCoffe(restaurantCoffe.getMenu().get(optionCoffe));
        }
        else System.out.println("Option invalid");
    }

    public void chooseSushi(RestaurantSusshi restaurantSushi, OrderSushi orderSushi) {
        Scanner keyboard = new Scanner(System.in);
        int optionSushi;
        System.out.println("Choose your coffe from the menu:");
        for(int i = 0; i < restaurantSushi.getMenu().size(); i++)
        {
            System.out.println(i + " - " + restaurantSushi.getMenu().get(i));
        }
        optionSushi = keyboard.nextInt();
        if(optionSushi >= 0 && optionSushi < restaurantSushi.getMenu().size()){
            orderSushi.setMenuOption(restaurantSushi.getMenu().get(optionSushi));
        }
        else System.out.println("Option invalid");
    }

    public void chooseSizeCup(RestaurantCoffe restaurantCoffe, OrderCoffe orderCoffe){
        Scanner keyboard = new Scanner(System.in);
        int optionSizeCup;
        System.out.println("Choose the size from:");
        for (int i = 0; i < restaurantCoffe.getSizeCup().size(); i++){
            System.out.println(i + " - " + restaurantCoffe.getSizeCup().get(i));
        }
        optionSizeCup = keyboard.nextInt();
        if(optionSizeCup >= 0 && optionSizeCup < restaurantCoffe.getSizeCup().size()){
            orderCoffe.setOptionSizeCup(restaurantCoffe.getSizeCup().get(optionSizeCup));
        }
        else System.out.println("Invalid option");
    }

    public void chooseExtraTopping(RestaurantSusshi restaurantSusshi, OrderSushi orderSushi){
        Scanner keyboard = new Scanner(System.in);
        int extraTopping;
        System.out.println("Choose the extra topping from:");
        for (int i = 0; i < restaurantSusshi.getToppings().size(); i++){
            System.out.println(i + " - " + restaurantSusshi.getToppings().get(i));
        }
        extraTopping = keyboard.nextInt();
        if(extraTopping >= 0 && extraTopping < restaurantSusshi.getToppings().size()){
            orderSushi.setExtraTopping(restaurantSusshi.getToppings().get(extraTopping));
        }
        else System.out.println("Invalid option");
    }

}

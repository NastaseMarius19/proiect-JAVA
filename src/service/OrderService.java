package src.service;

import src.domain.*;
import src.exceptions.InvalidDataException;
import src.persistence.OrderRepository;
import src.persistence.RestaurantRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderService implements GenericOrderCSV {
    private OrderRepository orderRepository = new OrderRepository();

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
            if(restaurantRepository.get(i).getClass() == (new RestaurantCoffe(null, null, null)).getClass())
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
            if(restaurantRepository.get(i).getClass() == (new RestaurantSusshi(null, null, null)).getClass())
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
            if(restaurantRepository.get(i).getClass() == (new RestaurantPizza(null, null, null)).getClass())
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


    @Override
    public void read() throws IOException {
        String line = "";
        try {
            BufferedReader file1 = new BufferedReader(new FileReader("files/ordersCoffee.csv"));
            BufferedReader file2 = new BufferedReader(new FileReader("files/ordersPizza.csv"));
            BufferedReader file3 = new BufferedReader(new FileReader("files/ordersSushi.csv"));
            while ((line = file1.readLine()) != null){
                String[] values = line.split(",");
                OrderCoffe orderCoffe = new OrderCoffe(values[0], values[1], values[2], values[3], values[4]);
                orderRepository.add(orderCoffe);
            }
            while ((line = file2.readLine()) != null){
                String[] values = line.split(",");
                OrderPizza orderPizza = new OrderPizza(values[0], values[1], values[2], values[3]);
                orderRepository.add(orderPizza);
            }
            while ((line = file3.readLine()) != null){
                String[] values = line.split(",");
                OrderSushi orderSushi = new OrderSushi(values[0], values[1], values[2], values[3]);
                orderRepository.add(orderSushi);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    public void writePizzaOrder(OrderPizza object) throws IOException {
        try{
            FileWriter fw = new FileWriter("files/ordersPizza.csv",true);
            fw.write("\n" + object.getId() + "," + object.getNameRestaurant() + "," + object.getHomeAddress()
                    + "," + object.getPayMethod() + "," + object.getDoughOption()
                    + ",");
            fw.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void writeCoffeOrder(OrderCoffe object) throws IOException {
        try{
            FileWriter fw = new FileWriter("files/ordersCoffee.csv",true);
            fw.write("\n" + object.getId() + "," + object.getNameRestaurant() + "," + object.getHomeAddress()
                    + "," + object.getPayMethod() + "," + object.getOptionCoffe() + "," + object.getOptionSizeCup()
                    + ",");
            fw.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void writeSushiOrder(OrderSushi object) throws IOException {
        try{
            FileWriter fw = new FileWriter("files/ordersSushi.csv",true);
            fw.write("\n" + object.getId() + "," + object.getNameRestaurant() + "," + object.getHomeAddress()
                    + "," + object.getPayMethod() + "," + object.getExtraTopping()
                    + ",");
            fw.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

}

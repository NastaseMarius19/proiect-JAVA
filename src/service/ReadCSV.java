package src.service;

import src.domain.*;
import src.exceptions.InvalidDataException;
import sun.rmi.runtime.Log;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class ReadCSV {
    private static ReadCSV rcsv = null;

    public ReadCSV() {
    }

    public static ReadCSV getInstance() {
        if(rcsv == null)
            rcsv = new ReadCSV();
        return rcsv;
    }

    private void read_orderCoffe(OrderService s) throws IOException, InvalidDataException {
        File f = new File("files/ordersCoffee.csv");
        Scanner sc = new Scanner(f);
        sc.useDelimiter(",");
        while (sc.hasNext())
        {
            s.registerNewCoffeOrder(new OrderCoffe(sc.next(),
                    sc.next(),
                    sc.next(),
                    sc.next(),
                    sc.next()));
        }
        sc.close();
    }

    private void read_orderPizza(OrderService s) throws IOException, InvalidDataException {
        File f = new File("files/ordersPizza.csv");
        Scanner sc = new Scanner(f);
        sc.useDelimiter(",");
        while (sc.hasNext())
        {
            s.registerNewPizzaOrder(new OrderPizza(sc.next(),
                    sc.next(),
                    sc.next(),
                    sc.next(),
                    sc.next()));
        }
        sc.close();
    }

    private void read_orderSushi(OrderService s) throws IOException, InvalidDataException {
        File f = new File("files/ordersPizza.csv");
        Scanner sc = new Scanner(f);
        sc.useDelimiter(",");
        while (sc.hasNext())
        {
            s.registerNewSushiOrder(new OrderSushi(sc.next(),
                    sc.next(),
                    sc.next(),
                    sc.next(),
                    sc.next()));
        }
        sc.close();
    }

    public void read_coffeeRestaurant(RestaurantService s) throws IOException, InvalidDataException {
        BufferedReader file1 = new BufferedReader(new FileReader("files/coffeeRestaurants.csv"));
        String line = "";
        while ((line = file1.readLine()) != null){
            String[] values = line.split(",");
            RestaurantCoffe restaurantCoffe = new RestaurantCoffe(values[0], values[1], null);
            ArrayList< String> newMenu = new ArrayList<>();
            int i = 2;
            do {
                newMenu.add(values[i]);
                i++;
            }while (!values[i-1].endsWith("]"));
            ArrayList< String> newSizeOptions = new ArrayList<>();
            for (int j = i; j < values.length; j++)
                newSizeOptions.add(values[j]);
            restaurantCoffe.setMenu(newMenu);
            restaurantCoffe.setSizeCup(newSizeOptions);
            s.registerCoffeRestaurant(restaurantCoffe);
        }
    }

    public void read_pizzaRestaurant(RestaurantService s) throws IOException, InvalidDataException {
        BufferedReader file2 = new BufferedReader(new FileReader("files/pizzaRestaurants.csv"));
        Scanner sc = new Scanner(file2);
        String line = "";
        while ((line = file2.readLine()) != null){
            String[] values = line.split(",");
            RestaurantPizza restaurantPizza = new RestaurantPizza(values[0], values[1], null);
            ArrayList< String> newMenu = new ArrayList<>();
            int i = 2;
            do {
                newMenu.add(values[i]);
                i++;
            }while (!values[i-1].endsWith("]"));
            ArrayList< String> newDoughOptions = new ArrayList<>();
            for (int j = i; j < values.length; j++)
                newDoughOptions.add(values[j]);
            restaurantPizza.setMenu(newMenu);
            restaurantPizza.setDoughOpions(newDoughOptions);
            s.registerPizzaRestaurant(restaurantPizza);
        }
    }

    public void read_sushiRestaurants(RestaurantService s) throws IOException, InvalidDataException {
        BufferedReader file3 = new BufferedReader(new FileReader("files/sushiRestaurants.csv"));
        Scanner sc = new Scanner(file3);
        String line = "";
        while ((line = file3.readLine()) != null){
            String[] values = line.split(",");
            RestaurantSusshi restaurantSusshi = new RestaurantSusshi(values[0], values[1], null);
            ArrayList< String> newMenu = new ArrayList<>();
            int i = 2;
            do {
                newMenu.add(values[i]);
                i++;
            }while (!values[i-1].endsWith("]"));
            ArrayList< String> newTopingOptions = new ArrayList<>();
            for (int j = i; j < values.length; j++)
                newTopingOptions.add(values[j]);
            restaurantSusshi.setMenu(newMenu);
            restaurantSusshi.setToppings(newTopingOptions);
            s.registerSushiRestaurant(restaurantSusshi);
        }
    }

    public void loadFiles(OrderService s, RestaurantService r) throws IOException, InvalidDataException {
        read_orderCoffe(s);
        read_orderPizza(s);
        read_orderSushi(s);
        read_coffeeRestaurant(r);
        read_pizzaRestaurant(r);
        read_sushiRestaurants(r);
    }
}

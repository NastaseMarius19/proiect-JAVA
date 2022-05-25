package src.service;

import src.domain.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV {
    private static WriteCSV wcsv = null;

    static File f = null;
    static FileWriter fw = null;
    static BufferedWriter bw = null;

    public WriteCSV() {
    }

    public static WriteCSV getInstance() {
        if(wcsv == null)
            wcsv = new WriteCSV();
        return wcsv;
    }

    void openFile(String path) {
        f = new File(path);
        try {
            fw = new FileWriter(f, true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        bw = new BufferedWriter(fw);
    }

    public void writeCoffeOrder(OrderCoffe oc) {
        try {
            openFile("files/ordersCoffee.csv");
            if(f.length() != 0)
                bw.newLine();
            bw.write(oc.getNameRestaurant() +
                    "," + oc.getHomeAddress() +
                    "," + oc.getPayMethod() +
                    "," + oc.getOptionCoffe() +
                    "," + oc.getOptionSizeCup() + ",");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writePizzaOrder(OrderPizza oc) {
        try {
            openFile("files/ordersPizza.csv");
            if(f.length() != 0)
                bw.newLine();
            bw.write(oc.getNameRestaurant() +
                    "," + oc.getHomeAddress() +
                    "," + oc.getPayMethod() +
                    "," + oc.getDoughOption() +
                    "," + oc.getPizzaOption() + ",");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeSushiOrder(OrderSushi oc) {
        try {
            openFile("files/ordersSushi.csv");
            if(f.length() != 0)
                bw.newLine();
            bw.write(oc.getNameRestaurant() +
                    "," + oc.getHomeAddress() +
                    "," + oc.getPayMethod() +
                    "," + oc.getExtraTopping() +
                    "," + oc.getMenuOption() + ",");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeCoffeRestaurant(RestaurantCoffe coffe){
        try {
            openFile("files/coffeeRestaurants.csv");
            if(f.length() != 0)
                bw.newLine();
            bw.write(coffe.getName() +
                    "," + coffe.getAddress() +
                    "," + coffe.getMenu() +
                    "," + coffe.getSizeCup() + ",");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writePizzaRestaurant(RestaurantPizza pizza){
        try {
            openFile("files/pizzaRestaurants.csv");
            if(f.length() != 0)
                bw.newLine();
            bw.write(pizza.getName() +
                    "," + pizza.getAddress() +
                    "," + pizza.getMenu() +
                    "," + pizza.getDough() + ",");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeSushiRestaurant(RestaurantSusshi sushi){
        try {
            openFile("files/sushiRestaurants.csv");
            if(f.length() != 0)
                bw.newLine();
            bw.write(sushi.getName() +
                    "," + sushi.getAddress() +
                    "," + sushi.getMenu() +
                    "," + sushi.getToppings() + ",");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

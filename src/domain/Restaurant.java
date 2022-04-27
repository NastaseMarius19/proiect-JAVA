package src.domain;

import src.persistence.GenericRestaurant;
import java.util.ArrayList;

public class Restaurant implements GenericRestaurant<String > {

    private static int id = 1;
    private String name;
    private String address;
    private ArrayList<String > menu = new ArrayList<>();

    public Restaurant(){
        id ++;
    }

    @Override
    public void add(String newFood) {
        menu.add(newFood);
    }

    @Override
    public String get(int index) {
        if(index > 0 && index < menu.size())
            return menu.get(index);
        else
            System.out.println("non-existing index");
        return null;
    }

    public Restaurant(String name, String address, ArrayList<String> menu) {
        this.name = name;
        this.address = address;
        this.menu = menu;

    }

    @Override
    public void delete(int index) {
        if(index > 0 && index < menu.size()) {
            menu.remove(index);
        }
        else System.out.println("non-existing index");
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getMenu() {
        return menu;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", menu=" + menu + ",";
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMenu(ArrayList<String> menu) {
        this.menu = menu;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public static int getId() {
        return id;
    }
}

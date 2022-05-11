package src.domain;

import src.persistence.RestaurantRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {

    private static int id = 1;
    private String nameRestaurant;
    private String homeAddress;
    private String payMethod;

    public Order(){
        id ++;
    }

    public Order(String nameRestaurant, String homeAddress, String payMethod) {
        this.nameRestaurant = nameRestaurant;
        this.homeAddress = homeAddress;
        this.payMethod = payMethod;
    }

    public String getNameRestaurant() {
        return nameRestaurant;
    }


    public String getHomeAddress() {
        return homeAddress;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public static int getId() {
        return id;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public void chooseHomeAddress(){
        System.out.println("Enter your address:");
        Scanner keyboard = new Scanner(System.in);
        String address = keyboard.next();
        this.homeAddress = address;
    }
    @Override
    public String toString() {
        return "Order{" +
                "nameRestaurant='" + nameRestaurant + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                ',';
    }

    public void setPayMethod(String option){this.payMethod = option;}

    public void setNameRestaurant(String option){this.nameRestaurant = option;};

}

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

    public void setPayMethod(){
        System.out.println("Choose paymant method: 1 for card 2 for cash");
        Scanner keyboard = new Scanner(System.in);
        int option = keyboard.nextInt();
        switch (option){
            case 1:
                payMethod = "card";
                break;
            case 2:
                payMethod = "cash";
                break;
        }
        if (option != 1 && option != 2){
            System.out.println("Invalid paymant option");
            System.exit(1);
        }
    }

    public void setCoffeRestaurant(RestaurantRepository restaurantRepository){
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
            nameRestaurant = coffeRestaurants.get(option);
        }
    }

    public void setPizzaRestaurant(RestaurantRepository restaurantRepository){
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
            nameRestaurant = coffeRestaurants.get(option);
        }
    }
}

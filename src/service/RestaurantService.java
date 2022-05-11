package src.service;

import src.domain.Restaurant;
import src.domain.RestaurantCoffe;
import src.domain.RestaurantPizza;
import src.domain.RestaurantSusshi;
import src.exceptions.InvalidDataException;
import src.persistence.RestaurantRepository;

import java.security.cert.CertificateParsingException;
import java.util.*;

public class RestaurantService {
    private RestaurantRepository restaurantRepository = new RestaurantRepository();

    public void registerCoffeRestaurant(RestaurantCoffe newRestaurant) throws InvalidDataException {
        if (newRestaurant.getName() == null || newRestaurant.getName().trim().isEmpty()){
            throw new InvalidDataException("Invalid name");
        }
        if(newRestaurant.getAddress() == null || newRestaurant.getAddress().trim().isEmpty()){
            throw new InvalidDataException("Invalid address");
        }
        if(newRestaurant.getMenu() == null || newRestaurant.getMenu().isEmpty())
        {
            throw new InvalidDataException("Invalid menu");
        }
        if(newRestaurant.getSizeCup() == null)
        {
            throw new InvalidDataException("Size error");
        }
        restaurantRepository.add(newRestaurant);
    }

    public RestaurantRepository getRestaurantRepository() {
        return restaurantRepository;
    }

    public void registerPizzaRestaurant(RestaurantPizza newRestaurant) throws InvalidDataException {
        if (newRestaurant.getName() == null || newRestaurant.getName().trim().isEmpty()){
            throw new InvalidDataException("Invalid name");
        }
        if(newRestaurant.getAddress() == null || newRestaurant.getAddress().trim().isEmpty()){
            throw new InvalidDataException("Invalid address");
        }
        if(newRestaurant.getMenu() == null || newRestaurant.getMenu().isEmpty())
        {
            throw new InvalidDataException("Invalid menu");
        }
        if(newRestaurant.getDough() == null)
        {
            throw new InvalidDataException("Invalid dough");
        }
        restaurantRepository.add(newRestaurant);
    }

    public void registerSushiRestaurant(RestaurantSusshi newRestaurant) throws InvalidDataException {
        if (newRestaurant.getName() == null || newRestaurant.getName().trim().isEmpty()){
            throw new InvalidDataException("Invalid name");
        }
        if(newRestaurant.getAddress() == null || newRestaurant.getAddress().trim().isEmpty()){
            throw new InvalidDataException("Invalid address");
        }
        if(newRestaurant.getMenu() == null || newRestaurant.getMenu().isEmpty())
        {
            throw new InvalidDataException("Invalid menu");
        }
        restaurantRepository.add(newRestaurant);
    }

    public Restaurant[] getRestaurantWithName(String name){
        List<Restaurant> result = new ArrayList<>();
        for(int i = 0; i < restaurantRepository.getSize(); i++){
            if(restaurantRepository.get(i) != null && restaurantRepository.get(i).getName() == name){
                result.add(restaurantRepository.get(i));
            }
        }
        return result.toArray(new Restaurant[0]);
    }

    public Restaurant getRestaurantIndex(String name){
        for (int i = 0; i < restaurantRepository.getSize(); i++)
            if(restaurantRepository.get(i).getName().equals(name))
                return restaurantRepository.get(i);
        return null;
    }
    public int getSizeRepository(){
        return restaurantRepository.getSize();
    }

    public void getALL(){
        for (int i = 0; i < restaurantRepository.getSize(); i++)
        {
            System.out.println(restaurantRepository.get(i));
        }
    }

    public void setSizeCup(RestaurantCoffe restaurantCoffe){
        System.out.println("Enter the noumber of options to add:");
        Scanner keyboard = new Scanner(System.in);
        int optionsNr = keyboard.nextInt();
        ArrayList<String> options = new ArrayList<>();
        for (int i = 0; i < optionsNr ; i++)
        {
            System.out.println("Enter the size cup " + (i+1) + " option:");
            options.add(keyboard.next());
        }
        restaurantCoffe.setSizeCup(options);
    }

    public void setDoughOpions(RestaurantPizza restaurantPizza) {
        System.out.println("Enter the noumber of options to add:");
        Scanner keyboard = new Scanner(System.in);
        int optionsNr = keyboard.nextInt();
        ArrayList<String> options = new ArrayList<>();
        for (int i = 0; i < optionsNr; i++) {
            System.out.println("Enter the " + i + " option:");
            options.add(keyboard.next());
        }
        restaurantPizza.setDoughOpions(options);
    }

    public void addToppings(RestaurantSusshi restaurantSusshi){
        System.out.printf("Enter the number of toppings options:");
        Scanner keyboard = new Scanner(System.in);
        int optionsNr = keyboard.nextInt();
        ArrayList<String > newToppings = new ArrayList<>();
        for (int i = 0; i < optionsNr; i++){
            System.out.println("Enter the " + i + " option:");
            newToppings.add(keyboard.next());
        }
        restaurantSusshi.setToppings(newToppings);
    }
}

package src.service;

import src.domain.Restaurant;
import src.domain.RestaurantCoffe;
import src.domain.RestaurantPizza;
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


}

package src.persistence;

import src.domain.Restaurant;
import src.domain.RestaurantCoffe;
import src.domain.RestaurantPizza;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RestaurantRepository implements GenericRepository<Restaurant>{
    private List<Restaurant> pubs = new ArrayList<>();

    @Override
    public String toString() {
        return "RestaurantRepository{" +
                "pubs=" + pubs +
                '}';
    }

    @Override
    public int compareTo(Restaurant o1, Restaurant o2)
    {
        return o1.getName().compareTo(o2.getName());
    }

    @Override
    public void add(Restaurant entity) {
        pubs.add(entity);
    }

    @Override
    public Restaurant get(int id) {
        return pubs.get(id);
    }

    public RestaurantCoffe getCoffeRestaurant(int id){
        if (pubs.get(id).getClass() == (new RestaurantCoffe(null,null,null)).getClass())
            return (RestaurantCoffe) pubs.get(id);
        return null;
    }

    public RestaurantPizza getPizzaRestaurant(int id){
        if(pubs.get(id).getClass() == (new RestaurantPizza(null,null,null)).getClass())
            return (RestaurantPizza) pubs.get(id);
        return null;
    }

    @Override
    public void update(Restaurant entity) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What you want to update:");
        System.out.println("1 name");
        System.out.println("2 address");
        System.out.println("3 exit");

        int choice = keyboard.nextInt();

        while (choice != 3)
        {
            if(choice == 1)
            {
                System.out.println("Enter the new name:");
                String newName = new String();
                newName = keyboard.next();
                entity.setName(newName);
            }
            if (choice == 2)
            {
                System.out.println("Enter the new address:");
                String newAddress = new String();
                newAddress = keyboard.next();
                entity.setAddress(newAddress);
            }
            if (choice == 3)
            {
                System.out.println("Your changed have been saved!");
                break;
            }
            choice = keyboard.nextInt();
        }
        saveChanges(entity);
    }


    public void saveChanges(Restaurant restaurantChanged){

        for (int i = 0; i < pubs.size(); i++)
            if(pubs.get(i).getId() == restaurantChanged.getId())
            {
                pubs.set(i, restaurantChanged);
                break;
            }
    }

    @Override
    public void delete(Restaurant entity) {
        boolean pubExist = pubs.stream().anyMatch(entitySearch -> entity == entitySearch);

        if(pubExist){
            pubs.remove(entity);
        }
    }

    @Override
    public int getSize() {
        return pubs.size();
    }

}

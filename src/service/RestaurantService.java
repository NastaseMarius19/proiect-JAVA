package src.service;

import src.domain.Restaurant;
import src.domain.RestaurantCoffe;
import src.domain.RestaurantPizza;
import src.domain.RestaurantSusshi;
import src.exceptions.InvalidDataException;
import src.persistence.RestaurantRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class RestaurantService implements GenericRestaurantCSV {
    private final RestaurantRepository restaurantRepository = new RestaurantRepository();

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
            if(restaurantRepository.get(i) != null && Objects.equals(restaurantRepository.get(i).getName(), name)){
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

    @Override
    public void read() throws IOException {
        String line = "";
        try {
            BufferedReader file1 = new BufferedReader(new FileReader("files/coffeeRestaurants.csv"));
            BufferedReader file2 = new BufferedReader(new FileReader("files/pizzaRestaurants.csv"));
            BufferedReader file3 = new BufferedReader(new FileReader("files/sushiRestaurants.csv"));
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
                restaurantRepository.add(restaurantCoffe);
            }
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
                restaurantRepository.add(restaurantPizza);
            }
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
                restaurantRepository.add(restaurantSusshi);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    public void writePizzaRestaurant(RestaurantPizza object) throws IOException {
        try{
            FileWriter fw = new FileWriter("files/pizzaRestaurants.csv",true);
            fw.write("\n" + object.getName() + "," + object.getAddress()
                    + "," + object.getMenu() + "," + object.getDough()
                    + ",");
            fw.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void writeSushiRestaurant(RestaurantSusshi object) throws IOException {
        try{
            FileWriter fw = new FileWriter("files/sushiRestaurants.csv",true);
            fw.write("\n" + object.getName() + "," + object.getAddress()
                    + "," + object.getMenu() + "," + object.getToppings()
                    + ",");
            fw.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void writeCoffeRestaurant(RestaurantCoffe object) throws IOException {
        try{
            FileWriter fw = new FileWriter("files/coffeeRestaurants.csv",true);
            fw.write("\n" + object.getName() + "," + object.getAddress()
                    + "," + object.getMenu() + "," + object.getSizeCup()
                    + ",");
            fw.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

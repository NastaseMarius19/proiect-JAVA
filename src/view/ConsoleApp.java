package src.view;

import src.domain.*;
import src.exceptions.InvalidDataException;
import src.service.OrderService;
import src.service.RestaurantService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ConsoleApp {
    
    private final Scanner keyboard = new Scanner(System.in);
    private final RestaurantService restaurantService = new RestaurantService();
    private final OrderService orderService = new OrderService();

    private void loadCSVfiles(){
        try {
            orderService.read();
            restaurantService.read();
        }catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
    public static void main(String [] args) throws InvalidDataException {
        ConsoleApp app = new ConsoleApp();
        app.loadCSVfiles();
        while (true){
            app.showMenu();
            int option = app.readOption();
            app.execute(option);
        }
    }

    private void execute(int option) throws InvalidDataException {
        switch (option){
            case 1:
                addRestaurant();
                break;
            case 2:
                selectRestaurant();
                break;
            case 3:
                selectALlRestaurants();
                break;
            case 4:
                makeOrder();
                break;
            case 5:
                sortRestaurants();
                break;
            case 6:
                selectAllOrders();
                break;
            case 8:
                System.exit(0);
        }
    }

    private void selectAllOrders() {
        orderService.getALL();
    }

    private void sortRestaurants() {
        System.out.println(restaurantService.getRestaurantRepository());
    }

    private void makeOrder() throws InvalidDataException {
        System.out.println("Select the type of order: 1 - pizza order , 2 - coffe order , 3 - sushi");
        int option = keyboard.nextInt();
        switch (option){
            case 1:
            {
                boolean check = false;
                for (int i = 0; i < restaurantService.getRestaurantRepository().getSize(); i++)
                    if(restaurantService.getRestaurantRepository().get(i).getClass() == RestaurantPizza.class)
                    {
                        check = true;
                        break;
                    }
                if(!check) {
                    System.out.println("Add first an pizza restaurant");
                    break;
                }
                else {
                    OrderPizza newOrder = new OrderPizza(null, null, null, null,null);
                    orderService.setOrder(newOrder);
                    orderService.setPizzaRestaurant(restaurantService.getRestaurantRepository(), newOrder);
                    for (int i = 0; i < restaurantService.getRestaurantRepository().getSize(); i++){
                        if(restaurantService.getRestaurantRepository().get(i).getName().equals(newOrder.getNameRestaurant())){
                            orderService.choosePizzaOption(restaurantService.getRestaurantRepository().getPizzaRestaurant(i), newOrder);
                            orderService.chooseDoughPizza(restaurantService.getRestaurantRepository().getPizzaRestaurant(i), newOrder);
                            break;
                        }
                    }
                    orderService.registerNewPizzaOrder(newOrder);
                    try {
                        orderService.writePizzaOrder(newOrder);
                    }catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                    break;
                }
            }
            case 2:
            {
                boolean check = false;
                for (int i = 0; i < restaurantService.getRestaurantRepository().getSize(); i++)
                    if(restaurantService.getRestaurantRepository().get(i).getClass() == RestaurantCoffe.class)
                    {
                        check = true;
                        break;
                    }
                if(!check){
                    System.out.println("Add first an coffe restaurant");
                    break;
                }
                else {
                    OrderCoffe newOrder = new OrderCoffe(null, null, null, null,null);
                    orderService.setOrder(newOrder);
                    orderService.setCoffeRestaurant(restaurantService.getRestaurantRepository(), newOrder);
                    for (int i = 0; i < restaurantService.getSizeRepository(); i++)
                        if (restaurantService.getRestaurantRepository().get(i).getName().equals(newOrder.getNameRestaurant())) {
                            orderService.chooseCoffe(restaurantService.getRestaurantRepository().getCoffeRestaurant(i), newOrder);
                            orderService.chooseSizeCup(restaurantService.getRestaurantRepository().getCoffeRestaurant(i), newOrder);
                            break;
                        }
                    orderService.registerNewCoffeOrder(newOrder);
                    try {
                        orderService.writeCoffeOrder(newOrder);
                    }catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                    break;
                }
            }
            case 3:
            {
                boolean check = false;
                for (int i = 0; i < restaurantService.getRestaurantRepository().getSize(); i++)
                    if(restaurantService.getRestaurantRepository().get(i).getClass() == RestaurantSusshi.class)
                    {
                        check = true;
                        break;
                    }
                if(!check){
                    System.out.println("Add first an sushi restaurant");
                    break;
                }
                else {
                    OrderSushi newOrder = new OrderSushi(null,null,null,null, null);
                    orderService.setOrder(newOrder);
                    orderService.setSushiRestaurant(restaurantService.getRestaurantRepository(), newOrder);
                    for (int i = 0; i < restaurantService.getSizeRepository(); i++)
                        if (restaurantService.getRestaurantRepository().get(i).getName().equals(newOrder.getNameRestaurant())) {
                            orderService.chooseSushi(restaurantService.getRestaurantRepository().getSushiRestaurant(i), newOrder);
                            orderService.chooseExtraTopping(restaurantService.getRestaurantRepository().getSushiRestaurant(i), newOrder);
                            break;
                        }
                    orderService.registerNewSushiOrder(newOrder);
                    try {
                        orderService.writeSushiOrder(newOrder);
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
    }

    private void selectALlRestaurants() {
        restaurantService.getALL();
    }

    private void selectRestaurant() {
        String nameRestaurant;
        System.out.println("Enter the restaurant name:");
        nameRestaurant = keyboard.nextLine();
        if(restaurantService.getRestaurantIndex(nameRestaurant)!= null)
            System.out.println(restaurantService.getRestaurantIndex(nameRestaurant));
        else
            System.out.println("Invalid restaurant");

    }

    private void addRestaurant() throws InvalidDataException {
        int option;
        System.out.println("1 - Coffe Restaurant");
        System.out.println("2 - Pizza Restaurant");
        System.out.println("3 - Sushi Restaurant");
        option = keyboard.nextInt();
        System.out.println("Enter the name:");
        String name = keyboard.next();
        System.out.println("Enter the address:");
        String address = keyboard.next();
        System.out.println("Enter the noumber of menu options:");
        ArrayList<String > menu = new ArrayList<>();
        String[] menuC = new String[keyboard.nextInt()];
        keyboard.nextLine();
        for (int i = 0; i < menuC.length; i++) {
            menuC[i] = keyboard.nextLine();
        }
        Collections.addAll(menu, menuC);
        switch (option){
            case 1:
            {
                RestaurantCoffe newRestaurant = new RestaurantCoffe(name, address, menu);
                restaurantService.setSizeCup(newRestaurant);
                restaurantService.registerCoffeRestaurant(newRestaurant);
                break;
            }
            case 2:
            {
                RestaurantPizza newRestaurant = new RestaurantPizza(name, address, menu);
                restaurantService.setDoughOpions(newRestaurant);
                restaurantService.registerPizzaRestaurant(newRestaurant);
                try {
                    restaurantService.writePizzaRestaurant(newRestaurant);
                }catch (IOException e){
                    e.printStackTrace();
                }
                break;
            }
            case 3:
            {
                RestaurantSusshi newRestaurant = new RestaurantSusshi(name, address, menu);
                restaurantService.addToppings(newRestaurant);
                restaurantService.registerSushiRestaurant(newRestaurant);
                break;
            }
        }
    }

    private int readOption() {
        try {
            int option = readInt();
            if (option >= 1 && option <= 8)
                return option;
        }catch (InvalidDataException ignored){
            System.out.println("Invalid option. Try again");
        }
        return readOption();
    }

    private int readInt() throws InvalidDataException {
        String line = keyboard.nextLine();
        if(line.matches("^\\d+$"))
            return Integer.parseInt(line);
        else {
            throw new InvalidDataException("Invalid option");
        }
    }

    private void showMenu() {
        System.out.println("What do you want to do?");
        System.out.println("1 add restaurant");
        System.out.println("2 select restaurant by name");
        System.out.println("3 select all restaurants");
        System.out.println("4 make an order");
        System.out.println("5 sort restaurants");
        System.out.println("6 list orders");
        System.out.println("7 sort orders");
        System.out.println("8 exit");
    }
}

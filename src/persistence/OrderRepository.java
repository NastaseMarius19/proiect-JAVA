package src.persistence;

import src.domain.Order;
import src.domain.Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderRepository implements GenericRepository<Order> {
    private final List<Order> order = new ArrayList<>();

    @Override
    public String toString() {
        return "OrderRepository{" +
                "order=" + order +
                '}';
    }

    @Override
    public int compareTo(Restaurant o1, Restaurant o2) {
        return 0;
    }

    @Override
    public void add(Order entity) {order.add(entity);}

    @Override
    public Order get(int id) {return order.get(id);}

    @Override
    public void update(Order entity) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What you want to update:");
        System.out.println("1 adresa");
        System.out.println("2 payment method");
        System.out.println("3 exit");

        int choice = keyboard.nextInt();

        while (choice != 0){
            if(choice == 1)
            {
                System.out.println("Enter the new address");
                String newAddress;
                newAddress = keyboard.next();
                entity.setHomeAddress(newAddress);
            }
            if (choice == 2)
            {
                entity.setPayMethod("card");
            }
            if (choice == 3)
            {
                System.out.println("Your changes have beens saved!");
                break;
            }
            choice = keyboard.nextInt();
        }

        saveChanges(entity);
    }

    private void saveChanges(Order entity) {
        for (int i = 0; i < order.size(); i ++)
            if(order.get(i).getId() == entity.getId())
            {
                order.set(i, entity);
                break;
            }
    }

    @Override
    public void delete(Order entity) {
        boolean orderExist = order.stream().anyMatch(orderSearch -> entity == orderSearch);

        if(orderExist)
            order.remove(entity);
    }

    @Override
    public int getSize() {return order.size();}

}

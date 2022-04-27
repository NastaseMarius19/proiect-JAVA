package src.service;

import src.domain.OrderCoffe;
import src.domain.OrderPizza;
import src.exceptions.InvalidDataException;
import src.persistence.OrderRepository;

public class OrderService {
    private OrderRepository orderRepository = new OrderRepository();

    public void registerNewPizzaOrder(OrderPizza newPizzaOrder) throws InvalidDataException {
        if (newPizzaOrder.getHomeAddress() == null || newPizzaOrder.getHomeAddress().trim().isEmpty())
        {
            throw new InvalidDataException("Invalid order address");
        }
        if(newPizzaOrder.getNameRestaurant() == null || newPizzaOrder.getNameRestaurant().trim().isEmpty())
        {
            throw new InvalidDataException("Invalid restaurant for oder");
        }
        if(newPizzaOrder.getPayMethod() == null || newPizzaOrder.getPayMethod().trim().isEmpty())
        {
            throw new InvalidDataException("Invalid payment method for the order");
        }
        if(newPizzaOrder.getDoughOption() == null || newPizzaOrder.getDoughOption().trim().isEmpty())
        {
            throw new InvalidDataException("Invalid dough for the order");
        }
        orderRepository.add(newPizzaOrder);
    }

    public OrderRepository getOrderRepository() {
        return orderRepository;
    }

    public void registerNewCoffeOrder(OrderCoffe newCoffeOrder) throws InvalidDataException {
        if (newCoffeOrder.getHomeAddress() == null || newCoffeOrder.getHomeAddress().trim().isEmpty())
        {
            throw new InvalidDataException("Invalid order address");
        }
        if(newCoffeOrder.getNameRestaurant() == null || newCoffeOrder.getNameRestaurant().trim().isEmpty())
        {
            throw new InvalidDataException("Invalid restaurant for oder");
        }
        if(newCoffeOrder.getPayMethod() == null || newCoffeOrder.getPayMethod().trim().isEmpty())
        {
            throw new InvalidDataException("Invalid payment method for the order");
        }
        if (newCoffeOrder.getOptionCoffe() == null || newCoffeOrder.getOptionCoffe().trim().isEmpty())
        {
            throw new InvalidDataException("Invalid coffe option");
        }
        if (newCoffeOrder.getOptionSizeCup() == null || newCoffeOrder.getOptionSizeCup().trim().isEmpty())
        {
            throw new InvalidDataException("Invalid size cup option");
        }

        orderRepository.add(newCoffeOrder);

    }
    public void getALL(){
        for (int i = 0; i < orderRepository.getSize(); i++)
        {
            System.out.println(orderRepository.get(i));
        }
    }
}

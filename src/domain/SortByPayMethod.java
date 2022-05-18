package src.domain;

import java.util.Comparator;

public class SortByPayMethod implements Comparator<Order> {
    @Override
    public int compare(Order o1, Order o2) {
        if(o1.getPayMethod() == "cash")
            return 1;
        else if(o2.getPayMethod() == "cash")
            return -1;
        return 1;
    }
}
package src.domain;

import java.util.Comparator;

public class SortByName implements Comparator<Restaurant> {
    @Override
    public int compare(Restaurant o1, Restaurant o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

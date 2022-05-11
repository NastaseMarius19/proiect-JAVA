package src.service;

import src.domain.RestaurantCoffe;
import src.domain.RestaurantPizza;
import src.domain.RestaurantSusshi;

import java.io.IOException;

public interface GenericRestaurantCSV {
    void read() throws IOException;
    void writePizzaRestaurant(RestaurantPizza object) throws IOException;
    void writeSushiRestaurant(RestaurantSusshi object) throws  IOException;
    void writeCoffeRestaurant(RestaurantCoffe object) throws  IOException;
}

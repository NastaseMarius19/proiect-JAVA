package src.service;

import src.domain.*;

import java.io.IOException;

public interface GenericOrderCSV {
    void read() throws IOException;
    void writePizzaOrder(OrderPizza object) throws  IOException;
    void writeCoffeOrder(OrderCoffe object) throws  IOException;
    void writeSushiOrder(OrderSushi object) throws  IOException;

}

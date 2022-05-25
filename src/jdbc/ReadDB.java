package src.jdbc;

import src.domain.OrderCoffe;
import src.domain.OrderPizza;
import src.exceptions.InvalidDataException;
import src.service.OrderService;

import java.io.IOException;
import java.sql.*;

public class ReadDB {
    private static ReadDB rdb = null;

    private ReadDB() {
    }

    public static ReadDB getInstance() {
        if(rdb == null)
            rdb = new ReadDB();
        return rdb;
    }

    private void loadCoffeOrders(OrderService s, Statement stmt) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM ordercoffee");
            while(rs.next()) {
                s.registerNewCoffeOrder(
                        new OrderCoffe(
                                rs.getString("nameRestaurant"),
                                rs.getString("homeAddress"),
                                rs.getString("payMethod"),
                                rs.getString("optionCoffe"),
                                rs.getString("optionSizeCup")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InvalidDataException e) {
            e.printStackTrace();
        }
    }

    private void loadPizzaOrders(OrderService s, Statement stmt) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM orderpizza");
            while(rs.next()) {
                s.registerNewPizzaOrder(
                        new OrderPizza(
                                rs.getString("nameRestaurant"),
                                rs.getString("homeAddress"),
                                rs.getString("payMethod"),
                                rs.getString("doughOption"),
                                rs.getString("pizzaOption")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InvalidDataException e) {
            e.printStackTrace();
        }
    }

    public void loadObjects(OrderService s) {
        try {
            DBConn dbconn = DBConn.getInstance();
            Statement stmt = dbconn.getConn().createStatement();

            loadCoffeOrders(s, stmt);
            loadPizzaOrders(s, stmt);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

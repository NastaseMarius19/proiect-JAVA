package src.jdbc;

import src.domain.*;

import java.sql.SQLException;
import java.sql.Statement;

public class WriteDB {
    private static WriteDB wdb = null;
    private final DBConn dbconn = DBConn.getInstance();
    private Statement stmt = null;

    private WriteDB() {
    }

    public static WriteDB getInstance() {
        if(wdb == null)
            wdb = new WriteDB();
        return wdb;
    }

    public void writeOrderSushi(OrderSushi orderSushi) {
        if(dbconn.getConn() != null) {
            try {
                stmt = dbconn.getConn().createStatement();
                stmt.execute("INSERT INTO ordersushi VALUES(" +
                        "\"" + orderSushi.getNameRestaurant() + "\"" + "," +
                        "\"" + orderSushi.getHomeAddress() + "\"" + "," +
                        "\"" + orderSushi.getPayMethod() + "\"" + "," +
                        "\"" + orderSushi.getExtraTopping() + "\"" +
                        "\"" + orderSushi.getMenuOption() + "\"" +
                        ")");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void writeOrderPizza(OrderPizza orderPizza) {
        if(dbconn.getConn() != null) {
            try {
                stmt = dbconn.getConn().createStatement();
                stmt.execute("INSERT INTO ordersushi VALUES(" +
                        "\"" + orderPizza.getNameRestaurant() + "\"" + "," +
                        "\"" + orderPizza.getHomeAddress() + "\"" + "," +
                        "\"" + orderPizza.getPayMethod() + "\"" + "," +
                        "\"" + orderPizza.getDoughOption() + "\"" +
                        "\"" + orderPizza.getPizzaOption() + "\"" +
                        ")");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void writeOrderCoffee(OrderCoffe orderCoffe) {
        if(dbconn.getConn() != null) {
            try {
                stmt = dbconn.getConn().createStatement();
                stmt.execute("INSERT INTO ordersushi VALUES(" +
                        "\"" + orderCoffe.getNameRestaurant() + "\"" + "," +
                        "\"" + orderCoffe.getHomeAddress() + "\"" + "," +
                        "\"" + orderCoffe.getPayMethod() + "\"" + "," +
                        "\"" + orderCoffe.getOptionCoffe() + "\"" +
                        "\"" + orderCoffe.getOptionSizeCup() + "\"" +
                        ")");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void writeSushiRestaurant(RestaurantSusshi restaurantSusshi) {
        if(dbconn.getConn() != null) {
            try {
                stmt = dbconn.getConn().createStatement();
                stmt.execute("INSERT INTO sushirestaurant VALUES(" +
                        "\"" + restaurantSusshi.getName() + "\"" + "," +
                        "\"" + restaurantSusshi.getAddress() + "\"" + "," +
                        "\"" + restaurantSusshi.getMenu().size() + "\"" + "," +
                        "\"" + restaurantSusshi.getToppings().size() + "\"" +
                        ")");

                stmt.execute("INSERT INTO sushirestaurant_menu VALUES(" +
                        "\"" + restaurantSusshi.getMenu() + "\"" + "," +
                        ")");

                stmt.execute("INSERT INTO sushirestaurant_extraTopping VALUES(" +
                        "\"" + restaurantSusshi.getToppings() + "\"" + "," +
                        ")");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void writePizzaRestaurant(RestaurantPizza restaurantPizza) {
        if(dbconn.getConn() != null) {
            try {
                stmt = dbconn.getConn().createStatement();
                stmt.execute("INSERT INTO pizzarestaurant VALUES(" +
                        "\"" + restaurantPizza.getName() + "\"" + "," +
                        "\"" + restaurantPizza.getAddress() + "\"" + "," +
                        "\"" + restaurantPizza.getMenu().size() + "\"" + "," +
                        "\"" + restaurantPizza.getDough().size() + "\"" +
                        ")");

                stmt.execute("INSERT INTO pizzarestaurant_menu VALUES(" +
                        "\"" + restaurantPizza.getMenu() + "\"" + "," +
                        ")");

                stmt.execute("INSERT INTO pizzarestaurant_Dough VALUES(" +
                        "\"" + restaurantPizza.getDough() + "\"" + "," +
                        ")");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void writeCoffeeRestaurant(RestaurantCoffe restaurantCoffe) {
        if(dbconn.getConn() != null) {
            try {
                stmt = dbconn.getConn().createStatement();
                stmt.execute("INSERT INTO coffeerestaurant VALUES(" +
                        "\"" + restaurantCoffe.getName() + "\"" + "," +
                        "\"" + restaurantCoffe.getAddress() + "\"" + "," +
                        "\"" + restaurantCoffe.getMenu().size() + "\"" + "," +
                        "\"" + restaurantCoffe.getSizeCup().size() + "\"" +
                        ")");

                stmt.execute("INSERT INTO coffeerestaurant_menu VALUES(" +
                        "\"" + restaurantCoffe.getMenu() + "\"" + "," +
                        ")");

                stmt.execute("INSERT INTO coffeerestaurant_sizeCup VALUES(" +
                        "\"" + restaurantCoffe.getSizeCup() + "\"" + "," +
                        ")");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

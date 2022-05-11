package src.domain;

import java.util.Scanner;

public class OrderPizza extends Order{
    private String doughOption;

    @Override
    public String toString() {
        return
                super.toString()+ doughOption + '\'' +
                '}';
    }

    public String getDoughOption() {
        return doughOption;
    }

    public void setDoughOption(String doughOption) {
        this.doughOption = doughOption;
    }
}

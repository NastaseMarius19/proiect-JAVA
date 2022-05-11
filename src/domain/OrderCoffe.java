package src.domain;

import java.util.Scanner;

public class OrderCoffe extends Order{
    public String getOptionCoffe() {
        return optionCoffe;
    }

    public String getOptionSizeCup() {
        return optionSizeCup;
    }

    private String optionCoffe;
    private String optionSizeCup;

    @Override
    public String toString() {
        return super.toString() + optionCoffe + " " + optionSizeCup +
                '}';
    }

    public void setOptionCoffe(String optionCoffe) {
        this.optionCoffe = optionCoffe;
    }

    public void setOptionSizeCup(String optionSizeCup) {
        this.optionSizeCup = optionSizeCup;
    }

}

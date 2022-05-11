package src.domain;

public class OrderCoffe extends Order{
    private String optionCoffe;
    private String optionSizeCup;

    public OrderCoffe(String nameRestaurant, String homeAddress, String payMethod, String optionCoffe, String optionSizeCup) {
        super(nameRestaurant, homeAddress, payMethod);
        this.optionCoffe = optionCoffe;
        this.optionSizeCup = optionSizeCup;
    }

    public String getOptionCoffe() {
        return optionCoffe;
    }

    public String getOptionSizeCup() {
        return optionSizeCup;
    }

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

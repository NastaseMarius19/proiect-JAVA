package src.domain;

public class OrderSushi extends Order{

    private String extraTopping;

    private String menuOption;

    public String getMenuOption() {
        return menuOption;
    }

    public void setMenuOption(String menuOption) {
        this.menuOption = menuOption;
    }

    public OrderSushi(String nameRestaurant, String homeAddress, String payMethod, String extraTopping, String menuOption) {
        super(nameRestaurant, homeAddress, payMethod);
        this.extraTopping = extraTopping;
        this.menuOption = menuOption;
    }

    @Override
    public String toString() {
        return super.toString() +
                "extraTopping='" + extraTopping + '\'' + "menuOption=" + '\'' + menuOption + '\'' +
                '}';
    }

    public String getExtraTopping() {
        return extraTopping;
    }

    public void setExtraTopping(String extraTopping) {
        this.extraTopping = extraTopping;
    }
}

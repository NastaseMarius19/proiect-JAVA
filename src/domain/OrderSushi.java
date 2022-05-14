package src.domain;

public class OrderSushi extends Order{

    private String extraTopping;

    public OrderSushi(String nameRestaurant, String homeAddress, String payMethod, String extraTopping) {
        super(nameRestaurant, homeAddress, payMethod);
        this.extraTopping = extraTopping;
    }

    @Override
    public String toString() {
        return super.toString() +
                "extraTopping='" + extraTopping + '\'' +
                '}';
    }

    public String getExtraTopping() {
        return extraTopping;
    }

    public void setExtraTopping(String extraTopping) {
        this.extraTopping = extraTopping;
    }
}

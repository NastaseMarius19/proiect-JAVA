package src.domain;

public class OrderSushi extends Order{

    private String extraTopping = null;

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

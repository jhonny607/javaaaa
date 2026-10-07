import java.util.Objects;

public class Smartphone {
    private String imei;
    private String brand;
    private String model;
    private double price;
    private int batteryCapacity;

    public Smartphone(String imei, String brand, String model,
                      double price, int batteryCapacity) {
        this.imei = imei;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.batteryCapacity = batteryCapacity;
    }

    public String getImei() {
        return imei;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    @Override
    public String toString() {
        return brand + " " + model +
                ", цена: " + price +
                ", батарея: " + batteryCapacity + " мАч";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Smartphone that = (Smartphone) o;

        return Objects.equals(imei, that.imei);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imei);
    }
}
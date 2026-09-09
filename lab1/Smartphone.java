public class Smartphone {

    private String imei;
    private String brand;
    private String model;
    private double price;
    private int batteryCapacity;

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        if (imei == null || !imei.matches("\\d{15}")) {
            throw new IllegalArgumentException("IMEI должен состоять из 15 цифр");
        }
        this.imei = imei;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (brand == null || brand.isBlank()) {
            throw new IllegalArgumentException("Бренд не может быть пустым");
        }
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model == null || model.isBlank()) {
            throw new IllegalArgumentException("Модель не может быть пустой");
        }
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Цена должна быть больше 0");
        }
        this.price = price;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        if (batteryCapacity < 500 || batteryCapacity > 10000) {
            throw new IllegalArgumentException(
                    "Ёмкость батареи должна быть от 500 до 10000"
            );
        }
        this.batteryCapacity = batteryCapacity;
    }

    public String getDescription() {
        return String.format(
                "%s %s (IMEI: %s) — %.2f руб., батарея %d мА·ч",
                brand, model, imei, price, batteryCapacity
        );
    }
}
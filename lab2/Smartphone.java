public class Smartphone {

    private String imei;
    private String brand;
    private String model;
    private double price;
    private int batteryCapacity;

    private static int smartphoneCounter = 0;

    public Smartphone() {
        this("000000000000000", "Неизвестно", "Неизвестно", 1, 500);
    }

    public Smartphone(String brand, String model) {
        this("000000000000000", brand, model, 1, 500);
    }

    public Smartphone(String brand, String model, double price, int batteryCapacity) {
        this("000000000000000", brand, model, price, batteryCapacity);
    }

    public Smartphone(String imei, String brand, String model, double price, int batteryCapacity) {
        setImei(imei);
        setBrand(brand);
        setModel(model);
        setPrice(price);
        setBatteryCapacity(batteryCapacity);

        smartphoneCounter++;
    }

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
                brand,
                model,
                imei,
                price,
                batteryCapacity
        );
    }

    public String getDescription(boolean shortFormat) {
        if (shortFormat) {
            return brand + " " + model + " — " + price + " руб.";
        }

        return getDescription();
    }

    public String getDescription(boolean shortFormat, boolean showBattery) {
        if (shortFormat && showBattery) {
            return brand + " " + model
                    + ", батарея " + batteryCapacity + " мА·ч";
        }

        if (shortFormat) {
            return brand + " " + model;
        }

        return getDescription();
    }

    public static int getCounter() {
        return smartphoneCounter;
    }

    public static Smartphone createSmartphone(
            String imei,
            String brand,
            String model,
            double price,
            int batteryCapacity
    ) {
        return new Smartphone(
                imei,
                brand,
                model,
                price,
                batteryCapacity
        );
    }
}
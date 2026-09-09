public class Main {
    public static void main(String[] args) {

        Smartphone phone1 = new Smartphone();
        phone1.setImei("123456789012345");
        phone1.setBrand("Samsung");
        phone1.setModel("Galaxy S24");
        phone1.setPrice(79990);
        phone1.setBatteryCapacity(4000);

        Smartphone phone2 = new Smartphone();
        phone2.setImei("234567890123456");
        phone2.setBrand("Apple");
        phone2.setModel("iPhone 16");
        phone2.setPrice(99990);
        phone2.setBatteryCapacity(3561);

        Smartphone phone3 = new Smartphone();
        phone3.setImei("345678901234567");
        phone3.setBrand("Xiaomi");
        phone3.setModel("14");
        phone3.setPrice(69990);
        phone3.setBatteryCapacity(4610);

        System.out.println("=== Список смартфонов ===");
        System.out.println("1. " + phone1.getDescription());
        System.out.println("2. " + phone2.getDescription());
        System.out.println("3. " + phone3.getDescription());
    }
}
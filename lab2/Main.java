public class Main {

    public static void main(String[] args) {

        Smartphone phone1 = new Smartphone(
                "123456789012345",
                "Samsung",
                "Galaxy S24",
                79990,
                4000
        );

        Smartphone phone2 = Smartphone.createSmartphone(
                "234567890123456",
                "Apple",
                "iPhone 16",
                99990,
                3561
        );

        Smartphone phone3 = new Smartphone(
                "Xiaomi",
                "14",
                69990,
                4610
        );

        System.out.println("=== Смартфоны ===");

        System.out.println(phone1.getDescription());
        System.out.println(phone2.getDescription());
        System.out.println(phone3.getDescription());

        System.out.println();

        System.out.println("Краткое описание:");
        System.out.println(phone1.getDescription(true));

        System.out.println();

        System.out.println("Описание с батареей:");
        System.out.println(phone1.getDescription(true, true));

        System.out.println();

        System.out.println(
                "Всего создано смартфонов: "
                        + Smartphone.getCounter()
        );
    }
}
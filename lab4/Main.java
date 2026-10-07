import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Smartphone> phones = new ArrayList<>();

        phones.add(new Smartphone("111", "Samsung", "Galaxy S24", 75000, 4000));
        phones.add(new Smartphone("222", "Apple", "iPhone 15", 80000, 3349));
        phones.add(new Smartphone("333", "Xiaomi", "Redmi Note 13", 25000, 5000));
        phones.add(new Smartphone("444", "Samsung", "Galaxy A55", 42000, 5000));
        phones.add(new Smartphone("555", "Xiaomi", "Poco X6", 35000, 5100));
        phones.add(new Smartphone("666", "Apple", "iPhone 14", 65000, 3279));
        phones.add(new Smartphone("777", "Realme", "12 Pro", 38000, 5000));
        phones.add(new Smartphone("888", "Honor", "90", 45000, 5000));
        phones.add(new Smartphone("999", "Samsung", "Galaxy S23", 60000, 3900));
        phones.add(new Smartphone("101", "Xiaomi", "Redmi 12", 18000, 5000));

        System.out.println("=== Сортировка по марке ===");

        phones.sort(Comparator.comparing(Smartphone::getBrand));

        for (Smartphone phone : phones) {
            System.out.println(phone);
        }

        System.out.println("\n=== Сортировка по цене ===");

        phones.sort(Comparator.comparingDouble(Smartphone::getPrice));

        for (Smartphone phone : phones) {
            System.out.println(phone);
        }

        System.out.println("\n=== Сортировка по батарее ===");

        phones.sort(Comparator.comparingInt(Smartphone::getBatteryCapacity));

        for (Smartphone phone : phones) {
            System.out.println(phone);
        }

        System.out.println("\n=== Set ===");

        Set<Smartphone> phoneSet = new HashSet<>(phones);

        phoneSet.add(
                new Smartphone(
                        "111",
                        "Samsung",
                        "Galaxy S24",
                        75000,
                        4000
                )
        );

        System.out.println("Количество элементов List: " + phones.size());
        System.out.println("Количество элементов Set: " + phoneSet.size());

        System.out.println("\n=== Группировка по марке ===");

        Map<String, List<Smartphone>> byBrand =
                phones.stream()
                        .collect(Collectors.groupingBy(Smartphone::getBrand));

        byBrand.forEach((brand, list) -> {
            System.out.println(brand + ":");
            list.forEach(System.out::println);
        });

        System.out.println("\n=== Смартфоны дешевле 50000 ===");

        List<Smartphone> cheapPhones =
                phones.stream()
                        .filter(phone -> phone.getPrice() < 50000)
                        .collect(Collectors.toList());

        cheapPhones.forEach(System.out::println);

        System.out.println("\n=== Средняя батарея по маркам ===");

        Map<String, Double> averageBattery =
                phones.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Smartphone::getBrand,
                                        Collectors.averagingInt(
                                                Smartphone::getBatteryCapacity
                                        )
                                )
                        );

        averageBattery.forEach((brand, battery) ->
                System.out.println(
                        brand + ": " +
                                String.format("%.0f", battery) +
                                " мАч"
                )
        );

        System.out.println("\n=== Производительность ===");

        List<Integer> arrayList = new ArrayList<>();
        Set<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < 100000; i++) {
            arrayList.add(i);
            hashSet.add(i);
        }

        long startList = System.nanoTime();

        arrayList.contains(99999);

        long endList = System.nanoTime();

        long startSet = System.nanoTime();

        hashSet.contains(99999);

        long endSet = System.nanoTime();

        System.out.println(
                "ArrayList: " +
                        (endList - startList) +
                        " нс"
        );

        System.out.println(
                "HashSet: " +
                        (endSet - startSet) +
                        " нс"
        );
    }
}
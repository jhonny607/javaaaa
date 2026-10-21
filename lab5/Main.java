
import java.util.LinkedHashMap;
import java.util.Map;

class Cache<K, V> {
    private int capacity;
    private LinkedHashMap<K, V> data;

    public Cache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Размер должен быть больше 0");
        }

        this.capacity = capacity;
        data = new LinkedHashMap<>(capacity, 0.75f, true);
    }

    public void put(K key, V value) {
        if (!data.containsKey(key) && data.size() >= capacity) {
            K firstKey = data.keySet().iterator().next();
            data.remove(firstKey);
        }
        data.put(key, value);
    }

    public V get(K key) {
        return data.get(key);
    }

    public void remove(K key) {
        data.remove(key);
    }

    public int size() {
        return data.size();
    }

    public void printAll() {
        for (Map.Entry<K, V> entry : data.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Cache<Integer, String> cache = new Cache<>(3);

        cache.put(1, "Apple");
        cache.put(2, "Samsung");
        cache.put(3, "Xiaomi");

        System.out.println("Начальный кэш:");
        cache.printAll();

        cache.get(1);
        cache.put(4, "Huawei");

        System.out.println("После добавления Huawei:");
        cache.printAll();

        System.out.println("Элемент 1: " + cache.get(1));
        System.out.println("Размер: " + cache.size());

        cache.remove(3);

        System.out.println("После удаления:");
        cache.printAll();
    }
}

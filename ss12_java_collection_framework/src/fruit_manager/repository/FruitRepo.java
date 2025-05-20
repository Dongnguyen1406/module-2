package fruit_manager.repository;

import fruit_manager.model.Fruit;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitRepo implements IFruitRepo {
    private static final Map<Integer, Fruit> fruitMap = new HashMap<>();

    static {
        fruitMap.put(1, new Fruit(1, "Xoài", "Qủa", LocalDate.of(2025, 5, 19), LocalDate.of(2025, 5, 20), "DN", 12000.0));
        fruitMap.put(2, new Fruit(2, "Bưởi", "Qủa", LocalDate.of(2025, 5, 20), LocalDate.of(2025, 5, 25), "DN", 12000.0));
        fruitMap.put(3, new Fruit(3, "Chuối", "Qủa", LocalDate.of(2025, 5, 22), LocalDate.of(2025, 5, 29), "DN", 12000.0));
    }

    @Override
    public List<Fruit> getAll() {
        return new ArrayList<>(fruitMap.values());
    }

    @Override
    public void add(Fruit fruit) {
        fruitMap.put(fruit.getId(), fruit);
    }

    @Override
    public boolean isExist(int id) {
        return fruitMap.containsKey(id);
    }

    @Override
    public boolean findIdToDelete(int id) {
        return fruitMap.remove(id) != null;
    }

    // != null: Kiểm tra xem phần tử có thực sự được xóa hay không. 
    // Nếu phần tử tồn tại, nó sẽ bị xóa và phương thức remove trả về giá trị (value) tương ứng với key đó (khác null).
    // Nếu phần tử không tồn tại (id không có trong Map), phương thức remove trả về null.

    @Override
    public List<Fruit> searchByName(String name) {
        List<Fruit> result = new ArrayList<>();
        for (Fruit fruit1 : fruitMap.values()) {
            if (fruit1.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(fruit1);
            }
        }
        return result;
    }

    @Override
    public void update(Fruit fruit) {
        if (fruitMap.containsKey(fruit.getId())) {
            fruitMap.put(fruit.getId(), fruit);
        }
    }

    // Cách 1: Hiển thị danh sách bằng keySet()
    public void displayByKeySet() {
        for (Integer id : fruitMap.keySet()) {
            System.out.println(fruitMap.get(id));
        }
    }

    // Cách 2: Hiển thị danh sách bằng entrySet()
    public void displayByEntrySet() {
        for (Map.Entry<Integer, Fruit> entry : fruitMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " | Value: " + entry.getValue());
        }
    }
}
